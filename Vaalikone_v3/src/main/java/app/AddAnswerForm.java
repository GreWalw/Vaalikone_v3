package app;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Path;

import data.*;



@Path("/addanswerform")
public class AddAnswerForm {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");

	private void printForm(PrintWriter out) {
        EntityManager em=emf.createEntityManager();
        List<Candidate> candilist=em.createQuery("select a from Candidate a").getResultList();
        List<Question> questionlist=em.createQuery("select a from Question a").getResultList();

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
	
	
	
	
	
}
