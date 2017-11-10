
<!-- Awesome comments right here ! -->

<!-- get(0) is for computer and get(1) is for computerData -->

<!-- computerData contain informations about a computer like ram, hardDisk etc...
ComputerData can be equals null because it is created by computer agent
Don't panic if ComputerData is missing -->

<div class="card">
	<i class="fa fa-desktop fa-5x"></i>
	<h1>${model.get(0).name}</h1>
	<p>${model.get(0).ip}</p>
	<p>${model.get(0).getLastHistoricals_cState().name}</p>
	<button class="button button-block">Contact machine</button>
</div>


<div class="card">
	<h2>Features</h2>
	<c:choose>
		<c:when test="${model.get(1) != null}">
			<p>${model.get(1).processor}</p>
			<p>${model.get(1).freeMemory}</p>
			<p>${model.get(1).maxMemory}</p>
			<p>${model.get(1).totalMemory}</p>
		</c:when>
		<c:otherwise>
			<p>Data is missing</p>
		</c:otherwise>
	</c:choose>
</div>

