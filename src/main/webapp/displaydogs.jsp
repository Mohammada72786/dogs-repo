<%@page import="java.util.List"%>
<%@page import="com.animalmanagement.model.Dog"%>
<%@page import="com.animalmanagement.model.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Dog> dogs = (List<Dog>) session.getAttribute("dogs");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
    function CheckNumeric(e) {
        if (window.event) 
        {
            if ((e.keyCode <48 || e.keyCode > 57) & e.keyCode != 8 && e.keyCode != 44) {
                event.returnValue = false;
                return false;
            }
        }
        else {
            if ((e.which <48 || e.which > 57) & e.which != 8 && e.which != 44) {
                e.preventDefault();
                return false;
            }
        }
    }     
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<br> <br>
		<form action="displayDogs" method="post">
			Name <input type="text" name="name" required> <input
				type="submit" name="submit" value="Search">
		</form>
		
		<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Display By IDs</button>
  <div id="demo" class="collapse">
  Enter IDs of all those Dogs that you want to display separate by comma(')
  <form action="displaydogsbyids" method="post">
  <input type="text" name = "dogids" placeholder="Eg 1,2,3" onkeypress="CheckNumeric(event);">
  <input type="hidden" name="source" value="displaydogsbyids">
  <button class="btn btn-info" type="submit">Search</button>
  </form> 
  </div>
		<%
		if (null != dogs) {
			for (Dog dog : dogs) {
				List<Food> foods = dog.getFoods();
		%>
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
				<td><%=dog.getWeight()%>KG</td>
			</tr>
			<tr class="bg-success">
				<td>Running speed of dog is</td>
				<td><%=dog.getSpeed()%>KM/h</td>
			</tr>
			<tr class="bg-info">
				<td>Date of birth of dog is</td>
				<td><%=dog.getDob()%></td>
			</tr>
		</table>

		<% if (null != foods) {%>
		<%for (Food food : foods) {%>
		<br>Associated favorite food...<br>
		<table class="table bg-success">
			<tr>
				<td>Id of the food</td>
				<td><%=food.getId()%></td>
			</tr>
			<tr>
				<td>Name of Food</td>
				<td><%=food.getName()%></td>
			</tr>
			<tr>
				<td>Type Of food</td>
				<td><%=food.getType()%></td>
			</tr>
		</table>
		<%
     		    }
	        } else {
		        out.println("No associated favorite food found");
	        }
         }
     } else {
	  	%>
		<div class="alert alert-success alert-dismissible fade show">
			<button type="button" class="close" data-dismiss="alert"></button>
			<strong>No result found!</strong> please check your input and try
			again.
		</div>
	<%  }%>
	</div>
</body>
</html>