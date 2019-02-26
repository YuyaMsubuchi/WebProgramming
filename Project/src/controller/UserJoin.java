package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class UserJoin
 */
@WebServlet("/UserJoin")
public class UserJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();


		if(session.getAttribute("userInfo") == null) {

			response.sendRedirect("login");
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userJoin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordC = request.getParameter("passwordC");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");


		if(password.equals(passwordC)) {
			request.setAttribute("errMsg", "パスワードが異なっています。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userJoin.jsp");
			dispatcher.forward(request, response);
			return;

		}

		UserDao userDao = new UserDao();
		try {
			userDao.InsertUser(loginId,password,name,birthDate );
		} catch (SQLException e) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userJoin.jsp");
			dispatcher.forward(request, response);
			return;
		}


		response.sendRedirect("UserList");
	}

}
