package business.impl;

import java.util.List;

import vo.ContaVO;
import business.BusinessException;
import business.spec.IConta;
import dao.DAOFactory;
import dao.spec.IContaDAO;

public class Conta implements IConta {

	public void create(ContaVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void delete(String name) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			ContaVO conta = getConta(name);
			dao.delete(conta);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(ContaVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			dao.update(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public ContaVO getConta(String name) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			return (ContaVO) dao.selectByName(name);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public ContaVO getContaByUsuario(String email) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			return dao.selectByUsuario(email);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List<Object> getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
