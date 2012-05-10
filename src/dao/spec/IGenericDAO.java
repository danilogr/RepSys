package dao.spec;

import java.sql.SQLException;
import java.util.List;

import vo.ObjectVO;
import vo.VOException;
import dao.DAOException;

public interface IGenericDAO {

	List<Object> selectAll() throws DAOException, VOException;

	void insert(ObjectVO vo) throws DAOException;

	void delete(ObjectVO vo) throws DAOException;

	void update(ObjectVO vo) throws DAOException;
	
	public void setAutoCommit(boolean opt) throws SQLException;
	
	public void commit() throws SQLException;
	
	public void rollback() throws SQLException;
}
