<a href = "<c:url value="./AddOrUpdate"></c:url>">Creation</a>
<table class="table-container">
  <tr>
    <th>Name</th>
    <th>Table</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
<c:forEach items="${model}" var="state">
	 <tr>
	    <td>${state.name}</td>
	    <td>${state.table}</td>
	    <td>	<a href = "<c:url value="./AddOrUpdate">
			<c:param name="id_state" value="${state.id}"/>
		</c:url>">Update</a></td>
   	    <td><a href = "<c:url value="./Delete">
			<c:param name="id_state" value="${state.id}"/>
		</c:url>">Delete</a></td>
	 </tr>
</c:forEach>
</table>