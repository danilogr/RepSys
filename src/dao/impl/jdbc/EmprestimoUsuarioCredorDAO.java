package dao.impl.jdbc;

import java.util.Properties;

import dao.DAOException;

public class EmprestimoUsuarioCredorDAO extends EmprestimoUsuarioRelJDBCDAO {

	public EmprestimoUsuarioCredorDAO(Properties properties)
			throws DAOException {
		super(properties);
	}

	@Override
	protected String getTableName() {
		return "EMPRESTIMO_USUARIO_CREDOR";
	}
}
