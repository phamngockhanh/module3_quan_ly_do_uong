<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="d-flex flex-column min-vh-100">
<!--Navbar-->
<jsp:include page="layout/navbar_none_bg.jsp"/>
<%-- Detail Product --%>
<main class="flex-grow-1">
    <div class="container my-5">
        <div class="card shadow-lg border-0 rounded-4 p-4">
            <div class="row g-4">
                <!-- Ảnh sản phẩm -->
                <div class="col-md-6 text-center">
                    <img src="${product.image}" alt="${product.name}" class="img-fluid rounded-3 border" style="max-height: 500px; object-fit: contain;">
                </div>

                <!-- Thông tin sản phẩm -->
                <div class="col-md-6 d-flex flex-column justify-content-center">

                    <!-- Tên sản phẩm -->
                    <div class="pb-3 mb-3 border-bottom">
                        <h1 class="fw-bold text-dark mb-0">${product.name}</h1>
                    </div>

                    <!-- Danh mục -->
                    <div class="pb-3 mb-3 border-bottom">
                        <p class="text-muted fs-5 mb-0">
                            <strong>Danh mục:</strong>
                            <c:forEach var="category" items="${categories}">
                                <c:if test="${product.categoryId == category.id}">
                                    ${category.name}
                                </c:if>
                            </c:forEach>
                        </p>
                    </div>

                    <!-- Giá -->
                    <div class="pb-3 mb-3 border-bottom">
                        <h3 class="text-danger fw-bold mb-0">${product.price} đ</h3>
                    </div>

                    <!-- Mô tả -->
                    <div class="pb-3 mb-4 border-bottom">
                        <p class="text-secondary fs-5 mb-0">${product.description}</p>
                    </div>

                    <!-- Nút thêm vào giỏ hàng -->
                    <button class="btn btn-outline-warning btn-lg w-100 add-to-cart-btn" data-product-id="${product.id}">
                        <i class="bi bi-cart-plus me-2"></i> Thêm vào giỏ hàng
                    </button>

                </div>
            </div>
        </div>
    </div>
</main>



<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</html>
