
<div id="signup">
	<h1>Sign Up for Free</h1>

	<form action="#" method="post">

		<div class="top-row">
			<div class="field-wrap">
				<label> First Name<span class="req">*</span>
				</label> <input type="text" id="name" name="name" required
					autocomplete="off" />
			</div>

			<div class="field-wrap">
				<label> Last Name<span class="req">*</span>
				</label> <input type="text" name="surname" id="surname" required
					autocomplete="off" />
			</div>
		</div>

		<div class="field-wrap">
			<label> Email Address<span class="req">*</span>
			</label> <input type="email" name="mail" id="mail" required
				autocomplete="off" />
		</div>

		<div class="field-wrap">
			<label> Set A Password<span class="req">*</span>
			</label> <input type="password" name="password" id="password" required
				autocomplete="off" />
		</div>

		<div class="field-wrap">
			<label> Confirm Password<span class="req">*</span>
			</label> <input type="password" name="confirm-password" id="confirm-password" required
				autocomplete="off" />
		</div>
		<button type="submit" class="button button-block" />
		Get Started
		</button>

	</form>
	<div>
    	<h2 style="color:red" display="${display}"> ${errorMessage}</h2>
	</div>
</div>





