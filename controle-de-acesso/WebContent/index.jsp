<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INICIO</title>
</head>
<body>


<%-- Aqui vamos receber os atributos do request que est�o sendo encaminhados pela Servlet. --%>
<h2>Nome de Usu�rio  : <%=request.getAttribute("attrUser") %></h2>
<h2>Senha do Usu�rio : <%=request.getAttribute("attrPass") %></h2>
		   
</body>
</html>