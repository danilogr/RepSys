package dao.impl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import vo.ObjectVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IGenericDAO;

public abstract class GenericJDBCDAO implements IGenericDAO {

	private Connection connection;

	public GenericJDBCDAO(Properties properties) throws DAOException {
		try {
			String driver = properties.getProperty("jdbc.driver");
			String url = properties.getProperty("jdbc.url");
			String user = properties.getProperty("jdbc.user");
			String password = properties.getProperty("jdbc.password");
			if (password == null) {
				password = "";
			}
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	protected Connection getConnection() {
		return connection;
	}

	public final List selectAll() throws DAOException, VOException {
		String sql = "SELECT * FROM " + this.getTableName();
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
	
	public final List selectAll(String order, String sort) throws DAOException, VOException {
		if(!(sort.equalsIgnoreCase("DESC") || sort.equalsIgnoreCase("ASC"))) {
			sort = "DESC";
		}
		
		String sql = "SELECT * FROM " + this.getTableName()
					+ " ORDER BY " + order + " " + sort;
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
	
	public final List selectAll(String order, String sort, int limit) throws DAOException, VOException {
		if(!(sort.equalsIgnoreCase("DESC") || sort.equalsIgnoreCase("ASC"))) {
			sort = "DESC";
		}
		
		String sql = "SELECT * FROM " + this.getTableName()
					+ " ORDER BY " + order + " " + sort
					+ " LIMIT " + limit;
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
	
	public final List selectAll(String order, String sort, int limit, int offset) throws DAOException, VOException {
		if(!(sort.equalsIgnoreCase("DESC") || sort.equalsIgnoreCase("ASC"))) {
			sort = "DESC";
		}
		
		String sql = "SELECT * FROM " + this.getTableName()
					+ " ORDER BY " + order + " " + sort
					+ " LIMIT " + limit + " OFFSET " + offset;
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

	protected abstract String getTableName();

	protected abstract ObjectVO createVO(ResultSet rs) throws DAOException, VOException;

}
