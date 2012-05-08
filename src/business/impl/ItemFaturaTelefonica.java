package business.impl;

import vo.ItemFaturaTelefonicaVO;
import business.BusinessException;
import business.spec.IItemFaturaTelefonica;
import dao.DAOFactory;
import dao.spec.IItemFaturaTelefonicaDAO;
import java.util.Calendar;
import java.util.List;

/**
 * @author Nelson
 */


public class ItemFaturaTelefonica implements IItemFaturaTelefonica{

        public void create(ItemFaturaTelefonicaVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IItemFaturaTelefonicaDAO dao = factory.getItemFaturaTelefonicaDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
    
    	public void delete(int mes, int ano, Calendar dataHora) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IItemFaturaTelefonicaDAO dao = factory.getItemFaturaTelefonicaDAO();
			ItemFaturaTelefonicaVO itemFatura = getItemFaturaTelefonica(mes, ano, dataHora);
			dao.delete(itemFatura);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

      	public void update(ItemFaturaTelefonicaVO vo) throws BusinessException {
	DAOFactory factory = DAOFactory.getInstance();
	try {
		IItemFaturaTelefonicaDAO dao = factory.getItemFaturaTelefonicaDAO();
		dao.update(vo);
            } catch (Exception e) {
		throw new BusinessException(e);
            }
	}
        
       	public ItemFaturaTelefonicaVO getItemFaturaTelefonica(int mes, int ano, Calendar dataHora) throws BusinessException {
	DAOFactory factory = DAOFactory.getInstance();
	try {
		IItemFaturaTelefonicaDAO dao = factory.getItemFaturaTelefonicaDAO();
		return (ItemFaturaTelefonicaVO) dao.selectByMesAnoDataHora(mes,ano,dataHora);
            } catch (Exception e) {
		throw new BusinessException(e);
            }
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IItemFaturaTelefonicaDAO dao = factory.getItemFaturaTelefonicaDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	} 
    
}
