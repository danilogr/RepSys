package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.FaturaTelefonicaVO;
import business.BusinessException;

public interface IFaturaTelefonica {

	void create(FaturaTelefonicaVO vo) throws BusinessException;

	void delete(int id) throws BusinessException;

	void update(FaturaTelefonicaVO vo) throws BusinessException;

	FaturaTelefonicaVO getFaturaTelefonica(int id) throws BusinessException;

	List getAll() throws BusinessException;

}