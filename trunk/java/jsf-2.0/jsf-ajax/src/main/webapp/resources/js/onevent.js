$(function() {
	$('#ajaxLoader').hide();
});

function showHideAjaxLoader(data){
	if ( data.status == "begin")
		$('#ajaxLoader').show();	
	else if (data.status == "success")
		$('#ajaxLoader').hide();
}
