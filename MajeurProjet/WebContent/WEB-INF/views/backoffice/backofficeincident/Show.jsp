<table class="table-container">
  <thead>
  <tr>
  	<th>Incident Number</th>
  	<th>Computer name</th>
  	<th>Description</th>
    <th>Date</th>
    <th>State</th>
    <th>Note</th>
  </tr>
  </thead>
	<c:forEach items="${model.historicals_i}" var="historical">
	  <tr>
	  <td>${model.number}</td>
	  <td>${model.computer.name}</td>
	  <td>${model.description}</td>
	    <td>${historical.date}</td>
	    <td>${historical.state.name}</td>
	    <td>${historical.note}</td>
	  </tr>
	</c:forEach>
</table>