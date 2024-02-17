<%@page import="ExpenseModel.ExpenseModel"%>
<%@page import="ExpenseDAO.Expense"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense</title>
</head>
<body>



	<%@include file="Bootstrap_and_files/allLinks.jsp"%>
	<%@include file="Bootstrap_and_files/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">Edit Expense</p>

						<%
						Registration user1 = (Registration) session.getAttribute("loginUser");
						if (user1 == null) {
							response.sendRedirect("login.jsp");
							session.setAttribute("Login-error", "Please Login...");
						}

						String message = (String) session.getAttribute("msg");
						if (message != null) {
						%>

						<div class="alert alert-success" role="alert">
							<%=message%>
						</div>



						<%
						session.removeAttribute("reg-success");
						}
						%>


						<%
						Expense p = (Expense) request.getAttribute("EMP");
						%>


					</div>
					<div class="card-body">
						<form method="post" action="UpdateExpenseServlet">
							<input type="hidden" name="id" value="<%=p.getId()%>">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Title
								</label> <input type="text" value="<%=p.getTitle()%>" name="title"
									class="form-control" id="exampleInputEmail1" readonly
									aria-describedby="emailHelp">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Date</label>
								<input type="date" name="date" value="<%=p.getDate()%>"
									class="form-control" id="exampleInputPassword1">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Time</label>
								<input type="time" value="<%=p.getTime()%>" name="time"
									class="form-control" id="exampleInputPassword1">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Description</label>
								<input type="text" value="<%=p.getDescription()%>"
									name="description" class="form-control"
									id="exampleInputPassword1">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Price</label>
								<input type="text" name="price" value="<%=p.getPrice()%>"
									class="form-control" id="exampleInputPassword1">
							</div>

							<button type="submit" class="btn btn-success col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>