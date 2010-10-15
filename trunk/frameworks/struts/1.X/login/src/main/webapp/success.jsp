<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
	<head>
		<title>Sucess</title>
	</head>
	<h2>Struts login example</h2>
	<hr>
	<h2> Login Success: Welcome <bean:write name="loginForm" property="login"/> </h2>
</html>