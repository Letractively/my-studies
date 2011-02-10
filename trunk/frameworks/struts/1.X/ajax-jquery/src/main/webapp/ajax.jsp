<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<script type="text/javascript" src="/ajax-jquery/resources/js/jquery-1.5.min.js"></script>


<script type="text/javascript">

 $(function(){
		$('#btnLogin').click(function(){
			$.ajax({
				  type: 'POST',
				  url: '/ajax-jquery/ajax.do?method=ajax',
				  cache: false,
				  data: $('#form').serialize(),
				  success: function(data){
				    alert(data);
				  }
				});
			}		 
		);
	}
);

</script>


<html>
	<head>
		<title>Struts & JQuery</title>
	</head>
	<h2>Struts Ajax with JQuery</h2>
	<hr>
	<div style="color: red;">
		<html:errors/>
	</div>
	<html:form action="/ajax" styleId="form">
		<p>Login: <html:text property="login" name="ajaxForm"> </html:text> </p>
		<p>Password: <html:password property="password" name="ajaxForm"> </html:password> </p>
		<input value="login" type="button" id="btnLogin">
	</html:form>
	
	
</html>

