package dao.impl.jdbc;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import util.Configuration;
import vo.ContaVO;
import vo.ContaValorVariavelVO;
import vo.ObjectVO;
import vo.UsuarioVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IContaValorVariavelDAO;

public class ContaValorVariavelJDBCDAO extends ContaJDBCDAO implements
		IContaValorVariavelDAO {

	public ContaValorVariavelJDBCDAO(Properties properties) throws DAOException {
		super(properties);
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		super.insert(vo);
		String sql = "INSERT INTO " + this.getTableName()
				+ " (NOME, DATA_DE_VENCIMENTO)" + " VALUES (?, ?)";
		try {
			ContaValorVariavelVO cvf = (ContaValorVariavelVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			stmt.setString(1, cvf.getNome());
			stmt.setTimestamp(2, new Timestamp(cvf.getDataVencimento().getTime()
					.getTime()));

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		super.update(vo);
		String sql = "UPDATE " + this.getTableName() + " SET"
				+ " DATA_DE_VENCIMENTO = ? WHERE NOME = ?";
		try {
			ContaValorVariavelVO cvf = (ContaValorVariavelVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setTimestamp(1, new Timestamp(cvf.getDataVencimento().getTime()
					.getTime()));
			stmt.setString(2, cvf.getNome());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName() + " WHERE NOME = ?";
		try {
			ContaVO conta = (ContaVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, conta.getNome());
			stmt.executeUpdate();
			super.delete(vo);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "VALORVARIAVEL";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			ContaVO conta = (ContaVO) super.createVO(rs);

			Calendar dataVenc = new GregorianCalendar();
			dataVenc.setTime(rs.getTimestamp("DATA_DE_VENCIMENTO"));

			return new ContaValorVariavelVO(conta, dataVenc);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List selectByUsuario(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaValorVariavelVO selectByNome(String nome) throws DAOException,
			VOException {
		ContaValorVariavelVO vo = null;
		String sql = "SELECT * FROM " + this.getTableName()
				+ " AS CVF INNER JOIN " + super.getTableName() + " AS C"
				+ " ON CVF.NOME = C.NOME WHERE C.NOME = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				vo = (ContaValorVariavelVO) this.createVO(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return vo;
	}

	public static void main(String[] argv) throws DAOException, VOException {
		ContaValorVariavelJDBCDAO cvfDAO = new ContaValorVariavelJDBCDAO(
				Configuration.getInstance().getProperties());
		UsuarioJDBCDAO uDAO = new UsuarioJDBCDAO(Configuration.getInstance()
				.getProperties());
		UsuarioVO user = uDAO.selectByEmail("endril.caps@gmail.com");
		Calendar cal = new GregorianCalendar();
		cal.set(2013, 02, 11);
		ContaValorVariavelVO vo = new ContaValorVariavelVO("Luz-02/2013",
				124.18d, user,
				"Conta referente ao consumo de luz do mes de fevereiro", cal);
		cvfDAO.insert(vo);
//		ContaValorVariavelVO vo = cvfDAO.selectByName("Luz-02/2013");
//		cvfDAO.delete(vo);
	}

}
