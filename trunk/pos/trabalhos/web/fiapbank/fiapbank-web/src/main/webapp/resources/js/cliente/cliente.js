/*
 * JS para a pagina de cliente
 */

function exibirDocTed(){	
	hideShowCliente(
		 '#cliente-transferencia', 
		 '#cliente-extrato', 
		 '#cliente-frase-secreta',
		 '#cliente-poupanca-aplicacao',
		 '#cliente-poupanca-resgate',
		 '#cliente-saldo',
		 '#cliente-doc-ted'
	);	
}


function exibirExtrato(){	
	hideShowCliente(
		 '#cliente-transferencia',  
		 '#cliente-frase-secreta',
		 '#cliente-poupanca-aplicacao',
		 '#cliente-poupanca-resgate',
		 '#cliente-saldo',
		 '#cliente-doc-ted',
		 '#cliente-extrato'
	);	
}


function exibirFraseSecreta(){	
	hideShowCliente(
		 '#cliente-transferencia',  
		 '#cliente-poupanca-aplicacao',
		 '#cliente-poupanca-resgate',
		 '#cliente-saldo',
		 '#cliente-doc-ted',		 
		 '#cliente-extrato',
		 '#cliente-frase-secreta'
	);	
}

function exibirPoupancaAplicacao(){	
	hideShowCliente(
		 '#cliente-transferencia',  
		 '#cliente-poupanca-resgate',
		 '#cliente-saldo',
		 '#cliente-doc-ted',		 
		 '#cliente-extrato',
		 '#cliente-frase-secreta',
		 '#cliente-poupanca-aplicacao'
	);	
}


function exibirPoupancaResgate(){	
	hideShowCliente(
		 '#cliente-transferencia',  
		 '#cliente-saldo',
		 '#cliente-doc-ted',		 
		 '#cliente-extrato',
		 '#cliente-frase-secreta',
		 '#cliente-poupanca-aplicacao',
		 '#cliente-poupanca-resgate'
	);	
}


function exibirSaldo(){	
	hideShowCliente(
		 '#cliente-transferencia',  
		 '#cliente-doc-ted',		 
		 '#cliente-extrato',
		 '#cliente-frase-secreta',
		 '#cliente-poupanca-aplicacao',
		 '#cliente-poupanca-resgate',
		 '#cliente-saldo'
	);	
}


function exibirTransferencia(){	
	hideShowCliente(  
		 '#cliente-doc-ted',		 
		 '#cliente-extrato',
		 '#cliente-frase-secreta',
		 '#cliente-poupanca-aplicacao',
		 '#cliente-poupanca-resgate',
		 '#cliente-saldo',
		 '#cliente-transferencia'
	);	
}


function exibirBtnConfirmaExtrado(){	
	hideShowClienteBtn(  
		 '#div-btn-confirmar-doc-ted',		 
		 '#div-btn-confirmar-transferencia',
		 '#div-btn-confirmar-resagte-poupanca',
		 '#div-btn-confirmar-aplicar-poupanca',
		 '#div-btn-confirmar-frase-secreta',
		 '#div-btn-confirmar-saldo',
		 '#div-btn-confirmar-extrado'
	);	
}



function exibirBtnConfirmaSaldo(){	
	hideShowClienteBtn(  
		 '#div-btn-confirmar-doc-ted',		 
		 '#div-btn-confirmar-transferencia',
		 '#div-btn-confirmar-resagte-poupanca',
		 '#div-btn-confirmar-aplicar-poupanca',
		 '#div-btn-confirmar-frase-secreta',
		 '#div-btn-confirmar-extrado',
		 '#div-btn-confirmar-saldo'		 
	);	
}



function exibirBtnConfirmaFraseSecreta(){	
	hideShowClienteBtn(  
		 '#div-btn-confirmar-doc-ted',		 
		 '#div-btn-confirmar-transferencia',
		 '#div-btn-confirmar-resagte-poupanca',
		 '#div-btn-confirmar-aplicar-poupanca',
		 '#div-btn-confirmar-extrado',
		 '#div-btn-confirmar-saldo',
		 '#div-btn-confirmar-frase-secreta'		 
	);	
}



function exibirBtnConfirmaTransferencia(){	
	hideShowClienteBtn(  
		 '#div-btn-confirmar-doc-ted',
		 '#div-btn-confirmar-resagte-poupanca',
		 '#div-btn-confirmar-aplicar-poupanca',
		 '#div-btn-confirmar-extrado',
		 '#div-btn-confirmar-saldo',
		 '#div-btn-confirmar-frase-secreta',
		 '#div-btn-confirmar-transferencia'
	);	
}



function exibirBtnConfirmaResgatePoupanca(){	
	hideShowClienteBtn(  
		 '#div-btn-confirmar-doc-ted',
		 '#div-btn-confirmar-aplicar-poupanca',
		 '#div-btn-confirmar-extrado',
		 '#div-btn-confirmar-saldo',
		 '#div-btn-confirmar-frase-secreta',
		 '#div-btn-confirmar-transferencia',
		 '#div-btn-confirmar-resagte-poupanca'
	);	
}


function exibirBtnConfirmaAplicarPoupanca(){	
	hideShowClienteBtn(  
		 '#div-btn-confirmar-doc-ted',
		 '#div-btn-confirmar-extrado',
		 '#div-btn-confirmar-saldo',
		 '#div-btn-confirmar-frase-secreta',
		 '#div-btn-confirmar-transferencia',
		 '#div-btn-confirmar-resagte-poupanca',
		 '#div-btn-confirmar-aplicar-poupanca'
	);	
}



function exibirBtnConfirmaDocTed(){	
	hideShowClienteBtn(  
		 '#div-btn-confirmar-extrado',
		 '#div-btn-confirmar-saldo',
		 '#div-btn-confirmar-frase-secreta',
		 '#div-btn-confirmar-transferencia',
		 '#div-btn-confirmar-resagte-poupanca',
		 '#div-btn-confirmar-aplicar-poupanca',
		 '#div-btn-confirmar-doc-ted'
	);	
}

function hideShowCliente(id1, id2, id3, id4, id5, id6, id7) {
	j(id1).hide();
	j(id2).hide();
	j(id3).hide();
	j(id4).hide();
	j(id5).hide();
	j(id6).hide();	
	j(id7).fadeIn(1000);
}



function hideShowClienteBtn(id1, id2, id3, id4, id5, id6, id7) {
	j(id1).hide();
	j(id2).hide();
	j(id3).hide();
	j(id4).hide();
	j(id5).hide();
	j(id6).hide();	
	j(id7).show();
}