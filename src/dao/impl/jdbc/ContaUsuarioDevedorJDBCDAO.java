package dao.impl.jdbc;

import java.sql.ResultSet;
import java.util.Properties;

import vo.ObjectVO;
import dao.DAOException;

public class ContaUsuarioDevedorJDBCDAO extends GenericJDBCDAO {

	public ContaUsuarioDevedorJDBCDAO(Properties properties)
			throws DAOException {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
