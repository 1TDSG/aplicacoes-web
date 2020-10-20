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

<title><f:message key="site.paginas.lista.titulo" /></title>
</head>
<body>

	<%@ include file="../menu-header.html" %>

	<section>

		<table class="table table-hover table-dark">
			<tr>
				<th><f:message key="site.paginas.lista.tabela.th.id" /> </th>
				<th><f:message key="site.paginas.lista.tabela.th.nome" /></th>
				<th><f:message key="site.paginas.lista.tabela.th.dt_nasc" /></th>
				<th><f:message key="site.paginas.lista.tabela.th.genero" /></th>
				<th><f:message key="site.paginas.lista.tabela.th.telefone" /></th>
				<th colspan="2"><f:message key="site.paginas.lista.tabela.th.editar" /></th>
			</tr>
		<!-- Montando a tabela dinâmicamente com os dados dos atributos -->
		<!-- que estão chegando no request.-->

			<!--Criando uma linha na tabela-->
			<%-- Recuperando dados do request com EL e JSTL --%>
			
		
					
		<c:forEach var="cli" items="${listaCli}" varStatus="id">
			
			<tr>
				<td>${cli.id}</td>
				<td>${cli.nome}</td>
				
				<td><f:formatDate value="${cli.dtNasc}" pattern="dd-MMM-yyyy"/></td>
					
				<c:choose>
					<c:when test="${cli.genero eq 'm'.charAt(0)}">
						<td>Masculino</td>
					</c:when>
					<c:when test="${cli.genero eq 'f'.charAt(0)}">
						<td>Feminino</td>
					</c:when>
					<c:otherwise>
						<td>Outros</td>
					</c:otherwise>
				</c:choose>
				
				<td>${cli.telefone}</td>
				<td><a href="listar?idCli=${cli.id}"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/><path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/></svg></a></td>
				<td><a href="excluir?idCli=${cli.id}"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg"> d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/><path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/></svg></a></td>
			</tr>
		</c:forEach>
			
		</table>
	</section>
	
</body>
</html>









