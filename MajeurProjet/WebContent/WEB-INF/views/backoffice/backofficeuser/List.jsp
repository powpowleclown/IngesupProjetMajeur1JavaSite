<a href = "<c:url value="./AddOrUpdate"></c:url>">Creation</a>
<table class="table-container">
 <thead>
  <tr>
    <th>Firstname</th>
    <th>Surname</th>
    <th>Mail</th>
    <th>Password</th>
    <th>Role</th>
    <th>Show</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  </thead>
<c:forEach items="${model}" var="user">
	<tr>
	   <td>${user.firstname}</td>
	   <td>${user.surname}</td>
	   <td>${user.mail}</td>
	   <td>${user.pwd}</td>
	   <td>${user.role.name}</td>
	   <td><a href = "<c:url value="./Show">
			<c:param name="id_user" value="${user.id}"/>
		</c:url>">Show</a></td>
       <td><a href = "<c:url value="./AddOrUpdate">
			<c:param name="id_user" value="${user.id}"/>
		</c:url>">Update</a></td>
	   <td><a href = "<c:url value="./Delete">
			<c:param name="id_user" value="${user.id}"/>
		</c:url>">Delete</a></td>
	</tr>
</c:forEach>
</table>