<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
	<head>
		<title>Struts - HTML Tags</title>

	</head>
	<h2>Struts - HTML Tags</h2>
	<hr>
	
	
	<fieldset><legend>Radio</legend>
	<html:form action="/htmltags" styleId="formRadio">
		<div id="radio">		
			<html:radio property="sexo" value="M" >M</html:radio>
			<html:radio property="sexo" value="F" >F</html:radio>
			<span id="msg"></span>
		</div>							
	</html:form>
	<div>
	  <a href="http://struts.apache.org/1.3.10/struts-taglib/tagreference.html#html:radio">Doc Oficial</a>
	</div>
	</fieldset>
</html>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.6.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html-tags.js" ></script>