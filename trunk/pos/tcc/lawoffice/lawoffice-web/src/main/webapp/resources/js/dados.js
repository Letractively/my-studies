function onClickBtnNovo(){	
	showDados();
	jQuery("#btnSalvarEditar").hide();
	jQuery("#btnSalvarNovo").show();
}


function onClickBtnEditar(){	
	showDados();
	jQuery("#btnSalvarEditar").show();
	jQuery("#btnSalvarNovo").hide();
	
}


// function para os dois btn de salvar ( novo/editar )
function onClickBtnSalvar(){
		showListaDados();
}


function onClickBtnCancelar(){		
	showListaDados();
}


function showListaDados() {
	jQuery("#listaDados").show();
	jQuery("#dados").hide();
}

function showDados() {
	jQuery("#listaDados").hide();		
	jQuery("#dados").show();
}
