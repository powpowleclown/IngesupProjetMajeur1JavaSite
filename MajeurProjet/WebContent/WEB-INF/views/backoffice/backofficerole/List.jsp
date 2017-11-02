<a href = "<c:url value="./AddOrUpdate"></c:url>">Creation</a>
<table>
  <tr>
    <th>Name</th>
    <th>Role</th>
    <th>Show</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
<c:forEach items="${model}" var="role">
	<tr>
	   <td>${role.name}</td>
	   <td>${role.role}</td>
	   <td><a href = "<c:url value="./Show">
			<c:param name="id_role" value="${role.id}"/>
		</c:url>">Show</a></td>
       <td><a href = "<c:url value="./AddOrUpdate">
			<c:param name="id_role" value="${role.id}"/>
		</c:url>">Update</a></td>
	   <td><a href = "<c:url value="./Delete">
			<c:param name="id_role" value="${role.id}"/>
		</c:url>">Delete</a></td>
	</tr>
</c:forEach>
</table>