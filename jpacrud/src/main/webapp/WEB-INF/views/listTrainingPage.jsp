<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Books</title>
</head>
<body>
	<style>
a {
	border-style: outset;
	border-color: white;
	padding: 4px 15px 4px 15px;
	border-radius: .5em;
	background-color: green;
	color: white;
	text-decoration: none;
}

a:hover {
	border-color: lime;
	color
	.navy;
}

a:link {
	/*unvisited style*/ color red;
	text-decoration: none;
}

a:visited {color .green;
	
}

a.active {
	/*on click style*/ color .#0000FF;
	
}

]
caption {
	color: blue;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #04AA6D;
	color: white;
}

body, html {
	height: 100%;
}

.bg {
	/* The image used */
	background-image:
		url("https://th.bing.com/th/id/R.b3e82cf10057b84508f1a1f445bfc89b?rik=3uTc%2fA%2fHmayCRA&riu=http%3a%2f%2fst.depositphotos.com%2f1152339%2f4006%2fi%2f950%2fdepositphotos_40060449-stock-photo-education-concept-training-on-computer.jpg&ehk=gd9lHlTNzN84MUkgjYHZgTnja90msyqJvRA8xp1DD%2bE%3d&risl=&pid=ImgRaw&r=0");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<body class="bg">
	<a href="/addTraining">Add Training List</a>
	<c:if test="${not empty msg}">
		<h4 style="color: green">"${msg}"</h4>
		<p></p>
		<p></p>
	</c:if>
	<c:if test="${empty trainingList}">
		<h>NoRecords found</h>
	</c:if>
	<c:if test="${not empty trainingList}">
		<center>
			<h1>List of Trainings</h1>
			<div style="text-align: right;">
				<a href="/listTrainings?pageNumber=0">1</a> | <a
					href="/listTrainings?pageNumber=1">2</a> | <a
					href="/listTrainings?pageNumber=2">3</a>
			</div>
			<table border="3" width="100%" height="100">
				<tr>

					<th>Name</th>
					<th>startDate</th>
					<th>endDate</th>
					<th>fee</th>
					<th>trainerName</th>
					<th>personsAllowed</th>
					<th>personsNominated</th>
					<th>skills</th>
					<th width="20%">action</th>
				</tr>
				<c:forEach var="table" items="${trainingList}">
					<tr>

						<td><c:out value="${table.name}" /></td>
						<td><c:out value="${table.startDate}" /></td>
						<td><c:out value="${table.endDate}" /></td>
						<td><c:out value="${table.fee}" /></td>
						<td><c:out value="${table.trainerName}" /></td>
						<td><c:out value="${table.personsAllowed}" /></td>
						<td><c:out value="${table.personsNominated}" /></td>
						<td><c:out value="${table.skills}" /></td>
						<td>&nbsp;&nbsp;&nbsp;<a
							background-color:green;
					 href="/editTraining?id=<c:out value='${table.id}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a background-color:
							red;
						href="/deleteTraining?id=<c:out value='${table.id}' />">Delete</a></td>

					</tr>


				</c:forEach>
			</table>
	</c:if>
	&nbsp;&nbsp;
	<BR> &nbsp;&nbsp;
	<BR>


</body>
</html>