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
html{
     background-color: white;
}
body {
	position:relative;
	background-color: AliceBlue;
	font-family: Arial, Helvetica, sans-serif;
	margin-top:0px;
	margin-bottom:0px;
	margin-left:150px;
	margin-right:150px;
	padding-left:200px;
	padding-right:200px;
	padding-bottom:90px;
	padding-top:10px;
}

</style>
</head>
<body>
<a style="text-align: center;" href='/index.html'>Home page</a><br>

<h2>CANDIDATE: Answer the questions here</h2>
<p><b>INFO:</b><br>First: Choose your candidate number and name from the dropdown list below<br>
Second: Answer the questions</p>

<label for="candis"><b>Choose your candidate here:</b></label>

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
<button onClick="window.location.reload();">Refresh Page</button>
</form>

<br><br>
<h2>CANDIDATE! EDIT YOUR ANSWERS HERE!</h2>
<p><b>INFO:</b><br>If you want to change your answers select your name from the list below and push "Edit answers"</p>

<form action="/rest/electionservice/sendanswers" method="post">
<select name="answerDrop" id="answerDrop">
<c:forEach var="candidate" items="${requestScope.candidatelist}" >
<option value="${candidate.candidateId}">${candidate.candNo}: ${candidate.surname} ${candidate.firstName}</option>
</c:forEach>
</select>
<input type="submit" value="Edit answers">  
</form>
<ol>

</body>
</html>