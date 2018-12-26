<%-- 
    Document   : login
    Created on : 24/12/2018, 16:24:14
    Author     : ricardobalduino
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de Login</title>
</head>
<body>
	<h2>Login do sistema</h2>
	<%
		String msg = (String)session.getAttribute("MENSAGEM");
		if (msg != null) {
			session.setAttribute("MENSAGEM", null);
	%>
			<h3><script>alert("<%=msg%>");</script></h3>
	<%  } %>
	<form action="./Authenticator" method="post">
		<table>
			<tr>
				<td>Usuario : </td>
				<td><input type="text" name="TXTUSER"/></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="text" name="TXTPASS"/></td>
			</tr>		
			<tr>
				<td><input type="submit" value="Logar"/></td>
			</tr>			
		</table>
	</form>
</body>
</html>
