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
    <label for="formGroupExampleInput0" class="form-label">Tên</label>
    <input  pattern="[A-Za-zÀ-ỹà-ỹ0-9\s]+" title="không nhập kí tư đặc biệt"
           name="name" required value="${product.name}" type="text" class="form-control" id="formGroupExampleInput0"
           placeholder="Name">
  </div>
  <div class="d-flex gap-2">
    <button type="submit" class="btn btn-warning btn-sm"> Thêm </button>

  </div>
</form>
</body>
</html>
