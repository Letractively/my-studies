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


function oneventFecharLancamento(data){
	if ( data.status == "begin")
		$("#btnFecharLancamento").attr('disabled', 'disabled');	
	if (data.status == "success")
		$("#btnFecharLancamento").attr('disabled', '');
}

