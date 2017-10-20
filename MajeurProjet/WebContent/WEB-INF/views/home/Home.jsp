<c:forEach items="${model}" var="room">
		<p>${room.name}</p>
		<p>${room.ipmask}</p>
		<c:forEach items="${room.getComputers()}" var="computer">
			<p>${computer.name}</p>
			<p>${computer.ip}</p>
		</c:forEach>
</c:forEach>