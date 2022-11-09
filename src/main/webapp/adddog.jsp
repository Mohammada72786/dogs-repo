<%@page import="com.animalmanagement.model.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.animalmanagement.model.Dog"%>
<%@page import="com.animalmanagement.dao.impl.DogDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Dog dog = (Dog) session.getAttribute("dog");
%>
<%
List<Food> foods = (List<Food>) session.getAttribute("foods");
%>
<%
StringBuffer foodIds = new StringBuffer();
%>
<%
String foodsIds;
%>
<html>
<head>
<title>Animal Management</title>
<script>
	function assign() {
		alert("Foods assigned successfully");
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<br>
	<div class="container">
		<form action="insertDog" method="post">
			<table class="table bg-info">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" required
						placeholder="Enter name of dog"></td>
				</tr>
				<tr>
					<td>Weight</td>
					<td><input type="Number" name="weight" required
						placeholder="Enter weight in Kgs"></td>
				</tr>
				<tr>
					<td>colour</td>
					<td><input type="text" name="colour" required
						placeholder="Enter color of your dog"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><select name="gender" required>
							<option value="MALE">MALE</option>
							<option value="FEMALE">FEMALE</option>
					</select></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="text" required name="dateofbirth" required
						placeholder="dd-mm-yyyy" /></td>
				</tr>
				<tr>
					<td>Speed</td>
					<td><input type="number" required name="speed"
						placeholder="Enter speed in Km/h"></td>
				</tr>
			</table>
			<input type="submit" value="submit" name="submit">
		</form>
		<%
		if (dog != null) {
		%>
		Details of dog you have added
		<table class="table bg-danger">
			<tr class="bg-dark">
				<td>Name of dog is</td>
				<td><%=dog.getName()%></td>
			</tr>
			<tr class="bg-warning">
				<td>Colour of dog is</td>
				<td><%=dog.getColour()%></td>
			</tr>
			<tr class="bg-danger">
				<td>Weight of dog is</td>
				<td><%=dog.getWeight()%></td>
			</tr>
			<tr class="bg-success">
				<td>Running speed of dog is</td>
				<td><%=dog.getSpeed()%></td>
			</tr>
			<tr class="bg-info">
				<td>Date of birth of dog is</td>
				<td><%=dog.getDob()%></td>
			</tr>
		</table>
		<br>
		<button type="button" class="btn btn-info" data-toggle="collapse"
			data-target="#demo">Assign Foods</button>
		<div id="demo" class="collapse">
			<h3>Enter food IDs that you want to assign to the above dog,
				separate each id by comma(,)</h3>
			<form action="displayfoodsbyids" method="post">
				<input type="text" name="foodids" placeholder="Eg 1,2 "> <input
					type="hidden" name="source" value="foodtoassign">
				<button class="btn btn-info" type="submit">Search</button>
			</form>
		</div>
		<%
		}
		%>
		<%
		if (null != foods) {
		%>
		<%
		for (Food food : foods) {
			foodIds.append(food.getId());
			foodIds.append(",");
		%>
		<table class="table bg-warning">
			<tr>
				<td>Id of Food</td>
				<td><%=food.getId()%></td>
			</tr>
			<tr>
				<td>Name of Food</td>
				<td><%=food.getName()%></td>
			</tr>
			<tr>
				<td>Type of Food</td>
				<td><%=food.getType()%></td>
			</tr>
		</table>
		<%
		}
		%>
		<%
		foodIds.delete(foodIds.length() - 1, foodIds.length());
		%>
		<%
		foodsIds = foodIds.toString();
		%>
		<form action="assignfoodstodog" method="post">
			<input type="hidden" value=<%=dog.getDogCode()%> name="dogcode">
			<input type="hidden" value=<%=foodsIds%> name="foodids"> <input
				type="hidden" name="source" value="assignfoodstodog">
			<button type="submit" class="btn btn-primary" onclick="assign();">
				Assign and Save</button>
		</form>
		<%
		}
		%>
	</div>
</body>
</html>