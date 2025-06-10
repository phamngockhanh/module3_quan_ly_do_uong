<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/8/2025
  Time: 10:00 PM
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
        <label for="formGroupExampleInput0" class="form-label">Name</label>
        <input name="name" required value="${product.name}" type="text" class="form-control" id="formGroupExampleInput0"
               placeholder="Name">
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput" class="form-label">Price</label>
        <input name="price" required value="${product.price}" type="text" class="form-control"
               id="formGroupExampleInput" placeholder="Price">
    </div>
    <div class="mb-3">
        <label class="form-label">Category</label>
        <select name="categoryId">
            <option>Name</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>

        <%--        <label for="formGroupExampleInput2" class="form-label">CategoryId</label>--%>
        <%--        <input name="categoryId" required value="${product.categoryId}" type="text" class="form-control" id="formGroupExampleInput2" placeholder="CategoryId">--%>
    </div>
    <div class="mb-3">
        <label class="form-label">Status</label>
        <select name="status" class="form-control" id="formGroupExampleInput3" required>
            <option value="true" ${product.status == 'true' ? 'selected' : ''}>True</option>
            <option value="false" ${product.status == 'false' ? 'selected' : ''}>False</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="formGroupExampleInput4" class="form-label">Image</label>
        <input name="image" required value="${product.image}" type="text" class="form-control"
               id="formGroupExampleInput4" placeholder="Image">
    </div>
    <div class="d-flex gap-2">
        <button type="submit" class="btn btn-warning btn-sm">Add product</button>

    </div>
</form>
</body>
</html>
