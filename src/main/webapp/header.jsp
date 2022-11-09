<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
</head>
<body>
<div class="container">
	<div class="jumbotron" style="background:khaki">
		<div class="text-center">
		<h3 class="bg-info">A pet is the only thing on earth that loves you more than you love yourself.</h3>
		</div>
	</div>
	<ul class="nav nav-pills nav-justified">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Dog <span class="caret"></span></a>
            <ul class="dropdown-menu">
        <li><a href="adddog.jsp">Add Dog &nbsp&nbsp&nbsp<span class="glyphicon glyphicon-arrow-right"></span></a></li>
        <li><a href="deletedog.jsp">Remove Dog &nbsp&nbsp&nbsp<span class="glyphicon glyphicon-arrow-right"></span></a></li>
        <li><a href="updatedog.jsp">Update Dog &nbsp&nbsp&nbsp<span class="glyphicon glyphicon-arrow-right"></span></a></li>  
        <li><a href="displaydogs.jsp"> Display Dogs &nbsp&nbsp&nbsp<span class="glyphicon glyphicon-arrow-right"></span></a></li>                      
      </ul>
    </li>
    <li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href ="#">Food<span class="caret"></span></a>
	    <ul class="dropdown-menu">
            <li><a href="addfood.jsp">Add Food</a></li>
            <li><a href="removefood.jsp">Remove Food</a></li>
            <li><a href="updatefood.jsp">Update Food</a></li>  
            <li><a href="displayfood.jsp"> Display Foods</a></li>                      
        </ul>
	   </li>
	 <li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href ="#">Pet Store<span class="caret"></span></a>
	    <ul class="dropdown-menu">
            <li><a href="Addpestore.jsp">Add Pet Store</a></li>
            <li><a href="removepetstore.jsp">Remove Pet Store</a></li>
            <li><a href="updatepetstore.jsp">Update Pet Store</a></li>  
            <li><a href="displaypetstores.jsp"> Display Pet Stores</a></li>                      
        </ul>
	   </li>
    <li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href ="#">Breed<span class="caret"></span></a>
	    <ul class="dropdown-menu">
            <li><a href="addbreed.jsp">Add Breed</a></li>
            <li><a href="removebreed.jsp">Remove breed</a></li>
            <li><a href="updatebreed.jsp">Update Breed</a></li>  
            <li><a href="displaybreeds.jsp"> Display Breeds</a></li>                      
        </ul>
	   </li>
  </ul>
</div>
</body>
</html>