package tests.dao;

import junit.framework.Assert;

import org.junit.Test;

import util.Configuration;
import vo.NumeroTelefonicoVO;
import dao.DAOException;
import dao.impl.jdbc.NumeroTelefonicoJDBCDAO;
import dao.spec.INumeroTelefonicoDAO;

public class NumeroTelefonicoJDBCDAOTest extends AbstractJDBCDAOTest {
	private INumeroTelefonicoDAO ntDAO;
	
	@Override
	protected void setupMainDAO() throws DAOException {
		objDAO = new NumeroTelefonicoJDBCDAO(Configuration.getInstance().getProperties());
		ntDAO = (INumeroTelefonicoDAO) objDAO;
	}
	
	@Test
	public void testInsert() throws Exception {
		NumeroTelefonicoVO emp = new NumeroTelefonicoVO("999999999999");
		
		ntDAO.insert(emp);
		
		NumeroTelefonicoVO inserted = ntDAO.selectByNumero("999999999999");
		Assert.assertTrue(emp.isEquals(inserted));
	}
	
	@Test(expected=DAOException.class)
	public void testUpdate() throws Exception {
		NumeroTelefonicoVO emp = new NumeroTelefonicoVO("999999999999");
		emp.setNumero("000000000000");
		ntDAO.update(emp);
	}
	
	@Test
	public void testDelete() throws Exception {
		NumeroTelefonicoVO oldNum = ntDAO.selectByNumero("5534159898");
		ntDAO.delete(oldNum);
		NumeroTelefonicoVO newNum = ntDAO.selectByNumero("5534159898");
		
		Assert.assertNull(newNum);
	}
}
