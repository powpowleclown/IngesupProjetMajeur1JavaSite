<c:choose>
  <c:when test="${model.get(0) != null}">
    <form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" value="${model.get(0).firstname}"/>
		<label for="surname">Surname :</label>
		<input type="text" name="surname" id="surname" value="${model.get(0).surname}"/>
		<label for="mail">Mail :</label>
		<input type="text" name="mail" id="mail" value="${model.get(0).mail}"/>
		<label for="pwd">Password :</label>
		<input type="text" name="pwd" id="pwd" value="${model.get(0).pwd}"/>
		<label for="id_role">Role :</label>
		<select name="id_role">
			<c:forEach items="${model.get(1)}" var="role">
				<option value="${role.id}" ${role.id == model.get(0).role.id ? 'selected="selected"' :''}>${role.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Envoyer</button>
	</form>
  </c:when>
  <c:otherwise>
  	<form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" />
		<label for="surname">Surname :</label>
		<input type="text" name="surname" id="surname" />
		<label for="mail">Mail :</label>
		<input type="text" name="mail" id="mail" />
		<label for="pwd">Password :</label>
		<input type="text" name="pwd" id="pwd" />
		<label for="id_role">Role :</label>
		<select name="id_role">
			<c:forEach items="${model.get(1)}" var="role">
				<option value="${role.id}">${role.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Envoyer</button>
	</form>
  </c:otherwise>
</c:choose>
