<%--
  Created by IntelliJ IDEA.
  User: ngock
  Date: 04/06/2025
  Time: 11:42 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./assets/user/css/product_style.css">
</head>
<body>
<!--Navbar-->
<jsp:include page="layout/navbar_none_bg.jsp"/>
<%--Display Product--%>
<div class="container mt-5">
    <div class="row">

        <!-- Filter Sidebar -->
        <div class="col-md-3 mb-4">
            <div class="border p-3 rounded-0 shadow-sm">
                <h5>Bộ lọc</h5>
                <form>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="tra-sua" id="filter1">
                        <label class="form-check-label" for="filter1">Trà Sữa</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="ca-phe" id="filter2">
                        <label class="form-check-label" for="filter2">Cà Phê</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="sinh-to" id="filter3">
                        <label class="form-check-label" for="filter3">Sinh Tố</label>
                    </div>
                </form>
                <h5>Giá sản phẩm</h5>
                <form>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="tra-sua" id="filter4">
                        <label class="form-check-label" for="filter1">Trà Sữa</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="ca-phe" id="filter5">
                        <label class="form-check-label" for="filter2">Cà Phê</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="sinh-to" id="filter6">
                        <label class="form-check-label" for="filter3">Sinh Tố</label>
                    </div>
                    <button type="button" class="btn btn-warning mt-3 w-100 rounded-0">Áp dụng</button>
                </form>
            </div>
        </div>

        <!-- Drink Cards -->
        <div class="col-md-9">
            <div class="row g-4">

                <!-- Card 1 -->
                <div class="col-md-4">
                    <div class="card h-100 shadow-sm rounded-0">
                        <img src="https://culacstudio.com/wp-content/uploads/2021/08/NG_1164-2-scaled-1.jpg"
                             class="card-img-top rounded-0"
                             alt="Cà Phê Sữa Đá"
                             style="width: 100%; height: 200px; object-fit: cover;">
                        <div class="icons d-flex justify-content-center gap-2 my-2">
                            <button class="btn btn-md btn-outline-warning me-2 add-to-cart-btn" data-bs-toggle="offcanvas" data-bs-target="#cartSidebar" aria-controls="cartSidebar">
                                <i class="bi bi-cart"></i>
                            </button>
                            <a href="#" class="btn btn-md btn-outline-secondary">
                                <i class="bi bi-eye"></i>
                            </a>
                        </div>
                        <div class="card-body text-center">
                            <h5 class="card-title">Cà Phê Sữa Đá</h5>
                            <p class="card-text">Đậm đà truyền thống, hương vị Việt.</p>
                            <p class="text-muted">45,000 VND</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
