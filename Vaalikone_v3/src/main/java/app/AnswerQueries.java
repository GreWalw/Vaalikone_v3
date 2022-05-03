package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Answer;
import data.Candidate;

@WebServlet("/answerqueries")
public class AnswerQueries extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
	
    public AnswerQueries() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		selectAllKids(out);
	}
    
	private void selectAllKids(PrintWriter out) {
		out.println("<h3>All candidates</h3>");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Candidate> list=em.createQuery("select c from Candidate c").getResultList();
		em.getTransaction().commit();
		em.close();
		printCandidatesAndAll(out, list);
	}
	
	private void printCandidatesAndAll(PrintWriter out, List<Candidate> list) {
		// TODO Auto-generated method stub
		out.println("<h3>All candidates and their answers to the questions</h3>");
		for (int i=0;list!=null && i<list.size();i++) {
			Candidate c=list.get(i);
			out.println(c+"<br>");
			for (Answer a : c.getAnswers()) {
				out.println(a.getQuestion() + " candidate answered: " + a + "<br>");
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
