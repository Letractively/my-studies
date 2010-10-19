<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
	<head>
		<title>Lookup Dispacth Action</title>
	</head>
	<h2>Struts Lookup Dispacth Action example</h2>
	<hr>
	<html:form action="/user">
		<bean:write name="UserForm" property="message"/>
		<br>
		<html:submit property="method"> <bean:message key="UserForm.add"/> </html:submit>
		<br>
		<html:submit property="method"> <bean:message key="UserForm.update"/> </html:submit>
		<br>
		<html:submit property="method" > <bean:message key="UserForm.delete"/> </html:submit>
		<br>				
	</html:form>
</html>

