<c:choose>
  <c:when test="${model != null}">
    <form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" value="${model.getName()}"/>
		<label for="ip">Ip :</label>
		<input type="text" name="ip" id="ip" value="${model.getIp()}"/>
		<label for="id_room">Id Room :</label>
		<input type="text" name="id_room" id="id_room" value="${model.getRoom().getId()}"/>
		<button type="submit">Envoyer</button>
	</form>
  </c:when>
  <c:otherwise>
  	<form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" />
		<label for="ip">Ip :</label>
		<input type="text" name="ip" id="ip" />
		<label for="id_room">Id Room :</label>
		<input type="text" name="id_room" id="id_room" />
		<button type="submit">Envoyer</button>
	</form>
  </c:otherwise>
</c:choose>
