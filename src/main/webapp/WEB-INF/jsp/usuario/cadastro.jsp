<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>

<h2>User</h2>

<div id="content-admin">
	<form action="<c:url value="/admin/usuario/cadastro" />" method="post">
		<div>
			<label>Name:</label>
			<input type="text" name="usuario.nome" />
		</div>
		<div>
			<label>Email:</label>
			<input type="text" name="usuario.email" />
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="usuario.senha" />
		</div>
			<input type="hidden" name="usuario.role" value="EDITOR" />
			<input class="bt-feature" class="bt-feature" type="submit" />
	</form>
</div>

</body>
</html>