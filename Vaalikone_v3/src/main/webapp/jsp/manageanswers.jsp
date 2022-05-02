<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Answer Management</title>
</head>
<body>
<a style="text-align: center;" href='/index.html'>Home page</a><br>
<a style="text-align: center;" href='/showquestions'>Edit questions</a><br>
<a style="text-align: center;" href='/candidates'>Edit candidates</a>
<h1>Questions</h1>
<c:forEach var="question" items="${requestScope.questionlist}" >
<li><b>${question.questionNumber}</b><b>:</b> "${question.question}"
<form><input type="radio" id="questionid" name="Valitteppa" value="1">
<input type="radio" id="questionid" name="Valitteppa" value="2">
<input type="radio" id="questionid" name="Valitteppa" value="3">
<input type="radio" id="questionid" name="Valitteppa" value="4">
<input type="radio" id="questionid" name="Valitteppa" value="5">
<input type="submit" id="editanswer" name="editanswer" value="Update your answer"> 
</form>
<br>
</c:forEach>
<br><br>
<input type="submit" id="postanswers" name="submitanswers" value="Answer"> 

<h1>Candidates</h1>
<c:forEach var="candidate" items="${requestScope.candidatelist}" >
<li><b>${candidate.candNo}</b><b>: </b>${candidate.surname} ${candidate.firstName}
</c:forEach>

<c:forEach var="answer" items="${requestScope.answerlist}" >
<li><b>ID:</b>${answer.answer}, "${answer.id}" 
</c:forEach>



<h2>Add an answer</h2>
<form action='/addanswer' method='post'>
<label for="question">Question:</label><br>
<input type='text' name='question' value='${requestScope.question.question}'><br> 
<label for="question">Question number:</label><br>
<input type='text' name='qnumber' value='${requestScope.question.qnumber}'><br> 
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>