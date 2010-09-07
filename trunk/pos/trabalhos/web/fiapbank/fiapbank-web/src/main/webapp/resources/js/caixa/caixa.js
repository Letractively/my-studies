/*
 * JS para a pagina de caixa
 */

function exibirRetiradaCartao(){	
	hideShow(
		 '#caixa-retirada-talao', 
		 '#caixa-saque', 
		 '#caixa-deposito', 
		 '#caixa-retirada-cartao'
	);	
}

function exibirSaque(){
	hideShow(
		'#caixa-retirada-talao', 
		'#caixa-deposito', 
		'#caixa-retirada-cartao', 
		'#caixa-saque'
	);
}


function exibirDeposito(){
	hideShow(
		'#caixa-retirada-talao', 
		'#caixa-saque', 
		'#caixa-retirada-cartao',
		'#caixa-deposito'
	);
}


function exibirRetiradaTalao(){	
	hideShow( 
		'#caixa-saque', 
		'#caixa-deposito', 
		'#caixa-retirada-cartao',
		'#caixa-retirada-talao'
	);	
}


function exibirBtnConfirmarSaque(){	
	hideShowBtn(  
		'#confirmar-deposito', 
		'#confirmar-cartao',
		'#confirmar-talao',
		'#confirmar-saque'
	);	
}


function exibirBtnConfirmarDeposito(){	
	hideShowBtn(  
		'#confirmar-cartao',
		'#confirmar-talao',
		'#confirmar-saque',
		'#confirmar-deposito'
	);	
}


function exibirBtnConfirmarTalao(){	
	hideShowBtn(  
		'#confirmar-cartao',
		'#confirmar-saque',
		'#confirmar-deposito',
		'#confirmar-talao'
	);	
}


function exibirBtnConfirmarCartao(){	
	hideShowBtn(
		'#confirmar-saque',
		'#confirmar-deposito',
		'#confirmar-talao',
		'#confirmar-cartao'		
	);	
}
function hideShow(id1, id2, id3, id4) {
	j(id1).hide();
	j(id2).hide();
	j(id3).hide();
	j(id4).fadeIn(1000);
}


function hideShowBtn(id1, id2, id3, id4) {
	j(id1).hide();
	j(id2).hide();
	j(id3).hide();
	j(id4).show();
}