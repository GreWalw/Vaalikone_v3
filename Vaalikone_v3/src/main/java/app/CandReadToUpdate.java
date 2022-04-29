package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Candidate;

/**
 * Servlet implementation class ReadToUpdate
 */
@WebServlet("/candreadtoupdate")
public class CandReadToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone?useSSL=false", "sikli", "kukkuu");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandReadToUpdate() {
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
		String id = request.getParameter("id");
		Candidate c = null;
		if (dao.getConnection()) {
			c = dao.readCandidate(id);
		}
		
		request.setAttribute("surname", c);
		request.setAttribute("firstname", c);
		request.setAttribute("candNumb", c);
		request.setAttribute("age", c);
		request.setAttribute("hometown", c);
		request.setAttribute("party", c);
		request.setAttribute("profession", c);
		request.setAttribute("description", c);


		RequestDispatcher rd = request.getRequestDispatcher("/jsp/managecandidates.jsp");

		rd.forward(request, response);
	}
}