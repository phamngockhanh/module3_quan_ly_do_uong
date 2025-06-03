<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="web_dang_ky_style.css">
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false" style="padding-left: 40px;">
                        ĐỒ UỐNG
                    </a>
                    <ul class="dropdown-menu scrollable-dropdown">
                        <li><a class="dropdown-item" href="#">Cà phê</a></li>
                        <li><a class="dropdown-item" href="#">Trà sữa</a></li>
                        <li><a class="dropdown-item" href="#">Nước ép</a></li>
                        <li><a class="dropdown-item" href="#">Sinh tố</a></li>
                        <li><a class="dropdown-item" href="#">Soda</a></li>
                        <li><a class="dropdown-item" href="#">Trà trái cây</a></li>
                        <li><a class="dropdown-item" href="#">Cocktail</a></li>
                    </ul>
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
               data-bs-toggle="offcanvas" data-bs-target="#cartSidebar"
            >
                <i class="bi bi-cart" style="font-size: 1.25rem;"></i>
            </a>

            <a class="nav-link d-flex align-items-center justify-content-center user-icon"
               style="width: 40px; height: 40px;"
               href="#"
               data-bs-toggle="modal" data-bs-target="#loginModal"
            >
                <i class="bi bi-person" style="font-size: 1.25rem;"></i>
            </a>
        </div>

    </nav>
</div>
</body>
</html>
