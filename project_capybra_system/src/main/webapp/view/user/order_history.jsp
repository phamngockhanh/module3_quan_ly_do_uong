<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>Title</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link rel="stylesheet" href="./assets/user/css/product_style.css">
</head>
<body class="d-flex flex-column min-vh-100">

<!-- Navbar -->
<jsp:include page="layout/navbar_none_bg.jsp"/>

<!-- Container danh sách đơn hàng -->
<div class="container my-5 min-vh-100">
  <h2 class="mb-4">📦 Danh sách đơn hàng đã mua</h2>

  <div class="table-responsive">
    <table class="table table-striped table-hover align-middle">
      <thead class="table-warning">
      <tr>
        <th scope="col">Mã đơn hàng</th>
        <th scope="col">Ngày đặt</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">Tổng tiền</th>
        <th scope="col">Thao tác</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="order" items="${summaryDtoList}">
        <tr>
          <td>#DH00${order.orderId}</td>
          <td>
            <fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd"/>
          </td>
          <td>
            <c:choose>
              <c:when test="${order.status eq 'Đã giao'}">
                <span class="badge bg-success">Đã giao</span>
              </c:when>
              <c:when test="${order.status eq 'Đang giao'}">
                <span class="badge bg-warning text-dark">Đang giao</span>
              </c:when>
              <c:when test="${order.status eq 'Đã hủy'}">
                <span class="badge bg-secondary">Đã hủy</span>
              </c:when>
              <c:otherwise>
                <span class="badge bg-light text-dark">${order.status}</span>
              </c:otherwise>
            </c:choose>
          </td>
          <td>
            <fmt:formatNumber value="${order.totalPrice}" type="number" groupingUsed="true"/> VNĐ
          </td>
          <td>
            <a href="/order-detail?id=${order.orderId}" class="btn btn-sm btn-primary">Xem chi tiết</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
