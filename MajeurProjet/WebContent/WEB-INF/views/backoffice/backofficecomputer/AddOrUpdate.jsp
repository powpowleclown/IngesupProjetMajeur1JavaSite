<c:choose>
  <c:when test="${model.get(0) != null}">
    <form class="form" method="post" action="#">
		<label class="backoffice-label" for="name">Name :</label>
		<input type="text" name="name" id="name" value="${model.get(0).name}"/>
		<label class="backoffice-label" for="ip">Ip :</label>
		<input type="text" name="ip" id="ip" value="${model.get(0).ip}"/>
		<label class="backoffice-label" for="id_room">Room :</label>
		<select name="id_room">
			<c:forEach items="${model.get(1)}" var="room">
				<option value="${room.id}" ${room.id == model.get(0).room.id ? 'selected="selected"' :''}>${room.name}</option>
			</c:forEach>
		</select>
		<label class="backoffice-label" for="id_state">State :</label>
		<select name="id_state">
			<c:forEach items="${model.get(2)}" var="state">
				<option value="${state.id}" ${state.id == model.get(0).getLastHistoricals_cState().id ? 'selected="selected"' :''}>${state.name}</option>
			</c:forEach>
		</select>
		<button class="button button-block" type="submit">Envoyer</button>
	</form>
  </c:when>
  <c:otherwise>
  	<form class="form" method="post" action="#">
		<label class="backoffice-label" for="name">Name :</label>
		<input type="text" name="name" id="name" />
		<label class="backoffice-label" for="ip">Ip :</label>
		<input type="text" name="ip" id="ip" />
		<label class="backoffice-label" for="id_room">Room :</label>
		<select name="id_room">
			<c:forEach items="${model.get(1)}" var="room">
				<option value="${room.id}">${room.name}</option>
			</c:forEach>
		</select>
		<label class="backoffice-label" for="id_state">State :</label>
		<select name="id_state">
			<c:forEach items="${model.get(2)}" var="state">
				<option value="${state.id}">${state.name}</option>
			</c:forEach>
		</select>
		<button class="button button-block" type="submit">Envoyer</button>
	</form>
  </c:otherwise>
</c:choose>


 <div>
    <h2 style="color:red" display="${display}"> ${errorMessage}</h2>
</div>