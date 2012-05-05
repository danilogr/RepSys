package business.spec;

import java.util.List;

import vo.ContaVO;
import business.BusinessException;

public interface IConta {

	void create(ContaVO vo) throws BusinessException;

	void delete(int id) throws BusinessException;

	void update(ContaVO vo) throws BusinessException;

	ContaVO getConta(int id) throws BusinessException;

	ContaVO getContaByUsuario(int id) throws BusinessException;

	List getAll() throws BusinessException;

}
