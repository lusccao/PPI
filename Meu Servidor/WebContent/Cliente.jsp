<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente</title>
</head>
<body>
	<%Cliente cliente = (Cliente)request.getAttribute("cliente"); %>
	Id: <%=cliente.getId() %><br>
	Nome: <%=cliente.getNome() %><br>
	Fone: <%=cliente.getFone() %><br>
	E-mail: <%=cliente.getEmail() %><br>
</body>
</html>