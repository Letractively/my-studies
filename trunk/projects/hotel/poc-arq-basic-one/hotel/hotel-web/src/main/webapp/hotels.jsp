<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="hotel">

		<select name="region">
			<option>Brasil</option>
			<option>Mexico</option>
		</select>


		<input type="text" name="stars">


		<input type="submit" value="search"/>

	</form>




		<c:forEach items="${hotels}" var="hotel">
			<div>
				${hotel.name}
			</div>
		</c:forEach>


</body>
</html>