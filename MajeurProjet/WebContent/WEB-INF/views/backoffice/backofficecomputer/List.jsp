<a class="button" href = "<c:url value="./AddOrUpdate"></c:url>">Create a Computer</a>
<br><br>
<table class="table-container">
  <tr>
    <th>Name</th>
    <th>Ip</th>
    <th>Mac</th>
    <th>Room</th>
    <th>State</th>
    <th>Show</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  
	<c:forEach items="${model}" var="computer">
		<tr> 
		   <td>${computer.name}</td>
		   <td>${computer.ip}</td>
		   <td>${computer.mac}</td>
		   <td>${computer.room.name}</td>
		   <td>${computer.getLastHistoricals_cState().name}</td>
		   <td><a href = "<c:url value="./Show">
				<c:param name="id_computer" value="${computer.id}"/>
			</c:url>">Show</a></td>
	       <td><a href = "<c:url value="./AddOrUpdate">
				<c:param name="id_computer" value="${computer.id}"/>
			</c:url>">Update</a></td>
		   <td><a href = "<c:url value="./Delete">
				<c:param name="id_computer" value="${computer.id}"/>
			</c:url>">Delete</a></td>
		</tr>
	</c:forEach>
</table>



