package business.spec;

import java.util.List;

import vo.ContaVO;
import business.BusinessException;

public interface IConta {

	public void create(ContaVO vo, List<String> emails) throws BusinessException;

	public void update(ContaVO vo, List<String> emails) throws BusinessException;
        
	public void delete(String name) throws BusinessException;
        
	public ContaVO getConta(String name) throws BusinessException;

	public List<ContaVO> getContasByUsuario(String email) throws BusinessException;

	public List<Object> getAll() throws BusinessException;

}
