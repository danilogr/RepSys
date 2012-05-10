package tests.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContaJDBCDAOTest.class, EmprestimoJDBCDAOTest.class,
		NumeroTelefonicoJDBCDAOTest.class, UsuarioJDBCDAOTest.class })
public class AllTests {

}
