package dao.impl.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import vo.EmprestimoVO;
import vo.ObjectVO;
import dao.DAOException;
import dao.spec.IEmprestimoDAO;

public class EmprestimoJDBCDAO extends GenericJDBCDAO implements IEmprestimoDAO {

	public EmprestimoJDBCDAO(Properties properties) throws DAOException {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (DATA_HORA, VALOR, DESCRICAO) VALUES(?,?,?)";
		try {
			EmprestimoVO emprestimo = (EmprestimoVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			// Criando um objeto java.sql.Date a partir de um objeto
			// java.util.Calendar
			Date dt = new Date(emprestimo.getDataHora().getTime().getTime());
			stmt.setDate(1, dt);
			stmt.setDouble(2, emprestimo.getValor());
			stmt.setString(3, emprestimo.getDescricao());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		String sql = "UPDATE " + this.getTableName()
				+ " SET VALOR = ?, DESCRICAO = ? WHERE DATA_HORA = ?";
		try {
			EmprestimoVO emprestimo = (EmprestimoVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			stmt.setDouble(1, emprestimo.getValor());
			stmt.setString(2, emprestimo.getDescricao());

			// Criando um objeto java.sql.Date a partir de um objeto
			// java.util.Calendar
			Date dt = new Date(emprestimo.getDataHora().getTime().getTime());
			stmt.setDate(3, dt);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
				+ " WHERE DATA_HORA = ?";

		try {
			EmprestimoVO emprestimo = (EmprestimoVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			// Criando um objeto java.sql.Date a partir de um objeto
			// java.util.Calendar
			Date dt = new Date(emprestimo.getDataHora().getTime().getTime());
			stmt.setDate(1, dt);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "EMPRESTIMO";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException {
		try {
			Date dt = rs.getDate("DATA_HORA");
			double valor = rs.getDouble("VALOR");
			String desc = rs.getString("DESCRICAO");

			Calendar cal = new GregorianCalendar();
			cal.setTime(dt);

			return new EmprestimoVO(cal, valor, desc);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public EmprestimoVO selectByData(Calendar date) throws DAOException {
		String sql = "SELECT * FROM " + this.getTableName()
				+ " WHERE data_hora = ?";
		try {
			Date dt = new Date(date.getTime().getTime());
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			stmt.setDate(1, dt);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return (EmprestimoVO) createVO(rs);
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return null;
	}

}