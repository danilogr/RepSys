package dao.spec;

import java.util.List;

import vo.ContaValorFixoVO;
import vo.VOException;
import dao.DAOException;

public interface IContaValorFixoDAO extends IGenericDAO {
	
	public List selectByUsuario(String email) throws DAOException, VOException;
	public ContaValorFixoVO selectByNome(String nome) throws DAOException, VOException;
}
