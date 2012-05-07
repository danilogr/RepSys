package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.EmprestimoVO;
import business.BusinessException;

public interface IEmprestimo {

	void create(EmprestimoVO vo) throws BusinessException;

	void delete(String name) throws BusinessException;

	void update(EmprestimoVO vo) throws BusinessException;

	EmprestimoVO getEmprestimo(String name) throws BusinessException;

	List getAll() throws BusinessException;

}