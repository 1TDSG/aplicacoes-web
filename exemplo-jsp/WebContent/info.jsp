<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ include file="imports.jsp" %>


<title>INFO</title>
</head>
<body>

<%-- Criando a recepção do parâmetro que vem da página index.jsp com EL(Expresion Language) ! --%>

<div>
	<c:choose>
		<c:when test="${param.imgurl != null}">
			<p> ${param.imgurl}</p>
		</c:when>
		<c:when test="${param.imgurl == null}">
			<jsp:forward page="vazio.jsp"></jsp:forward>
		</c:when>
	</c:choose>
	
	
	<%-- Utilizamos a palavra param antes do nome do parâmetro quando enviamos de JSP para JSP. --%>
	<img alt="" src="${param.imgurl}">
</div>


<%@ include file="rodape.jsp" %>
</body>
</html>