package dao.spec;

import java.util.List;

import dao.DAOException;

import vo.NumeroTelefonicoVO;
import vo.UsuarioVO;

public interface IUsuarioNumeroTelefonicoDAO extends IGenericDAO {
	public List<UsuarioVO> getUsuarios(NumeroTelefonicoVO num) throws DAOException;
	public List<NumeroTelefonicoVO> getNumeros(UsuarioVO user) throws DAOException;
}
