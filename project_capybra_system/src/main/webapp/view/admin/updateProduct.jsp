<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/9/2025
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="mb-3">
        <label for="exampleInputEmail0" class="form-label">UpdateProduct</label>
        <input name="id" hidden="hidden" required value="${product.id}"  type="text" class="form-control" id="exampleInputEmail0" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Name</label>
        <input name="name" required value="${product.name}" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Price</label>
        <input name="price" required value="${product.price}" type="text" class="form-control" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail2" class="form-label">CategoryId</label>
        <input name="categoryId" required value="${product.categoryId}" type="text" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail3" class="form-label">Status</label>
        <input name="status" required value="${product.status}" type="text" class="form-control" id="exampleInputEmail3" aria-describedby="emailHelp">
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
