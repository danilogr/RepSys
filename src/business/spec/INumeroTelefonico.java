package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.NumeroTelefonicoVO;
import business.BusinessException;

public interface INumeroTelefonico {

	void create(NumeroTelefonicoVO vo) throws BusinessException;

	void delete(String name) throws BusinessException;

	void update(NumeroTelefonicoVO vo) throws BusinessException;

	NumeroTelefonicoVO getNumeroTelefonico(String name) throws BusinessException;

	List getAll() throws BusinessException;

}
