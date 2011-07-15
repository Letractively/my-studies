package br.com.lowoffice.caixa.extrato;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.dominio.Pessoa;


/**
 * Interface para o serviço de extrato de custas
 * 
 * <br><br>
 * 
 * Forncendo o serviço de pesquisa de lançamentos ( custas )
 * 
 * <br> <br>
 * 
 * @author robson
 *
 */
public interface ExtratoService{
	
	public ExtratoDTO getExtrato(Date dataInicial, Date dataFinal, Pessoa pessoa);
	
	
	public byte[] gerarExtrato(TipoExtrato tipoExtrato); 
}
