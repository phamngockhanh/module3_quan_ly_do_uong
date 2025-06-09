<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login & Register</title>
</head>
<body>

<!--Navbar-->
<div class="header-section">
    <nav class="navbar navbar-expand-lg navbar-light bg-warning shadow"
         style="position: fixed; top: 0; left: 0; right: 0; z-index: 1050; height: 100px;">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/homepage" style="padding-left: 40px;">TRANG CHỦ</a>
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
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search"
                       style="border-radius: 0"/>
                <button class="btn btn-outline-dark rounded-circle d-flex align-items-center justify-content-center"
                        type="submit" style="width: 40px; height: 40px;">
                    <i class="bi bi-search" style="font-size: 1.25rem;"></i>
                </button>
            </form>
            <a class="nav-link d-flex align-items-center justify-content-center user-icon"
               style="width: 40px; height: 40px;"
               href="#"
               data-bs-toggle="offcanvas" data-bs-target="#cartSidebar">
                <i class="bi bi-cart" style="font-size: 1.25rem;"></i>
            </a>

            <div class="dropdown">
                <a class="nav-link dropdown-toggle d-flex align-items-center " href="#" role="button"
                   data-bs-toggle="dropdown" aria-expanded="false">
                    Xin chào ${fullname}
                </a>
                <ul class="dropdown-menu dropdown-menu-end shadow">
                    <li><a class="dropdown-item" href="#">Thông tin cá nhân</a></li>
                    <li><a class="dropdown-item" href="#">Lịch sử đơn hàng</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item text-danger" href="/logout">Đăng xuất</a></li>
                </ul>
            </div>
        </div>

    </nav>
</div>


</body>
</html>
