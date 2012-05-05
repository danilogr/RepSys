package business.spec;

import java.util.List;

import vo.UserVO;
import business.BusinessException;

public interface IUsuario {

	void delete(int id) throws BusinessException;

	void create(UserVO user) throws BusinessException;

	void update(UserVO user) throws BusinessException;

	UserVO getUsuario(int id) throws BusinessException;

	List getAll() throws BusinessException;

	UserVO getUsuarioByLogin(String login) throws BusinessException;

	boolean authenticate(UserVO user) throws BusinessException;

}
