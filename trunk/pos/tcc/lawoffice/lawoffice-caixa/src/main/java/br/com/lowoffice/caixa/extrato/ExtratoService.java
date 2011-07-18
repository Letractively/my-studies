package br.com.lowoffice.caixa.extrato;

import java.util.Date;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;


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
	
	
	public ExtratoDTO getExtratoColaborador(Date dataInicial, Date dataFinal, Colaborador colaborador);
	
	
	public ExtratoDTO getExtratoCliente(Date dataInicial, Date dataFinal, Cliente cliente);
	
	
	
	public byte[] gerarExtrato(TipoExtrato tipoExtrato); 
}
