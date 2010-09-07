<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FiapBank</title>
<style type="text/css">
H3 {
	margin: 0px;
	color: #454545;
}

.div-hr{
	height: 10px;
	width: 100%;
	margin-top:4px;
	border-bottom: 0px;
	background-color:#E0E0E0; 
}

.div-input{
	margin-top: 10px;
	padding: 10px;
	background-color: #F8F9FB;
}
	
</style>
</head>
<body>
<h3>FiapBank</h3>
<div id="div-hr" class="div-hr">
</div>
	<div class="div-input">
			<form method="POST" action="j_security_check">
				<div>
					<table>
						<tr>
							<td>Login:</td>
							<td>
								<input type="text" name="j_username"/>
							</td>
						</tr>
						<tr>
							<td>Senha:</td>
							<td>
								<input type="password" name="j_password"/>
							</td>
						</tr>
					</table>
					<div>
						<input type="submit" value="Login"/> 
					</div>
				</div>			
			</form>
	</div>
</body>
</html>