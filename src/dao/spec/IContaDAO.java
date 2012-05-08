package dao.spec;

import java.util.List;

import vo.ContaVO;
import vo.VOException;
import dao.DAOException;

public interface IContaDAO extends IGenericDAO {

	public List selectByUsuario(String email) throws DAOException, VOException;

	public ContaVO selectByName(String conta) throws DAOException, VOException;

}
