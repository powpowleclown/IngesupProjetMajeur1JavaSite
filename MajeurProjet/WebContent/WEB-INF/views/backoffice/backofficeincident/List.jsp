<c:forEach items="${model}" var="incident">
		<p>${incident.number}</p>
		<p>${incident.description}</p>
		<p>${incident.getComputer().getName()}</p>
</c:forEach>