<c:choose>
	<c:when test="${model.get(0) != null}">
		<form method="post" action="#" class="form">
				<label class="backoffice-label" for="name">Name :</label> <input
					type="text" name="name" id="name" value="${model.get(0).firstname}" />
				<label class="backoffice-label" for="surname">Surname :</label> <input
					type="text" name="surname" id="surname"
					value="${model.get(0).surname}" />

				<label class="backoffice-label" for="mail">Mail :</label> <input
					type="email" name="mail" id="mail" value="${model.get(0).mail}" />

				<label class="backoffice-label" for="pwd">Password :</label> <input
					type="password" name="pwd" id="pwd" value="${model.get(0).pwd}" />
				<label class="backoffice-label" for="id_role">Role :</label> <select
					name="id_role">
					<c:forEach items="${model.get(1)}" var="role">
						<option value="${role.id}"
							${role.id == model.get(0).role.id ? 'selected="selected"' :''}>${role.name}</option>
					</c:forEach>
				</select>
			<button class="button button-block" type="submit">Submit</button>
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="#" class="form">
			<label class="backoffice-label" for="name">Name :</label> <input
				type="text" name="name	" id="name" /> <label
				class="backoffice-label" for="surname">Surname :</label> <input
				type="text" name="surname" id="surname" /> <label
				class="backoffice-label" for="mail">Mail :</label> <input
				type="email" name="mail" id="mail" /> <label
				class="backoffice-label" for="password">Password :</label> <input
				type="password" name="password" id="password" /> <label
				class="backoffice-label" for="confirm-password">Confirm
				Password :</label> <input type="password" name="confirm-password"
				id="confirm-password" /> <label class="backoffice-label"
				for="id_role">Role :</label> <select class="name="id_role">
				<c:forEach items="${model.get(1)}" var="role">
					<option value="${role.id}">${role.name}</option>
				</c:forEach>
			</select>
			<button class="button button-block" type="submit">Submit</button>
		</form>
	</c:otherwise>
</c:choose>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="../resources/js/test.js"></script>

