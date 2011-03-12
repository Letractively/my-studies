package br.com.lowoffice.custas.extrato;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.lawoffice.dominio.Custa;


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
public interface Extrato{
	
	public List<Custa> getCustasPorDataCliente(Date dataInicial, Date dataFinal, Long idCliente);
	
	public BigDecimal getValorTotalPesquisa();
	
	public byte[] gerarExtrato(TipoExtrato tipoExtrato); 
}
