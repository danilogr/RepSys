package dao.spec;

import java.util.Calendar;

import dao.DAOException;
import vo.EmprestimoVO;

/**
 * @author Nelson
 */
public interface IEmprestimoDAO extends IGenericDAO{
    

	EmprestimoVO selectByData(Calendar date) throws DAOException;
    
}
