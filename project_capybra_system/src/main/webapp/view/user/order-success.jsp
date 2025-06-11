<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body class="bg-light min-vh-100">
<jsp:include page="layout/navbar_none_bg.jsp"/>
<div class="container py-5 min-vh-100">
  <div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
      <div class="card shadow-lg border-0 rounded-4">
        <div class="card-body text-center p-5">
          <div class="mb-4">
            <svg xmlns="http://www.w3.org/2000/svg" width="80" height="80" fill="green" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
              <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM6.97 11.03a.75.75 0 0 0 1.07 0L12.03 7l-1.06-1.06L7.5 9.44 5.53 7.47 4.47 8.53l2.5 2.5z"/>
            </svg>
          </div>
          <h2 class="mb-3">Đặt đồ uống thành công!</h2>
          <p class="text-muted mb-4">
            Cảm ơn bạn đã đặt hàng. Đơn hàng của bạn đang được xử lý và sẽ được giao sớm nhất!
          </p>
          <a href="/homepage" class="btn btn-success me-2">Về trang chủ</a>
          <a href="/history-order" class="btn btn-outline-primary">Xem đơn hàng</a>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
