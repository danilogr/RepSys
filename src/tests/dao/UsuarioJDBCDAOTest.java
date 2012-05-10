package tests.dao;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import part3rd.AeSimpleMd5;

import util.Configuration;
import vo.UsuarioVO;

import dao.DAOException;
import dao.impl.jdbc.UsuarioJDBCDAO;

public class UsuarioJDBCDAOTest {
	private UsuarioJDBCDAO objDAO;
	
	public UsuarioJDBCDAOTest() throws DAOException, SQLException {
		setup();
	}
	
	@Before
	public void setup() throws DAOException, SQLException {
		objDAO = new UsuarioJDBCDAO(Configuration.getInstance().getProperties());
		objDAO.setAutoCommit(false);
	}
	
	@Test
	public void testCheckEmailSenhaOk() throws DAOException {
		String email = "zepitanga@gmail.com";
		String senha = "12345";
		
		boolean actual = objDAO.checkEmailSenha(email, senha);
		Assert.assertEquals(actual, true);
	}
	
	@Test
	public void testCheckEmailSenhaFails() throws DAOException {
		String email = "zepitanga@gmail.com";
		String senha = "1234";
		
		boolean actual = objDAO.checkEmailSenha(email, senha);
		Assert.assertEquals(actual, false);
	}
	
	@Test
	public void testInsert() throws Exception {
		String senha = "teste";
		
		UsuarioJDBCDAOTest t = new UsuarioJDBCDAOTest();
		UsuarioVO user = new UsuarioVO("teste@teste.com", senha, "Testonildo");
		
		t.objDAO.insert(user);
		
		UsuarioVO inserted = t.objDAO.selectByEmail("teste@teste.com");
		user.setSenha(AeSimpleMd5.md5(senha));
		
		Assert.assertTrue(user.equals(inserted));
	}
}
