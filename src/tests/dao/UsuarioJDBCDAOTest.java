package tests.dao;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import part3rd.AeSimpleMd5;

import util.Configuration;
import vo.UsuarioVO;

import dao.DAOException;
import dao.impl.jdbc.UsuarioJDBCDAO;

public class UsuarioJDBCDAOTest extends AbstractJDBCDAOTest {
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
		
		UsuarioVO user = new UsuarioVO("teste@teste.com", senha, "Testonildo");
		
		objDAO.insert(user);
		
		UsuarioVO inserted = objDAO.selectByEmail("teste@teste.com");
		user.setSenha(AeSimpleMd5.md5(senha));
		
		Assert.assertTrue(user.equals(inserted));
	}
	
	@Test
	public void testUpdateName() throws Exception {
		UsuarioVO oldData = objDAO.selectByEmail("nelsonguicg@gmail.com");
		UsuarioVO newData = new UsuarioVO(oldData.getEmail(), oldData.getSenha(), "Vaginildo");
		UsuarioVO afterUpdate = null;
		
		objDAO.update(newData);
		afterUpdate = objDAO.selectByEmail(newData.getEmail());
		
		Assert.assertTrue(newData.equals(afterUpdate));
	}
	
	@Test
	public void testUpdatePassword() throws Exception {
		String senha = "1234";
		UsuarioVO oldData = objDAO.selectByEmail("nelsonguicg@gmail.com");
		UsuarioVO newData = new UsuarioVO(oldData.getEmail(), senha, oldData.getNome());
		UsuarioVO afterUpdate = null;
		
		objDAO.update(newData, true);
		afterUpdate = objDAO.selectByEmail(newData.getEmail());
		newData.setSenha(AeSimpleMd5.md5(senha));
		Assert.assertTrue(newData.equals(afterUpdate));
	}
	
	@Test
	public void testDeleteOk() throws DAOException {
		String email = "madalena@dominio.com";
		UsuarioVO user = objDAO.selectByEmail(email);
		objDAO.delete(user);
		UsuarioVO isNull = objDAO.selectByEmail(email);
		Assert.assertNull(isNull);
	}
	
	@Test(expected=DAOException.class)
	public void testDeleteExpectedException() throws DAOException {
		String email = "nelsonguicg@gmail.com";
		UsuarioVO user = objDAO.selectByEmail(email);
		objDAO.delete(user);
		UsuarioVO isNull = objDAO.selectByEmail(email);
		Assert.assertNull(isNull);
	}
}
