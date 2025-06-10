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
                            <form>
                                <table class="table">
                                    <tr class="row">
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label for="productName" class="form-label">Tên sản phẩm</label>
                                                <input type="text" class="form-control" id="productName"
                                                       aria-describedby="productHelp">
                                                <div class="form-text">We'll never share your email with
                                                    anyone
                                                    else.
                                                </div>
                                            </div>
                                        </td>
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label for="" class="form-label">Password</label>
                                                <input type="password" class="form-control" id="">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="row">
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label for="" class="form-label">Email address</label>
                                                <input type="email" class="form-control" id=""
                                                       aria-describedby="">
                                                <div id="emailHelp" class="form-text">We'll never share your email with
                                                    anyone
                                                    else.
                                                </div>
                                            </div>
                                        </td>
                                        <td class="col-md-6">
                                            <div class="mb-3">
                                                <label for="" class="form-label">Password</label>
                                                <input type="password" class="form-control" id="">
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div class="mb-3">
                                                <label for="" class="form-label">Email address</label>
                                                <input type="email" class="form-control" id=""
                                                       aria-describedby="">
                                                <div id="" class="form-text">We'll never share your email with
                                                    anyone
                                                    else.
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </table>


                                <div class="mb-3 form-check">
                                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
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

