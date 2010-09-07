/*
 * JS para a pagina de contas  
 */

function exibirDadosRenda() {
	
	if (j("#proximo-passo").val() == "true") {
		j('#dados-cliente').hide();
		j('#dados-renda').fadeIn(1000);
	}	
}


function exibirConfirmarSenha() {
	
	if (j("#proximo-passo").val() == "true") {
		j('#dados-renda').hide();
		j('#confirmar-senha').fadeIn(1000);
	}	
}


function exibirContaAbertaSucesso() {
	
	if (j("#proximo-passo").val() == "true") {
		j('#confirmar-senha').hide();
		j('#conta-aberta-sucesso').fadeIn(1000);
	}	
}