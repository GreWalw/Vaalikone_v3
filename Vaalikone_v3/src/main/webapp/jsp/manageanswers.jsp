<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="java.util.ArrayList" %>   
 	<%@ page import="data.Answer" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Answer Management</title>
<style>

body {
background-color: LightBlue;
}

</style>
</head>
<body>
<a style="text-align: center;" href='/index.html'>Home page</a><br>
<a style="text-align: center;" href='/showquestions'>Edit questions</a><br>
<a style="text-align: center;" href='/candidates'>Edit candidates</a>
<h1>Questions</h1>

<label for="candis">Choose a candidate:</label>

<form action="/rest/electionservice/addanswer" method="post">
<select name="candidateDrop" id="candidateDrop">
<c:forEach var="candidate" items="${requestScope.candidatelist}" >
<option value="${candidate.candidateId}">${candidate.candNo}: ${candidate.surname} ${candidate.firstName}</option>
</c:forEach>
</select> 
<br><br>

<c:forEach var="question" items="${requestScope.questionlist}" >
<li><b>${question.questionNumber}: "${question.question}"</b><br>
<input type="radio" id="r1" name="valitteppa${question.questionId}" value="1">
<label for="r1">Completely disagree</label>
<input type="radio" id="r2" name="valitteppa${question.questionId}" value="2">
<label for="r2">Disagree</label>
<input type="radio" id="r3" name="valitteppa${question.questionId}" value="3">
<label for="r3">Can't say</label>
<input type="radio" id="r4" name="valitteppa${question.questionId}" value="4">
<label for="r4">Agree</label>
<input type="radio" id="r5" name="valitteppa${question.questionId}" value="5">
<label for="r5">Completely agree</label><br>
<br>
</c:forEach>
<br><br>
<input type="submit" id="postanswers" name="submitanswers" value="Answer"> 
</form>

<ol>
<c:forEach var="answer" items="${requestScope.answerlist}" >
<li><b>ID:</b>${answer.id}, "${answer.answer}" <a href='/rest/electionservice/deleteanswer/${answer.id}'>Delete</a>
</c:forEach>
</ol>

<a href='/rest/electionservice/readallquery'>Read All Query</a>

</body>
</html>