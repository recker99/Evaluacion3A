<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
	<div align="center">
	<h2>LOGIN</h2>
		<form action="LoginServlet" method="post">	
			<table>
				<tbody>
					<tr>
						<td>Usuario:</td>
						<td><input type="text" name="usuario"/></td>
					</tr>
					<tr>
						<td>Contraseña:</td>
						<td><input type="password" name="password"/><BR/></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Enviar"/></td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</body>
</html>
