package business.spec;

import java.util.Calendar;
import java.util.List;
import vo.EmprestimoVO;
import business.BusinessException;

/**
 * @author Nelson
 * @author Henrique (Alterações)
 */
public interface IEmprestimo {

	void create(EmprestimoVO vo) throws BusinessException;

	void delete(String name) throws BusinessException;

	void update(EmprestimoVO vo) throws BusinessException;

	EmprestimoVO getEmprestimo(Calendar date) throws BusinessException;

	List getAll() throws BusinessException;

}