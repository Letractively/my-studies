package br.com.lowoffice.caixa.extrato;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author robson
 *
 */
public class ExtratoDTO {

	
	public String nomePessoa; 
	
	public BigDecimal saldoAnterior;
	
	public BigDecimal saldoAtual;
	
	public Date dataAtual;
	
	public Date dataFinal;
	
	public List<ExtroItem> extratoItens;
	
}
