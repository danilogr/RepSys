package business.impl;

import vo.EmprestimoVO;
import business.BusinessException;
import business.spec.IEmprestimo;
import dao.DAOFactory;
import dao.spec.IEmprestimoDAO;

import dao.spec.IEmprestimoUsuarioRelDAO;
import java.util.Calendar;
import java.util.List;
import vo.EmprestimoUsuarioRelVO;

/**
 * @author Nelson
 * @author Henrique (Alterações)
 */
public class Emprestimo implements IEmprestimo {

	public void create(EmprestimoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
        
        public void createCredor(EmprestimoUsuarioRelVO vo) throws BusinessException
        {
                DAOFactory factory = DAOFactory.getInstance();
                try {
			IEmprestimoUsuarioRelDAO dao = factory.getEmprestimoUsuarioCredorDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
        }

        
        public void createDevedores(List<EmprestimoUsuarioRelVO> vo) throws BusinessException
        {
                DAOFactory factory = DAOFactory.getInstance();
                try {
			IEmprestimoUsuarioRelDAO dao = factory.getEmprestimoUsuarioDevedorDAO();
                        for(EmprestimoUsuarioRelVO a:vo)
                        {
                            dao.insert(a);
                        }
			
		} catch (Exception e) {
			throw new BusinessException(e);
		}
        }

        
        
	public void delete(Calendar date) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			EmprestimoVO emprestimo = getEmprestimo(date);
			dao.delete(emprestimo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(EmprestimoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			dao.update(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public EmprestimoVO getEmprestimo(Calendar date) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			return (EmprestimoVO) dao.selectByData(date);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
}
