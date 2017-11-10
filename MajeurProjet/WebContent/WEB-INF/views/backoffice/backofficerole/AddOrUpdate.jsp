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


<div>
    <h2 style="color:red" display="${display}"> ${errorMessage}</h2>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="../resources/js/test.js"></script>
