<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="imports.jsp"/>
<title>INíCIO</title>
</head>
<body>


<header>
	<nav>
		<ul>
			<li><a href="info.jsp?imgurl=img/jsp-1.png">IMG-1</a></li>
			<li><a href="info.jsp?imgurl=img/jsp-2.jpg">IMG-2</a></li>
			<li><a href="info.jsp?imgurl=img/jsp-3.png">IMG-3</a></li>
		</ul>
	</nav>
</header>


<%@ include file="rodape.jsp" %>
</body>
</html>