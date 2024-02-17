<%@page import="ExpenseModel.ExpenseModel"%>
<%@page import="ExpenseDAO.Expense"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Expense</title>
</head>
<body>
	<%@include file="Bootstrap_and_files/allLinks.jsp"%>
	<%@include file="Bootstrap_and_files/navbar.jsp"%>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">View Expense</p>
						<%
						String ms = (String) request.getAttribute("msg");
						if (ms != null)
							out.println("<h3 style=color:green>" + ms + "</h3>");
						%>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>

									<th scope="col">Title</th>
									<th scope="col">Date</th>
									<th scope="col">Time</th>
									<th scope="col">Description</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Registration user1 = (Registration) session.getAttribute("loginUser");
								if (user1 == null) {
									response.sendRedirect("login.jsp");
									session.setAttribute("Login-error", "Please Login...");
								}
								if (user1 != null) {
									ExpenseModel model = new ExpenseModel();
									List<Expense> list = model.getAllExpenseByUser(user1);
									for (Expense er : list) {
								%>

								<tr>
									<th scope="row"><%=er.getTitle()%></th>
									<td><%=er.getDate()%></td>
									<td><%=er.getTime()%></td>
									<td><%=er.getDescription()%></td>
									<td><%=er.getPrice()%></td>
									<td><a href="editExpense.jsp?eid=<%=er.getId()%>"
										class="btn btn-sm btn-primary me-1">Edit </a> <a href="#"
										class="btn btn-sm btn-danger me-1">Delete </a></td>
								</tr>
								<%
								}
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>