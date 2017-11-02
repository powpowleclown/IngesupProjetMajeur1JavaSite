<c:choose>
  <c:when test="${model != null}">
    <form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" value="${model.name}"/>
		<label for="role">Role :</label>
		<input type="text" name="role" id="role" value="${model.role}"/>
		<button type="submit">Envoyer</button>
	</form>
  </c:when>
  <c:otherwise>
  	<form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" />
		<label for="role">Role :</label>
		<input type="text" name="role" id="role" />
		<button type="submit">Envoyer</button>
	</form>
  </c:otherwise>
</c:choose>
