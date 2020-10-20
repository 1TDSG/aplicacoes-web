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

<title><f:message key="site.paginas.atualiza.titulo"/> </title>
</head>
<body>

	<%@ include file="../menu-header.html" %>

	<section>
		
		<form class="form-horizontal" action="update" method="post">
			<input type="hidden" name="txtIdCli" value="${objCli.id}" >
			<fieldset>
				<legend><f:message key="site.paginas.atualiza.form.legenda"/> </legend>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm"><f:message key="site.paginas.atualiza.form.campo.nome"/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idNm" name="txtNm"
							placeholder='<f:message key="site.paginas.atualiza.form.campo.placeholder.nome"/>' required="required" value="${objCli.nome}">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm"><f:message key="site.paginas.atualiza.form.campo.sobrenome"/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="idSnm" name="txtSnm"
							placeholder='<f:message key="site.paginas.atualiza.form.campo.placeholder.sobrenome"/>' required="required" value="${objCli.sobrenome}">
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc"><f:message key="site.paginas.atualiza.form.campo.data_nasc"/></label>
					<div class="col-sm-8">
						<input type="date" class="form-control" id="idDtNasc" name="txtDtNasc"
							required="required" value='<f:formatDate value="${objCli.dtNasc}" pattern="yyyy-MM-dd"/>' pattern="dd-MM-yyyy"> 
					</div>
				</div>
			<div class="form-group">    
					<label class="control-label col-sm-4" for="idGen"><f:message key="site.paginas.atualiza.form.campo.genero"/></label>
					<div class="col-sm-8">
						<select class="form-control" id="idGen" name="txtGen" required="required">
						<c:choose>
							<c:when test="${objCli.genero eq 'm'.charAt(0)}">
								<option value="0"><f:message key="site.paginas.atualiza.form.select.option.sel"/></option>
								<option value="m" selected="selected"><f:message key="site.paginas.atualiza.form.select.option.m"/></option>
								<option value="f"><f:message key="site.paginas.atualiza.form.select.option.f"/></option>
								<option value="o"><f:message key="site.paginas.atualiza.form.select.option.o"/></option>
							</c:when>
							<c:when test="${objCli.genero eq 'f'.charAt(0)}">
								<option value="0"><f:message key="site.paginas.atualiza.form.select.option.sel"/></option>
								<option value="m"><f:message key="site.paginas.atualiza.form.select.option.m"/></option>
								<option value="f" selected="selected"><f:message key="site.paginas.atualiza.form.select.option.f"/></option>
								<option value="o"><f:message key="site.paginas.atualiza.form.select.option.o"/></option>
							</c:when>
							<c:otherwise>
								<option value="0"><f:message key="site.paginas.atualiza.form.select.option.sel"/></option>
								<option value="m"><f:message key="site.paginas.atualiza.form.select.option.m"/></option>
								<option value="f"><f:message key="site.paginas.atualiza.form.select.option.f"/></option>
								<option value="o" selected="selected"><f:message key="site.paginas.atualiza.form.select.option.o"/></option>
							</c:otherwise>
						</c:choose>
						</select>
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-sm-4" for="idTel"><f:message key="site.paginas.atualiza.form.campo.telefone"/>(00) 00000-0000</label>
					<div class="col-sm-8">
						<input type="tel" class="form-control" id="idTel" name="txtTel"
							required="required" value="${objCli.telefone}" maxlength="15" 
							pattern="\([0-9]{2}\) [0-9]{4,5}-[0-9]{4}$">
					</div>
				</div>
 
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
					<button type="submit" class="btn btn-info btn-lg"><f:message key="site.paginas.atualiza.form.botao.atualizar"/></button>
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
