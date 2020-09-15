<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exemplo</title>
</head>
<body>
	
	
	<div>
	
		<h2>Nome user :${usuario}</h2>
		<h2>ID da sessão :${idSession}</h2>
	</div>
	<div>
		<a href=exemplo?logout=0>LOGIN</a>
		<a href=exemplo?logout=1>LOGOUT</a>
		
	</div>
	<div>
		<p>Parametro passado no redirect : ${param.nome}</p>
	</div>
	
</body>
</html>