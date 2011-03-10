/*function oneventAddCusta(data){
	//if ( data.status == "begin")
		//$('#ajaxLoader').show();	
	//else 
	if (data.status == "success"){
		jQuery("#natureza").focus();		
	}
}

function oneventFecharLancamento(data){
	if ( data.status == "begin")
		jQuery("#btnFecharLancamento").attr('disabled', 'disabled');	
	if (data.status == "success")
		jQuery("#btnFecharLancamento").attr('disabled', '');
}*/


function focusNatureza() {
	jQuery('#natureza').focus();
}


function showNotificationBar() {
	
	var text = jQuery("#msgLancamento").text();
	
	if(text != "")
		nofificationBarLancamento.show();
		
	
}

