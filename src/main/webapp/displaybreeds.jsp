<%@page import="java.util.List"%>
<%@page import="com.animalmanagement.model.Breed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Breed> breeds = (List<Breed>) session.getAttribute("breeds");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr>
	<hr>
	<div class="container">
		<form class="form" name="getbreeds" action="displaybreedsbyname"
			method="post">
			<input type="text" name="name" placeholder="Enter breed name">
			<input type="hidden" name="source" value="displaybreeds">
			<button type="submit" name="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-search">Search</span>
			</button>
			<hr>
			<hr>
			<%
			if (null != breeds) {
			%>
			<%
			for (Breed breed : breeds) {
			%>
			<table class="table" boarder="1px">
				<tr>
					<td>Name of breed</td>
					<td><%=breed.getName()%></td>
				</tr>
				<tr>
					<td>Country Of origin is</td>
					<td><%=breed.getCountryOfOrigin()%></td>
				</tr>
			</table>
			<hr>
			<%
			}
			}
			%>
		</form>
	</div>
</body>
</html>