package business.impl;

import vo.NumeroTelefonicoVO;
import business.BusinessException;
import business.spec.INumeroTelefonico;
import dao.DAOFactory;
import dao.spec.INumeroTelefonicoDAO;
import java.util.List;

/**
 * @author Nelson
 */
public class NumeroTelefonico implements INumeroTelefonico {
    
        public void create(NumeroTelefonicoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
    
    	public void delete(int numero) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			NumeroTelefonicoVO numeroTelefonico = getNumeroTelefonico(numero);
			dao.delete(numeroTelefonico);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

      	public void update(NumeroTelefonicoVO vo) throws BusinessException {
	DAOFactory factory = DAOFactory.getInstance();
	try {
		INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
		dao.update(vo);
            } catch (Exception e) {
		throw new BusinessException(e);
            }
	}
        
       	public NumeroTelefonicoVO getNumeroTelefonico(int numero) throws BusinessException {
	DAOFactory factory = DAOFactory.getInstance();
	try {
		INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
		return (NumeroTelefonicoVO) dao.selectByNumero(numero);
            } catch (Exception e) {
		throw new BusinessException(e);
            }
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

    
    
}
