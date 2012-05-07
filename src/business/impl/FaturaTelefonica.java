package business.impl;

import vo.FaturaTelefonicaVO;
import business.BusinessException;
import business.spec.IFaturaTelefonica;
import dao.DAOFactory;
import dao.spec.IFaturaTelefonicaDAO;
import java.util.List;

/**
 * @author Nelson
 */
public class FaturaTelefonica implements IFaturaTelefonica {
    
        public void create(FaturaTelefonicaVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IFaturaTelefonicaDAO dao = factory.getFaturaTelefonicaDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
    
    	public void delete(int id) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IFaturaTelefonicaDAO dao = factory.getFaturaTelefonicaDAO();
			dao.delete(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

      	public void update(FaturaTelefonicaVO vo) throws BusinessException {
	DAOFactory factory = DAOFactory.getInstance();
	try {
		IFaturaTelefonicaDAO dao = factory.getFaturaTelefonicaDAO();
		dao.update(vo);
            } catch (Exception e) {
		throw new BusinessException(e);
            }
	}
        
       	public FaturaTelefonicaVO getFaturaTelefonica(int id) throws BusinessException {
	DAOFactory factory = DAOFactory.getInstance();
	try {
		IFaturaTelefonicaDAO dao = factory.getFaturaTelefonicaDAO();
		return (FaturaTelefonicaVO) dao.selectByID(id);
            } catch (Exception e) {
		throw new BusinessException(e);
            }
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IFaturaTelefonicaDAO dao = factory.getFaturaTelefonicaDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

    
    
}

