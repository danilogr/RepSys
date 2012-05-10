package dao.spec;

import java.util.List;

import vo.ContaValorVariavelVO;
import vo.VOException;
import dao.DAOException;

public interface IContaValorVariavelDAO extends IGenericDAO {
	
	public List selectByUsuario(String email) throws DAOException, VOException;
	public ContaValorVariavelVO selectByNome(String nome) throws DAOException, VOException;
}
