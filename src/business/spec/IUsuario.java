package business.spec;

import java.util.List;

import vo.UsuarioVO;
import business.BusinessException;

public interface IUsuario {

	void delete(int id) throws BusinessException;

	void create(UsuarioVO user) throws BusinessException;

	void update(UsuarioVO user) throws BusinessException;

	UsuarioVO getUsuario(int id) throws BusinessException;

	List getAll() throws BusinessException;

	UsuarioVO getUsuarioByLogin(String login) throws BusinessException;

	boolean authenticate(UsuarioVO user) throws BusinessException;

}
