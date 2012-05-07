package business.spec;

import java.util.List;
import vo.ItemFaturaTelefonicaVO;
import business.BusinessException;

/**
 * @author Nelson
 */

public interface IItemFaturaTelefonica {

	void create(ItemFaturaTelefonicaVO vo) throws BusinessException;

	void delete(String name) throws BusinessException;

	void update(ItemFaturaTelefonicaVO vo) throws BusinessException;

	ItemFaturaTelefonicaVO getItemFaturaTelefonica(String name) throws BusinessException;

	List getAll() throws BusinessException;

    
}
