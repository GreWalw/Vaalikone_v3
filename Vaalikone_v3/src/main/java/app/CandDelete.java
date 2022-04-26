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

@WebServlet(name = "CandDelete", urlPatterns = { "/canddelete" })
public class CandDelete extends HttpServlet {
	private Dao dao;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone?useSSL=false", "sikli", "kukkuu");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		ArrayList<Candidates> list = null;
		if (dao.getConnection()) {
			list = dao.deleteCandidate(id);
		}
		request.setAttribute("candidatelist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/managecandidates.jsp");
		rd.forward(request, response);
	}

}