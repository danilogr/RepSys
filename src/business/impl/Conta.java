package business.impl;

import java.util.List;

import vo.ContaVO;
import business.BusinessException;
import business.spec.IConta;
import dao.DAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IContaUsuarioDevedorDAO;
import dao.spec.IContaValorFixoDAO;
import dao.spec.IContaValorVariavelDAO;
import vo.ContaUsuarioDevedorVO;
import vo.ContaValorFixoVO;
import vo.ContaValorVariavelVO;

public class Conta implements IConta {

	public void create(ContaUsuarioDevedorVO vo, boolean first) throws BusinessException {
            ContaVO conta = vo.getConta();
 		
            DAOFactory factory = DAOFactory.getInstance();
            try {
                if(first){
                    if(conta instanceof ContaValorFixoVO){
                        IContaValorFixoDAO dao = factory.getContaValorFixoDAO();
                        dao.insert(conta);
                    }
                    if(conta instanceof ContaValorVariavelVO){
                        IContaValorVariavelDAO dao = factory.getContaValorVariavelDAO();
                        dao.insert(conta);
                    }
                }

                IContaUsuarioDevedorDAO dao = factory.getContaUsuarioDevedorDAO();
                dao.insert(vo);

            } catch (Exception e) {
                    throw new BusinessException(e);
            }
	}

	public void delete(String name) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getContaDAO();
			ContaVO conta = getConta(name);
			dao.delete(conta);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(ContaVO vo, List<String> emails) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getContaDAO();
			dao.update(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public ContaVO getConta(String name) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getContaDAO();
			return (ContaVO) dao.selectByNome(name);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List<Object> getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getContaDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<ContaVO> getContasByUsuario(String email)
			throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IContaDAO dao = factory.getContaDAO();
			return dao.selectByUsuario(email);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
