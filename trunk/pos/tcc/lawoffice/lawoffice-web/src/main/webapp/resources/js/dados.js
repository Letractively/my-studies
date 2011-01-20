function onClickBtnNovo(data){	
	if (data.status == "success"){
		showDados();
		$("#btnSalvarEditar").hide();
	}
		
}


function onClickBtnEditar(data){	
	if (data.status == "success"){
		showDados();
		$("#btnSalvarNovo").hide();
	}
}


function temp(data) {
	if (data.status == "serverError"){
		alert("sksks");
	}
}

// function para os dois btn de salvar ( novo/editar )
function onClickBtnSalvar(data){	
	if (data.status == "success"){
		showClientes();
	}		
}


function onClickBtnCancelar(){		
	showClientes();
}


function showClientes() {
	$("#clientes").show();
	$("#dados").hide();
}

function showDados() {
	$("#clientes").hide();		
	$("#dados").show();
}
