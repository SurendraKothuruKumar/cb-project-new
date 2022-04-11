<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit Book</title>
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
	background-color: green;
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

.lblue {
	background-color: #04AA6D;
	color: white;
	padding: 5px;
	border-color: gray;
}

.labelfont {
	text-align: left;
	border-style: dashed;
}


body, html {
  height: 100%;
}

.bg {
  /* The image used */
  background-image: url("https://th.bing.com/th/id/R.b3e82cf10057b84508f1a1f445bfc89b?rik=3uTc%2fA%2fHmayCRA&riu=http%3a%2f%2fst.depositphotos.com%2f1152339%2f4006%2fi%2f950%2fdepositphotos_40060449-stock-photo-education-concept-training-on-computer.jpg&ehk=gd9lHlTNzN84MUkgjYHZgTnja90msyqJvRA8xp1DD%2bE%3d&risl=&pid=ImgRaw&r=0");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
</head>
<body class="bg">

	<center>

		<h1>Edit Training Detail</h1>
		<form:form action="/editTraining" method="post"
			modelAttribute="Training">
			<form:input type="hidden" name="id" style="width: 230px"
							path="id"  value="${Training.id}"/>
			<table border="1" width="20%" >




				<tr>
					<th class="lblue labelfont"><label> Training Name</label></th>
					<td><form:input type="text" name="name" style="width: 230px"
							id="name" path="name" /> <form:errors path="name"></form:errors></td>
				</tr>

				<tr>
					<th class="lblue labelfont"><label>start date</label></th>
					<td><form:input type="date" name="startDate"
							style="width: 230px" id="startDate" path="startDate" /> <form:errors
							path="startDate"></form:errors></td>
				</tr>
				<tr>
					<th class="lblue labelfont"><label>PRICE</label></th>
					<td><form:input type="date" name="endDate"
							style="width: 230px" id="endDate" path="endDate" /> <form:errors
							path="endDate"></form:errors></td>
				</tr>
				<tr>
					<th class="lblue labelfont"><label>Fee</label></th>
					<td><form:input type="number" name="fee" style="width: 230px"
							id="fee" path="fee" /> <form:errors path="fee"></form:errors></td>
				</tr>
				<tr>
					<th class="lblue labelfont"><label>gst</label></th>
					<td><form:input type="number" name="gst" style="width: 230px"
							id="gst" path="gst" /> <form:errors path="gst"></form:errors></td>
				</tr>
				<tr>
					<th class="lblue labelfont"><label>trainerName</label></th>
					<td><form:input type="text" name="trainerName"
							style="width: 230px" id="trainerName" path="trainerName" /> <form:errors
							path="trainerName"></form:errors></td>
				</tr>
				<tr>
					<th class="lblue labelfont"><label>personsAllowed</label></th>
					<td><form:input type="number" name="personsAllowed"
							style="width: 230px" id="personsAllowed" path="personsAllowed" />
						<form:errors path="personsAllowed"></form:errors></td>
				</tr>
				<tr>
					<th class="lblue labelfont"><label>personsNominated</label></th>
					<td><form:input type="number" name="personsNominated"
							style="width: 230px" id="personsNominated"
							path="personsNominated" /> <form:errors path="personsNominated"></form:errors></td>
				</tr>
				<tr>
					<th class="lblue labelfont"><label>skills</label></th>
					<td><form:input type="text" name="skills" style="width: 230px"
							id="skills" path="skills" /> <form:errors path="skills"></form:errors></td>
				</tr>
				<tr>

					<td class="lblue labelfont" colspan="2" align="center"><input
						type="submit" value="Update"></td>
				</tr>


				<form:hidden path="id" value="1" />


			</table>

		</form:form>
		&nbsp;&nbsp; <BR> &nbsp;&nbsp; <BR>
</body>
</html>