<p>${model.number}</p>
<p>${model.description}</p>
<p>${model.computer.name}</p>
<a href = "<c:url value="../Incident/AddOrUpdate"></c:url>">Creation</a>
<table>
  <tr>
    <th>Date</th>
    <th>State</th>
  </tr>
	<c:forEach items="${model.historicals_i}" var="historical">
	  <tr>
	    <td>${historical.date}</td>
	    <td>${historical.state.name}</td>
	  </tr>
	</c:forEach>
</table>