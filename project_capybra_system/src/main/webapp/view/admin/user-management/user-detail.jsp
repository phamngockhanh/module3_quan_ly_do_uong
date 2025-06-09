<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="adminAssetsPath" value="${basePath}/assets/admin"/>
<c:import url="/view/common/confirm-modal.jsp">
    <c:param name="actionUrl" value="" />
    <c:param name="confirmMessage" value="" />
</c:import>
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
                                        <form class="d-flex justify-content-end" action="/admin/user-management"  method="post">
                                            <input type="hidden" value="${user.accountId}" name="accountId">
                                            <button class="btn-danger btn ">Khóa tài khoản</button>
                                        </form>
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
