package dao.spec;

import java.util.List;

import dao.DAOException;
import vo.EmprestimoVO;
import vo.UsuarioVO;

public interface IEmprestimoUsuarioRelDAO extends IGenericDAO {
	/**
	 * Retorna a lista dos usuários credores do emprestimo.
	 * @throws DAOException 
	 */
	public List<UsuarioVO> getUsuarios(EmprestimoVO emprestimo) throws DAOException;
	
	/**
	 * Retorna a lista dos empréstimos na qual usuario é credor.
	 */
	public List<EmprestimoVO> getEmprestimos(UsuarioVO usuario) throws DAOException;
}
