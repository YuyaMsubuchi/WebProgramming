package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserRe
 */
@WebServlet("/UserRe")
public class UserRe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();


		if(session.getAttribute("userInfo") == null) {

			response.sendRedirect("login");
			return;
		}

		String id = request.getParameter("id");

		System.out.println(id);

		UserDao userDao = new UserDao();
		User user = userDao.UserRead(id);

		request.setAttribute("UserRead", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserRe.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");




		String password = request.getParameter("password");
		String passwordC = request.getParameter("passwordC");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		if(!password.equals(passwordC)) {
			request.setAttribute("errMsg", "パスワードが異なっています。");
			UserDao userDao = new UserDao();
			User user = userDao.UserRead(id);

			request.setAttribute("UserRead", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserRe.jsp");
			dispatcher.forward(request, response);
			return;

		}



		UserDao userDao = new UserDao();

		if(!name.equals("")||!birthDate.equals("")) {
		if(password.equals("")) {

        userDao.UserRe2(name,birthDate,id );

		}else {

			userDao.UserRe(password,name,birthDate,id );
		}
		}else {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			User user = userDao.UserRead(id);

			request.setAttribute("UserRead", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserRe.jsp");
			dispatcher.forward(request, response);
			return;

		}

		response.sendRedirect("UserList");



	}
	}


