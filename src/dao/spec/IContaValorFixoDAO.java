package dao.spec;

import vo.ContaValorFixoVO;
import dao.DAOException;

public interface IContaValorFixoDAO extends IGenericDAO {
	public ContaValorFixoVO selectByName(String conta) throws DAOException;
}
