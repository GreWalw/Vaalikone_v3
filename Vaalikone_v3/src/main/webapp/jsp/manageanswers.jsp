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

<h1>Questions</h1>
<c:forEach var="question" items="${requestScope.questionlist}" >
<li><b>${question.questionNumber}</b><b>:</b> "${question.question}"
</c:forEach>

<h1>Candidates</h1>
<c:forEach var="candidate" items="${requestScope.candidatelist}" >
<li><b>${candidate.candNo}</b><b>: </b>${candidate.surname} ${candidate.firstName}
</c:forEach>

<c:forEach var="answer" items="${requestScope.answerlist}" >
<li><b>ID:</b>${answer.answer}, "${answer.id}" 
</c:forEach>



</body>
</html>