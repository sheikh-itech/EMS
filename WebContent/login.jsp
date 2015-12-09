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
	<div style="margin-top: 100px;">

		<div class="row" style="margin-top: 10px;">
			<!-- form row starts -->

			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<%
						try {
							//request.setAttribute("flag", true);
							Object temp = request.getAttribute("flag");
							boolean flag = false;
							if (temp != null) {
								flag = Boolean.valueOf(temp.toString());
							}

							if (flag) {
								out.print("<span style='color:red;margin-left:20%;'>Invalid Username Or Password</span>");
							}
						} catch (Exception e) {
						}
					request.removeAttribute("flag");
					%>
					<!-- form -->
					<div class="panel-body">
						<form action="authenticate" method="post" style="padding: 10px;">

							<div class="form-group">
								<label for="txtFullName">Username</label> <input type="text"
									id="txtFullName" class="form-control" name="username"
									placeholder="Enter username" autofocus required />
							</div>
							<div class="form-group">
								<label for="txtPassword">Password</label> <input type="password"
									id="txtPassword" class="form-control" name="password"
									placeholder="Enter password" required />
							</div>

							<input type="submit" value="Login" class="btn btn-info"
								style="margin-left: 25%;"> <a href="register"
								class="btn btn-warning" style="margin-left: 5%;">New User</a>

						</form>
					</div>
					<!-- End of form  -->

				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		<!-- form row end -->

	</div>
</body>
</html>