package dao.spec;

import vo.UserVO;
import dao.DAOException;

public interface IUsuarioDAO extends IGenericDAO {

	boolean checkLoginPassword(String login, String password)
			throws DAOException;

	UserVO selectByLogin(String login) throws DAOException;
}
