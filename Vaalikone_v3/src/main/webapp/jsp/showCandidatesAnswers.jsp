<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Answer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	padding-bottom:290px;
	padding-top:10px;
}

</style>
</head>
<body>
<a href='/rest/electionservice/readquestions'>Back to answers</a>
<h2>Edit answers</h2>

<c:forEach var="candidate" items="${requestScope.candnamelist}">
<h2>${candidate.firstName} ${candidate.surname} <br> Candidate number: ${candidate.candNo}</h2>
</c:forEach>

<ol>
<c:forEach var="answer" items="${requestScope.answeridlist}">
<li><b>ID:</b>${answer.question}, Answer: "${answer.answer}" <a href='/rest/electionservice/deleteanswer/${answer.id}'>Delete</a>
</c:forEach>
</ol>
	
<button onClick="window.location.reload();">Refresh Page</button>
	
</body>
</html>