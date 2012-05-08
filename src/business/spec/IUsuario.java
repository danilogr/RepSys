package business.spec;

import java.util.List;

import vo.UsuarioVO;
import business.BusinessException;

public interface IUsuario {

	void delete(String email) throws BusinessException;

	void create(UsuarioVO user) throws BusinessException;

	void update(UsuarioVO user) throws BusinessException;

	UsuarioVO getUsuario(String email) throws BusinessException;

	List getAll() throws BusinessException;

	UsuarioVO getUsuarioByEmail(String email) throws BusinessException;

	boolean authenticate(UsuarioVO user) throws BusinessException;

}
