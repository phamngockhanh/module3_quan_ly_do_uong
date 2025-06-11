<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="adminAssetsPath" value="${basePath}/assets/admin"/>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Management</title>
    <link rel="stylesheet" href="${adminAssetsPath}/css/styles.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
     data-sidebar-position="fixed" data-header-position="fixed">

    <jsp:include page="/view/admin/layout/topstrip.jsp"/>

    <div>
        <jsp:include page="/view/admin/layout/sidebar.jsp"/>

        <div class="body-wrapper">
            <jsp:include page="/view/admin/layout/header.jsp"/>
            <div class="body-wrapper-inner">
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-body row">
                            <div class="col-md-12 mt-5">
                                <h2 class="mb-4">Danh sách sản phẩm</h2>

                                <!-- Tìm kiếm -->
                                <form class="d-flex justify-content-end mb-3" method="get" action="/admin/product-management">
                                    <input type="hidden" name="action" value="search"/>
                                    <input type="text" name="name" class="form-control me-2" placeholder="Tìm theo tên"
                                           value="${param.name}" style="width: 200px;">
                                    <select name="categoryId" class="form-select me-2" style="width: 200px;">
                                        <option value="">Tất cả loại</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option value="${category.id}" <c:if test="${param.categoryId == category.id}">selected</c:if>>
                                                    ${category.name}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <button type="submit" class="btn btn-outline-warning">Tìm kiếm</button>
                                </form>

                                <!-- Bảng sản phẩm -->
                                <table id="tableProduct" class="table table-striped table-bordered">
                                    <thead class="table-light">
                                    <tr style="background-color: #e3b159">
                                        <th>STT</th>
                                        <th>Tên</th>
                                        <th>Giá (VND)</th>
                                        <th>Loại</th>
                                        <th>Trạng thái</th>
                                        <th>Hình ảnh</th>
                                        <th>Chỉnh sửa</th>
                                    </tr>
                                    </thead>
                                    <tbody style="background-color: #fff4e5">
                                    <c:if test="${empty productList}">
                                        <tr><td colspan="7" class="text-center">Không tìm thấy sản phẩm</td></tr>
                                    </c:if>
                                    <c:forEach var="product" items="${productList}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${product.name}</td>
                                            <td>
                                                <fmt:formatNumber value="${product.price}" type="number" groupingUsed="true"/> vnđ
                                            </td>
                                            <td>
                                                <c:forEach var="category" items="${categories}">
                                                    <c:if test="${product.categoryId == category.id}">
                                                        ${category.name}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td>${product.status ? 'Còn hàng' : 'Hết hàng'}</td>
                                            <td>
                                                <img src="${product.image}" alt="" width="100" height="100" style="object-fit: cover">
                                            </td>
                                            <td>
                                                <div class="d-flex justify-content-center align-items-center">
                                                    <button onclick="deleteInfo(${product.id}, '${fn:escapeXml(product.name)}')"
                                                            class="btn btn-danger" data-bs-toggle="modal"
                                                            data-bs-target="#exampleModal">
                                                        <i class="ti ti-trash text-light"></i>
                                                    </button>
                                                    <button class="btn btn-warning"
                                                            onclick="window.location.href='/admin/product-management?action=update&id=${product.id}'">
                                                        <i class="ti ti-pencil text-light"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                                <!-- Modal xác nhận xoá -->
                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <form method="post" action="/admin/product-management?action=delete">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xoá sản phẩm</h1>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <input hidden id="deleteId" name="deleteId">
                                                    <span>Bạn có muốn xoá </span><span id="deleteName"></span> không?
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                                                    <button class="btn btn-primary">Xoá</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <jsp:include page="/view/admin/layout/footer.jsp"/>
</div>

<!-- Scripts -->
<script src="${adminAssetsPath}/libs/jquery/dist/jquery.min.js"></script>
<script src="${adminAssetsPath}/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script src="${adminAssetsPath}/js/sidebarmenu.js"></script>
<script src="${adminAssetsPath}/js/app.min.js"></script>
<script src="${adminAssetsPath}/libs/apexcharts/dist/apexcharts.min.js"></script>
<script src="${adminAssetsPath}/libs/simplebar/dist/simplebar.js"></script>
<script src="${adminAssetsPath}/js/dashboard.js"></script>

<!-- DataTables JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>

<!-- Script xác nhận xoá -->
<script>
    function deleteInfo(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }

    $(document).ready(function () {
        $('#tableProduct').DataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
            "language": {
                "info": "Sản phẩm trong trang",
                "infoEmpty": "Không có dữ liệu",
                "paginate": {
                    "next": "Sau",
                    "previous": "Trước"
                }
            }
        });
    });
</script>
</body>
</html>
