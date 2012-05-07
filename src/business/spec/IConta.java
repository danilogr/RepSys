package business.spec;

import java.util.List;

import vo.ContaVO;
import business.BusinessException;

public interface IConta {

	void create(ContaVO vo) throws BusinessException;

	void update(ContaVO vo) throws BusinessException;
        
        void delete(String name) throws BusinessException;
        
        ContaVO getConta(String name) throws BusinessException;

	ContaVO getContaByUsuario(String email) throws BusinessException;

	List<Object> getAll() throws BusinessException;

}
