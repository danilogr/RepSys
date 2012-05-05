package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ContaVO;
import vo.ObjectVO;
import vo.UserVO;
import dao.DAOException;
import dao.DAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IUsuarioDAO;

class ContaJDBCDAO extends GenericJDBCDAO implements IContaDAO {

	public ContaJDBCDAO(Properties properties) throws DAOException {
		super(properties);
	}

	public void update(ObjectVO vo) throws DAOException {
		String sql = "UPDATE " + this.getTableName()
				+ " SET NUMERO = ?, SALDO = ?, USUARIO_ID = ? WHERE ID = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			ContaVO account = (ContaVO) vo;
			stmt.setString(1, account.getNumero());
			stmt.setDouble(2, account.getSaldo());
			stmt.setInt(3, account.getUsuario().getId());
			stmt.setInt(4, account.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (NUMERO, SALDO, USUARIO_ID) VALUES (?,?,?)";
		try {
			ContaVO account = (ContaVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, account.getNumero());
			stmt.setDouble(2, account.getSaldo());
			stmt.setInt(3, account.getUsuario().getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public ContaVO selectByUsuario(int id) throws DAOException {
		ContaVO vo = null;
		String sql = "SELECT * FROM " + this.getTableName()
				+ " WHERE USUARIO_ID = " + id;
		try {
			Statement stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				vo = (ContaVO) this.createVO(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return vo;
	}

	public String getTableName() {
		return "CONTA";
	}

	protected ObjectVO createVO(ResultSet rs) throws DAOException {
		try {
			int id = rs.getInt("ID");
			String number = rs.getString("NUMERO");
			float balance = rs.getFloat("SALDO");
			int userID = rs.getInt("USUARIO_ID");
			IUsuarioDAO userDAO = DAOFactory.getInstance().getUserDAO();
			UserVO user = (UserVO) userDAO.selectByID(userID);
			return new ContaVO(id, number, new Double(balance), user);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
