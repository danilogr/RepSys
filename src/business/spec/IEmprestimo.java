package business.spec;

import java.util.Calendar;
import java.util.List;
import vo.EmprestimoVO;
import business.BusinessException;
import vo.EmprestimoUsuarioRelVO;

/**
 * @author Nelson
 * @author Henrique (Alterações)
 */
public interface IEmprestimo {

	void create(EmprestimoVO vo) throws BusinessException;

	void delete(EmprestimoVO vo) throws BusinessException;

	void update(EmprestimoVO vo) throws BusinessException;

	EmprestimoVO getEmprestimo(Calendar date) throws BusinessException;

	List getAll() throws BusinessException;
        
        List getAllWithUsers() throws BusinessException;
        
        public void createDevedores(List<EmprestimoUsuarioRelVO> vo) throws BusinessException;
        public void createCredor(EmprestimoUsuarioRelVO vo) throws BusinessException;

}