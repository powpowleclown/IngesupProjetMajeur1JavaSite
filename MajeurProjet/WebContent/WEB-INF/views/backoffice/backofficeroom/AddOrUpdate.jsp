<c:choose>
  <c:when test="${model != null}">
    <form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" value="${model.getName()}"/>
		<label for="ipmask">Ip Mask :</label>
		<input type="text" name="ipmask" id="ipmask" value="${model.getIpmask()}"/>
		<button type="submit">Envoyer</button>
	</form>
  </c:when>
  <c:otherwise>
  	<form method="post" action="#">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" />
		<label for="ipmask">Ip :</label>
		<input type="text" name="ipmask" id="ipmask" />
		<button type="submit">Envoyer</button>
	</form>
  </c:otherwise>
</c:choose>


<div>
    <h2 style="color:red" display="${display}"> ${errorMessage}</h2>
</div>