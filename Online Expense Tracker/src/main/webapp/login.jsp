<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@include file="Bootstrap_and_files/allLinks.jsp"%>
	<%@include file="Bootstrap_and_files/navbar.jsp"%>

<%
					String withoutLogin = (String) session.getAttribute("Login-error");
					if (withoutLogin != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=withoutLogin %></div>

					<%
					session.removeAttribute("Login-error");
					}
					%>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">Login</p>
						<c:if test="${not empty msg }">
							<p class="text-center text-danger fs-4">${msg}</p>
							<c:remove var="msg" />
						</c:if>

					</div>
					<div class="card-body">
						<form method="post" action="UserLoginServlet">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" name="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" name="password" class="form-control"
									id="exampleInputPassword1">
							</div>

							<button type="submit" class="btn btn-success col-md-12">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>