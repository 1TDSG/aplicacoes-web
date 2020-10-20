<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css">

<title><f:message key="site.paginas.index.titulo" /></title>

</head>
<body>

	<%@ include file="menu-header.html" %>

	<c:if test="${not empty param.msgStatus}">
		<div>
			<h2><f:message key="site.paginas.index.msg.${param.msgStatus}" /></h2>
		</div>
	</c:if>

	<section>
		<form class="form-horizontal" action="cliente" method="post">
			<fieldset>
				<legend><f:message key="site.paginas.index.form.legenda"/> </legend>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm"><f:message key="site.paginas.index.form.campo.nome"/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idNm" name="txtNm"
							placeholder="<f:message key="site.paginas.index.form.campo.placeholder.nome"/>" required="required">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm"><f:message key="site.paginas.index.form.campo.sobrenome"/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idSnm" name="txtSnm"
							placeholder="<f:message key="site.paginas.index.form.campo.placeholder.sobrenome"/>" required="required">
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc"><f:message key="site.paginas.index.form.campo.data_nasc"/></label>
					<div class="col-sm-8">
						<input type="date" class="form-control" id="idDtNasc" name="txtDtNasc"
							required="required">
					</div>
				</div>
			<div class="form-group">    
					<label class="control-label col-sm-4" for="idGen"><f:message key="site.paginas.index.form.campo.genero"/></label>
					<div class="col-sm-8">
						<select class="form-control" id="idGen" name="txtGen" required="required">
							<option value="0" selected="selected"><f:message key="site.paginas.index.form.select.option.sel"/></option>
							<option value="m"><f:message key="site.paginas.index.form.select.option.m"/></option>
							<option value="f"><f:message key="site.paginas.index.form.select.option.f"/></option>
							<option value="o"><f:message key="site.paginas.index.form.select.option.o"/></option>
						</select>
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idTel"><f:message key="site.paginas.index.form.campo.telefone"/> (00) 00000-0000</label>
					<div class="col-sm-8">
						<input type="tel" class="form-control" id="idTel" name="txtTel"
							required="required" maxlength="15" 
							pattern="\([0-9]{2}\) [0-9]{4,5}-[0-9]{4}$">
					</div>
				</div>
 
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
					<button type="submit" class="btn btn-success btn-lg"><f:message key="site.paginas.index.form.botao.cadastrar"/></button>
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
