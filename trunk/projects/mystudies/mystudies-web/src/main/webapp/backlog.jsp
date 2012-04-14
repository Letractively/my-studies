<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Backlog</title>

		<link rel="stylesheet" type="text/css" href="resources/css/style.css">

	</head>
	<body>

		<h2>My Studies - Backlog</h2>
		<hr/>



		<div id="containerTema">

			<c:forEach items="${themes}" var="theme">

				<div class="tema">
				    <h4>${theme.title}</h4>

				    <table  cellspacing="0">
				   		<tbody>
				   			<tr>
				   				<td>${theme.priority}</td>
				   				<td> <fmt:formatDate value="${theme.creationDate}" pattern="dd/MM/yyyy"/> </td>
				   				<td><a href="story"> ${fn:length(theme.stories)} stories </a></td>
				   				<td>3 comments</td>
				   				<td><button>new history</button></td>
				   			</tr>
				   		</tbody>
				   	</table>
				</div>

			</c:forEach>



		</div>

	</body>
</html>