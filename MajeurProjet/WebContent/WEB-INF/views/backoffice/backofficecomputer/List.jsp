<a href = "<c:url value="./AddOrUpdate"></c:url>">Creation</a>
<c:forEach items="${model}" var="computer">
		<p>${computer.name}</p>
		<p>${computer.ip}</p>
		<p>${computer.getRoom().getName()}</p>
		<a href = "<c:url value="./AddOrUpdate">
			<c:param name="id_computer" value="${computer.getId()}"/>
		</c:url>">Update</a>
		<a href = "<c:url value="./Delete">
			<c:param name="id_computer" value="${computer.getId()}"/>
		</c:url>">Delete</a>
</c:forEach>