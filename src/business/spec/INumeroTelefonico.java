package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.NumeroTelefonicoVO;
import business.BusinessException;

public interface INumeroTelefonico {

	void create(NumeroTelefonicoVO vo) throws BusinessException;

	void delete(String numero) throws BusinessException;

	void update(NumeroTelefonicoVO vo) throws BusinessException;

	NumeroTelefonicoVO getNumeroTelefonico(String numero) throws BusinessException;

	List getAll() throws BusinessException;

}
