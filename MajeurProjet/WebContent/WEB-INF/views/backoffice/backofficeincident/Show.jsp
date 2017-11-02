<p>${model.number}</p>
<p>${model.description}</p>
<p>${model.computer.name}</p>
<table>
  <tr>
    <th>Date</th>
    <th>State</th>
    <th>Note</th>
  </tr>
	<c:forEach items="${model.historicals_i}" var="historical">
	  <tr>
	    <td>${historical.date}</td>
	    <td>${historical.state.name}</td>
	    <td>${historical.note}</td>
	  </tr>
	</c:forEach>
</table>