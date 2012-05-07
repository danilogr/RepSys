package dao.spec;

import dao.DAOException;
import vo.FaturaTelefonicaVO;

/**
 * @author Nelson
 */
public interface IFaturaTelefonicaDAO extends IGenericDAO{
    
    FaturaTelefonicaVO selectByName(String fatura) throws DAOException;

    
}
