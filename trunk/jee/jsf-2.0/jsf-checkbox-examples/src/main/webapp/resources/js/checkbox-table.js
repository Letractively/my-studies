$(function() {	
	$('input:checkbox').click(function() {
		if(this.checked){			
			$('input:checkbox')
			.not(this)
			.attr('checked', false);			
		}
	});		
});