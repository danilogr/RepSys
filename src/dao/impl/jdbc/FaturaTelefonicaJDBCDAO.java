package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import vo.EmprestimoVO;
import vo.FaturaTelefonicaVO;
import vo.ObjectVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IFaturaTelefonicaDAO;

public class FaturaTelefonicaJDBCDAO extends GenericJDBCDAO implements IFaturaTelefonicaDAO {

	public FaturaTelefonicaJDBCDAO(Properties properties) throws DAOException {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName() 
					+ " (MES, ANO, VENCIMENTO) VALUES(?, ?, ?)";
		
		FaturaTelefonicaVO fatura = (FaturaTelefonicaVO) vo;
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setInt(1, fatura.getMes());
			stmt.setInt(2, fatura.getAno());
			stmt.setDate(3, new Date(fatura.getVencimento().getTime().getTime()));
			
			stmt.executeUpdate();
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
					+ " WHERE MES = ? AND ANO = ?";
		FaturaTelefonicaVO fatura = (FaturaTelefonicaVO) vo;
		
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setInt(1, fatura.getMes());
			stmt.setInt(2, fatura.getAno());
			
			stmt.executeUpdate();
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		String sql = "UPDATE " + this.getTableName()
					+ " SET VENCIMENTO = ?";
		
		FaturaTelefonicaVO fatura = (FaturaTelefonicaVO) vo;
		
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setDate(3, new Date(fatura.getVencimento().getTime().getTime()));
			stmt.executeUpdate();
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "FATURATELEFONICA";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			int mes = rs.getInt("MES");
			int ano = rs.getInt("ANO");
			Calendar cal = new GregorianCalendar();
			cal.setTime(rs.getDate("VENCIMENTO"));
			
			return new FaturaTelefonicaVO(mes, ano, cal);
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public FaturaTelefonicaVO selectByMesAno(int mes, int ano)
			throws DAOException {
		String sql = "SELECT * FROM " + this.getTableName()
					+ " WHERE MES = ? AND ANO = ?";
		
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return (FaturaTelefonicaVO) createVO(rs);
			}
		} catch(Exception e) {
			throw new DAOException(e);
		}
		return null;
	}

}
