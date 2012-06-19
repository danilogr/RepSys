package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import vo.EmprestimoVO;
import vo.ObjectVO;
import dao.DAOException;
import dao.spec.IEmprestimoDAO;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import vo.VOException;

public class EmprestimoJDBCDAO extends GenericJDBCDAO implements IEmprestimoDAO {

	public EmprestimoJDBCDAO(Properties properties) throws DAOException {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (DATA_HORA, VALOR, DESCRICAO) VALUES(TO_TIMESTAMP(?, 'DD/MM/YYYY HH24:MI:SS'),?,?)";
		try {
			EmprestimoVO emprestimo = (EmprestimoVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String date = df.format(emprestimo.getDataHora().getTime());

			stmt.setString(1, date);
			stmt.setDouble(2, emprestimo.getValor());
			stmt.setString(3, emprestimo.getDescricao());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		throw new DAOException(
				"Não é permitido atualizar empréstimos. Apague este e crie um novo!");
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
				+ " WHERE DATA_HORA = TO_TIMESTAMP(?, 'DD/MM/YYYY HH24:MI:SS')";

		try {
			EmprestimoVO emprestimo = (EmprestimoVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String date = df.format(emprestimo.getDataHora().getTime());

			stmt.setString(1, date);

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
			Timestamp dt = rs.getTimestamp("DATA_HORA");
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
				+ " WHERE data_hora = TO_TIMESTAMP(?, 'DD/MM/YYYY HH24:MI:SS')";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dt = df.format(date.getTime());
			
			
			stmt.setString(1, dt);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return (EmprestimoVO) createVO(rs);
			}
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return null;
	}
        
    @Override
    public final List selectAll() throws DAOException, VOException {
		String sql = "SELECT * FROM " + this.getTableName()+" ORDER BY data_hora DESC";
		List<ObjectVO> list = new ArrayList<ObjectVO>();
		try {
			Statement stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(this.createVO(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}

}