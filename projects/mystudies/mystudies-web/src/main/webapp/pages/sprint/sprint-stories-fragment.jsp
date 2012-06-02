<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:forEach items="${sprint.stories}" var="story">			
	<div class="item">				
		<div>
		    <h3 class="item-title"><a href="#">${story.title}</a> </h3>
		</div>
			
		<div >
			<ul class="item-information">
				<li>${story.priority}</li>
				<li>${story.points} points</li>
				<li> <fmt:formatDate value="${story.creationDate}" pattern="dd/MM/yyyy"/> </li>
				<li><a href="#">${fn:length(story.comments)} comments</a></li>
			</ul>
			<div style="clear: both;"></div>					
		</div>					    
	</div>				
</c:forEach>
