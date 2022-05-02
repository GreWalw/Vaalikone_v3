<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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