<%@page import="java.util.List"%>
<%@page import="com.animalmanagement.model.Food"%>
<%@page import="com.animalmanagement.model.Dog"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Dog dog = (Dog) session.getAttribute("dog");
Dog updatedDog = (Dog) session.getAttribute("updatedDog");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Update Dog</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<br>
		<form action="getDogByDogCode" method="post">
			Enter Dog code <input type="text" name="dogCode"> <input
				type="submit" class="btn btn-danger" name="submit" value="Search">
			<span class="glyphicon glyphicon-search"></span> <input
				type="hidden" value="updatedog" name="source">
		</form>
		<%
		if (null != dog) {
		%>
		<form action="updatedog" method="post">
			<div class="form-group">
				<label for="id">Dog Id</label> <input type="number"
					class="form-control" id="id" readonly name="id"
					value=<%=dog.getId()%>>
			</div>
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name"
					value=<%=dog.getName()%>>
			</div>
			<div class="form-group">
				<label for="colour">Colour</label> <input type="text"
					class="form-control" id="colour" name="colour"
					value=<%=dog.getColour()%>>
			</div>
			<div class="form-group">
				<label for="speed">Running Speed</label> <input type="number"
					class="form-control" id="speed" name="speed"
					value=<%=dog.getSpeed()%>>
			</div>
			<div class="form-group">
				<label for="weight">Total weight</label> <input type="number"
					class="form-control" id="weight" name="weight"
					value=<%=dog.getWeight()%>>
			</div>
			<div class="form-group">
				<label for="gender">Gender</label> <input type="text"
					class="form-control" id="gender" name="gender"
					value=<%=dog.getGender()%>>
			</div>
			<div class="form-group">
				<label for="dateOfBirth">Date Of Birth</label> <input type="text"
					class="form-control" id="dateOfBirth" name="dateOfBirth"
					value=<%=dog.getDob()%>>
			</div>
				<%List<Food> foods = dog.getFoods(); %>
                 <%if(null != foods) {%>
                 Foods Assigned 
                 <%for(Food food : foods) { %>
               <%=food.getName() %>  <input type="checkbox" value="checked" name="food"+<%=food.getId()%>>
                 <%}} %>
                 <br>
			<input type="hidden" name="dogCode" value=<%=dog.getDogCode()%>>
			<input type="submit" class="button btn-info btn-lg" value="update"
				name="submit">
		</form>
		<%
		} else {
		%>
		No result found on your code
		<%
		}
		%>
		<%
		if (null != updatedDog) {
		%>
		<div>
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong> Dog updated successfully!....</strong><a href="index.jsp">Home</a>
		</div>
		<%
		}
		%>
	</div>
	</div>
</body>
</html>