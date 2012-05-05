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
			vo.setId(dao.selectLastID() + 1);
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void delete(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			dao.delete(id);
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

	public ContaVO getConta(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			return (ContaVO) dao.selectByID(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public ContaVO getContaByUsuario(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			return dao.selectByUsuario(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getAccountDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
