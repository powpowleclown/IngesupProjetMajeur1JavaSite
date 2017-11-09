<c:choose>
  <c:when test="${model.get(0) != null}">
    <form method="post" action="#" class="form">
		<label for="number">Number :</label>
		<input type="text" name="number" id="number" value="${model.get(0).number}"/>
		<label for="description">Description :</label>
		<textarea  name="description" id="description">${model.get(0).description}</textarea>
		<label for="note">Note :</label>
		<textarea  name="note" id="note"></textarea>
		<label for="id_computer">Computer :</label>
		<select name="id_computer">
			<c:forEach items="${model.get(1)}" var="computer">
				<option value="${computer.id}" ${computer.id == model.get(0).computer.id ? 'selected="selected"' :''}>${computer.name}</option>
			</c:forEach>
		</select>
		<label for="id_state">State :</label>
		<select name="id_state">
			<c:forEach items="${model.get(2)}" var="state">
				<option value="${state.id}" ${state.id == model.get(0).getLastHistoricals_iState().id ? 'selected="selected"' :''}>${state.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Envoyer</button>
	</form>
  </c:when>
  <c:otherwise>
   <form method="post" action="#" class="form">
		<label for="number">Number :</label>
		<input type="text" name="number" id="number"/>
		<label for="description">Description :</label>
		<textarea  name="description" id="description"></textarea>
		<label for="note">Note :</label>
		<textarea  name="note" id="note"></textarea>
		<label for="id_computer">Computer :</label>
		<select name="id_computer">
			<c:forEach items="${model.get(1)}" var="computer">
				<option value="${computer.id}">${computer.name}</option>
			</c:forEach>
		</select>
		<label for="id_state">State :</label>
		<select name="id_state">
			<c:forEach items="${model.get(2)}" var="state">
				<option value="${state.id}">${state.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Envoyer</button>
	</form>
  </c:otherwise>
</c:choose>

 <div>
    <h2 style="color:red" display="${display}"> ${errorMessage}</h2>
</div>
