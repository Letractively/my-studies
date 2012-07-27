
$(function() {
	$( ".draggable" ).draggable();
	$( ".droppable" ).droppable({
		drop: function( event, ui ) {

			alert($(ui.draggable).parent().attr("id"));

			if( $(this).attr("id") != $(ui.draggable).parent().attr("id")){
				$.get('kanban');
			}
		}
	});
});

