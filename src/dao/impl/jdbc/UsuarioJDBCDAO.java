package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ObjectVO;
import vo.UserVO;
import dao.DAOException;
import dao.spec.IUsuarioDAO;

public class UsuarioJDBCDAO extends GenericJDBCDAO implements IUsuarioDAO {

    public UsuarioJDBCDAO(Properties properties) throws DAOException {
        super(properties);
    }

    public void update(ObjectVO vo) throws DAOException {
        UserVO user = (UserVO) vo;
        String sql = "UPDATE " + this.getTableName()
                + " SET LOGIN = ?, PASSWORD = ?, NOME = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            stmt.setInt(4, user.getId());
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void insert(ObjectVO vo) throws DAOException {
        String sql = "INSERT INTO " + this.getTableName()
                + " (LOGIN, PASSWORD, NOME) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            UserVO user = (UserVO) vo;
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public boolean checkLoginPassword(String login, String password)
            throws DAOException {
        boolean isAuthenticated = false;
        String sql = "SELECT PASSWORD FROM " + this.getTableName()
                + " WHERE LOGIN = '" + login + "'";
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String result = rs.getString("PASSWORD");
                isAuthenticated = result.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
        return isAuthenticated;
    }

    public String getTableName() {
        return "USUARIO";
    }

    protected ObjectVO createVO(ResultSet rs) throws DAOException {
        try {
            int id = rs.getInt("ID");
            String login = rs.getString("LOGIN");
            String password = rs.getString("PASSWORD");
            String nome = rs.getString("NOME");
            return new UserVO(id, login, password, nome);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public final UserVO selectByLogin(String login) throws DAOException {
        ObjectVO vo = null;
        String sql = "SELECT * FROM " + this.getTableName() + " WHERE LOGIN = '"
                + login + "'";
        try {
            Statement stmt = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                vo = this.createVO(rs);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return (UserVO) vo;
    }
}
