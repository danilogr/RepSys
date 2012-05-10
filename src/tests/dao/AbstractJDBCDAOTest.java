package tests.dao;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;

import util.Configuration;
import dao.DAOException;
import dao.impl.jdbc.ContaJDBCDAO;
import dao.impl.jdbc.UsuarioJDBCDAO;
import dao.spec.IGenericDAO;

public abstract class AbstractJDBCDAOTest {
	protected IGenericDAO objDAO;
	
	protected abstract void setupMainDAO() throws DAOException;
	
	@Before
	public void setup() throws DAOException, SQLException {
		setupMainDAO();
		objDAO.setAutoCommit(false);
	}
	
	@After
	public void tearDown() throws SQLException {
		objDAO.rollback();
	}
}
