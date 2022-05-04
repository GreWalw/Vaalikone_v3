<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidate" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage candidates</title>
<style>

html{
     background-color:white;
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
<a style="text-align: center;" href='/showquestions'>Edit questions</a>
<h2>Manage candidates</h2>

<c:forEach var="candidate" items="${requestScope.candidatelist}" >
<li><b>ID: ${candidate.candidateId} 
<br>
Candidate #${candidate.candNo}: ${candidate.surname}, ${candidate.firstName} </b>
<br>
Age: ${candidate.age}
<br>
Hometown: ${candidate.hometown} 
<br>
Party: ${candidate.party} 
<br>
Profession: ${candidate.profession}
<br>
Mayoral promise:
"${candidate.descr}" 

<a href='/canddelete?id=${candidate.candidateId}'>delete</a> 
<br><br>
</c:forEach>

<h2>Update a candidate</h2>
<h4>Insert the candidate's ID you want to edit</h4>

<form action='candupdate' method='post'> 
<label for="id">Candidate id:</label><br>
<input type='text' name='id' value='${requestScope.candidate.candidateId}'><br> 
<label for="surname">Surname:</label><br>
<input type='text' name='surname' value='${requestScope.candidate.surname}'><br>
<label for="firstname">First name:</label><br>
<input type='text' name='firstname' value='${requestScope.candidate.firstName}'><br>
<label for="candNumb">Candidate number:</label><br>
<input type='text' name='candNumb' value='${requestScope.candidate.candNo}'><br>
<label for="age">Age:</label><br>
<input type='text' name='age' value='${requestScope.candidate.age}'><br>
<label for="hometown">Home town:</label><br>
<input type='text' name='hometown' value='${requestScope.candidate.hometown}'><br>
<label for="party">Party:</label><br>
<input type='text' name='party' value='${requestScope.candidate.party}'><br>
<label for="profession">Profession:</label><br>
<input type='text' name='profession' value='${requestScope.candidate.profession}'><br>
<label for="description">Description:</label><br>
<input type='text' name='description' value='${requestScope.candidate.descr}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
<br>

<h2>Add a candidate</h2>
<h4>(Candidate ID will be generated automatically)</h4>
<form action='candadd' method='post'>
<label for="surname">Surname:</label><br>
<input type='text' name='surname' value='${requestScope.candidate.surname}'><br>
<label for="firstname">First name:</label><br>
<input type='text' name='firstname' value='${requestScope.candidate.firstName}'><br>
<label for="candNumb">Candidate number:</label><br>
<input type='text' name='candNumb' value='${requestScope.candidate.candNo}'><br>
<label for="age">Age:</label><br>
<input type='text' name='age' value='${requestScope.candidate.age}'><br>
<label for="hometown">Home town:</label><br>
<input type='text' name='hometown' value='${requestScope.candidate.hometown}'><br>
<label for="party">Party:</label><br>
<input type='text' name='party' value='${requestScope.candidate.party}'><br>
<label for="profession">Profession:</label><br>
<input type='text' name='profession' value='${requestScope.candidate.profession}'><br>
<label for="description">Description:</label><br>
<input type='text' name='description' value='${requestScope.candidate.descr}'><br>
<input type='submit' name='ok' value='Send'> 
</form>

</body>
</html>