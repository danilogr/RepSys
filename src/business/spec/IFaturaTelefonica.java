package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.FaturaTelefonicaVO;
import business.BusinessException;

public interface IFaturaTelefonica {

	void create(FaturaTelefonicaVO vo) throws BusinessException;

	void delete(int mes, int ano) throws BusinessException;

	void update(FaturaTelefonicaVO vo) throws BusinessException;

	FaturaTelefonicaVO getFaturaTelefonica(int mes, int ano) throws BusinessException;

	List getAll() throws BusinessException;

}