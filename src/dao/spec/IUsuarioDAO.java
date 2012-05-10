package dao.spec;

import vo.ObjectVO;
import vo.UsuarioVO;
import dao.DAOException;

public interface IUsuarioDAO extends IGenericDAO {

	boolean checkEmailSenha(String email, String senha)
			throws DAOException;

	UsuarioVO selectByEmail(String email) throws DAOException;
	
	void update(ObjectVO vo, boolean b) throws DAOException;
}
