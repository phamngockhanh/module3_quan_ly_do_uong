<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login & Register</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./assets/user/css/home_page_style.css">
</head>
<body class="d-flex flex-column min-vh-100">

<!--Navbar-->
<jsp:include page="layout/navbar.jsp"/>
<!-- Menu bestseller -->
<section class="drink-menu py-5">
    <div class="container text-center">
        <section class="drink-menu py-5">
            <div class="container">
                <div class="row align-items-center text-center text-md-start">

                    <div class="col-md-4 order-md-3 d-flex justify-content-md-end mb-3 mb-md-0">
                        <a href="#" class="text-dark text-decoration-none fw-semibold">XEM THÊM →</a>
                    </div>

                    <div class="col-md-4 order-md-2 mb-3 mb-md-0">
                        <p class="text-muted mb-0">
                            Từ các loại trà thảo mộc mát lạnh đến cà phê đậm đà, nước ép trái cây tươi mát và nhiều loại
                            đồ uống sáng tạo khác. Khám phá menu đồ uống hấp dẫn của chúng tôi!
                        </p>
                    </div>

                    <div class="col-md-4 order-md-1">
                        <h6 class="text-uppercase text-secondary mb-1">ĐỒ UỐNG ĐẶC BIỆT</h6>
                        <h2 class="fw-bold mb-0">MENU ĐỒ UỐNG</h2>
                    </div>

                </div>
            </div>

        </section>


        <div class="row mt-5">
            <!-- Đồ uống 1 -->

            <div class="col-md-3 mb-4">
                <img src="https://culacstudio.com/wp-content/uploads/2021/08/NG_1164-2-scaled-1.jpg"
                     alt="Trà Đào"
                     class="img-fluid mb-3"
                     style="height: 200px; width: 200px; object-fit: cover; border: 1px solid yellow;">
                <div class="icons mb-2">
                    <button class="btn btn-sm btn-outline-warning me-2 add-to-cart-btn" data-bs-toggle="offcanvas" data-bs-target="#cartSidebar" aria-controls="cartSidebar">
                        <i class="bi bi-cart"></i>
                    </button>
                    <a href="#" class="btn btn-sm btn-outline-secondary">
                        <i class="bi bi-eye"></i>
                    </a>
                </div>
                <p class="text-secondary">Đặc biệt</p>
                <h5 class="fw-bold">TRÀ ĐÀO</h5>
                <p class="text-muted">45,000 VND</p>
                <div class="text-warning">
                    ★★★★★
                </div>
            </div>

        </div>
    </div>
</section>
<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>
<!-- Modal Login -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="border-radius: 0; box-shadow: 0 4px 10px rgba(255, 193, 7, 0.4);">
            <form>
                <div class="modal-header">
                    <h5 class="modal-title fw-bold" id="loginModalLabel">ĐĂNG NHẬP</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="username" class="form-label">Tên đăng nhập</label>
                        <input type="text" class="form-control" id="username" placeholder="Nhập tên đăng nhập" style="border-radius: 0"
                               required/>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" id="password" placeholder="Nhập mật khẩu" style="border-radius: 0"
                               required/>
                    </div>
                    <div class="text-end">
                        <small>Bạn chưa có tài khoản? <a href="/register"
                                                         data-bs-target="#registerModal" style="color: #e3b159;">Đăng ký ngay</a></small>
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
<!--off canvas sidebar-->
<jsp:include page="layout/canvas_sidebar.jsp"/>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</html>
