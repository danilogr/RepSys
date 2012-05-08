package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Properties;

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
		String sql = "UPDATE " + this.getTableName() + " SET";

	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FaturaTelefonicaVO selectByMesAno(int mes, int ano)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
