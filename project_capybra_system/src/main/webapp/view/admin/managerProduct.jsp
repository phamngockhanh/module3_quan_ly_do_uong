<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <style>
        /* Hover màu vàng nhạt */
        table.table-hover > tbody > tr:hover {
            background-color: #fff9c4 !important;
        }
    </style>
    <style>
        .form-control:focus {
            border-color: #ffc107 !important;
            box-shadow: 0 0 0 0.25rem rgba(255, 193, 7, 0.25);
        }

        .table-hover tbody tr:hover {
            background-color: #fff9c4 !important; /* vàng nhạt */
        }

        td button {
            border: none;
            background: none;
            padding: 0 4px;
        }

        td i:hover {
            color: #ffc107;
            cursor: pointer;
        }
    </style>
</head>
<body>
<!-- Thanh nút và ô tìm kiếm -->
<div class="d-flex align-items-center gap-3 p-3">
    <div class="d-flex gap-2">
        <button type="button" class="btn btn-warning btn-sm">Add Category</button>
        <button onclick="window.location.href=`/managerProduct?action=add`" type="button"
                class="btn btn-warning btn-sm">Add Product
        </button>
    </div>

    <div class="ms-auto" style="width: 250px;">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" aria-label="Search"
                   aria-describedby="button-addon2">
            <button class="btn btn-warning" type="button" id="button-addon2">Search</button>
        </div>
    </div>
</div>
<p style="color: red">${param.mess}</p>

<!-- Bảng sản phẩm -->
<div class="m-5">
    <table class="table table-hover table-bordered">
        <thead class="table-light">
        <tr style="background-color: #e3b159">
            <th scope="col">No</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Category</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>

        </tr>
        </thead>
        <tbody style="background-color: #fff4e5">
        <c:forEach var="product" items="${productList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>


                    <c:forEach var="category" items="${category}">
                        <c:if test="${product.categoryId==category.id}">
                            ${category.name}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${product.status}</td>

                <td>
                    <button onclick="deleteInfo(`${product.id}`,`${product.name}`)"
                            class="btn btn- btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <i class="bi bi-trash text-danger me-2"></i></button>
                    <button onclick="window.location.href=`/managerProduct?action=update&id=${product.id}`"><i class="bi bi-pencil text-primary"></i></button>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/managerProduct?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xóa đồ uống</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá </span> <span id="deleteName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button class="btn btn-primary">Xoá</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function deleteInfo(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
    function updateInfo(id,name) {
        document.getElementById("updateId").value=id;
        document.getElementById("updateName").value=name;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
