<%@page import="com.sun.javafx.geom.Edge"%>
<%@page import="dto.EnquiryDetail"%>
<%@page import="java.util.List"%>
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
					<h3>Daily Enquiry Section</h3><a href='authenticate' class='btn btn-info btn-xs' style='float:right;margin-top:-40px;'>Log Out</a>
					<hr>
					<form action="enquiryhandler" method="post" class="form-inline">

						<div class="form-group">
							<label for="desc">Description</label>
							<textarea id="desc" rows="3" cols="40" class="form-control"
								name="desc" placeholder="Enter your enquiry"></textarea>

						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
			</div>
			<!-- end of well --> </section>
			<%
				String flag = "hidden";
				try {
					List<EnquiryDetail> enquiries = (List<EnquiryDetail>) request.getAttribute("enqueryList");

					if (enquiries != null) {
						flag = "visible";
						out.print("<div style='visibility:" + flag + ";'>");
			%>
			<div class="bs-example">
				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th>Name</th>
							<th>Contact</th>
							<th>Enqueiy Details</th>
							<th>Edit Details</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (EnquiryDetail ed : enquiries) {									
						
									out.print("<tr>");
									out.print("<td>"+ed.getName()+"</td>");
									out.print("<td>"+ed.getContact()+"</td>");
									out.print("<td>"+ed.getDescription()+"</td>");
									out.print("<td><a href='enquiryhandler?id="+ed.getId()+"'><span class='glyphicon glyphicon-edit'></span></a></td>");
									out.print("</tr>");
							}
						%>
					</tbody>
				</table>
			</div>
			<%
				}

				} catch (Exception e) {
				}

				out.print("</div>");
				request.removeAttribute("enqueryList");
			%>
		</div>
		<!--  end of column -->

		<!-- column start  -->
		<div class="col-md-2"></div>
		<!--  end of column -->
	</div>
	<!-- row end -->

</body>
</html>