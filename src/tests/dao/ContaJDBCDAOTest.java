package tests.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import dao.DAOException;
import dao.impl.jdbc.ContaJDBCDAO;
import dao.impl.jdbc.UsuarioJDBCDAO;
import dao.spec.IContaDAO;
import dao.spec.IUsuarioDAO;
import junit.framework.Assert;
import part3rd.AeSimpleMd5;
import util.Configuration;
import vo.ContaVO;
import vo.UsuarioVO;

public class ContaJDBCDAOTest extends AbstractJDBCDAOTest {
	private IUsuarioDAO uDAO;
	private IContaDAO cDAO;
	
	@Override
	protected void setupMainDAO() throws DAOException {
		objDAO = new ContaJDBCDAO(Configuration.getInstance().getProperties());
		cDAO = (IContaDAO) objDAO;
	}
	
	@Before
	public void setupUser() throws DAOException {
		 uDAO = new UsuarioJDBCDAO(Configuration.getInstance().getProperties());
	}
	
	@Test
	public void testInsert() throws Exception {
		UsuarioVO usuarioResponsavel = uDAO.selectByEmail("danilod100@gmail.com");
		ContaVO conta = new ContaVO("Aluguel__04/12", 1400d, usuarioResponsavel, "Teste");
		
		cDAO.insert(conta);
		
		ContaVO inserted = cDAO.selectByNome("Aluguel__04/12");
		System.out.println(conta);
		System.out.println(inserted);
		System.out.println(conta.equals(inserted));
	}
}
