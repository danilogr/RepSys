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

	public final List selectAll() throws DAOException {
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

	protected abstract String getTableName();

	protected abstract ObjectVO createVO(ResultSet rs) throws DAOException;

}
