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
import data.Candidates;

/**
 * Servlet implementation class CandAdd
 */
@WebServlet(name = "CandAdd", urlPatterns = { "/candadd" })
public class CandAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone?useSSL=false", "sikli", "kukkuu");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CandAdd() {
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

		String id = null;
		String surname = request.getParameter("surname");
		String firstname = request.getParameter("firstname");
		String candNumb = request.getParameter("candNumb");
		String age = request.getParameter("age");
		String hometown = request.getParameter("hometown");
		String party = request.getParameter("party");
		String profession = request.getParameter("profession");
		String description = request.getParameter("description");
		
		Candidates c = new Candidates(id, surname, firstname, candNumb, age, hometown, party, profession, description);
		String cSurname = c.getSurname();
		String cFirstname = c.getFirstname();
		int cCandnumb = c.getCandNumb();
		int cAge = c.getAge();
		String cHometown = c.getHometown();
		String cParty = c.getParty();
		String cProfession = c.getProfession();
		String cDescription = c.getDescription();
				
		ArrayList<Candidates> add = null;
		if (dao.getConnection()) {

			add = dao.addCandidate(cSurname, cFirstname, cCandnumb, cAge, cHometown, cParty, cProfession, cDescription);

		}

		request.setAttribute("candidatelist", add);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/managecandidates.jsp");

		rd.forward(request, response);
	}

}