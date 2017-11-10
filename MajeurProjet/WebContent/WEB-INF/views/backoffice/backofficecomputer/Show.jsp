<a class="button" href="<c:url value="../Incident/AddOrUpdate"></c:url>">Create New Computer</a>
<br><br>
<table class="table-container">
	<thead>
		<tr>
			<th>Computer name</th>
			<th>IP Address</th>
			<th>MAC Address</th>
			<th>Room</th>
			<th>Date</th>
			<th>State</th>
			<th>Note</th>
		</tr>
	</thead>
	<c:forEach items="${model.historicals_c}" var="historical">
		<tr>
			<td>${model.name}</td>
			<td>${model.ip}</td>
			<td>${model.mac}</td>
			<td>${model.room.name}</td>
			<td>${historical.date}</td>
			<td>${historical.state.name}</td>
			<td>${historical.note}</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<a class="button" href="<c:url value="../Incident/AddOrUpdate"></c:url>">Create New Incident</a>
<br><br>
  <h2>Related Incidents</h2>
 
<table class="table-container">
	<thead>
		<tr>
			<th>Number</th>
			<th>Description</th>
			<th>State</th>
			<th>Show</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
	<thead>
		<c:forEach items="${model.incidents}" var="incident">
			<tr>
				<td>${incident.number}</td>
				<td>${incident.description}</td>
				<td>${incident.getLastHistoricals_iState().name}</td>
				<td><a
					href="<c:url value="../Incident/Show">
			<c:param name="id_incident" value="${incident.id}"/>
		</c:url>">Show</a></td>
				<td><a
					href="<c:url value="../Incident/AddOrUpdate">
			<c:param name="id_incident" value="${incident.id}"/>
		</c:url>">Update</a></td>
				<td><a
					href="<c:url value="../Incident/Delete">
			<c:param name="id_incident" value="${incident.id}"/>
		</c:url>">Delete</a></td>
			</tr>
		</c:forEach>
</table>