/**
 * 
 */
package br.com.winter.dao;

import br.com.winter.dao.generic.IGenericDAO;
import br.com.winter.domain.Venda;
import br.com.winter.exceptions.DAOException;
import br.com.winter.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
