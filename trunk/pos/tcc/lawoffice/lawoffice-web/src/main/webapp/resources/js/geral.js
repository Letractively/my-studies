
$(function() {
	$("table").tablesorter();
});


function temp(data){
	//if ( data.status == "begin")
		//$('#ajaxLoader').show();	
	//else 
	if (data.status == "success")
		$("table").tablesorter();
}


$(function(){
	$('ul.sf-menu').superfish();
});