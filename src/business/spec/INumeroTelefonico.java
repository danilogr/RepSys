package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.NumeroTelefonicoVO;
import business.BusinessException;

public interface INumeroTelefonico {

	void create(NumeroTelefonicoVO vo) throws BusinessException;

	void delete(int id) throws BusinessException;

	void update(NumeroTelefonicoVO vo) throws BusinessException;

	NumeroTelefonicoVO getNumeroTelefonico(int id) throws BusinessException;

	List getAll() throws BusinessException;

}
