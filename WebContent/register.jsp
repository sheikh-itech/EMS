<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Welcome to Enquiry Management System</title>
</head>
<body style="background-color:lightblue;">

	<div class="row" style="margin-top: 50px;">
		<!-- form row starts -->

		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">Provide Registration Details</div>
				<%
					try {
						//request.setAttribute("flag", true);
						Object temp = request.getAttribute("flag");
						boolean flag = false;
						if (temp != null) {
							flag = Boolean.valueOf(temp.toString());
						}

						if (flag) {
							out.print("<span style='color:red;margin-left:25%;'>Username Already Exist</span>");
						}
					} catch (Exception e) {
					}
				request.removeAttribute("flag");
				%>
				<!-- form -->
				<div class="panel-body">
					<form action="registeruser" method="post">

						<div class="form-group">
							<label for="txtUsername">Username</label> <input type="text"
								id="txtUsername" class="form-control" name="username"
								placeholder="Enter username" required autofocus maxlength="20" />
						</div>
						<div class="form-group">
							<label for="txtName">Name</label> <input type="text" id="txtName"
								class="form-control" name="name" placeholder="Enter name"
								required maxlength="20" />
						</div>

						<div class="form-group">
							<label for="txtPassword">Password</label> <input type="text"
								id="txtPassword" class="form-control" name="password"
								placeholder="Enter password" required maxlength="10" />
						</div>
						<div class="form-group">
							<label for="ddType">User type</label> <select id="ddType"
								class="form-control" name="usertype" required>
								<option selected="true">Student</option>
								<option>Staff</option>
							</select>
						</div>
						<div class="form-group">
							<label for="txtNumber">Contact</label> <input type="number"
								id="txtNumber" class="form-control" name="contact"
								placeholder="Enter contact number" required min='0'
								max='9999999999' />
						</div>
						<input type="submit" value="Register" class="btn btn-info"
							style="margin-left: 25%;"> <a href="login"
							class="btn btn-warning" style="margin-left: 5%;">GoTo Login</a>
					</form>
				</div>
				<!-- End of form  -->

			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<!-- form row end -->


</body>
</html>