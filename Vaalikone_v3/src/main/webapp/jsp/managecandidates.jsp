<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage candidates</title>
<style>

body {
background-color: LightBlue;
}

</style>
</head>

<body>

<a style="text-align: center;" href='/index.html'>Home page</a><br>
<a style="text-align: center;" href='/showquestions'>Edit questions</a>
<h2>Manage candidates</h2>
<li>
<c:forEach var="candidates" items="${requestScope.candidatelist}" >
<li><b>ID:</b> ${candidates.id} ${candidates.surname}, ${candidates.firstname} <b>Candidate number:</b> ${candidates.candNumb} <b>Age:</b> ${candidates.age}, ${candidates.hometown} <b>Party:</b> ${candidates.party} <b>Profession:</b> ${candidates.profession}, "${candidates.description}" 
</c:forEach>
</li>
<h2>Update a candidate</h2>
<h4>Insert the candidate's ID you want to edit</h4>

<form action='candupdate' method='post'> 
<label for="id">Candidate id:</label><br>
<input type='text' name='id' value='${requestScope.candidates.id}'><br> 
<label for="surname">Surname:</label><br>
<input type='text' name='surname' value='${requestScope.candidates.surname}'><br>
<label for="firstname">First name:</label><br>
<input type='text' name='firstname' value='${requestScope.candidates.firstname}'><br>
<label for="candNumb">Candidate number:</label><br>
<input type='text' name='candNumb' value='${requestScope.candidates.candNumb}'><br>
<label for="age">Age:</label><br>
<input type='text' name='age' value='${requestScope.candidates.age}'><br>
<label for="hometown">Home town:</label><br>
<input type='text' name='hometown' value='${requestScope.candidates.hometown}'><br>
<label for="party">Party:</label><br>
<input type='text' name='party' value='${requestScope.candidates.party}'><br>
<label for="profession">Profession:</label><br>
<input type='text' name='profession' value='${requestScope.candidates.profession}'><br>
<label for="description">Description:</label><br>
<input type='text' name='description' value='${requestScope.candidates.description}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
<br>

<h2>Add a candidate</h2>
<h4>(Candidate ID will be generated automatically)</h4>
<form action='candadd' method='post'>
<label for="surname">Surname:</label><br>
<input type='text' name='surname' value='${requestScope.candidate.surname}'><br>
<label for="firstname">First name:</label><br>
<input type='text' name='firstname' value='${requestScope.candidate.firstname}'><br>
<label for="candNumb">Candidate number:</label><br>
<input type='text' name='candNumb' value='${requestScope.candidate.candNumb}'><br>
<label for="age">Age:</label><br>
<input type='text' name='age' value='${requestScope.candidate.age}'><br>
<label for="hometown">Home town:</label><br>
<input type='text' name='hometown' value='${requestScope.candidate.hometown}'><br>
<label for="party">Party:</label><br>
<input type='text' name='party' value='${requestScope.candidate.party}'><br>
<label for="profession">Profession:</label><br>
<input type='text' name='profession' value='${requestScope.candidate.profession}'><br>
<label for="description">Description:</label><br>
<input type='text' name='description' value='${requestScope.candidate.description}'><br>
<input type='submit' name='ok' value='Send'> 
</form>

</body>
</html>