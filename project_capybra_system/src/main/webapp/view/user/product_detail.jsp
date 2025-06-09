<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="d-flex flex-column min-vh-100">
<!--Navbar-->
<jsp:include page="layout/navbar_none_bg.jsp"/>
<%--Detail Product--%>
<main class="flex-grow-1">
    <div class="container my-5">
        <div class="row">
            <!-- Ảnh sản phẩm -->
            <div class="col-md-6">
                <img src="${product.image}" alt="Ảnh sản phẩm" class="img-fluid rounded shadow">
            </div>

            <!-- Thông tin sản phẩm -->
            <div class="col-md-6">
                <h1 class="mb-3" name="nameProduct">${product.name}</h1>
                <p name="category">
                    <c:forEach var="category" items="${categories}">
                        <c:if test="${product.categoryId == category.id}">
                            ${category.name}
                        </c:if>
                    </c:forEach>
                </p>
                <h3 class="text-danger mb-4" name="price">${product.price}đ</h3>
                <p name="description">
                    ${product.description}
                </p>

                <!-- Nút thêm vào giỏ hàng -->
                <button class="btn btn-primary btn-lg mt-3">
                    <i class="bi bi-cart-plus"></i> Thêm vào giỏ hàng
                </button>
            </div>
        </div>
    </div>
</main>

<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</html>
