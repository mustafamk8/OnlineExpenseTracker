package ExpenseController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ExpenseDAO.Expense;
import ExpenseDAO.Registration;
import ExpenseModel.ExpenseModel;


@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		
		HttpSession session = request.getSession();
		Registration user = (Registration)session.getAttribute("loginUser");
		
		Expense ex = new Expense(title,date,time,description,price,user);
		
		ExpenseModel model = new ExpenseModel();
		int i = model.createAddExpense(ex);
		
		if(i!=0) {
			session.setAttribute("msg", "Expense added successfull");
			response.sendRedirect("addExpense.jsp");
		}else {
			session.setAttribute("msg", "expense added failed something wrong !!!");
			response.sendRedirect("addExpense.jsp");
		}
	
	}

}
