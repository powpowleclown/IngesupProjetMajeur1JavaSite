<div class="card">
<i class="fa fa-archive fa-5x" aria-hidden="true"></i>
	<p>${model.name}</p>
	<p>${model.ipmask}</p>
</div>


<a class="button" href = "<c:url value="../Computer/AddOrUpdate"></c:url>">Create New Computer</a>
<br><br>
<table class="table-container">
<thead>
  <tr>
    <th>Name</th>
    <th>Ip</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  </thead>
<c:forEach items="${model.computers}" var="computer">
  <tr>
    <td>${computer.name}</td>
    <td>${computer.ip}</td>
    <td><a href = "<c:url value="../Computer/AddOrUpdate">
			<c:param name="id_computer" value="${computer.getId()}"/>
		</c:url>">Update</a></td>
    <td><a href = "<c:url value="../Computer/Delete">
			<c:param name="id_computer" value="${computer.getId()}"/>
		</c:url>">Delete</a></td>
  </tr>	
</c:forEach>
</table>

