<%@page import="dto.EnquiryDetail"%>
<%@page import="com.sun.javafx.geom.Edge"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Welcome to Enquiry Management System</title>
<style>
body {
	background: url(image/bg_image.png);
	overflow-y: scroll;
}

th {
	text-align: center;
}
</style>
</head>
<body>
	<!-- start row -->
	<div class="row" style="margin-top: 50px;">

		<!-- column start -->
		<div class="col-md-2"></div>
		<!-- end of column -->

		<!-- column  start -->
		<div class="col-md-8">


			<section>
			<div class="well">
				<div class="text-center">
					<h3>Daily Enquiry Section</h3>
					<hr>
					<%
						try {
							EnquiryDetail enquiryDetail = (EnquiryDetail) request.getAttribute("enquiryDetail");
							request.removeAttribute("enquiryDetail");
							if (enquiryDetail != null) {
					%>
					<form action="updatehandler" method="post" class="form-inline">

						<div class="form-group">
							<label for="desc">Description</label>

							<%
								out.print("<input type='hidden' name='id' value='"+enquiryDetail.getId()+"'/>");
								out.print("<textarea id='desc' rows='3' cols='40' class='form-control' name='desc'>"+enquiryDetail.getDescription()+"</textarea>");
									}
								} catch (Exception e) {
								}
							%>
						</div>
						<button type="submit" class="btn btn-default">Update</button>
					</form>
				</div>
			</div>
			<!-- end of well --> </section>
		</div>
		<!--  end of column -->

		<!-- column start  -->
		<div class="col-md-2"></div>
		<!--  end of column -->
	</div>
	<!-- row end -->

</body>
</html>