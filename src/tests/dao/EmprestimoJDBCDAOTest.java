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
		dt.set(Calendar.MONTH, 5);
		dt.set(Calendar.DAY_OF_MONTH, 10);
		dt.set(Calendar.HOUR_OF_DAY, 3);
		dt.set(Calendar.MINUTE, 37);
		dt.set(Calendar.SECOND, 10);
		
		EmprestimoVO emp = new EmprestimoVO(dt, 30d, "Teste");
		
		eDAO.insert(emp);
		
		EmprestimoVO inserted = eDAO.selectByData(dt);
		Assert.assertTrue(emp.isEquals(inserted));
	}
}
