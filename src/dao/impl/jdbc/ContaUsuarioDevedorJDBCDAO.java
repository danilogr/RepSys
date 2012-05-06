package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import vo.ContaUsuarioDevedorVO;
import vo.ContaVO;
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
		String sql = "INSERT INTO " + this.getTableName()
				+ " (EMAIL, NOME, PROPORCAO) VALUES (?,?,?)";
		try {
			ContaUsuarioDevedorVO cud = (ContaUsuarioDevedorVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, cud.getUsuario().getEmail());
			stmt.setString(2, cud.getConta().getNome());
			stmt.setFloat(3, cud.getProporcao());
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		String sql = "UPDATE " + this.getTableName()
				   + " PROPORCAO = ? WHERE EMAIL = ? AND NOME = ?";
		try {
			ContaUsuarioDevedorVO cud = (ContaUsuarioDevedorVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setFloat(1, cud.getProporcao());
			stmt.setString(2, cud.getUsuario().getEmail());
			stmt.setString(3, cud.getConta().getNome());
		} catch (Exception e) {
			throw new DAOException(e);
		}
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

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
