package dao.impl.jdbc;

import java.util.Properties;

import dao.DAOException;
import dao.DAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IUsuarioDAO;

public class JDBCDAOFactory extends DAOFactory {

	private Properties properties;
	
	/**
	 * Implementa��o do padr�o Factory Method
	 * 
	 * java.util.Properties � uma extens�o de java.util.HashTable.
	 * @param properties
	 */
	public JDBCDAOFactory(Properties properties) {
		this.properties = properties;
	}
	
	public IUsuarioDAO getUserDAO() throws DAOException {
		return new UsuarioJDBCDAO(this.properties);
	}

	public IContaDAO getAccountDAO() throws DAOException {
		return new ContaJDBCDAO(this.properties);
	}
}
