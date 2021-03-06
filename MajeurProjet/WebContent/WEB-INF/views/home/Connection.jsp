	<div>
		<h2 style="color: red" display=${display}>${errorMessage}</h2>
	</div>

<div class="form">

	<ul class="tab-group">

		<li class="tab active"><a href="#signup">Sign Up</a></li>
		<li class="tab"><a href="#login">Log In</a></li>
	</ul>

	<div class="tab-content">
		<div id="signup">
			<h1>Sign Up</h1>

			<form action="#" method="post">
				<input type="hidden" name="redirect" value="SignUp" />
				<div class="top-row">
					<div class="field-wrap">
						<label> First Name<span class="req">*</span>
						</label> <input type="text" name="name" id="name" required
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
					</label> <input type="password" name="confirm-password"
						id="confirm-password" required autocomplete="off" />
				</div>

				<button type="submit" class="button button-block" />
				Get Started
				</button>

			</form>

		</div>

		<div id="login">
			<h1>Welcome Back!</h1>

			<form action="#" method="post">
				<input type="hidden" value="SignIn" name="redirect" />
				<div class="field-wrap">
					<label> Email Address<span class="req">*</span>
					</label> <input type="email" name="mail" id="mail" required
						autocomplete="off" />
				</div>

				<div class="field-wrap">
					<label> Password<span class="req">*</span>
					</label> <input type="password" name="password" id="password" required
						autocomplete="off" />
				</div>
				<p class="forgot">
					<a href="#">Forgot Password?</a>
				</p>

				<button class="button button-block" />
				Log In
				</button>

			</form>
		</div>

	</div>
	<!-- tab-content -->


</div>
<!-- /form -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="../resources/js/test.js"></script>

