<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<%-- Detail Product --%>
<main class="flex-grow-1">
    <div class="container my-5">
        <div class="card shadow-lg border-0 rounded-4 p-4">
            <div class="row g-4">
                <!-- Ảnh sản phẩm -->
                <div class="col-md-6 text-center">
                    <img src="${product.image}" alt="${product.name}" class="img-fluid rounded-3 border"
                         style="max-height: 500px; object-fit: contain;">
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
                        <h3 class="text-danger fw-bold mb-0"><fmt:formatNumber value="${product.price}" type="number"
                                                                               groupingUsed="true"/> VNĐ</h3>
                    </div>

                    <!-- Mô tả -->
                    <div class="pb-3 mb-4 border-bottom">
                        <p class="text-secondary fs-5 mb-0">${product.description}</p>
                    </div>

                    <!-- Nút thêm vào giỏ hàng -->
                    <form action="AddToCartServlet" method="post" style="display: inline;" target="hidden_iframe">
                        <button class="btn btn-outline-warning btn-lg w-100 add-to-cart-btn"
                                data-product-id="${product.id}">
                            <input type="hidden" name="productId" value="${product.id}"></input>
                            <i class="bi bi-cart-plus me-2"></i> Thêm vào giỏ hàng
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<iframe name="hidden_iframe" style="display:none;"></iframe>
<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11; display: none;" id="toastContainer">
    <div id="liveToast" class="toast align-items-center text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
            <div class="toast-body" id="toastBody">
                Đã thêm sản phẩm vào giỏ hàng!
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        var toastElement = document.getElementById('liveToast');
        if (toastElement) {
            var toast = new bootstrap.Toast(toastElement);
            toast.show();
        }
    });
</script>
<script>
    window.addEventListener('message', function(event) {
        console.log('Received message:', event.data);

        if (event.data === 'addToCartSuccess') {
            var toastContainer = document.getElementById('toastContainer');
            toastContainer.style.display = 'block';

            var toastElement = document.getElementById('liveToast');
            var toast = new bootstrap.Toast(toastElement);
            toast.show();
        }
    });

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
