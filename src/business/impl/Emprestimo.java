package business.impl;

import vo.EmprestimoVO;
import business.BusinessException;
import business.spec.IEmprestimo;
import dao.DAOFactory;
import dao.spec.IEmprestimoDAO;
import java.util.List;

/**
 * @author Nelson
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
    
    	public void delete(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			dao.delete(id);
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
        
       	public EmprestimoVO getEmprestimo(int id) throws BusinessException {
	DAOFactory factory = DAOFactory.getInstance();
	try {
		IEmprestimoDAO dao = factory.getEmprestimoDAO();
		return (EmprestimoVO) dao.selectByID(id);
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

