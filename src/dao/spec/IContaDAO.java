package dao.spec;

import vo.ContaVO;
import dao.DAOException;

public interface IContaDAO extends IGenericDAO {

	ContaVO selectByUsuario(String email) throws DAOException;

	ContaVO selectByName(String conta) throws DAOException;

}
