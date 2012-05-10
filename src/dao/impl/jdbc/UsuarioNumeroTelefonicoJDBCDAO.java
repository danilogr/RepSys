package dao.impl.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import util.Configuration;
import vo.NumeroTelefonicoVO;
import vo.ObjectVO;
import vo.UsuarioNumeroTelefonicoVO;
import vo.UsuarioVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IUsuarioNumeroTelefonicoDAO;

public class UsuarioNumeroTelefonicoJDBCDAO extends GenericJDBCDAO implements
		IUsuarioNumeroTelefonicoDAO {

	public UsuarioNumeroTelefonicoJDBCDAO(Properties properties)
			throws DAOException {
		super(properties);
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (EMAIL, NUMERO, DATA_HORA, RECORRENCIA)"
				+ " VALUES (?, ?, ?, ?)";
		UsuarioNumeroTelefonicoVO unt = (UsuarioNumeroTelefonicoVO) vo;

		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			stmt.setString(1, unt.getUsuario().getEmail());
			stmt.setString(2, unt.getNumero().getNumero());
			stmt.setDate(3, new Date(unt.getDataHora().getTime().getTime()));
			stmt.setInt(4, unt.getRecorrencia());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
					+ " WHERE EMAIL = ? AND NUMERO = ? ";
		UsuarioNumeroTelefonicoVO unt = (UsuarioNumeroTelefonicoVO) vo;
		
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			stmt.setString(1, unt.getUsuario().getEmail());
			stmt.setString(2, unt.getNumero().getNumero());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		String sql = "UPDATE " + this.getTableName()
				+ " SET DATA_HORA = ?, RECORRENCIA = ?"
				+ " WHERE EMAIL = ? AND NUMERO = ? ";
		UsuarioNumeroTelefonicoVO unt = (UsuarioNumeroTelefonicoVO) vo;

		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			stmt.setDate(1, new Date(unt.getDataHora().getTime().getTime()));
			stmt.setInt(2, unt.getRecorrencia());
			stmt.setString(3, unt.getUsuario().getEmail());
			stmt.setString(4, unt.getNumero().getNumero());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "USUARIO_NUMEROTELEFONICO";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			String email = rs.getString("EMAIL");
			String numero = rs.getString("NUMERO");
			Date dataHora = rs.getDate("DATA_HORA");
			Calendar cal = new GregorianCalendar();
			cal.setTime(dataHora);
			int recorrencia = rs.getInt("RECORRENCIA");
			
			UsuarioJDBCDAO uDAO = new UsuarioJDBCDAO(Configuration.getInstance().getProperties());
			NumeroTelefonicoJDBCDAO ntDAO = new NumeroTelefonicoJDBCDAO(Configuration.getInstance().getProperties());
			
			UsuarioVO user = uDAO.selectByEmail(email);
			NumeroTelefonicoVO num = ntDAO.selectByNumero(numero);
			
			return new UsuarioNumeroTelefonicoVO(user, num, cal, recorrencia);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<UsuarioVO> getUsuarios(NumeroTelefonicoVO num) throws DAOException {
		List<UsuarioVO> list = new ArrayList<UsuarioVO>();
		String sql = "SELECT EMAIL FROM " + this.getTableName()
					+ " WHERE NUMERO = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, num.getNumero());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add((UsuarioVO) createVO(rs));
			}
			return list;
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<NumeroTelefonicoVO> getNumeros(UsuarioVO user) throws DAOException {
		List<NumeroTelefonicoVO> list = new ArrayList<NumeroTelefonicoVO>();
		String sql = "SELECT NUMERO FROM " + this.getTableName()
					+ " WHERE EMAIL = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add((NumeroTelefonicoVO) createVO(rs));
			}
			return list;
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

}
