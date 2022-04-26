<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Question Page</title>

<style>

body {
background-color: LightBlue;
}

</style>


</head>
<body>
<a style="text-align: center;" href='/index.html'>Home page</a><br>
<a style="text-align: center;" href='/candidates'>Edit candidates</a>
<h2>Manage questions</h2>
<li>
<c:forEach var="question" items="${requestScope.questionlist}" >
<li><b>ID:</b> ${question.id} <b>Question</b>: ${question.question} <a href='/delete?id=${question.id}'>delete</a> 
</c:forEach>
</li>

<h2>Update a question</h2>
<form action='update' method='post'> 
<label for="id">Insert the question id:</label><br>
<input type='text' name='id' value='${requestScope.question.id}'><br> 
<label for="question">Question:</label><br>
<input type='text' name='question' value='${requestScope.question.question}'><br>
<input type='submit' name='ok' value='Send'> 
</form>

<h2>Add a question</h2>
<form action='addquestion' method='post'>
<label for="question">Question:</label><br>
<input type='text' name='question' value='${requestScope.question.question}'><br> 
<input type='submit' name='ok' value='Send'> 
</form>

</body>
</html>