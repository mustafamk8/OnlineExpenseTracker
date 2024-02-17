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

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		Registration rs = new Registration(email,pwd);
		ExpenseModel model = new ExpenseModel();
		
		Registration rr =  model.createLogin(rs);
		
		HttpSession session = request.getSession();
		
		if(rr!=null) {
			session.setAttribute("loginUser", rr);
			response.sendRedirect("homePage.jsp");
			
		}else {
			session.setAttribute("msg", "invalid username or password");
			response.sendRedirect("login.jsp");
		}
		
	}

}
