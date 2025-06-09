<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                <form action="AddToCartServlet" method="post" style="display: inline;">
                                    <input type="hidden" name="productId" value="${product.id}">
                                    <button type="submit" class="btn btn-md btn-outline-warning me-2 add-to-cart-btn"
                                            data-product-id="${product.id}"  aria-controls="cartSidebar">
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
                                <p class="text-muted" name="price">${product.price} <b>VNĐ</b></p>
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>

            <!-- Pagination (nằm giữa khối card) -->
            <div class="d-flex justify-content-center my-4">
                <!-- Previous button -->
                <form action="product" method="get" style="display:inline;">
                    <input type="hidden" name="pageNumber" value="${currentPage - 1}"/>
                    <input type="hidden" name="categoryId" value="${selectedCategoryId}"/>
                    <input type="hidden" name="keyword" value="${keyword}"/>
                    <button type="submit" class="btn btn-sm mx-1"
                            style="background-color: #ffcc99; border: none; font-weight: bold;" ${currentPage == 1 ? 'disabled' : ''}>
                        Previous
                    </button>
                </form>

                <!-- Current page button -->
                <button disabled class="btn btn-sm mx-1"
                        style="background-color: #ffe0b3; color: #cc3300; border: none; font-weight: bold;">
                    ${currentPage} / ${totalPages}
                </button>

                <!-- Next button -->
                <form action="product" method="get" style="display:inline;">
                    <input type="hidden" name="pageNumber" value="${currentPage + 1}"/>
                    <input type="hidden" name="categoryId" value="${selectedCategoryId}"/>
                    <input type="hidden" name="keyword" value="${keyword}"/>
                    <button type="submit" class="btn btn-sm mx-1"
                            style="background-color: #ffcc99; border: none; font-weight: bold;" ${currentPage == totalPages ? 'disabled' : ''}>
                        Next
                    </button>
                </form>
            </div>
        </div>

    </div>
</div>
<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const buttons = document.querySelectorAll('.add-to-cart-btn');

        buttons.forEach(button => {
            button.addEventListener('click', function (event) {
                event.preventDefault();

                const productId = this.getAttribute('data-product-id');

                fetch('AddToCartServlet', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                    },
                    body: 'productId=' + encodeURIComponent(productId)
                })
                    .then(response => response.text())
                    .then(data => {
                        console.log(data); // Hiện thông báo hoặc cập nhật UI giỏ hàng
                        Swal.fire({
                            title: 'Thành công!',
                            text: 'Đã thêm sản phẩm vào giỏ hàng.',
                            icon: 'success',
                            confirmButtonText: 'OK'
                        });
                    })
                    .catch(error => console.error('Error:', error));
            });
        });
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>
