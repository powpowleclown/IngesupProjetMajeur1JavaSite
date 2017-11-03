<c:choose>
	<c:when test="${model != null}">
		<form method="post" action="#" class="form">
			<div class="field-wrap">
				<label for="name">Name :</label> <input type="text" name="name"
					id="name" value="${model.name}" />
			</div>
			<div class="field-wrap">

				<label for="table">Table :</label> <select name="table">
					<option value="Computer"
						${model.table == "Computer" ? 'selected="selected"' :''}>Computer</option>
					<option value="Incident"
						${model.table == "Incident" ? 'selected="selected"' :''}>Incident</option>
				</select>
			</div>
			<button class="button button-block" type="submit">Envoyer</button>
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="#" class="form">
			<div class="field-wrap">

				<label for="name">Name :</label> <input type="text" name="name"
					id="name" />
			</div>
			<div class="field-wrap">

				<label for="table">Table :</label> 
				<select name="table">
					<option value="Computer">Computer</option>
					<option value="Incident">Incident</option>
				</select>
			</div>
			<button class="button button-block" type="submit">Envoyer</button>
		</form>
	</c:otherwise>
</c:choose>


<div>
	<h2 style="color: red" display="${display}">${errorMessage}</h2>
</div>