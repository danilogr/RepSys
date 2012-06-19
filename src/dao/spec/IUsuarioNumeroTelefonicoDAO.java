package dao.spec;

import java.util.Calendar;
import java.util.List;

import dao.DAOException;

import vo.NumeroTelefonicoVO;
import vo.UsuarioNumeroTelefonicoVO;
import vo.UsuarioVO;

public interface IUsuarioNumeroTelefonicoDAO extends IGenericDAO {
	public List<UsuarioVO> getUsuarios(NumeroTelefonicoVO num) throws DAOException;
	public List<NumeroTelefonicoVO> getNumeros(UsuarioVO user) throws DAOException;
        public List<UsuarioNumeroTelefonicoVO> getLigacoes(NumeroTelefonicoVO num) throws DAOException;
        public List<UsuarioNumeroTelefonicoVO> getLigacoesPorUsuario(String email) throws DAOException;

        public UsuarioNumeroTelefonicoVO getLigacao(String numero, Calendar dataHora) throws DAOException;
}
