package ExpenseController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ExpenseDAO.Expense;
import ExpenseDAO.Registration;
import ExpenseModel.ExpenseModel;

/**
 * Servlet implementation class UpdateExpenseServlet
 */
@WebServlet("/UpdateExpenseServlet")
public class UpdateExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("eid"));
		ExpenseModel model = new ExpenseModel();
		Expense i = model.getExpenseById(id);
		RequestDispatcher rd = request.getRequestDispatcher("editExpense.jsp");
		request.setAttribute("EMP", i);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		
		HttpSession session = request.getSession();
		Registration user = (Registration)session.getAttribute("loginUser");
		
		Expense ex = new Expense(id, title, date, time, description, price, user);
		
		ExpenseModel model = new ExpenseModel();
		int i = model.updateExpense(ex);
		
		if (i != 0) {
			//ArrayList<EmployeeRegistration> ee = new EmployeeRegistration().getEmployeeDetails();
			
			
			List<Expense> list = model.getAllExpenseByUser(user);
			
			RequestDispatcher rd = request.getRequestDispatcher("viewExpense.jsp");
			request.setAttribute("EMP", list);
			request.setAttribute("msg", "Expense Detail Updated Successfully");
			rd.forward(request, response);
			System.out.println("Data Successfully Updated");
		}
		
		
		
	}

}
