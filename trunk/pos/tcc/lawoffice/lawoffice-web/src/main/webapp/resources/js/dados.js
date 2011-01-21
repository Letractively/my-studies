function onClickBtnNovo(data){	
	if (data.status == "success"){
		showDados();
		$("#btnSalvarEditar").hide();
		$("#btnSalvarNovo").show();
	}
		
}


function onClickBtnEditar(data){	
	if (data.status == "success"){
		showDados();
		$("#btnSalvarEditar").show();
		$("#btnSalvarNovo").hide();
	}
}


// function para os dois btn de salvar ( novo/editar )
function onClickBtnSalvar(data){	
	if (data.status == "success"){
		showListaDados();
	}		
}


function onClickBtnCancelar(){		
	showListaDados();
}


function showListaDados() {
	$("#listaDados").show();
	$("#dados").hide();
}

function showDados() {
	$("#listaDados").hide();		
	$("#dados").show();
}
