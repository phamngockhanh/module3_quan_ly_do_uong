<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/8/2025
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="mb-3">
        <label for="formGroupExampleInput0" class="form-label">Name</label>
        <input name="name" required value="${product.name}" type="text" class="form-control" id="formGroupExampleInput0" placeholder="Name">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput" class="form-label">Price</label>
        <input name="price" required value="${product.price}" type="text" class="form-control" id="formGroupExampleInput" placeholder="Price">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput2" class="form-label">CategoryId</label>
        <input name="categoryId" required value="${product.categoryId}" type="text" class="form-control" id="formGroupExampleInput2" placeholder="CategoryId">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput3" class="form-label">Statucs</label>
        <input name="status" required value="${product.status}" type="text" class="form-control" id="formGroupExampleInput3" placeholder="Statucs">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput4" class="form-label">Description</label>
        <input name="description" required value="${product.description}" type="text" class="form-control" id="formGroupExampleInput4" placeholder="Description">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput5" class="form-label">Image</label>
        <input name="image" required value="${product.image}" type="text" class="form-control" id="formGroupExampleInput5" placeholder="Image">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput6" class="form-label">Size</label>
        <input name="size" required value="${product.size}" type="text" class="form-control" id="formGroupExampleInput6" placeholder="Image">
    </div>
    <div class="d-flex gap-2">
        <button type="submit" class="btn btn-warning btn-sm">Add product</button>

    </div>
</form>
</body>
</html>
