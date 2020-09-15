<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

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
				<td>${cli.dtNasc}</td>
				
				<c:choose>
					<c:when test="${cli.genero eq m}">
						<td>Masculino</td>
					</c:when>
					<c:when test="${cli.genero eq f}">
						<td>Feminino</td>
					</c:when>
					<c:when test="${cli.genero eq o}">
						<td>Outros</td>
					</c:when>
					<c:otherwise>
						<td>Não quero responder</td>
					</c:otherwise>
				</c:choose>
				
				<td>${cli.telefone}</td>
				
				<td><a href="listar?idCli=${id.count}">Atualizar</a></td>
				<td><a href="listar?idCli=${id.count}">Excluir</a></td>
			</tr>
		</c:forEach>
			
		</table>
		
	</section>
	<footer></footer>


	<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>

</body>
</html>