<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<ul class="tab-group">
		<li class="tab active"><a href="#signup">Sign Up</a></li>
		<li class="tab"><a href="#login">Log In</a></li>
	</ul>
	
	<p>Document content goes here...</p>
	
	<div class="form">
		<div class="tab-content">
		<iframe src = "./home/" width = "555" height = "200">
         Sorry your browser does not support inline frames.
      </iframe><div class="tab-content">
      
		<iframe src = "" width = "555" height = "200">
         Sorry your browser does not support inline frames.
      </iframe>
      </div>
	</div>	
		<div>
			<h2 style="color: red" display="${display}">${errorMessage}</h2>
		</div>

		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<script src="../resources/js/test.js"></script>

