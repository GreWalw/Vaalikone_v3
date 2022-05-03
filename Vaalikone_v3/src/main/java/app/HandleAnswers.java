package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Answer;
import data.Fish;

@WebServlet(urlPatterns = { "/deleteanswer" })

public class HandleAnswers extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getServletPath();
		List<Answer> list = null;
		switch (action) {
		case "/deleteanswer":
			String id = request.getParameter("id");
			list = deleteanswer(request);
			break;
		case "/updateanswer":
//			list = updateanswer(request);
			break;
		case "/readtoupdateanswer":
			Answer a = readtoupdateanswer(request);
			request.setAttribute("answer", a);
			RequestDispatcher rd = request.getRequestDispatcher("./jsp/manageanswers.jsp");
			rd.forward(request, response);
			return;
		}
		request.setAttribute("answerlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("./jsp/manageanswers.jsp");
		rd.forward(request, response);
	}

//	private List<Answer> updateanswer(HttpServletRequest request) {
//		// A Fish object to send to our web-service
//		Answer f = new Answer(request.getParameter("id"));
//		System.out.println(f);
//		String uri = "http://127.0.0.1:8080/rest/fishservice/updatefish";
//		Client c = ClientBuilder.newClient();
//		WebTarget wt = c.target(uri);
//		Builder b = wt.request();
//		// Here we create an Entity of a Fish object as JSON string format
//		Entity<Answer> e = Entity.entity(f, MediaType.APPLICATION_JSON);
//		// Create a GenericType to be able to get List of objects
//		// This will be the second parameter of post method
//		GenericType<List<Answer>> genericList = new GenericType<List<Answer>>() {
//		};
//
//		// Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Answer> returnedList = b.put(e, genericList);
//		return returnedList;
//	}

	private Answer readtoupdateanswer(HttpServletRequest request) {
		String id = request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/electionservice/readtoupdateanswer/" + id;
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(uri);
		Builder b = wt.request();
		Answer answer = b.get(Answer.class);
		return answer;
	}

	private List<Answer> deleteanswer(HttpServletRequest request) {
		String id = request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/electionservice/deleteanswer/" + id;
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(uri);
		Builder b = wt.request();
		// Create a GenericType to be able to get List of objects
		// This will be the second parameter of post method
		GenericType<List<Answer>> genericList = new GenericType<List<Answer>>() {
		};

		// Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Answer> returnedList = b.delete(genericList);
		return returnedList;
	}

}
