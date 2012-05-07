package dao.spec;

import dao.DAOException;
import vo.EmprestimoVO;

/**
 * @author Nelson
 */
public interface IEmprestimoDAO extends IGenericDAO{
    
    EmprestimoVO selectByName(String emprestimo) throws DAOException;
    
}
