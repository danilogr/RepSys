package dao.impl.jdbc;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import util.Configuration;
import vo.EmprestimoUsuarioRelVO;
import vo.EmprestimoVO;
import vo.ObjectVO;
import vo.UsuarioVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IEmprestimoUsuarioRelDAO;

public class EmprestimoUsuarioDevedorDAO extends EmprestimoUsuarioRelJDBCDAO {

	public EmprestimoUsuarioDevedorDAO(Properties properties)
			throws DAOException {
		super(properties);
	}

	@Override
	protected String getTableName() {
		return "EMPRESTIMO_USUARIO_DEVEDOR";
	}

}
