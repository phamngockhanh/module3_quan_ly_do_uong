<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<!--navbar-->
<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-warning shadow"
         style="height: 100px;">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link"
                       href="/homepage"
                       style="padding-left: 40px;">TRANG CHỦ</a>
                </li>
                <!-- Dropdown ĐỒ UỐNG -->
                <li class="nav-item">
                    <a class="nav-link" href="/product" style="padding-left: 40px;">ĐỒ UỐNG</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" style="padding-left: 40px;">LIÊN HỆ</a>
                </li>
            </ul>
        </div>
        <a class="navbar-brand" href="#"
           style="position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); height: 100%;">
            <img src="/assets/user/images/logo.png" alt="Logo"
                 style="height: 100%; width: auto; object-fit: contain;">
        </a>

        <div class="d-flex align-items-center" style="gap: 10px;">
            <a class="nav-link d-flex align-items-center justify-content-center position-relative user-icon"
               style="width: 40px; height: 40px;"
               href="/cart"
            >
                <i class="bi bi-cart" style="font-size: 1.25rem;"></i>

                <span id="cart-count-badge"
                      class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
                      style="font-size: 0.7rem; display: none;">
                        1
                </span>
            </a>

            <c:if test="${empty sessionScope.account}">
                <a class="nav-link d-flex align-items-center justify-content-center user-icon"
                   style="width: 40px; height: 40px;"
                   href="#"
                   data-bs-toggle="modal" data-bs-target="#loginModal">
                    <i class="bi bi-person" style="font-size: 1.25rem;"></i>
                </a>
            </c:if>
            <c:if test="${not empty sessionScope.account}">
                <div class="dropdown">
                    <a class="nav-link dropdown-toggle d-flex align-items-center mx-2" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                            ${sessionScope.account.username}
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end shadow ">
                        <li><a class="dropdown-item" href="/profile">Thông tin cá nhân</a></li>
                        <c:if test="${sessionScope.account.roleId == 1}">
                            <li><a class="dropdown-item" href="/history-order">Lịch sử đơn hàng</a></li>
                        </c:if>
                        <c:if test="${sessionScope.account.roleId == 2}">
                            <li><a class="dropdown-item" href="/admin">Trang quản trị</a></li>
                        </c:if>

                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item text-danger" href="/logout">Đăng xuất</a></li>
                    </ul>
                </div>
            </c:if>
        </div>

    </nav>
</div>
<!-- Modal Login -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="border-radius: 0; box-shadow: 0 4px 10px rgba(255, 193, 7, 0.4);">
            <form method="post" action="/login">
                <div class="modal-header">
                    <h5 class="modal-title fw-bold" id="loginModalLabel">ĐĂNG NHẬP</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="username" class="form-label">Tên đăng nhập</label>
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="Nhập tên đăng nhập" style="border-radius: 0"
                               required value="${username}"/>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="Nhập mật khẩu" style="border-radius: 0"
                               required/>
                    </div>
                    <input type="hidden" id="message" name="message" value="${message}">
                    <div class="text-end">
                        <small>Bạn chưa có tài khoản? <a href="/register"
                                                         data-bs-target="#registerModal" style="color: #e3b159;">Đăng ký
                            ngay</a></small>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-transparent"
                            style="border-radius: 0; border:1px solid orange; ">Đăng nhập
                    </button>
                    <button type="button" class="btn btn-warning " style="border-radius: 0;" data-bs-dismiss="modal">
                        Đóng
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
