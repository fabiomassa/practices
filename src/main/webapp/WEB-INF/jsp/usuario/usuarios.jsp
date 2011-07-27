<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios</title>
</head>
<body>

<h2>Usuários</h2>

<div id="content-admin">
	<a class="bt-feature" href="<c:url value="/admin/usuario/cadastro"/> ">Create</a>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.nome }</td>
				<td>${usuario.email }</td>
				<td>
					<a href="<c:url value="/admin/usuario/edicao?usuario.email=${usuario.email }"/> ">edit</a>
					<a href="<c:url value="/admin/usuario/delete?usuario.email=${usuario.email }"/> ">delete</a>
					<a href="<c:url value="/admin/usuario/novaSenha?usuario.email=${usuario.email }"/> ">change password</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>