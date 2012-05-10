package tests.dao;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import part3rd.AeSimpleMd5;

import util.Configuration;
import vo.UsuarioVO;

import dao.DAOException;
import dao.impl.jdbc.UsuarioJDBCDAO;
import dao.spec.IUsuarioDAO;

public class UsuarioJDBCDAOTest extends AbstractJDBCDAOTest {
	private IUsuarioDAO userDAO;
	
	protected void setupMainDAO() throws DAOException {
		objDAO = new UsuarioJDBCDAO(Configuration.getInstance().getProperties());
		userDAO = (IUsuarioDAO) objDAO;
	}
	
	@Test
	public void testCheckEmailSenhaOk() throws DAOException {
		String email = "zepitanga@gmail.com";
		String senha = "12345";
		
		boolean actual = userDAO.checkEmailSenha(email, senha);
		Assert.assertEquals(actual, true);
	}
	
	@Test
	public void testCheckEmailSenhaFails() throws DAOException {
		String email = "zepitanga@gmail.com";
		String senha = "1234";
		
		boolean actual = userDAO.checkEmailSenha(email, senha);
		Assert.assertEquals(actual, false);
	}
	
	@Test
	public void testInsert() throws Exception {
		String senha = "teste";
		
		UsuarioVO user = new UsuarioVO("teste@teste.com", senha, "Testonildo", 20);
		
		userDAO.insert(user);
		
		UsuarioVO inserted = userDAO.selectByEmail("teste@teste.com");
		user.setSenha(AeSimpleMd5.md5(senha));
		
		Assert.assertTrue(user.isEquals(inserted));
	}
	
	@Test
	public void testUpdateName() throws Exception {
		UsuarioVO oldData = userDAO.selectByEmail("nelsonguicg@gmail.com");
		UsuarioVO newData = new UsuarioVO(oldData.getEmail(), oldData.getSenha(), "Vaginildo", 30);
		UsuarioVO afterUpdate = null;
		
		userDAO.update(newData);
		afterUpdate = userDAO.selectByEmail(newData.getEmail());
		
		Assert.assertTrue(newData.isEquals(afterUpdate));
	}
	
	@Test
	public void testUpdatePassword() throws Exception {
		String senha = "1234";
		UsuarioVO oldData = userDAO.selectByEmail("nelsonguicg@gmail.com");
		UsuarioVO newData = new UsuarioVO(oldData.getEmail(), senha, oldData.getNome(), 20);
		UsuarioVO afterUpdate = null;
		
		userDAO.update(newData, true);
		afterUpdate = userDAO.selectByEmail(newData.getEmail());
		newData.setSenha(AeSimpleMd5.md5(senha));
		Assert.assertTrue(newData.isEquals(afterUpdate));
	}
	
	@Test
	public void testDeleteExpectedException() throws DAOException {
		String email = "nelsonguicg@gmail.com";
		UsuarioVO user = userDAO.selectByEmail(email);
		userDAO.delete(user);
		UsuarioVO isNull = userDAO.selectByEmail(email);
		Assert.assertNull(isNull);
	}
}
