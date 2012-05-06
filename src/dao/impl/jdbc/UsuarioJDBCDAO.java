package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ContaVO;
import vo.ObjectVO;
import vo.UsuarioVO;
import dao.DAOException;
import dao.spec.IUsuarioDAO;

public class UsuarioJDBCDAO extends GenericJDBCDAO implements IUsuarioDAO {

	public UsuarioJDBCDAO(Properties properties) throws DAOException {
		super(properties);
	}

	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (EMAIL, SENHA, NOME) VALUES (?,MD5(?),?)";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			UsuarioVO user = (UsuarioVO) vo;
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getSenha());
			stmt.setString(3, user.getNome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void update(ObjectVO vo) throws DAOException {

	}

	public void update(ObjectVO vo, boolean updatePassword) throws DAOException {
		UsuarioVO user = (UsuarioVO) vo;
		String sql = "UPDATE " + this.getTableName() 
				   + " SET NOME = ?, ";

		if (updatePassword) {
			sql += "SENHA = MD5(?)";
		}
		
		sql += " WHERE EMAIL = ?";
		
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, user.getNome());
			if(updatePassword) {
				stmt.setString(2, user.getSenha());
				stmt.setString(3, user.getEmail());
			} else {
				stmt.setString(2, user.getEmail());
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName() + "WHERE NOME = ?";
		try {
			ContaVO conta = (ContaVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, conta.getNome());
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	public boolean checkEmailSenha(String login, String password)
			throws DAOException {
		boolean isAuthenticated = false;
		String sql = "SELECT SENHA FROM " + this.getTableName()
				+ " WHERE EMAIL = '" + login + "'";
		try {
			Statement stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String result = rs.getString("SENHA");
				isAuthenticated = result.equals(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		return isAuthenticated;
	}

	public String getTableName() {
		return "USUARIO";
	}

	protected ObjectVO createVO(ResultSet rs) throws DAOException {
		try {
			String login = rs.getString("EMAIL");
			String password = rs.getString("SENHA");
			String nome = rs.getString("NOME");
			return new UsuarioVO(login, password, nome);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public final UsuarioVO selectByEmail(String login) throws DAOException {
		ObjectVO vo = null;
		String sql = "SELECT * FROM " + this.getTableName()
				+ " WHERE EMAIL = '" + login + "'";
		try {
			Statement stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				vo = this.createVO(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return (UsuarioVO) vo;
	}
}
