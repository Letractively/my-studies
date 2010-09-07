/*
 * JS para a pagina de contas  
 */

function exibirEstatusPedido(){
	
	var status = j("#status-credito").val();
	
	if ( status == 'APROVADO') {
		j('#dados-credito').hide();
		j('#pedido-aprovado').fadeIn(1000);
	}
	else if ( status == 'SUJEITO_A_APROVACAO') {
		j('#dados-credito').hide();
		j('#pedido-sujeito-aprovacao').fadeIn(1000);
	}
	else{
		j('#dados-credito').hide();
		j('#pedido-recusado').fadeIn(1000);
	}	
}


function exibirDadosCredito() {
	hideStatusPedidos();
	j('#dados-credito').fadeIn(1000);
}


function exibirPedidoGeradoSucesso() {
	hideStatusPedidos();
	j('#pedido-gerado-sucesso').fadeIn(1000);
}


function exibirDetalhesPedido() {
	j('#panel-lista-credito-avaliar').hide();
	j('#detalhes-credito').fadeIn(1000);
}


function exibirListaCreditosAvaliar(){
	j('#detalhes-credito').hide();
	j('#panel-lista-credito-avaliar').fadeIn(1000);	
}



function hideStatusPedidos() {
	j('#pedido-aprovado').hide();	
	j('#pedido-sujeito-aprovacao').hide();			
	j('#pedido-recusado').hide();
}