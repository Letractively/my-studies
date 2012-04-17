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

		<div class="header">
			<a>MYSTUDIES</a>
		</div>
			
			
		<div class="title-content">
			<h3><a href="#">THEMES</a> </h3>
		</div>


		<div class="main-content">
			<c:forEach items="${themes}" var="theme">			
				<div class="item">				
					<div>
					    <h3 class="item-title"><a href="#">${theme.title}</a> </h3>
					</div>
						
					<div >
						<ul class="item-information">
							<li>${theme.priority}</li>
							<li> <fmt:formatDate value="${theme.creationDate}" pattern="dd/MM/yyyy"/> </li>
							<li><a href="history.html">${fn:length(theme.stories)} stories</a></li>
							<li><a href="#">${fn:length(theme.comments)} comments</a></li>
						</ul>
						<div style="clear: both;"></div>					
					</div>					    
				</div>				
			</c:forEach>			
		</div>


		<ul class="menu">
			<li class="home"><a>New Theme</a></li>
			<li class="about"><a>Add Story</a></li>
			<li class="about"><a>Add Comment</a></li>
		</ul>
		
		<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="resources/js/menu.js"></script>

	</body>
</html>