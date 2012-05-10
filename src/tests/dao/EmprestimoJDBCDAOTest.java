package tests.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

import part3rd.AeSimpleMd5;

import util.Configuration;
import vo.EmprestimoVO;
import vo.UsuarioVO;
import dao.DAOException;
import dao.impl.jdbc.EmprestimoJDBCDAO;
import dao.impl.jdbc.UsuarioJDBCDAO;
import dao.spec.IEmprestimoDAO;
import dao.spec.IUsuarioDAO;

public class EmprestimoJDBCDAOTest extends AbstractJDBCDAOTest {
	private IEmprestimoDAO eDAO;
	
	@Override
	protected void setupMainDAO() throws DAOException {
		objDAO = new EmprestimoJDBCDAO(Configuration.getInstance().getProperties());
		eDAO = (IEmprestimoDAO) objDAO;
	}
	
	@Test
	public void testInsert() throws Exception {
		Calendar dt = new GregorianCalendar();
		dt.set(Calendar.YEAR, 2012);
		dt.set(Calendar.MONTH, 3);
		dt.set(Calendar.DAY_OF_MONTH, 10);
		dt.set(Calendar.HOUR_OF_DAY, 3);
		dt.set(Calendar.MINUTE, 37);
		dt.set(Calendar.SECOND, 10);
		
		EmprestimoVO emp = new EmprestimoVO(dt, 30d, "Teste");
		
		eDAO.insert(emp);
		
		EmprestimoVO inserted = eDAO.selectByData(dt);
		Assert.assertTrue(emp.isEquals(inserted));
	}
	
	@Test(expected=DAOException.class)
	public void testUpdate() throws Exception {
		Calendar dt = new GregorianCalendar();
		dt.set(Calendar.YEAR, 2012);
		dt.set(Calendar.MONTH, 1);
		dt.set(Calendar.DAY_OF_MONTH, 15);
		dt.set(Calendar.HOUR_OF_DAY, 12);
		dt.set(Calendar.MINUTE, 23);
		dt.set(Calendar.SECOND, 0);
		
		EmprestimoVO before = eDAO.selectByData(dt);
		EmprestimoVO updt = new EmprestimoVO(before.getDataHora(), 30d, before.getDescricao());
		
		eDAO.update(updt);
		EmprestimoVO after = eDAO.selectByData(dt);
		
		Assert.assertTrue(updt.isEquals(after));
	}
	
	@Test
	public void testDelete() throws Exception {
		Calendar dt = new GregorianCalendar();
		dt.set(Calendar.YEAR, 2012);
		dt.set(Calendar.MONTH, 1);
		dt.set(Calendar.DAY_OF_MONTH, 15);
		dt.set(Calendar.HOUR_OF_DAY, 12);
		dt.set(Calendar.MINUTE, 23);
		dt.set(Calendar.SECOND, 0);
		
		EmprestimoVO before = eDAO.selectByData(dt);
		eDAO.delete(before);
		EmprestimoVO after = eDAO.selectByData(dt);
		
		Assert.assertNull(after);
	}
}
