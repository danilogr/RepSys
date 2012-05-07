package dao.impl.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ContaVO;
import vo.ObjectVO;
import vo.UsuarioVO;
import vo.VOException;
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
				+ " SET VALOR = ?, EMAIL = ? WHERE NOME = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			ContaVO conta = (ContaVO) vo;
			stmt.setDouble(1, conta.getValor());
			stmt.setString(2, conta.getUsuario().getEmail());
			stmt.setString(3, conta.getNome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (NOME, VALOR, EMAIL) VALUES (?,?,?)";
		try {
			ContaVO conta = (ContaVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, conta.getNome());
			stmt.setDouble(2, conta.getValor());
			stmt.setString(3, conta.getUsuario().getEmail());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<ContaVO> selectByUsuario(String email) throws DAOException, VOException {
		List<ContaVO> list = new ArrayList<ContaVO>();
		String sql = "SELECT * FROM " + this.getTableName()
				+ " WHERE EMAIL = " + email;
		try {
			Statement stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				try {
					list.add((ContaVO) this.createVO(rs));
				} catch (Exception e) {
					throw new VOException(e);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}
	
	@Override
	public ContaVO selectByName(String nome) throws DAOException, VOException {
		ContaVO vo = null;
		String sql = "SELECT * FROM " + this.getTableName()
				+ " WHERE NOME = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				vo = (ContaVO) this.createVO(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return vo;
	}
	
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
					+ " WHERE NOME = ?";
		try {
			ContaVO conta = (ContaVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, conta.getNome());
			stmt.executeUpdate();
		} catch(Exception e){
			throw new DAOException(e);
		}
	}

	protected String getTableName() {
		return "CONTA";
	}

	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			String nome = rs.getString("NOME");
			float valor = rs.getFloat("VALOR");
			String userEmail = rs.getString("EMAIL");
			String desc = rs.getString("DESCRICAO");
			
			IUsuarioDAO userDAO = DAOFactory.getInstance().getUserDAO();
			UsuarioVO user = (UsuarioVO) userDAO.selectByEmail(userEmail);
			return new ContaVO(nome, new Double(valor), user, desc);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
