<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
	<head>
		<title>Login</title>
	</head>
	<h2>Struts login example</h2>
	<hr>
	<div style="color: red;">
		<html:errors/>
	</div>
	<html:form action="/login">
		<p>Login: <html:text property="login" name="loginForm"> </html:text> </p>
		<p>Password: <html:password property="password" name="loginForm"> </html:password> </p>
		<html:submit value="Login"/>
	</html:form>
</html>

