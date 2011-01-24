function oneventAddCusta(data){
	//if ( data.status == "begin")
		//$('#ajaxLoader').show();	
	//else 
	if (data.status == "success"){
		$("#natureza").focus();		
	}
}


function oneventFecharLancamento(data){
	if ( data.status == "begin")
		$("#btnFecharLancamento").attr('disabled', 'disabled');	
	if (data.status == "success")
		$("#btnFecharLancamento").attr('disabled', '');
}
