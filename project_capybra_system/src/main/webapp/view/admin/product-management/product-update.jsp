<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="adminAssetsPath" value="${basePath}/assets/admin"/>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Management</title>
    <link rel="stylesheet" href="${adminAssetsPath}/css/styles.min.css"/>

</head>
<body>
<!--  Body Wrapper -->
<div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
     data-sidebar-position="fixed" data-header-position="fixed">

    <!--  App Topstrip -->
    <jsp:include page="/view/admin/layout/topstrip.jsp"/>
    <!-- Sidebar Start -->
    <jsp:include page="/view/admin/layout/sidebar.jsp"/>
    <!--  Sidebar End -->
    <!--  Main wrapper -->
    <div class="body-wrapper">
        <!--  Header Start -->
        <jsp:include page="/view/admin/layout/header.jsp"/>
        <!--  Header End -->
        <div class="body-wrapper-inner">
            <div class="container-fluid">
                <div class="card">
                    <div class="card-body row">
                        <div class="col-md-12 mt-5">
                            <h2 class="mb-4">Cập nhật sản phẩm</h2>
                            <form method="post">
                                <table class="table">
                                    <tr class="row">
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label for="formGroupExampleInput0" class="form-label">Tên sản phẩm</label>
                                                <input pattern="[A-Za-zÀ-ỹà-ỹ0-9\s]+" title="Không nhập kí tự đặc biệt"
                                                       name="name" required value="${product.name}" type="text" class="form-control"
                                                       id="formGroupExampleInput0" placeholder="Nhập tên sản phẩm">
                                            </div>
                                        </td>
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label for="formGroupExampleInput" class="form-label">Giá (VND)</label>
                                                <input pattern="[0-9]+" title="Chỉ nhập số" name="price" required value="${product.price}"
                                                       type="text" class="form-control" id="formGroupExampleInput" placeholder="Nhập giá sản phẩm">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="row">
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Loại</label>
                                                <select name="categoryId" class="form-select" required>
                                                    <option disabled selected>-- Chọn loại sản phẩm --</option>
                                                    <c:forEach var="category" items="${categories}">
                                                        <option value="${category.id}" ${category.id == product.categoryId ? 'selected' : ''}>
                                                                ${category.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </td>
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Trạng thái</label>
                                                <select name="status" class="form-select" id="formGroupExampleInput3" required>
                                                    <option value="true" ${product.status == 'true' ? 'selected' : ''}>Còn hàng</option>
                                                    <option value="false" ${product.status == 'false' ? 'selected' : ''}>Hết hàng</option>
                                                </select>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div class="mb-3">
                                                <label for="formGroupExampleInput4" class="form-label">Hình Ảnh</label>
                                                <input name="image" required value="${product.image}" type="text" class="form-control"
                                                       id="formGroupExampleInput4" placeholder="Nhập đường dẫn hình ảnh">
                                            </div>
                                        </td>
                                    </tr>
                                </table>

                                <div class="d-flex gap-2">
                                    <button type="submit" class="btn btn-warning btn-sm">Cập nhật</button>
                                </div>
                            </form>

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

</body>
</html>

