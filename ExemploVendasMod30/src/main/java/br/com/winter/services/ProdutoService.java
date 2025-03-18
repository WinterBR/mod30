/**
 * 
 */
package br.com.winter.services;

import br.com.winter.dao.IProdutoDAO;
import br.com.winter.domain.Produto;
import br.com.winter.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
