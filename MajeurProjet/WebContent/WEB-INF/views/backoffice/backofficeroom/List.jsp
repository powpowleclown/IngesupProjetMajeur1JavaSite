<a href="<c:url value="./AddOrUpdate"></c:url>">Creation</a>
<table class="table-container">
<thead>
	<tr>
		<th>Name</th>
		<th>Ip Mask</th>
		<th>Show</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
</thead>
	<c:forEach items="${model}" var="room">
		<tr>
			<td>${room.name}</td>
			<td>${room.ipmask}</td>
			<td><a
				href="<c:url value="./Show">
			<c:param name="id_room" value="${room.getId()}"/>
		</c:url>">Show</a></td>
			<td>
			<a href="<c:url value="./AddOrUpdate">
			<c:param name="id_room" value="${room.getId()}"/>	
		</c:url>">Update</a>
		</td>
			<td><a
				href="<c:url value="./Delete">
			<c:param name="id_room" value="${room.getId()}"/>
		</c:url>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
