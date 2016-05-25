<%@page import="com.webapp.dominio.Registro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Registro texto = (Registro) request.getAttribute("texto");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1><%=texto.getName() %></h1>
    </body>
</html>
