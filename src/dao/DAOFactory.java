package dao;

import util.Configuration;
import dao.impl.jdbc.JDBCDAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IUsuarioDAO;

abstract public class DAOFactory {

	private static DAOFactory instance = null;

	public static DAOFactory getInstance() {
		if (instance == null) {
			Configuration configuration = Configuration.getInstance();
			String value = configuration.getProperty("dao");
			if (value.equals("JDBC")) {
				instance = new JDBCDAOFactory(configuration.getProperties());
			}
                        System.out.println(instance);
		}
		return instance;
	}

	public abstract IUsuarioDAO getUserDAO() throws DAOException;

	public abstract IContaDAO getAccountDAO() throws DAOException;
}