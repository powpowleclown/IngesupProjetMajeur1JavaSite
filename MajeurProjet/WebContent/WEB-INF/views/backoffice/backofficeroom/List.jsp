<a href = "<c:url value="./AddOrUpdate"></c:url>">Creation</a>
<c:forEach items="${model}" var="room">
		<p>${room.name}</p>
		<p>${room.ipmask}</p>
		<a href = "<c:url value="./AddOrUpdate">
			<c:param name="id_room" value="${room.getId()}"/>
		</c:url>">Update</a>
		<a href = "<c:url value="./Delete">
			<c:param name="id_room" value="${room.getId()}"/>
		</c:url>">Delete</a>
</c:forEach>