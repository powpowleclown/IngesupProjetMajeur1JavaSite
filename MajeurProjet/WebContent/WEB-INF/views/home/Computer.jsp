
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
	<div class="card-content">
	<c:choose>
		<c:when test="${model.get(1) != null}">
		<label class="backoffice-label">Available processors (cores)</label>
			<p>${model.get(1).processor}</p>
		<label class="backoffice-label">Free memory (bytes)</label>
			<p>${model.get(1).freeMemory}</p>
			<label class="backoffice-label">Maximum memory (bytes)</label>
			<p>${model.get(1).maxMemory}</p>
			<label class="backoffice-label">Total memory available to JVM (bytes)</label>
			<p>${model.get(1).totalMemory}</p>
		</c:when>
		<c:otherwise>
			<p>Data is missing</p>
		</c:otherwise>
	</c:choose>
	</div>
</div>

