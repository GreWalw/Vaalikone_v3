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
<ol>
<c:forEach var="answer" items="${requestScope.answeridlist}" >
<label value="">${answer.candidate}</label>
<li><b>ID:</b>${answer.question}, Answer: "${answer.answer}" <a href='/rest/electionservice/deleteanswer/${answer.id}'>Delete</a>
</c:forEach>

</ol>
</body>
</html>