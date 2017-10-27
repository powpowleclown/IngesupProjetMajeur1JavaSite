<c:choose>
  <c:when test="${model != null}">
    <form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" value="${model.name}"/>
		<label for="table">Table :</label>
		<select name="table">
			<option value="Computer" ${model.table == "Computer" ? 'selected="selected"' :''}>Computer</option>
			<option value="Incident" ${model.table == "Incident" ? 'selected="selected"' :''}>Incident</option>
		</select>
		<button type="submit">Envoyer</button>
	</form>
  </c:when>
  <c:otherwise>
  	<form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" />
		<label for="table">Table :</label>
		<select name="table">
			<option value="Computer">Computer</option>
			<option value="Incident">Incident</option>
		</select>
		<button type="submit">Envoyer</button>
	</form>
  </c:otherwise>
</c:choose>
