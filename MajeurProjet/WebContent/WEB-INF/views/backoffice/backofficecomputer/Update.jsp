<form method="post" action="#">
	<label for="name">Name :</label>
	<input type="text" name="name" id="name" value={model.getName()}/>
	<label for="ip">Ip :</label>
	<input type="text" name="ip" id="ip" value={model.getIp()}/>
	<label for="id_room">Id Room :</label>
	<input type="text" name="id_room" id="id_room" value={model.getRoom().getId()}/>
	<button type="submit">Envoyer</button>
</form>