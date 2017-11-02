<table>
  <tr>
    <th>Name</th>
    <th>Ip Mask</th>
     <th>Computers</th>
  </tr>
<c:forEach items="${model}" var="room">
	<tr>
	   <td>${room.name}</td>
	   <td>${room.ipmask}</td>
	   <td>
		<table>
		  <tr>
		    <th>Name</th>
		    <th>Ip</th>
		  </tr>
			<c:forEach items="${room.getComputers()}" var="computer">
				<tr>
				   <td>${computer.name}</td>
				   <td>${computer.ip}</td>
				<tr>
			</c:forEach>
		</table>
		</td>
	</tr>
</c:forEach>
</table>