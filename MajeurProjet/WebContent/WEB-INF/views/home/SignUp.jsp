<form method="post" action="#">
	<label for="prenom">Prenom :</label>
	<input type="text" name="name" id="prenom"/>
	<label for="nom">Nom :</label>
	<input type="text" name="surname" id="nom"/>
	<label for="mail">Mail :</label>
	<input type="text" name="mail" id="mail"/>
	<label for="pwd">Mot de passe :</label>
	<input type="password" name="password" id="pwd"/>
	<label for="confpwd">Confirmation du Mot de passe :</label>
	<input type="password" name="confirm-password" id="confpwd"/>
	<button type="submit">Envoyer</button>
</form>

<div>
    <h2 style="color:red" display="${display}"> ${errorMessage}</h2>
</div>