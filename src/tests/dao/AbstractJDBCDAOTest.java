package tests.dao;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;

import util.Configuration;
import dao.DAOException;
import dao.impl.jdbc.UsuarioJDBCDAO;

public abstract class AbstractJDBCDAOTest {
	protected UsuarioJDBCDAO objDAO;
	
	@Before
	public void setup() throws DAOException, SQLException {
		objDAO = new UsuarioJDBCDAO(Configuration.getInstance().getProperties());
		objDAO.setAutoCommit(false);
	}
	
	@After
	public void tearDown() throws SQLException {
		objDAO.rollback();
	}
}
