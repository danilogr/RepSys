package business.impl;

import java.util.List;

import vo.UserVO;
import business.BusinessException;
import business.spec.IUsuario;
import dao.DAOFactory;
import dao.spec.IUsuarioDAO;

public class Usuario implements IUsuario {

	public void delete(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			dao.delete(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void create(UserVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			dao.insert(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(UserVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			dao.update(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public UserVO getUsuario(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			return (UserVO) dao.selectByID(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public UserVO getUsuarioByLogin(String email) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			return (UserVO) dao.selectByEmail(email);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public boolean authenticate(UserVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			return dao.checkEmailSenha(user.getEmail(), user.getSenha());
		} catch (Exception e) {
                    e.printStackTrace();
			throw new BusinessException(e);
		}
	}
}
