package dao.spec;

import java.util.List;

import vo.ObjectVO;
import vo.VOException;
import dao.DAOException;

public interface IGenericDAO {

	List<Object> selectAll() throws DAOException, VOException;

	void insert(ObjectVO vo) throws DAOException;

	void delete(ObjectVO vo) throws DAOException;

	void update(ObjectVO vo) throws DAOException;
}
