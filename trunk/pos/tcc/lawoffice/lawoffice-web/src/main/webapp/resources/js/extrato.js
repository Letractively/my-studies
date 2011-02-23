/*jQuery(function() {
	jQuery("#dataInicial").datepicker({ dateFormat: 'dd/mm/yy' });
	jQuery("#dataFinal").datepicker({ dateFormat: 'dd/mm/yy' });
});*/


function oneventPesquisar(data){
	if ( data.status == "begin"){
		jQuery("#btnPesquisar").attr('disabled', 'disabled');
	}			
	if (data.status == "success"){
		jQuery("#btnPesquisar").attr('disabled', '');
		jQuery("table").tablesorter();
	}
}


