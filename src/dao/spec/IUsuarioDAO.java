package dao.spec;

import vo.UserVO;
import dao.DAOException;

public interface IUsuarioDAO extends IGenericDAO {

	boolean checkEmailSenha(String email, String senha)
			throws DAOException;

	UserVO selectByEmail(String email) throws DAOException;
}
