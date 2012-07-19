<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Kanban</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<style type="text/css">
		

	
	</style>
</head>
<body>

	<div class="header">
		<a>MYSTUDIES</a>
	</div>


	
	<div class="kanban">
	
		
	
		<c:forEach var="entry" items="${map}">
		
			<div style="border: 1px solid blue; float: left; width: 10%;    height: ${100 / fn:length(map)}%; ">
												
				<c:out value="${entry.key.title}"></c:out>
				
			</div>
			
			<div style="border: 1px solid black; float: left; width: 30%; height: ${100 / fn:length(map)}%;">
				<c:forEach var="story" items="${entry.value}">
					<div class="story">
						<c:out value="${story.title}"></c:out>
					</div>
				</c:forEach>				
			</div>
			
			<div style="border: 1px solid black; float: left;  width: 30%; height: ${100 / fn:length(map)}%;">
				<c:forEach var="story" items="${entry.value}">
					<c:out value="${story.title}"></c:out>
				</c:forEach>				
			</div>
			
			<div style="border: 1px solid black;  height: ${100 / fn:length(map)}%;">
				<c:forEach var="story" items="${entry.value}">
					<c:out value="${story.title}"></c:out>
				</c:forEach>				
			</div>
					
		</c:forEach>
	</div>	

	<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="resources/js/general.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui-1.8.18.custom.min.js"></script>
	<script type="text/javascript" src="resources/js/kanban.js"></script>
	
</body>
</html>