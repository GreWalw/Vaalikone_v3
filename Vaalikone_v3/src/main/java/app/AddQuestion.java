package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Question;

/**
 * Servlet implementation class AddQuestion
 */
@WebServlet(name = "AddQuestion", urlPatterns = { "/addquestion" })
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	// VAALIKONE_V3 REPO SETTING
	


	// JOEL PUSH TESTI


	// VAALIKONE_V3 WALTTERI BRANCH TESTING

	// Joona teki muudoksen


	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone?useSSL=false", "sikli", "kukkuu");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String question = request.getParameter("question");
		String id = null;
		
		Question q = new Question(id, question);
		String kysymys = q.getQuestion();

		ArrayList<Question> add = null;
		if (dao.getConnection()) {

			add = dao.addQuestion(kysymys);

		}

		request.setAttribute("questionlist", add);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showkysmarits.jsp");

		rd.forward(request, response);
	}

}
