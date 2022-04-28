package rest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Question;
import data.Candidates;
import data.Answers;

@Path("/electionservice")
public class ElectionService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");

	@GET
	@Path("/readanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answers> readAnswers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Answers> list = em.createQuery("select xyx from Answers xyx").getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	@GET
	@Path("/readquestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Question> readQuestions() {
		System.out.println("Terse");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Question> list = em.createQuery("select xyx from Questions xyx").getResultList();
		em.getTransaction().commit();
		System.out.println("Moro");
		return list;
	}
	@GET
	@Path("/readcandidates/{p1}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Candidates readCandidates(@PathParam("p1") int candId) {
		Candidates c = new Candidates();
		candId = c.getId();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Candidates> list = em.createQuery("select xyx from Candidates where candidate_id=" + c.getId()).getResultList();
		em.getTransaction().commit();
		return list.get(candId);
	}
	@POST
	@Path("/answerform")
	private void printForm(PrintWriter out) {
        EntityManager em=emf.createEntityManager();
        List<Candidates> candilist=em.createQuery("select a from Candidates a").getResultList();
        List<Question> questionlist=em.createQuery("select a from Questions a").getResultList();

        out.println("<form action='/addanswerform/addanswer' method='get'</form>");
        out.println("Answer: <input type='text' name='answer' value=''><br>");
        out.println("Candi: <select name='candi'>");
        for (Candidates candi:candilist) {
            out.println("<option value='"+candi.getId()+"'>"+candi.getSurname()+candi.getFirstname());
        }
        out.println("</select><br>");
        out.println("Question: <select name='q'>");
        for (Question q:questionlist) {
            out.println("<option value='"+q.getId()+"'>"+q.getQuestion());
        }
        out.println("</select><br>");
        out.println("<input type='submit' name='ok' value='OK'><br>");
        out.println("</form>");

    }
//	@POST
//	@Path("/addfish")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Fish> addFish(Fish fish) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(fish);// The actual insertion line
//		em.getTransaction().commit();
//		// Calling the method readFish() of this service
//		List<Fish> list = readFish();
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
