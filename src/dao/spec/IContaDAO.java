package dao.spec;

import java.util.List;

import vo.ContaVO;
import dao.DAOException;

public interface IContaDAO extends IGenericDAO {

	public List selectByUsuario(String email) throws DAOException;

	public ContaVO selectByName(String conta) throws DAOException;

}
