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
                            <h2 class="mb-4">Danh sách người dùng</h2>
                            <table id="userTable" class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <td colspan="5">
                                        <form class="d-flex align-content-start" action="" method="get">
                                            <input type="text" class="form-control w-50" placeholder="Nhập tên..." name="name" value="${name}">
                                            <select class="form-select w-25" name="status">
                                                <option value="-1" <c:if test="${status == -1 || empty status}">selected</c:if>>--> Trạng thái tài khoản <--</option>
                                                <option value="1" <c:if test="${status == 1}">selected</c:if>>Hoạt động</option>
                                                <option value="0" <c:if test="${status == 0}">selected</c:if>>Bị khóa</option>
                                            </select>
                                            <button class="btn btn-outline-warning w-25">Tìm kiếm</button>
                                        </form>
                                    </td>
                                </tr>
                                </thead>

                                <thead class="table-primary">
                                <tr>
                                    <th>#</th>
                                    <th>Tên tài khoản</th>
                                    <th>Họ và tên</th>
                                    <th>Trạng thái</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${users}" varStatus="index">
                                    <tr>
                                        <td>${index.count}</td>
                                        <td>${item.username}</td>
                                        <td>${item.name}</td>
                                        <td>${item.accountStatus ? '<span class="badge bg-success">Hoạt động</span>' :
                                                '<span class="badge bg-danger">Bị khóa</span>' }</td>
                                        <td>
                                            <form method="get" action="/admin/user-management">
                                                <input type="hidden" name="userId" value="${item.userId}">
                                                <button class="btn btn-outline-info">Chi tiết</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tr>
                                    <td colspan="5">
                                        <div class="d-flex justify-content-center align-items-center">
                                            <nav aria-label="Page navigation example">
                                                <ul class="pagination" id="pagination">
                                                    <li class="page-item">
                                                        <a class="page-link" href="#" aria-label="Previous">
                                                            <span aria-hidden="true">&laquo;</span>
                                                        </a>
                                                    </li>
                                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                    <li class="page-item">
                                                        <a class="page-link" href="#" aria-label="Next">
                                                            <span aria-hidden="true">&raquo;</span>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    const rowsPerPage = 5;
    const table = document.getElementById("userTable");
    const tbody = table.querySelector("tbody");
    const rows = tbody.querySelectorAll("tr");
    const pagination = document.getElementById("pagination");

    function displayPage(page) {
        const start = (page - 1) * rowsPerPage;
        const end = start + rowsPerPage;

        rows.forEach((row, index) => {
            row.style.display = (index >= start && index < end) ? "" : "none";
        });

        updatePagination(page);
    }

    function updatePagination(currentPage) {
        const totalPages = Math.ceil(rows.length / rowsPerPage);
        pagination.innerHTML = "";

        const createPageItem = (page, label = page, active = false, disabled = false) => {
            const li = document.createElement("li");
            li.className = `page-item ${active ? "active" : ""} ${disabled ? "disabled" : ""}`;

            const a = document.createElement("a");
            a.className = "page-link";
            a.href = "#";
            a.textContent = label;
            a.onclick = (e) => {
                e.preventDefault();
                if (!disabled) displayPage(page);
            };

            li.appendChild(a);
            return li;
        };

        pagination.appendChild(createPageItem(currentPage - 1, "«", false, currentPage === 1));

        for (let i = 1; i <= totalPages; i++) {
            pagination.appendChild(createPageItem(i, i, i === currentPage));
        }

        pagination.appendChild(createPageItem(currentPage + 1, "»", false, currentPage === totalPages));
    }

    // Khởi tạo
    displayPage(1);
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
