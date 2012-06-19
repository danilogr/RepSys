package dao.impl.jdbc;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import util.Configuration;
import vo.FaturaTelefonicaVO;
import vo.ItemFaturaTelefonicaVO;
import vo.NumeroTelefonicoVO;
import vo.ObjectVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IItemFaturaTelefonicaDAO;
import org.postgresql.util.PGInterval;

public class ItemFaturaTelefonicaJDBCDAO extends GenericJDBCDAO implements
		IItemFaturaTelefonicaDAO {

	public ItemFaturaTelefonicaJDBCDAO(Properties properties)
			throws DAOException {
		super(properties);
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
					+ " (NUMERO, DATA_HORA, DURACAO, VALOR, MES, ANO)" 
					+ " VALUES(?, ?, ?, ?, ?, ?)";
		
		ItemFaturaTelefonicaVO item = (ItemFaturaTelefonicaVO) vo;
		
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setString(1, item.getNumero().getNumero());
			stmt.setTimestamp(2, new Timestamp(item.getDataHora().getTime().getTime()));
			stmt.setObject(3, new PGInterval(item.getDuracao()));
			stmt.setDouble(4, item.getValor());
			stmt.setInt(5, item.getFatura().getMes());
			stmt.setInt(6, item.getFatura().getAno());
			
			stmt.executeUpdate();
                        this.commit();
                        this.close();
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
				+ " WHERE NUMERO = ? AND DATA_HORA = ?";
	
		ItemFaturaTelefonicaVO item = (ItemFaturaTelefonicaVO) vo;
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setString(1, item.getNumero().getNumero());
			stmt.setTimestamp(2, new Timestamp(item.getDataHora().getTime().getTime()));
			
			stmt.executeUpdate();
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		String sql = "UPDATE " + this.getTableName()
				+ " SET DURACAO = ?, VALOR = ?, MES = ?, ANO = ?" 
				+ " WHERE NUMERO = ? AND DATA_HORA = ?";
	
		ItemFaturaTelefonicaVO item = (ItemFaturaTelefonicaVO) vo;
		
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setString(1, item.getDuracao());
			stmt.setDouble(2, item.getValor());
			stmt.setInt(3, item.getFatura().getMes());
			stmt.setInt(4, item.getFatura().getAno());
			
			stmt.setString(5, item.getNumero().getNumero());
			stmt.setTimestamp(6, new Timestamp(item.getDataHora().getTime().getTime()));
			
			stmt.executeUpdate();
		} catch(Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public ItemFaturaTelefonicaVO selectByNumeroDataHora(String numero,
			Calendar dataHora) throws DAOException {
		String sql = "SELECT * FROM " + this.getTableName()
				+ " WHERE NUMERO = ? AND DATA_HORA = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setString(1, numero);
			stmt.setTimestamp(2, new Timestamp(dataHora.getTime().getTime()));
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return (ItemFaturaTelefonicaVO) createVO(rs);
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return null;
	}

	@Override
	protected String getTableName() {
		return "itemfaturatelefonica";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			String numero = rs.getString("NUMERO");
			Timestamp dataHora = rs.getTimestamp("DATA_HORA");
			Calendar cal = new GregorianCalendar();
			cal.setTime(dataHora);
			String duracao = rs.getString("DURACAO");
			double valor = rs.getDouble("VALOR");
			int mes = rs.getInt("MES");
			int ano = rs.getInt("ANO");
			
			NumeroTelefonicoJDBCDAO ntDAO = new NumeroTelefonicoJDBCDAO(Configuration.getInstance().getProperties());
			FaturaTelefonicaJDBCDAO ftDAO = new FaturaTelefonicaJDBCDAO(Configuration.getInstance().getProperties());
			
			NumeroTelefonicoVO numVO = ntDAO.selectByNumero(numero);
			FaturaTelefonicaVO fatVO = ftDAO.selectByMesAno(mes, ano);
			
			return new ItemFaturaTelefonicaVO(cal, fatVO, numVO, valor, duracao);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
