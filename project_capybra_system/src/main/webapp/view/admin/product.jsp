<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="adminAssetsPath" value="${basePath}/assets/admin"/>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Management</title>
    <link rel="stylesheet" href="${adminAssetsPath}/css/styles.min.css"/>

    <%--CODE CỦA BÉ THẢO--%>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <!-- DataTables CSS + JS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>

    <style>
        /* Hover màu vàng nhạt */
        table.table-hover > tbody > tr:hover {
            background-color: #fff9c4 !important;
        }

        .form-control:focus {
            border-color: #ffc107 !important;
            box-shadow: 0 0 0 0.25rem rgba(255, 193, 7, 0.25);
        }

        .table-hover tbody tr:hover {
            background-color: #fff9c4 !important; /* vàng nhạt */
        }

        td button {
            border: none;
            background: none;
            padding: 0 4px;
        }

        td i:hover {
            color: #ffc107;
            cursor: pointer;
        }

    </style>
    <%--END--%>

</head>
<body>
<!--  Body Wrapper -->
<div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
     data-sidebar-position="fixed" data-header-position="fixed">

    <!--  App Topstrip -->
    <jsp:include page="layout/topstrip.jsp"/>
    <!-- Sidebar Start -->
    <jsp:include page="layout/sidebar.jsp"/>
    <!--  Sidebar End -->
    <!--  Main wrapper -->
    <div class="body-wrapper">
        <!--  Header Start -->
        <jsp:include page="layout/header.jsp"/>
        <!--  Header End -->
        <div class="body-wrapper-inner">
            <div class="container-fluid">
                <div class="card">
                    <div class="card-body row">
                        <div class="col-md-12 mt-5">
                            <h2 class="mb-4">Danh sách sản phẩm</h2>

                            <%--CODE CỦA BÉ THẢO--%>
                            <div class="d-flex align-items-center gap-3 p-3">
                                <div class="d-flex gap-2">
                                    <button onclick="window.location.href=`/managerProduct?action=addCategory`"
                                            type="button" class="btn btn-warning btn-sm">Thêm loại đồ uống
                                    </button>
                                    <button onclick="window.location.href=`/managerProduct?action=add`" type="button"
                                            class="btn btn-warning btn-sm">Thêm đồ uống
                                    </button>
                                </div>

                                <form method="get" action="/managerProduct" class="d-flex align-items-center gap-3 p-3">

                                    <input type="hidden" name="action" value="search"/>

                                    <input type="text" name="name"
                                           class="form-control form-control-sm" placeholder="Tìm theo tên"
                                           style="width: 200px;" value="${param.name}"/>

                                    <select name="categoryId" class="form-select form-select-sm" style="width: 200px;">
                                        <option value="">Tất cả loại</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option value="${category.id}"
                                                    <c:if test="${param.categoryId == category.id}">selected</c:if>>
                                                    ${category.name}
                                            </option>
                                        </c:forEach>
                                    </select>

                                    <button type="submit" class="btn btn-warning btn-sm">Tìm kiếm</button>
                                </form>
                            </div>
                        </div>
                        <p style="color: red">${param.mess}</p>

                        <!-- Bảng sản phẩm -->
                        <div class="m-5">
                            <table id="tableProduct" class="table table-hover table-bordered">
                                <thead class="table-light">
                                <tr style="background-color: #e3b159">
                                    <th scope="col">No</th>
                                    <th scope="col">Tên</th>
                                    <th scope="col">Giá (VND)</th>
                                    <th scope="col">Loại</th>
                                    <th scope="col">Trạng thái</th>
                                    <th scope="col">Hình ảnh</th>
                                    <th scope="col">Chỉnh sửa</th>

                                </tr>
                                </thead>
                                <tbody style="background-color: #fff4e5">
                                <c:if test="${empty productList}">
                                    <td>không tìm thấy sản phẩm</td>
                                </c:if>
                                <c:forEach var="product" items="${productList}" varStatus="status">

                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${product.name}</td>
                                        <td><fmt:formatNumber value="${product.price}" type="number"
                                                              groupingUsed="true"/> đồng
                                        </td>

                                        <td>
                                            <c:forEach var="category" items="${categories}">
                                                <c:if test="${product.categoryId==category.id}">
                                                    ${category.name}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>${product.status}</td>
                                        <td><img src="${product.image}" alt="" width="100" height="100"
                                                 style="object-fit: cover"></td>

                                        <td>
                                            <button onclick="deleteInfo(`${product.id}`,`${product.name}`)"
                                                    class="btn btn- btn-sm" data-bs-toggle="modal"
                                                    data-bs-target="#exampleModal">
                                                <i class="bi bi-trash text-danger me-2"></i></button>
                                            <button onclick="window.location.href=`/managerProduct?action=update&id=${product.id}`">
                                                <i
                                                        class="bi bi-pencil text-primary"></i></button>
                                        </td>
                                    </tr>

                                </c:forEach>


                                </tbody>
                            </table>
                        </div>
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <form method="post" action="/managerProduct?action=delete">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Xóa đồ uống</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <input hidden="hidden" id="deleteId" name="deleteId">
                                            <span>Bạn có muốn xoá </span> <span id="deleteName"></span> không?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                Huỷ
                                            </button>
                                            <button class="btn btn-primary">Xoá</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <script>
                            function deleteInfo(id, name) {
                                document.getElementById("deleteId").value = id;
                                document.getElementById("deleteName").innerText = name;
                            }

                        </script>
                        <%--END--%>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="${adminAssetsPath}/libs/jquery/dist/jquery.min.js"></script>
<script src="${adminAssetsPath}/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script src="${adminAssetsPath}/js/sidebarmenu.js"></script>
<script src="${adminAssetsPath}/js/app.min.js"></script>
<script src="${adminAssetsPath}/libs/apexcharts/dist/apexcharts.min.js"></script>
<script src="${adminAssetsPath}/libs/simplebar/dist/simplebar.js"></script>
<script src="${adminAssetsPath}/js/dashboard.js"></script>
<!-- solar icons -->
<script src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>

<%-- CODE CỦA BÉ THẢO --%>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- Bootstrap Bundle (đã có Popper) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

<!-- DataTables -->
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableProduct').DataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
            "language": {
                "info": "Hiển thị _START_ đến _END_ của _TOTAL_ mục",
                "infoEmpty": "Không có dữ liệu",
                "paginate": {
                    "next": "Sau",
                    "previous": "Trước"
                }
            }
        });
    });
</script>
<%--END--%>
</body>
</html>
