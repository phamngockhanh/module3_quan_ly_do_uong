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
<!--Navbar-->
<jsp:include page="layout/navbar_none_bg.jsp"/>
<%--Display Product--%>
<div class="container mt-5" style="min-height: 100vh;">
    <div class="row">

        <!-- Filter Sidebar -->
        <div class="col-md-3 mb-4">
            <div class="border p-3 rounded-0 shadow-sm">
                <h5>Tìm kiếm sản phẩm</h5>
                <form>
                    <!-- Search Input -->
                    <div class="mb-3">
                        <input name="keyword" type="text" class="form-control" placeholder="Nhập tên đồ uống..."
                               value="${keyword}">
                    </div>

                    <!-- Select Drink Type -->
                    <div class="mb-3">
                        <label for="drinkType" class="form-label">Chọn loại đồ uống</label>
                        <select class="form-select" id="drinkType" name="categoryId">
                            <option value="0">Tất cả</option>
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}"
                                        <c:if test="${category.id==selectedCategoryId}">selected</c:if>>${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <!-- Search Button -->
                    <input type="hidden" name="action" value="filter">
                    <button type="submit" class="btn btn-warning w-100 rounded-0">Tìm kiếm</button>
                </form>
            </div>
        </div>


        <!-- Drink Cards -->
        <div class="col-md-9">
            <div class="row g-4">
                <!-- Card 1 -->
                <c:forEach var="product" items="${products}">
                    <div class="col-md-4">
                        <div class="card h-100 shadow-sm rounded-0">
                            <img src="${product.image}"
                                 class="card-img-top rounded-0"
                                 style="width: 100%; height: 200px; object-fit: cover;">
                            <div class="icons d-flex justify-content-center gap-2 my-2">
                                <form action="AddToCartServlet" method="post" style="display: inline;" target="hidden_iframe">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <button type="submit" class="btn btn-md btn-outline-warning me-2 btn-add-to-cart" aria-controls="cartSidebar" data-product-id="${product.id}">
                                        <i class="bi bi-cart"></i>
                                    </button>
                                    <a href="product?action=detail&id=${product.id}"
                                       class="btn btn-md btn-outline-secondary">
                                        <i class="bi bi-eye"></i>
                                    </a>
                                </form>
                            </div>
                            <div class="card-body text-center">
                                <h5 class="card-title" name="productName">${product.name}</h5>
                                <p class="card-text" name="description">${product.description}</p>
                                <p class="text-muted" name="price"><b><fmt:formatNumber value="${product.price}" type="number" groupingUsed="true" /></b> VNĐ</p>
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>

            <!-- Pagination (nằm giữa khối card) -->
            <div class="d-flex justify-content-center align-items-center gap-2 my-4">
                <!-- Previous button -->
                <form action="product" method="get" class="m-0 p-0">
                    <input type="hidden" name="pageNumber" value="${currentPage - 1}"/>
                    <input type="hidden" name="categoryId" value="${selectedCategoryId}"/>
                    <input type="hidden" name="keyword" value="${keyword}"/>
                    <button type="submit" class="btn btn-sm px-3 py-2"
                            style="background-color: #ffcc99; border: none; font-weight: bold;" ${currentPage == 1 ? 'disabled' : ''}>
                        <
                    </button>
                </form>

                <!-- Current page button (to và đậm hơn) -->
                <div class="px-4 py-2 rounded"
                     style="background-color: #ffa64d; color: white; font-weight: bold; font-size: 1.2rem;">
                    ${currentPage} / ${totalPages}
                </div>

                <!-- Next button -->
                <form action="product" method="get" class="m-0 p-0">
                    <input type="hidden" name="pageNumber" value="${currentPage + 1}"/>
                    <input type="hidden" name="categoryId" value="${selectedCategoryId}"/>
                    <input type="hidden" name="keyword" value="${keyword}"/>
                    <button type="submit" class="btn btn-sm px-3 py-2"
                            style="background-color: #ffcc99; border: none; font-weight: bold;" ${currentPage == totalPages ? 'disabled' : ''}>
                        >
                    </button>
                </form>
            </div>

        </div>

    </div>
</div>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
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
</body>
</html>
