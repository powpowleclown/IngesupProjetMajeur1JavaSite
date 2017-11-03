<c:choose>
	<c:when test="${model.get(0) != null}">
		<form method="post" action="#" class="form">
			<div class="field-wrap">
				<label for="name">Name :</label> <input type="text" name="name"
					id="name" value="${model.get(0).firstname}" />
			</div>
			<div class="field-wrap">
				<label for="surname">Surname :</label> <input type="text"
					name="surname" id="surname" value="${model.get(0).surname}" />
			</div>
			<div class="field-wrap">

				<label for="mail">Mail :</label> <input type="text" name="mail"
					id="mail" value="${model.get(0).mail}" />
			</div>
			<div class="field-wrap">

				<label for="pwd">Password :</label> <input type="text" name="pwd"
					id="pwd" value="${model.get(0).pwd}" />
			</div>

			<div class="field-wrap">

				<label for="id_role">Role :</label> <select name="id_role">
					<c:forEach items="${model.get(1)}" var="role">
						<option value="${role.id}"
							${role.id == model.get(0).role.id ? 'selected="selected"' :''}>${role.name}</option>
					</c:forEach>
				</select>
			</div>
			<button class="button button-block" type="submit">Envoyer</button>
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="#" class="form">
			<div class="field-wrap">
				<label for="name">Name :</label> 
				<input type="text" name="name" id="name" />
			</div>
			<div class="field-wrap">
				<label for="surname">Surname :</label> 
				<input type="text" name="surname" id="surname" />
			</div>
			<div class="field-wrap">
				<label for="mail">Mail :</label> 
				<input type="text" name="mail" id="mail" />
			</div>
			<div class="field-wrap">
				<label for="pwd">Password :</label> 
				<input type="text" name="pwd" id="pwd" />
			</div>
			<div class="field-wrap">
				<label for="id_role">Role :</label> <select name="id_role">
					<c:forEach items="${model.get(1)}" var="role">
						<option value="${role.id}">${role.name}</option>
					</c:forEach>
				</select>
			</div>
			<button class="button button-block" type="submit">Envoyer</button>
		</form>
	</c:otherwise>
</c:choose>
