<%@page import="com.animalmanagement.model.PetStore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<PetStore> petStores = (List<PetStore>) session.getAttribute("petStores");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<hr>
		<hr>
		<form class="form" name="petstore" action="displaypetstoresbyname"
			method="post">
			Name of Pet Store <input type="text" name="name"
				placeholder="Enter name"> <input type="hidden" name="source"
				value="displaypetstore">
			<button class="btn btn-info" type="submit">
				<span class=" glyphicon glyphicon-search"> Search</span>
			</button>
		</form>
		<%if(null != petStores) { %>
		<%for(PetStore petStore : petStores) {%>
		<table class="table">
			<tr>
				<td>Name of Pet Store</td>
				<td><%= petStore.getName()%></td>
			</tr>
			<tr>
				<td>Location of Pet Store</td>
				<td><%= petStore.getAddress()%></td>
			</tr>
		</table>
		<%} 
		}%>
		<h1> Here I am out side loop and if</h1>
	</div>
</body>
</html>