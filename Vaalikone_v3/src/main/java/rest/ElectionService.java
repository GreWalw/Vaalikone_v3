package rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Question;
import data.Answer;
import data.Candidate;

@Path("/electionservice")
public class ElectionService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	@GET
	@Path("/readanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAnswers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Answer> list = em.createQuery("select a from Answer a").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/manageanswers.jsp");
		request.setAttribute("answerlist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/readquestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Question> readQuestions() {
		System.out.println("Terse");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Question> list = em.createQuery("select q from Question q").getResultList();
		em.getTransaction().commit();
		em.close();
		System.out.println("Moro");
		return list;
	}
	@GET
	@Path("/readcandidates/{p1}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Candidate readCandidates(@PathParam("p1") int candId) {
		Candidate c = new Candidate();
		candId = c.getCandidateId();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Candidate> list = em.createQuery("select c from Candidate where candId=" + c.getCandidateId()).getResultList();
		em.getTransaction().commit();
		return list.get(candId);
	}
	@POST

	@Path("/addanswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAnswer(Answer answers) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(answers);// The actual insertion line
		em.getTransaction().commit();
		// Calling the method readFish() of this service
		
		
	}

	@Path("/answerform")
	private void printForm(PrintWriter out) {
        EntityManager em=emf.createEntityManager();
        List<Candidate> candilist=em.createQuery("select c from Candidate c").getResultList();
        List<Question> questionlist=em.createQuery("select q from Question q").getResultList();


        out.println("<form action='/addanswerform/addanswer' method='get'</form>");
        out.println("Answer: <input type='text' name='answer' value=''><br>");
        out.println("Candi: <select name='candi'>");
        for (Candidate candi:candilist) {
            out.println("<option value='"+candi.getCandidateId()+"'>"+candi.getSurname()+candi.getFirstName());
        }
        out.println("</select><br>");
        out.println("Question: <select name='q'>");
        for (Question q:questionlist) {
            out.println("<option value='"+q.getQuestionId()+"'>"+q.getQuestion());
        }
        out.println("</select><br>");
        out.println("<input type='submit' name='ok' value='OK'><br>");
        out.println("</form>");

    }
//	@POST
//	@Path("/addfish")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Answer> addFish(Answer answer) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(answer);// The actual insertion line
//		em.getTransaction().commit();
//		// Calling the method readFish() of this service
//		List<Answer> list = readAnswers();
//		return list;
//	}
//
//	@PUT
//	@Path("/updatefish")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Fish> updateFish(Fish fish) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Fish f = em.find(Fish.class, fish.getId());
//		if (f != null) {
//			em.merge(fish);// The actual update line
//		}
//		em.getTransaction().commit();
//		// Calling the method readFish() of this service
//		List<Fish> list = readFish();
//		return list;
//	}
//
//	@DELETE
//	@Path("/deletefish/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Fish> deleteFish(@PathParam("id") int id) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Fish f = em.find(Fish.class, id);
//		if (f != null) {
//			em.remove(f);// The actual insertion line
//		}
//		em.getTransaction().commit();
//		// Calling the method readFish() of this service
//		List<Fish> list = readFish();
//		return list;
//	}
//
//	@GET
//	@Path("/readtoupdatefish/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Fish readToUpdateFish(@PathParam("id") int id) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Fish f = em.find(Fish.class, id);
//		em.getTransaction().commit();
//		return f;
//	}

}
