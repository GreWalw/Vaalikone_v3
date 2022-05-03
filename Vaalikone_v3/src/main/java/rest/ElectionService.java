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
import javax.ws.rs.core.MultivaluedMap;

import data.Question;
import data.Answer;
import data.Candidate;
import data.Fish;

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
	public List<Answer> readAnswers() {
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
		return list;
	}
	
	@GET
	@Path("/readquestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readQuestions() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Question> list = em.createQuery("select q from Question q").getResultList();
		List<Candidate> list2 = em.createQuery("select c from Candidate c").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/manageanswers.jsp");
		request.setAttribute("questionlist", list);
		request.setAttribute("candidatelist", list2);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/readcandidates")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readCandidates() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Candidate> list = em.createQuery("select c from Candidate c").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/manageanswers.jsp");
		request.setAttribute("candidatelist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Path("/updateanswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answer> updateAnswer(Answer Answer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Answer a = em.find(Answer.class, Answer.getId());
		if (a != null) {
			em.merge(Answer);
		}
		em.getTransaction().commit();
		List<Answer> list = readAnswers();
		return list;
	}
	
	@GET
	@Path("/readtoupdateanswer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Answer readToUpdateAnswer(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Answer a=em.find(Answer.class, id);
		em.getTransaction().commit();
		return a;
	}
	
	@DELETE
	@Path("/deleteanswer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Answer> deleteAnswer(@PathParam("id") int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Answer a = em.find(Answer.class, id);
		if (a != null) {
			em.remove(a);
		}
		em.getTransaction().commit();
		List<Answer> list = readAnswers();
		return list;
	}
	
//	@POST
//	@Path("/addanswer")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void addAnswer(Answer answers) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(answers);// The actual insertion line
//		em.getTransaction().commit();
//		// Calling the method readFish() of this service
//	}
	
	

	@POST
	@Path("/addanswer")
	@Consumes("application/x-www-form-urlencoded")
	public void addAnswer(MultivaluedMap<String, String> formParams) {
	    // Store the message
		String candId=formParams.getFirst("candidateDrop");
		Candidate candidate = new Candidate();
		candidate.setId(candId);
		Question question = new Question();
		for (String key: formParams.keySet()) {
			if (key.startsWith("valitteppa")) {
				
				String answerValue = formParams.getFirst(key);
				int answerValInt = Integer.parseInt(answerValue);
				//System.out.println(key+" " + answerValue);
				String questionId = key.substring(10);
				//System.out.println(questionId);
				Answer answer = new Answer();
				question.setQuestionId(questionId);
				answer.setCandidate(candidate);
				answer.setQuestion(question);
				answer.setAnswer(answerValInt);
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(answer);// The actual insertion line
				em.getTransaction().commit();
				
			}
		}
		
	}
	
}
