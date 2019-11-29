package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserAccount;
import beans.UserDAO;
import util.GlobalConstants;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		toDo(request, response);
	}

	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserAccount a = UserDAO.selectUSER("1");
		request.getSession().setAttribute("user_id", a.getUSER_ID());
		Integer userId = (Integer) request.getSession().getAttribute("user_id");
		UserAccount ua = UserDAO.selectUSER(userId.toString());

		request.setAttribute("user", ua);

		request.getRequestDispatcher("/proFileUser.jsp").forward(request, response);
		

	}

}
