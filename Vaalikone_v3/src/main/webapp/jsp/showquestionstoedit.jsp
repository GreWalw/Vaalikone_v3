
<%@page import="app.ShowQuestions"%>
<%@page import="dao.Dao"%>
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
</head>
<body>


	<h1>Admin question control pages</h1>

	<h2>Edit questions</h2>
  
	<form action='update' method='post'>
		Question id: <input type='text' name='id'
			value='${requestScope.question.id}' readonly><br>
		Question: <input type='text' name='question'
			value='${requestScope.question.question}'><br> <input
			type='submit' name='ok' value='Send'>
	</form>
<br>
<form action='addquestion' method='post'>
Question: <input type='text' name='question' value='${requestScope.question.question}'><br> 
<input type='submit' name='ok' value='Send'> 
</form>

</body>
</html>