
$(function() {
	$( ".draggable" ).draggable();
	$( ".droppable" ).droppable({
		drop: function( event, ui ) {
			$.get(
				'kanban'
			);
		}
	});
});