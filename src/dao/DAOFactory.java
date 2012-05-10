package dao;

import util.Configuration;
import dao.impl.jdbc.JDBCDAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IContaUsuarioDevedorDAO;
import dao.spec.IContaValorFixoDAO;
import dao.spec.IContaValorVariavelDAO;
import dao.spec.IEmprestimoDAO;
import dao.spec.IFaturaTelefonicaDAO;
import dao.spec.IItemFaturaTelefonicaDAO;
import dao.spec.INumeroTelefonicoDAO;
import dao.spec.IUsuarioDAO;
import dao.spec.IUsuarioNumeroTelefonicoDAO;

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

	public abstract IContaDAO getContaDAO() throws DAOException;
	
	public abstract IContaUsuarioDevedorDAO getContaUsuarioDevedorDAO() throws DAOException;
	
	public abstract IUsuarioNumeroTelefonicoDAO getUsuarioNumeroTelefoneDAO() throws DAOException;

	public abstract IContaValorFixoDAO getContaValorFixoDAO()
			throws DAOException;

	public abstract IContaValorVariavelDAO getContaValorVariavelDAO()
			throws DAOException;

	public abstract IEmprestimoDAO getEmprestimoDAO() throws DAOException;

	public abstract IFaturaTelefonicaDAO getFaturaTelefonicaDAO()
			throws DAOException;

	public abstract IItemFaturaTelefonicaDAO getItemFaturaTelefonicaDAO()
			throws DAOException;

	public abstract INumeroTelefonicoDAO getNumeroTelefonicoDAO()
			throws DAOException;
}