package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.FaturaTelefonicaVO;
import business.BusinessException;

public interface IFaturaTelefonica {

	void create(FaturaTelefonicaVO vo) throws BusinessException;

	void delete(String name) throws BusinessException;

	void update(FaturaTelefonicaVO vo) throws BusinessException;

	FaturaTelefonicaVO getFaturaTelefonica(String name) throws BusinessException;

	List getAll() throws BusinessException;

}