package rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

import dao.Dao;
import data.Question;
import data.Answer;
import data.Candidate;

@Path("/electionservice")
public class ElectionService {
	private Dao dao = new Dao("jdbc:mysql://localhost:3306/vaalikone?useSSL=false", "sikli", "kukkuu");
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	
	@Context
	HttpServletRequest request;
	@Context
	HttpServletResponse response;
	
	public void sendCandName(String stId) {
		ArrayList<Candidate> candNameList=new ArrayList<>();
		candNameList=dao.readCandName(stId);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showCandidatesAnswers.jsp");
		request.setAttribute("candnamelist", candNameList);
	}
	
	
	@POST
	@Path("/sendanswers")
	@Consumes("application/x-www-form-urlencoded")
	public void sendAnswers(MultivaluedMap<String, String> formParams) throws SQLException {
		
		String stId=formParams.getFirst("answerDrop");
		
		int intId = Integer.parseInt(stId);
		
		System.out.println("" + intId);
		ArrayList<String> answeridlist = null;
		

		
		ArrayList<Answer> result = new ArrayList<>();
		result=dao.readAnswersId(stId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showCandidatesAnswers.jsp");
		request.setAttribute("answeridlist", result);
		sendCandName(stId);
		readQuestions2();
		try {
			
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	
//	@GET
//	@Path("/readallquery")
//	@Produces(MediaType.APPLICATION_JSON)
//	public void selectAllKids(PrintWriter out) {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		List<Candidate> list=em.createQuery("select c from Candidate c").getResultList();
//		em.getTransaction().commit();
//		em.close();
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/manageanswers.jsp");
//		request.setAttribute("answerlist", list);
//		try {
//			rd.forward(request, response);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		printCandidatesAndAll(out, list);
//	}
//	
//	private void selectAllKidss(PrintWriter out) {
//		out.println("<h3>All candidates</h3>");
//		EntityManager em=emf.createEntityManager();
//		em.getTransaction().begin();
//		List<Candidate> list=em.createQuery("select c from Candidate c").getResultList();
//		em.getTransaction().commit();
//		em.close();
//		printCandidatesAndAll(out, list);
//	}
	
//	public void printCandidatesAndAll(PrintWriter out, List<Candidate> list) {
//		// TODO Auto-generated method stub
//		out.println("<h3>All candidates and their answers to the questions</h3>");
//		for (int i=0;list!=null && i<list.size();i++) {
//			Candidate c=list.get(i);
//			out.println(c+"<br>");
//			for (Answer a : c.getAnswers()) {
//				out.println(a.getQuestion() + " candidate answered: " + a + "<br>");
//			}
//		}
//	}

	
//	@GET
//	@Path("/readquestions2")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
	public void readQuestions2() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Question> list = em.createQuery("select q from Question q").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showCandidatesAnswers.jsp");
		request.setAttribute("questionlist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
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
		List<Answer> list3 = em.createQuery("select a from Answer a").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/manageanswers.jsp");
		request.setAttribute("questionlist", list);
		request.setAttribute("candidatelist", list2);
		request.setAttribute("answerlist", list3);
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
	
	@GET
	@Path("/deleteanswer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAnswer(@PathParam("id") int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Answer a = em.find(Answer.class, id);
		if (a != null) {
			em.remove(a);
		}
		em.getTransaction().commit();
//		readQuestions();
	}

	@POST
	@Path("/addanswer")
	@Consumes("application/x-www-form-urlencoded")
	public void addAnswer(MultivaluedMap<String, String> formParams) throws SQLException {
		// Store the message
		String candId = formParams.getFirst("candidateDrop");

		Candidate candidate = new Candidate();
		candidate.setId(candId);
		int intCandId = Integer.parseInt(candId);
		Question question = new Question();
		for (String key : formParams.keySet()) {
			if (key.startsWith("valitteppa")) {

				String answerValue = formParams.getFirst(key);
				int answerValInt = Integer.parseInt(answerValue);
				String questionId = key.substring(10);
				Answer answer = new Answer();
				question.setQuestionId(questionId);
				answer.setCandidate(candidate);
				answer.setQuestion(question);
				answer.setAnswer(answerValInt);
				// System.out.println("" + dao.readCandidateId());

				EntityManager em = emf.createEntityManager();

				em.getTransaction().begin();
				em.persist(answer);// The actual insertion line
				em.getTransaction().commit();

			}
		}

	}

}
