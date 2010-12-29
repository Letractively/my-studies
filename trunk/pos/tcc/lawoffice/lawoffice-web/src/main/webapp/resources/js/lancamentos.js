$(function() {
	$("#dataInicial").datepicker({ dateFormat: 'dd/mm/yy' });
	$("#dataFinal").datepicker({ dateFormat: 'dd/mm/yy' });
	$("table").tablesorter();
});


function oneventPesquisar(data){
	if ( data.status == "begin"){
		$("#btnPesquisar").attr('disabled', 'disabled');
	}			
	if (data.status == "success"){
		$("#btnPesquisar").attr('disabled', '');
		$("table").tablesorter();
	}
}


