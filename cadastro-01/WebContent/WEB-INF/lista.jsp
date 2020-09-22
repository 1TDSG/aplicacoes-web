<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css">

<title>LISTAGEM</title>
</head>
<body>

	<header>
		<nav></nav>
	</header>
	<div></div>
	<section>

		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dt Nasc</th>
				<th>Genêro</th>
				<th>Tel</th>
				<th colspan="2">Editar</th>
			</tr>
		<!-- Montando a tabela dinâmicamente com os dados dos atributos -->
		<!-- que estão chegando no request.-->

			<!--Criando uma linha na tabela-->
			<%-- Recuperando dados do request com EL e JSTL --%>
			
		
					
		<c:forEach var="cli" items="${listaCli}" varStatus="id">
			
			<tr>
				<td>${id.count}</td>
				<td>${cli.nome}</td>
				
				<td><f:formatDate value="${cli.dtNasc}" pattern="dd-MMM-yyyy"/></td>
					
				<c:choose>
					<c:when test="${cli.genero eq 'm'.charAt(0)}">
						<td>Masculino</td>
					</c:when>
					<c:when test="${cli.genero eq 'f'.charAt(0)}">
						<td>Feminino</td>
					</c:when>
					<c:when test="${cli.genero eq 'o'.charAt(0)}">
						<td>Outros</td>
					</c:when>
					<c:otherwise>
						<td>Não quero responder</td>
					</c:otherwise>
				</c:choose>
				
				<td>${cli.telefone}</td>
				
				<td><a href="listar?idCli=${id.count}">Atualizar</a></td>
				<td><a href="excluir?idCli=${id.count}">Excluir</a></td>
			</tr>
		</c:forEach>
			
		</table>
	</section>

	
	
</body>
</html>