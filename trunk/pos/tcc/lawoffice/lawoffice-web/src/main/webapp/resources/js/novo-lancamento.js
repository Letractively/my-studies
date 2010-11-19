$(function() {
	$("table").tablesorter();
});


function oneventAddCusta(data){
	//if ( data.status == "begin")
		//$('#ajaxLoader').show();	
	//else 
	if (data.status == "success"){
		$("#tableCustas").tablesorter();
		$("#natureza").focus();
	}
}