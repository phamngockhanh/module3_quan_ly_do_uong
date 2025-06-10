<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="m-5">
  <table id="tableProduct" class="table table-hover table-bordered">
    <thead class="table-light">
    <tr style="background-color: #e3b159">
      <th scope="col">No</th>
      <th scope="col">Tên</th>
    </tr>
    </thead>
    <tbody style="background-color: #fff4e5">
          <c:forEach var="category" items="${categories}">
            <td>${category.id}</td>
            <td>
              ${category.name}
            </td>
          </c:forEach>
    </tbody>
  </table>
</div>