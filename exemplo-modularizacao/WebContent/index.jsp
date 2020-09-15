<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRINCIPAL</title>
</head>
<body>


<a href="info.jsp?nome=ale">LINK</a>

<header>
	<nav>
		<ul>
			<li><a href="info.jsp?imgurl=img/jsp-1.png">IMG-1</a></li>
			<li><a href="info.jsp?imgurl=img/jsp-2.jpg">IMG-2</a></li>
			<li><a href="info.jsp?imgurl=img/jsp-3.png">IMG-3</a></li>
		</ul>
	</nav>
</header>

<%@ include file="head.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="body.jsp"%>
<%@ include file="footer.jsp"%>
</body>
</html>