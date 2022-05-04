<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="java.util.ArrayList" %>   
 	<%@ page import="data.Answer" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>No terve!</h1>



<c:forEach var="candidate" items="${requestScope.candnamelist}" >

<li><h2>${candidate.firstName} ${candidate.surname}, Candidate number: "${candidate.candNo}"</h2>
</c:forEach>

<c:forEach var="question" items="${requestScope.questionlist}">
<li>Question ID: ${question.questionId}, Question: ${question.question}</li>
</c:forEach>



<ol>
<c:forEach var="answer" items="${requestScope.answeridlist}" >

<li><b>ID:</b>${answer.question}, Answer: "${answer.answer}" <a href='/rest/electionservice/deleteanswer/${answer.id}'>Delete</a>
</c:forEach>

</ol>
</body>
</html>