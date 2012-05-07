package dao.spec;

import java.util.List;

import vo.ObjectVO;
import dao.DAOException;

public interface IGenericDAO {

	List selectAll() throws DAOException;

	void insert(ObjectVO vo) throws DAOException;

	void delete(ObjectVO vo) throws DAOException;

	void update(ObjectVO vo) throws DAOException;
}
