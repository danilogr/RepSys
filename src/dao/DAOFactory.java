package dao;

import util.Configuration;
import dao.impl.jdbc.JDBCDAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IEmprestimoDAO;
import dao.spec.IFaturaTelefonicaDAO;
import dao.spec.IItemFaturaTelefonicaDAO;
import dao.spec.INumeroTelefonicoDAO;
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

	public abstract IUsuarioDAO getUsuarioDAO() throws DAOException;

	public abstract IContaDAO getAccountDAO() throws DAOException;
        
        public abstract IEmprestimoDAO getEmprestimoDAO() throws DAOException;
        
        public abstract IFaturaTelefonicaDAO getFaturaTelefonicaDAO() throws DAOException;
        
        public abstract IItemFaturaTelefonicaDAO getItemFaturaTelefonicaDAO() throws DAOException;
        
        public abstract INumeroTelefonicoDAO getNumeroTelefonicoDAO() throws DAOException;
}