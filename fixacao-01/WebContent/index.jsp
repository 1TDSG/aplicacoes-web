<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<title>INICIAL</title>
</head>
<body>

<!-- Adicionar além dos dois campos existentes, adicionar também
os campos:
img-alt=valor o aluno decide
img-title=valor o aluno decide
img-width=400px
 -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="">MENU</a>
												<!--A construção de uma QueryString , utilizando doi parâmetros
												img-uri e img-url sendo encaminhados para montador.
												-->
			<a class="nav-item nav-link" href="montador?img-uri=um.jpg&img-url=./img/&img-capt=Numero Um">Imagem-1</a>
			<a class="nav-item nav-link" href="montador?img-uri=dois.jpg&img-url=./img/&img-capt=Numero Dois">Imagem-2</a>
			<a class="nav-item nav-link" href="montador?img-uri=tres.jpg&img-url=./img/&img-capt=Numero Três">Imagem-3</a>
			<a class="nav-item nav-link" href="montador?img-uri=quatro.jpg&img-url=./img/&img-capt=Numero Quatro">Imagem-4</a>
			<a class="nav-item nav-link" href="montador?img-uri=cinco.jpg&img-url=./img/&img-capt=Numero Cinco">Imagem-5</a>
		</nav>
	</header>
	<div></div>
	
	<section>
		
		<figure>
			<img alt="" src="<%=request.getAttribute("attrImg")%>">
			
			
			
			<% %>
			
			
			<%= %>
			
			
			<figcaption>
			<%
			
			//Recuperar o valor do atributo e verificar se existe valor
				
				if(request.getAttribute("attrCaptFig") != null){%>
					<%=request.getAttribute("attrCaptFig")%>
					
				<%}%>
			</figcaption>
			
			
		</figure>
	
	</section>
	<footer> </footer>


	<script src="js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>