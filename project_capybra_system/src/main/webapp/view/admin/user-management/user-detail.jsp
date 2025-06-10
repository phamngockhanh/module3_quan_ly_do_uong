<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="adminAssetsPath" value="${basePath}/assets/admin"/>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Management</title>
    <!-- <link rel="shortcut icon" type="image/png" href="./assets/images/logos/favicon.png" /> -->
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
                            <h2 class="mb-4">Thông tin người dùng</h2>
                            <table class="table table-striped table-bordered">
                                <thead class="table-warning">
                                <tr>
                                    <th colspan="2"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="text-danger fw-bolder">Tên tài khoản</td>
                                    <td>${user.username}</td>
                                </tr>
                                <tr>
                                    <td class="text-danger fw-bolder">Tên người dùng</td>
                                    <td>${user.name}</td>
                                </tr>
                                <tr>
                                    <td class="text-danger fw-bolder">Số điện thoại</td>
                                    <td>${user.phone}</td>
                                </tr>
                                <tr>
                                    <td class="text-danger fw-bolder">Email</td>
                                    <td>${user.email}</td>
                                </tr>
                                <tr>
                                    <td class="text-danger fw-bolder">Địa chỉ</td>
                                    <td>${user.address}</td>
                                </tr>
                                <tr>
                                    <td class="text-danger fw-bolder">Trạng thái tài khoản</td>
                                    <td>${user.accountStatus ? 'Hoạt động' : 'Bị khóa'}</td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <div class="d-flex justify-content-end">
                                            <a type="button" class="btn-warning btn mx-2" href="/admin/user-management">Trở về</a>
                                            <c:if test="${user.accountStatus == true}">
                                                <button type="button" class="btn-danger btn" onclick="deleteInfo('${user.username}', '${user.username}')"
                                                        data-bs-toggle="modal" data-bs-target="#exampleModal">Khóa tài khoản</button>
                                            </c:if>
                                            <c:if test="${user.accountStatus == false}">
                                                <form action="/admin/user-management" method="post">
                                                    <input type="hidden" name="action" value="unblock">
                                                    <input type="hidden" value="${user.userId}" name="userId">
                                                    <input type="hidden" name="username" value="${user.username}">
                                                    <button class="btn-success btn">Mở khóa tài khoản</button>
                                                </form>

                                            </c:if>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

//Modal
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/admin/user-management">
            <input type="hidden" name="action" value="block">
            <input type="hidden" value="${user.userId}" name="userId">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" id="deleteId" name="username">
                    <span>Bạn có muốn khóa tài khoản </span><span id="deleteName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button class="btn btn-primary">Khóa</button>
                </div>
            </div>
        </form>
    </div>
</div>
//Modal onclick
<script>
    function deleteInfo(id, name) {
        document.getElementById("deleteId").value= id;
        document.getElementById("deleteName").innerText= name;
    }
</script>

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
