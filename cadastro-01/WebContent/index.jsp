<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css">

<title>${title == 'ATUALIZAR' ?'ATUALIZAR' : 'CADASTRO'}</title>
</head>
<body>

	<header>
		<nav></nav>
	</header>

	<div>
		<h2>${msgStatus}</h2>
	</div>

	<section>
		
		<form class="form-horizontal" action="${action == 'update' ?'update' : 'cliente'}" method="post">
			<fieldset>
				<legend>${legenda == 'Atualiza��o de Dados' ? 'Atualiza��o de Dados' : 'Cadastro de Pessoas'}</legend>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm">Nome</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idNm" name="txtNm"
							placeholder="Digite seu nome" required="required" value="${objCli.nome}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm">Sobrenome</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idSnm" name="txtSnm"
							placeholder="Digite seu sobrenome" required="required" value="${objCli.sobrenome}">
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc">Data de Nascimento</label>
					<div class="col-sm-8">
						<input type="date" class="form-control" id="idDtNasc" name="txtDtNasc"
							required="required" value="${objCli.dtNasc}">
					</div>
				</div>
			<div class="form-group">    
					<label class="control-label col-sm-4" for="idGen">Genero</label>
					<div class="col-sm-8">
						<select class="form-control" id="idGen" name="txtGen" required="required">
							<option value="0" selected="selected">Selecione uma op��o.</option>
							<option value="m">Masculino</option>
							<option value="f">Feminino</option>
							<option value="o">Outros</option>
						</select>
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idTel">Telefone (00) 00000-0000</label>
					<div class="col-sm-8">
						<input type="tel" class="form-control" id="idTel" name="txtTel"
							required="required" value="${objCli.telefone}" maxlength="15" 
							pattern="\([0-9]{2}\) [0-9]{4,5}-[0-9]{4}$">
					</div>
				</div>
 
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
					<button type="submit" class="btn btn-success btn-lg">Cadastrar</button>
				</div>
			</div>

			</fieldset>
		</form>
	</section>

	<footer> </footer>

	<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>

</body>
</html>