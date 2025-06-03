<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login & Register</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link rel="stylesheet" href="/assets/user/css/home_page_style.css">
</head>
<body class="d-flex flex-column min-vh-100">

<!--off canvas sidebar-->
<div class="offcanvas offcanvas-end" tabindex="-1" id="cartSidebar"
     data-bs-scroll="true"
     aria-labelledby="cartSidebarLabel" style="z-index: 1055;">
  <div class="offcanvas-header">
    <h5 id="offcanvasRightLabel"><b>Giỏ hàng</b></h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body d-flex flex-column" style="height: calc(100vh - 56px - 56px); overflow-y: auto;">
    <!-- Nội dung giỏ hàng (danh sách sản phẩm) -->
    <div id="cart-items" class="flex-grow-1 overflow-auto mb-3">
      <!-- Sản phẩm sẽ được thêm vào đây -->
      <div class="d-flex align-items-center justify-content-between py-2 border-bottom" style="border-color: #ccc;">
        <div class="d-flex align-items-center">
          <img src="https://culacstudio.com/wp-content/uploads/2021/08/NG_1164-2-scaled-1.jpg"
               alt="Trà Đào"
               style="width: 60px; height: 60px; object-fit: cover; border: 1px solid #e3e3e3; border-radius: 5px; margin-right: 10px;">
          <div>
            <div class="fw-bold">TRÀ ĐÀO</div>
            <small class="text-muted">2 x 45.000 VND</small>
          </div>
        </div>
        <div class="fw-bold text-end" style="white-space: nowrap;">90.000 VND</div>
      </div>
    </div>

    <!-- Khu vực Tạm tính -->
    <div class="border-top pt-3 mb-2">
      <div class="d-flex justify-content-between">
        <span><strong>Tạm tính:</strong></span>
        <span class="fw-bold" id="cart-subtotal">0 VND</span>
      </div>
    </div>
    <!-- Nút ở cuối -->
    <div class="mt-auto pt-3">
      <button class="btn btn-warning w-100 mb-2" style="border-radius: 0">Xem giỏ hàng</button>
      <button class="btn w-100" style="border-radius: 0; border:1px solid black">Thanh toán</button>
    </div>
  </div>
</div>

</body>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</html>