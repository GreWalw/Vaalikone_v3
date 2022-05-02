<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<br><br><br>


<c:forEach var="question" items="${requestScope.questionlist}" >
<li><b>${question.questionNumber}</b><b>:</b> "${question.question}"<br><br>
<input type="radio" name="valitteppa${question.questionId}" value="1">
<input type="radio" name="valitteppa${question.questionId}" value="2">
<input type="radio" name="valitteppa${question.questionId}" value="3">
<input type="radio" name="valitteppa${question.questionId}" value="4">
<input type="radio" name="valitteppa${question.questionId}" value="5">


<br>
</c:forEach>
<br><br>
<input type="submit" id="postanswers" name="submitanswers" value="Answer"> 
</form>



<c:forEach var="answer" items="${requestScope.answerlist}" >
<li><b>ID:</b>${answer.answer}, "${answer.id}" 
</c:forEach>




</body>
</html>