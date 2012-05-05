package dao.spec;

import vo.ContaVO;
import dao.DAOException;

public interface IContaDAO extends IGenericDAO {

	ContaVO selectByUsuario(int id) throws DAOException;

}
