/**
 * 
 */
package br.com.winter.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.winter.dao.generic.GenericDAO;
import br.com.winter.domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		entityCadastrado.setCidade(entity.getCidade());
		entityCadastrado.setIdade(entity.getIdade());
		entityCadastrado.setCpf(entity.getCpf());
		entityCadastrado.setEnd(entity.getEnd());
		entityCadastrado.setEstado(entity.getEstado());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setNumero(entity.getNumero());
		entityCadastrado.setTel(entity.getTel());
		
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_CLIENTE ");
		sb.append("(ID, NOME, IDADE, CPF, TEL, ENDERECO, NUMERO, CIDADE, ESTADO)");
		sb.append("VALUES (nextval('sq_cliente'),?,?,?,?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException {
		stmInsert.setString(1, entity.getNome());
		stmInsert.setLong(2, entity.getIdade());
		stmInsert.setLong(3, entity.getCpf());
		stmInsert.setLong(4, entity.getTel());
		stmInsert.setString(5, entity.getEnd());
		stmInsert.setLong(6, entity.getNumero());
		stmInsert.setString(7, entity.getCidade());
		stmInsert.setString(8, entity.getEstado());
		
	}

	@Override
	protected String getQueryExclusao() {
		return "DELETE FROM TB_CLIENTE WHERE CPF = ?";
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
		stmExclusao.setLong(1, valor);
	}
	
	@Override
	protected String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_CLIENTE ");
		sb.append("SET NOME = ?,");
		sb.append("IDADE = ?,");
		sb.append("TEL = ?,");
		sb.append("ENDERECO = ?,");
		sb.append("NUMERO = ?,");
		sb.append("CIDADE = ?,");
		sb.append("ESTADO = ?");
		sb.append(" WHERE CPF = ?");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {
		stmUpdate.setString(1, entity.getNome());
		stmUpdate.setLong(2, entity.getIdade());
		stmUpdate.setLong(3, entity.getTel());
		stmUpdate.setString(4, entity.getEnd());
		stmUpdate.setLong(5, entity.getNumero());
		stmUpdate.setString(6, entity.getCidade());
		stmUpdate.setString(7, entity.getEstado());
		stmUpdate.setLong(8, entity.getCpf());
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
		stmSelect.setLong(1, valor);
	}

}
