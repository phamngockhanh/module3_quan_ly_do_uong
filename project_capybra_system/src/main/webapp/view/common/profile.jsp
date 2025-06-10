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
<jsp:include page="/view/user/layout/navbar_none_bg.jsp"/>
<!--form register-->
<div class="container d-flex justify-content-center align-items-center" style="min-height: 60vh;">
    <div class="register-box">
        <h2 class="mb-4 text-center"><b>Thông tin tài khoản</b></h2>
        <form id="register-form" method="post" action="">
            <div class="row">
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="fullName" class="form-label">Họ tên</label>
                        <input type="text" class="form-control" name="name" id="fullName" placeholder="Nhập họ tên" value="${user.name}">
                        <div id="error-fullName" class="text-danger small mt-1"></div>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Nhập mật khẩu" disabled
                               value="${not empty user ? '11111111' : ''}">
                        <div id="error-password" class="text-danger small mt-1"></div>
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Số điện thoại</label>
                        <input type="tel" class="form-control" name="phone" id="phone" placeholder="Nhập số điện thoại" value="${user.phone}">
                        <div id="error-phone" class="text-danger small mt-1"></div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="username" class="form-label">Tên tài khoản</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="Nhập tên tài khoản" disabled value="${user.username}">
                        <div id="error-username" class="text-danger small mt-1"></div>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Nhập địa chỉ" value="${user.address}">
                        <div id="error-address" class="text-danger small mt-1"></div>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="Nhập email" value="${user.email}">
                        <div id="error-email" class="text-danger small mt-1"></div>
                    </div>
                </div>
            </div>
            <div class="text-center">
                <input hidden="hidden" id="message" name="message" value="${message}">
                <button type="submit" class="btn btn-outline-warning px-5">Cập nhật</button>
                <button type="reset" class="btn btn-outline-warning px-5">Hủy thay đổi</button>
                <a type="button" href="/" class="btn btn-danger px-5">Trở về</a>
                <div id="error-account" class="text-danger small mt-1"></div>
            </div>
        </form>
    </div>
</div>
<!-- Footer -->
<jsp:include page="/view/user/layout/footer.jsp"/>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        let message = document.getElementById("message").value;
        if (message === "update-success") {
            Swal.fire({
                title: 'Thành công!',
                text: 'Cập nhật thông tin hoàn tất',
                icon: 'success',
                confirmButtonText: 'OK'
            });

        }else if (message === "update-success"){
            Swal.fire({
                title: 'Lỗi!',
                text: 'Cập nhật thất bại do lỗi.',
                icon: 'error',
                confirmButtonText: 'OK'
            });
        }
    });
</script>

</body>
<script src="/assets/user/js/register-validation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</html>