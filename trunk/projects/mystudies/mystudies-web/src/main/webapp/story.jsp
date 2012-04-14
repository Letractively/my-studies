<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Stories</title>

		<link rel="stylesheet" type="text/css" href="resources/css/style.css">

	</head>
	<body>

		<h2>OSGI - HiSTORIA</h2>
		<hr/>

		<div id="containerHistoria">

			<c:forEach items="${stories}" var="story">
				<div class="history">

				    <h4>${story.title}</h4>

				   	<table  cellspacing="0">
				   		<tbody>
				   			<tr>
				   				<td>${story.status}</td>
				   				<td>${story.priority}</td>
				   				<td> <fmt:formatDate value="${story.creationDate}" pattern="dd/MM/yyyy"/> </td>
				   				<td> ${fn:length(story.comments)} comments</td>
				   			</tr>
				   		</tbody>
				   	</table>

				</div>
			</c:forEach>

	</body>
</html>