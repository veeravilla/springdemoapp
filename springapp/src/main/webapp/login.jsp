<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="mvc/senddata" method="post">
		Username : <input type="text" name="username" />
		Password : <input type="password" name="password" />
		<input type="submit" name="login" value="Login"/>
	</form>
</body>
</html>