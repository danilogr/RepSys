package tests.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import vo.FaturaTelefonicaVO;
import vo.VOException;
import static org.junit.Assert.assertEquals;

public class FaturaTelefonicaVOTest {
	private FaturaTelefonicaVO obj;
	
	@Before
	public void setUp() {
		obj = new FaturaTelefonicaVO(new GregorianCalendar(2012, 5, 1), new GregorianCalendar(2012, 5, 30));
	}
	
	@Test
	public void testSetAndGetWithCalendar() {
		int year = obj.getAno();
		int mon = obj.getMes();
		
		assertEquals(year, 2012);
		assertEquals(mon, 5);
	}
	
	@Test
	public void testGet() {
		Assert.assertEquals(obj.getMes(), 5);
		Assert.assertEquals(obj.getAno(), 2012);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String actual = df.format(obj.getVencimento().getTime());
		Assert.assertEquals(actual, "30/06/2012");
	}
	
	@Test
	public void testSet() throws VOException {
		obj.setMes(7);
		Assert.assertEquals(obj.getMes(), 7);
		
		obj.setAno(2013);
		Assert.assertEquals(obj.getAno(), 2013);
		
		obj.setVencimento(new GregorianCalendar());
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String actual = df.format(obj.getVencimento().getTime());
		Assert.assertEquals(actual, "10/05/2012");
	}
	
	@Test
	public void testSetInvalidMonth() {
		obj.setMes(13);
		Assert.assertEquals(obj.getMes(), 4);
	}
	
	@Test
	public void testSetInvalidYear() throws VOException {
		obj.setAno(-1);
		Assert.assertEquals(obj.getAno(), 2012);
	}
}
