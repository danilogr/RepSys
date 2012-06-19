package dao.impl.jdbc;

import java.util.Properties;

import dao.DAOException;

public class EmprestimoUsuarioDevedorDAO extends EmprestimoUsuarioRelJDBCDAO {

	public EmprestimoUsuarioDevedorDAO(Properties properties)
			throws DAOException {
		super(properties);
	}

	@Override
	protected String getTableName() {
		return "EMPRESTIMO_USUARIO_DEVEDOR";
	}

}
