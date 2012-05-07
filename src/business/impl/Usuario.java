package business.impl;

import java.util.List;

import vo.UsuarioVO;
import business.BusinessException;
import business.spec.IUsuario;
import dao.DAOFactory;
import dao.spec.IUsuarioDAO;

public class Usuario implements IUsuario {

	public void delete(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			// TODO: alter the call of method delete do apdapt it to the new interface
			//dao.delete(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void create(UsuarioVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			dao.insert(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(UsuarioVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			dao.update(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public UsuarioVO getUsuario(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			// TODO: method selectByID not exists anymore
			//return (UsuarioVO) dao.selectByID(id);
                        return null;
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

	public UsuarioVO getUsuarioByLogin(String email) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUserDAO();
			return (UsuarioVO) dao.selectByEmail(email);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public boolean authenticate(UsuarioVO user) throws BusinessException {
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
