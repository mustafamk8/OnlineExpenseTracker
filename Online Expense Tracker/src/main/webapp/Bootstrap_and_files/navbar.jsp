<%@page import="ExpenseDAO.Registration"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><i
			class="fa-solid fa-money-check-dollar mx-1"></i>Expense tracker</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<%
			response.addHeader("pragma", "no-cache");
			response.addHeader("cache-control", "no-store");
			response.addHeader("expire", "0");
			%>




			<%
			Registration user = (Registration) session.getAttribute("loginUser");
			if (user != null) {
			%>

			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#"><i
						class="fa-solid fa-house-chimney mx-1"></i>Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="addExpense.jsp"><i
						class="fa-solid fa-plus mx-1"></i>Add Expense</a></li>

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="viewExpense.jsp"><i
						class="fa-solid fa-list mx-1"></i>View Expense</a></li>

			</ul>


			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item mx-2"><a href="" id="Modal1"
					class="btn btn-light my-2 my-sm-0 mr-2" data-toggle="modal"
					data-target="#exampleModal" type="submit"><i
						class="fa fa-user-circle-o px-1" aria-hidden="true"></i><%=user.getName()%></a>

				</li>
				<li class="nav-item"><a href="logoutServlet"
					class="btn btn-light my-2 my-sm-0" type="submit"><i
						class="fa fa-sign-out" aria-hidden="true"></i>Logout</a></li>
			</ul>




			<%
			} else {
			%>

			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#"><i
						class="fa-solid fa-house-chimney mx-1"></i>Home</a></li>

			</ul>


			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					href="login.jsp"><i class="fa-solid fa-right-to-bracket mx-1"></i>Login</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					href="signUp.jsp" tabindex="-1"><i
						class="fa-solid fa-user-plus mx-1"></i>Sign Up</a></li>
			</ul>
			<%
			}
			%>

		</div>
	</div>
</nav>