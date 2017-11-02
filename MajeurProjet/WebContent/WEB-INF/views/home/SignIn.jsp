<form method="post" action="#">
	<label for="mail">Mail :</label>
	<input type="text" name="mail" id="mail"/>
	<label for="pwd">Mot de passe :</label>
	<input type="password" name="password" id="pwd"/>	
	<button type="submit">Envoyer</button>
</form>

<div>
    <h2 style="color:red" display="${display}"> ${errorMessage}</h2>
</div>