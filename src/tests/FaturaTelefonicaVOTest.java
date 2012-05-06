package tests;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import vo.FaturaTelefonicaVO;
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
}
