<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
	<head>
		<title>Dispacth Action</title>
		<script type="text/javascript">
			function submitForm(){
				document.forms[0].action = "user.do?method=add"
				document.forms[0].submit();
			}
		</script>		
	</head>
	<h2>Struts Dispacth Action example</h2>
	<hr>
	<html:form action="/user">
		<bean:write name="UserForm" property="message"/>
		<br>
		<html:submit value="Add" onclick="submitForm()"></html:submit>
		<br>
		<html:submit value="update" property="method"></html:submit>
		<br>
		<html:submit property="method" >delete</html:submit>
		<br>				
	</html:form>
</html>

