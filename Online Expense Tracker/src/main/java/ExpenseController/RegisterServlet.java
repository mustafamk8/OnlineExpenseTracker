package ExpenseController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ExpenseDAO.Registration;
import ExpenseModel.ExpenseModel;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nm = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String about = request.getParameter("about");
		
		Registration rs = new Registration(nm,email,password,about);
		
		ExpenseModel model = new ExpenseModel();
		
		int i = model.createUserSignUp(rs);
		
		HttpSession session = request.getSession();
		
		if(i!=0) {
			session.setAttribute("msg", "registration successfull");
			response.sendRedirect("signUp.jsp");
		}else {
			session.setAttribute("msg", "registration failed something wrong !!!");
			
		}
		
	}

}
