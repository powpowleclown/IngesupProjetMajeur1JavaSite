<table class="table-container">
	<thead>
		<tr>
			<th>Name</th>
			<th>Ip Mask</th>
			<th>Computers</th>
		</tr>
	</thead>
	<c:forEach items="${model}" var="room">
		<tr>
			<td>${room.name}</td>
			<td>${room.ipmask}</td>
			<td>
				<ul>
					
					<c:forEach items="${room.getComputers()}" var="computer">
								<li class="tab-group"><i class="fa fa-laptop" aria-hidden="true"></i>
								<a href="<c:url value="./Computer">
										<c:param name="id_computer" value="${computer.id}"/>
										</c:url>">${computer.name}</li></a>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</c:forEach>
</table>