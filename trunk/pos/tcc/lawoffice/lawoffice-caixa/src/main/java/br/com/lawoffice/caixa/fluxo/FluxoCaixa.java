package br.com.lawoffice.caixa.fluxo;

import java.util.Date;
import java.util.List;

import br.com.lawoffice.dominio.Transacao;

/**
 * 
 * TODO: javadoc
 * 
 * @author robson
 *
 */
public interface FluxoCaixa {

	public List<Transacao> consultarFluxoDeCaixa(Date dateInicial, Date dataFinal, Long numeroConta);
}
