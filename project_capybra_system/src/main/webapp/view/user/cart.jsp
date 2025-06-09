<%--
  Created by IntelliJ IDEA.
  User: ngock
  Date: 09/06/2025
  Time: 2:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body class="d-flex flex-column min-vh-100">
<!--Navbar-->
<jsp:include page="layout/navbar_none_bg.jsp"/>
<div class="offcanvas offcanvas-end" tabindex="-1" id="cartSidebar"
     data-bs-scroll="true"
     aria-labelledby="cartSidebarLabel" style="z-index: 1055;">
    <div class="offcanvas-header">
        <h5 id="offcanvasRightLabel"><b>Giỏ hàng</b></h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body d-flex flex-column" style="height: calc(100vh - 56px - 56px); overflow-y: auto;">
        <div id="cart-items" class="flex-grow-1 overflow-auto mb-3">
            <c:if test="${not empty sessionScope.cart}">
                <c:forEach var="entry" items="${sessionScope.cart.entrySet()}">
                    <c:set var="productId" value="${entry.key}" />
                    <c:set var="quantity" value="${entry.value}" />
                    <c:set var="product" value="${productDAO.getProductById(productId)}" /> <!-- gọi db lấy product chi tiết -->

                    <div class="d-flex align-items-center justify-content-between py-2 border-bottom" style="border-color: #ccc;">
                        <div class="d-flex align-items-center">
                            <img src="${product.image}" alt="${product.name}"
                                 style="width: 60px; height: 60px; object-fit: cover; border: 1px solid #e3e3e3; border-radius: 5px; margin-right: 10px;">
                            <div>
                                <div class="fw-bold">${product.name}</div>
                                <small class="text-muted">${quantity} x ${product.price} VND</small>
                            </div>
                        </div>
                        <div class="fw-bold text-end" style="white-space: nowrap;">${quantity * product.price} VND</div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty sessionScope.cart}">
                <p>Giỏ hàng trống</p>
            </c:if>
        </div>

        <!-- Tạm tính -->
        <div class="border-top pt-3 mb-2">
            <div class="d-flex justify-content-between">
                <span><strong>Tạm tính:</strong></span>
                <span class="fw-bold" id="cart-subtotal">
          <c:set var="subtotal" value="0" />
          <c:forEach var="entry" items="${sessionScope.cart.entrySet()}">
              <c:set var="product" value="${productDAO.getProductById(entry.key)}" />
              <c:set var="subtotal" value="${subtotal + (entry.value * product.price)}" />
          </c:forEach>
          ${subtotal} VND
        </span>
            </div>
        </div>

        <!-- Nút -->
        <div class="mt-auto pt-3">
            <button class="btn btn-warning w-100 mb-2" style="border-radius: 0">Xem giỏ hàng</button>
            <button class="btn w-100" style="border-radius: 0; border:1px solid black">Thanh toán</button>
        </div>
    </div>
</div>
<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
