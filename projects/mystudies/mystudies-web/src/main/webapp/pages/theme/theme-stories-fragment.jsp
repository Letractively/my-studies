<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:forEach items="${theme.stories}" var="story">			
	<div class="item">				
		<div>
		    <h3 class="item-title"><a href="#">${story.title}</a> </h3>
		</div>
			
		<div>
			<form>
				<ul class="item-information">
					<li>${story.priority}</li>
					<li>${story.status}</li>
					<li> <fmt:formatDate value="${story.creationDate}" pattern="dd/MM/yyyy"/> </li>
					<li><a href="#">${fn:length(story.comments)} comments</a></li>
					<c:choose>
						<c:when test="${story.status == 'SPRINT_BACKLOG'}">
							<li><a href="#" class="addSprint" >add sprint</a></li>
						</c:when>
						<c:otherwise>
							<li>${story.points } points</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<input type="hidden" value="${story.id}" name="storyId"/>
				<input type="hidden" value="${theme.id}" name="themeId"/>
				<input type="hidden" value="ADDSTORYSPRINT" name="action"/>
				<div style="clear: both;"></div>
			</form>					
		</div>					    
	</div>				
</c:forEach>
