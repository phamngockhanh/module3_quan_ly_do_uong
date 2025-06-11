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
<body class="d-flex flex-column min-vh-100 bg-light">
<!--Navbar-->
<jsp:include page="layout/navbar_none_bg.jsp"/>


<div class="container mt-5 min-vh-100">
    <h2 class="mb-4">🛒 Giỏ hàng của bạn</h2>

    <table class="table table-bordered table-striped text-center align-middle">
        <thead class="table-dark">
        <tr>
            <th scope="col">Ảnh</th>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Giá</th>
            <th scope="col">Thành tiền</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td style="width: 100px;">
                    <img src="${item.product.image}" alt="Product Image" class="img-thumbnail"
                         style="width: 80px; height: 80px; object-fit: cover;">
                </td>
                <td>${item.product.name}</td>
                <td class="align-middle">
                    <div class="d-flex justify-content-center align-items-center">
                        <!-- Nút Giảm -->
                        <form method="post" class="m-0 p-0">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="updateAction" value="decrease">
                            <input type="hidden" name="productId" value="${item.product.id}">
                            <input type="hidden" name="quantity" value="${item.quantity}">
                            <button type="submit" class="btn btn-sm btn-outline-secondary px-2 py-1">
                                <i class="bi bi-dash"></i>
                            </button>
                        </form>

                        <!-- Hiển thị số lượng -->
                        <span class="mx-3 fs-5">${item.quantity}</span>

                        <!-- Nút Tăng -->
                        <form method="post" class="m-0 p-0">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="updateAction" value="increase">
                            <!-- đặt tên khác để phân biệt -->
                            <input type="hidden" name="productId" value="${item.product.id}">
                            <input type="hidden" name="quantity" value="${item.quantity}">
                            <button type="submit" class="btn btn-sm btn-outline-secondary px-2 py-1">
                                <i class="bi bi-plus"></i>
                            </button>
                        </form>
                    </div>
                </td>

                <td>
                    <fmt:formatNumber value="${item.product.price}" type="number" groupingUsed="true"/> VNĐ
                </td>
                <td>
                    <fmt:formatNumber value="${item.product.price * item.quantity}" type="number" groupingUsed="true"/>
                    VNĐ
                </td>

                <td>
                    <!-- Button mở Modal -->
                    <button type="button" class="btn btn-sm btn-outline-danger" data-bs-toggle="modal"
                            data-bs-target="#confirmDeleteModal${item.product.id}">
                        <i class="bi bi-trash"></i>
                    </button>

                    <!-- Modal xác nhận XÓA -->
                    <div class="modal fade" id="confirmDeleteModal${item.product.id}" tabindex="-1"
                         aria-labelledby="confirmDeleteModalLabel${item.product.id}" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="confirmDeleteModalLabel${item.product.id}">Xác nhận
                                        xóa</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Đóng"></button>
                                </div>
                                <div class="modal-body">
                                    Bạn có chắc chắn muốn xóa <strong>${item.product.name}</strong> khỏi giỏ hàng không?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>

                                    <!-- Form XÓA -->
                                    <form method="post" class="d-inline">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="productId" value="${item.product.id}">
                                        <button type="submit" class="btn btn-danger">Xóa</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </td>

            </tr>
            <c:set var="totalAmount" value="${totalAmount + (item.product.price * item.quantity)}"/>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th colspan="4" class="text-end">Tổng cộng:</th>
            <th colspan="2" class="text-start text-danger fs-5">
                <fmt:formatNumber value="${totalAmount}" type="number" groupingUsed="true"/> VNĐ
            </th>
        </tr>
        </tfoot>
    </table>


    <!-- Nút tiếp tục mua / thanh toán -->
    <div class="d-flex justify-content-between align-items-center mt-4 gap-2 flex-wrap">
        <a href="/product" class="btn btn-secondary px-4 py-2">
            ← Tiếp tục mua hàng
        </a>

        <c:if test="${empty sessionScope.account}">
            <!-- Nếu chưa đăng nhập thì dùng button mở modal -->
            <button type="button" class="btn btn-success px-4 py-2" data-bs-toggle="modal" data-bs-target="#loginModal2">
                Thanh toán
            </button>
        </c:if>

        <c:if test="${not empty sessionScope.account}">
            <!-- Nếu đã đăng nhập thì submit form bình thường -->
            <form id="checkoutForm" method="post" action="/cart?action=checkout" class="m-0">
                <c:forEach var="item" items="${cartItems}">
                    <input type="hidden" name="productId" value="${item.product.id}" />
                    <input type="hidden" name="quantity" value="${item.quantity}" />
                </c:forEach>

                <button type="submit" class="btn btn-success px-4 py-2">
                    Thanh toán
                </button>
            </form>
        </c:if>
    </div>
</div>
<!-- Footer -->
<jsp:include page="layout/footer.jsp"/>

<div class="modal fade" id="loginModal2" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Yêu cầu đăng nhập</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
            </div>
            <div class="modal-body">
                Bạn cần đăng nhập để tiếp tục thanh toán.
            </div>
            <div class="modal-footer">
                <button  class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#loginModal">Đăng nhập</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
