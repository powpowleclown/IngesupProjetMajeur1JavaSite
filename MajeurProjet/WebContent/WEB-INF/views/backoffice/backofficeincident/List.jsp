<a href = "<c:url value="./AddOrUpdate"></c:url>">Creation</a>
<table class="table-container">
<thead>
  <tr>
    <th>Number</th>
    <th>Description</th>
    <th>Computer</th>
    <th>State</th>
    <th>Show</th>
    <th>Update</th>
    <th>Delete</th>   
  </tr>
</thead>


<c:forEach items="${model}" var="incident">
	 <tr>
	    <td>${incident.number}</td>
	    <td>${incident.description}</td>
	    <td>${incident.computer.name}</td>
	    <td>${incident.getLastHistoricals_iState().name}</td>
	    <td><a href = "<c:url value="./Show">
			<c:param name="id_incident" value="${incident.id}"/>
		</c:url>">Show</a></td>
	    <td><a href = "<c:url value="./AddOrUpdate">
			<c:param name="id_incident" value="${incident.id}"/>
		</c:url>">Update</a></td>
	    <td><a href = "<c:url value="./Delete">
			<c:param name="id_incident" value="${incident.id}"/>
		</c:url>">Delete</a></td>	    
	 </tr>
</c:forEach>
</table>