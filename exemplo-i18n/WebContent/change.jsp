<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Título</title>
</head>
<body>
		
		<c:if test="${not empty param.lingua}">
			<f:setLocale value="${param.lingua}" scope="session"/>
		</c:if>
		
		<jsp:forward page="index.jsp"/>
		
</html>