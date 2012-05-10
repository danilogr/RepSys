package tests.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import dao.DAOException;
import junit.framework.Assert;
import part3rd.AeSimpleMd5;
import vo.ContaVO;
import vo.UsuarioVO;

public class ContaJDBCDAOTest extends AbstractJDBCDAOTest {
	public void testInsert() throws Exception {
		ContaVO user = new ContaVO("Aluguel__04/12", 1400d, usuarioResponsavel, descricao);
		
		objDAO.insert(user);
		
		UsuarioVO inserted = objDAO.selectByEmail("teste@teste.com");
		user.setSenha(AeSimpleMd5.md5(senha));
		
		Assert.assertTrue(user.equals(inserted));
	}
}
