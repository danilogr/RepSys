package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import vo.NumeroTelefonicoVO;
import vo.ObjectVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.INumeroTelefonicoDAO;

public class NumeroTelefonicoJDBCDAO extends GenericJDBCDAO implements
		INumeroTelefonicoDAO {

	public NumeroTelefonicoJDBCDAO(Properties properties) throws DAOException {
		super(properties);
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (NUMERO) VALUES(?)";

		NumeroTelefonicoVO num = (NumeroTelefonicoVO) vo;

		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			stmt.setString(1, num.getNumero());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
				+ " WHERE NUMERO = ?";

		NumeroTelefonicoVO num = (NumeroTelefonicoVO) vo;

		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			stmt.setString(1, num.getNumero());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		throw new DAOException("Update não permitido em " + this.getTableName());
	}

	@Override
	public NumeroTelefonicoVO selectByNumero(String numero) throws DAOException {
		String sql = "SELECT * FROM " + this.getTableName()
					+ " WHERE numero = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, numero);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return (NumeroTelefonicoVO) this.createVO(rs);
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return null;
	}

	@Override
	protected String getTableName() {
		return "NUMEROTELEFONICO";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			String numero = rs.getString("NUMERO");
			return new NumeroTelefonicoVO(numero);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
