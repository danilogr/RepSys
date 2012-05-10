package dao.impl.jdbc;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import util.Configuration;
import vo.ContaVO;
import vo.ContaValorFixoVO;
import vo.EmprestimoVO;
import vo.ObjectVO;
import vo.UsuarioVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IContaDAO;
import dao.spec.IContaValorFixoDAO;

public class ContaValorFixoJDBCDAO extends ContaJDBCDAO implements IContaValorFixoDAO {

	public ContaValorFixoJDBCDAO(Properties properties) throws DAOException {
		super(properties);
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		super.insert(vo);
		String sql = "INSERT INTO " + this.getTableName()
					+ " (NOME, DATA_INICIAL, TEMPO_RECORRENCIA, PERIODO_RECORRENCIA)"
					+ " VALUES (?, ?, ?, ?)";
		try {
			ContaValorFixoVO cvf = (ContaValorFixoVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setString(1, cvf.getNome());
			stmt.setTimestamp(2, new Timestamp(cvf.getDataInicial().getTime().getTime()));
			stmt.setInt(3, cvf.getTempoRecorrencia());
			stmt.setString(4, cvf.getPeriodoRecorrencia());
			
			stmt.executeUpdate();
		} catch(Exception e){
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		super.update(vo);
		String sql  = "UPDATE " + this.getTableName() + " SET"
					+ " DATA_INICIAL = ?, TEMPO_RECORRENCIA = ?, PERIODO_RECORRENCIA = ?" 
					+ " WHERE NOME = ?";
		try {
			ContaValorFixoVO cvf = (ContaValorFixoVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setTimestamp(1, new Timestamp(cvf.getDataInicial().getTime().getTime()));
			stmt.setInt(2, cvf.getTempoRecorrencia());
			stmt.setString(3, cvf.getPeriodoRecorrencia());
			stmt.setString(4, cvf.getNome());
			
			stmt.executeUpdate();
		} catch(Exception e){
			throw new DAOException(e);
		}
	}
	
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
					+ " WHERE NOME = ?";
		try {
			ContaVO conta = (ContaVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, conta.getNome());
			stmt.executeUpdate();
			super.delete(vo);
		} catch(Exception e){
			throw new DAOException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "VALORFIXO";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			ContaVO conta = (ContaVO) super.createVO(rs);
			
			Calendar cal = new GregorianCalendar();
			cal.setTime(rs.getTimestamp("DATA_INICIAL"));
			int tempoRec = rs.getInt("TEMPO_RECORRENCIA");
			String periodoRec = rs.getString("PERIODO_RECORRENCIA");

			return new ContaValorFixoVO(conta, cal, tempoRec, periodoRec);
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
	public ContaValorFixoVO selectByNome(String nome) throws DAOException, VOException {
		ContaValorFixoVO vo = null;
		String sql = "SELECT * FROM " + this.getTableName()
				+ " AS CVF INNER JOIN " + super.getTableName() + " AS C"
				+ " ON CVF.NOME = C.NOME WHERE C.NOME = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				vo = (ContaValorFixoVO) this.createVO(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return vo;
	}
	
	public static void main(String[] argv) throws DAOException, VOException {
		ContaValorFixoJDBCDAO cvfDAO = new ContaValorFixoJDBCDAO(Configuration.getInstance().getProperties());
		ContaValorFixoVO vo = cvfDAO.selectByNome("Aluguel");
		System.out.println(vo.toString());
	}

}
