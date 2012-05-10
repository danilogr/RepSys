package business.spec;

import java.util.List;
import vo.ItemFaturaTelefonicaVO;
import business.BusinessException;
import java.util.Calendar;

/**
 * @author Nelson
 */

public interface IItemFaturaTelefonica {

	void create(ItemFaturaTelefonicaVO vo) throws BusinessException;

	void delete(String numero, Calendar dataHora) throws BusinessException;

	void update(ItemFaturaTelefonicaVO vo) throws BusinessException;

	ItemFaturaTelefonicaVO getItemFaturaTelefonica(String numero, Calendar dataHora) throws BusinessException;

	List getAll() throws BusinessException;

    
}
