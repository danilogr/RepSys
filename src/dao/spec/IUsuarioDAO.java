package dao.spec;

import vo.UsuarioVO;
import dao.DAOException;

public interface IUsuarioDAO extends IGenericDAO {

	boolean checkEmailSenha(String email, String senha)
			throws DAOException;

	UsuarioVO selectByEmail(String email) throws DAOException;
}
