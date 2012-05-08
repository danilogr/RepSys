package business.impl;

import java.util.List;

import vo.UsuarioVO;
import business.BusinessException;
import business.spec.IUsuario;
import dao.DAOFactory;
import dao.spec.IUsuarioDAO;

public class Usuario implements IUsuario {

	public void delete(String email) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUsuarioDAO();
			UsuarioVO user = getUsuario(email);
			dao.delete(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void create(UsuarioVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUsuarioDAO();
			dao.insert(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(UsuarioVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUsuarioDAO();
			dao.update(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public UsuarioVO getUsuario(String email) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUsuarioDAO();
			return (UsuarioVO) dao.selectByEmail(email);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUsuarioDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public UsuarioVO getUsuarioByEmail(String email) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUsuarioDAO();
			return (UsuarioVO) dao.selectByEmail(email);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public boolean authenticate(UsuarioVO user) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioDAO dao = factory.getUsuarioDAO();
			return dao.checkEmailSenha(user.getEmail(), user.getSenha());
		} catch (Exception e) {
                    e.printStackTrace();
			throw new BusinessException(e);
		}
	}
}
