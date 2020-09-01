<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css">

<title>CADASTRO</title>
</head>
<body>

	<header>
		<nav></nav>
	</header>

	<div></div>

	<section>
		<form class="form-horizontal">
			<fieldset>
				<legend>Cadastro de Pessoas</legend>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm">Nome</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idNm" name="txtNm"
							placeholder="Digite seu nome" required="required">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm">Sobrenome</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idSnm" name="txtSnm"
							placeholder="Digite seu sobrenome" required="required">
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc">Data de Nascimento</label>
					<div class="col-sm-8">
						<input type="date" class="form-control" id="idDtNasc" name="txtDtNasc"
							required="required">
					</div>
				</div>
			<div class="form-group">    
					<label class="control-label col-sm-4" for="idGen">Genero</label>
					<div class="col-sm-8">
						<select class="form-control" id="idGen" name="txtGen" required="required">
							<option value="0" selected="selected">Selecione uma opção.</option>
							<option value="m">Masculino</option>
							<option value="f">Feminino</option>
							<option value="o">Outros</option>
						</select>
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idTel">Telefone</label>
					<div class="col-sm-8">
						<input type="tel" class="form-control" id="idTel" name="txtTel"
							required="required">
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