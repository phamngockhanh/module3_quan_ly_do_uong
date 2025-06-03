<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./assets/user/css/register_style.css">
</head>
<body>
<!--Navbar-->
<jsp:include page="layout/navbar_none_bg.jsp"/>
<!--form register-->
<div class="container d-flex justify-content-center align-items-center" style="min-height: 60vh;">
    <div class="register-box">
        <h2 class="mb-4 text-center"><b>ĐĂNG KÝ</b></h2>
        <form method="post" action="">
            <div class="row">
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="fullName" class="form-label">Họ tên</label>
                        <input type="text" class="form-control" name="name" id="fullName" placeholder="Nhập họ tên">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Nhập mật khẩu">
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Số điện thoại</label>
                        <input type="tel" class="form-control" name="phone" id="phone" placeholder="Nhập số điện thoại">
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="username" class="form-label">Tên tài khoản</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="Nhập tên tài khoản">
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Nhập địa chỉ">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="Nhập email">
                    </div>
                </div>
            </div>
            <div class="text-center">
                <button type="submit" class="btn px-5">Đăng ký</button>
            </div>
        </form>
    </div>
</div>
<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</html>