<%@page import="com.animalmanagement.model.Dog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%Dog dog = (Dog) session.getAttribute("dog"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container"><br><br>
<hr>
<form action="getDogByDogCode" method="post">
<strong>Dog code</strong> <input type= "text"  name = "dogCode" >
<input name="source" value="deletedog" type="hidden">
<input type ="submit" name="submit" value="find" class="btn btn-info">
</form>
<%if (null!= dog) { %>
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
		<form method ="post" action = "deletedogbydogcode">
            <input type="hidden" name="dogCode" value=<%= dog.getDogCode() %>>
            <input type = "submit" name="submit" value="Delete" class="btn btn-danger">
        </form>
<%} %>
        <%if(session.getAttribute("flag") != null) { %>
        <%boolean flag = (boolean) session.getAttribute("flag"); %>
        <%if(true == flag) { %>
        <%= "Deleted Successfully" %>
        <%=flag %>
        <%} else {
        	out.println(" Not deleted");
        }}%>
        <% session.invalidate(); %>
</div>
</body>
</html>