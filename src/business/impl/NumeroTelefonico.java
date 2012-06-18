package business.impl;

import dao.DAOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.NumeroTelefonicoVO;
import business.BusinessException;
import business.spec.INumeroTelefonico;
import dao.DAOFactory;
import dao.spec.INumeroTelefonicoDAO;
import dao.spec.IUsuarioNumeroTelefonicoDAO;
import java.util.List;
import vo.UsuarioNumeroTelefonicoVO;

/**
 * @author Nelson
 */
public class NumeroTelefonico implements INumeroTelefonico {

	public void create(NumeroTelefonicoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void delete(String numero) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			NumeroTelefonicoVO numeroTelefonico = getNumeroTelefonico(numero);
			dao.delete(numeroTelefonico);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(NumeroTelefonicoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			dao.update(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

        public void addLigacao(UsuarioNumeroTelefonicoVO ligacao) throws BusinessException {
            DAOFactory factory = DAOFactory.getInstance();
            try {
                IUsuarioNumeroTelefonicoDAO dao = factory.getUsuarioNumeroTelefonicoDAO();
                dao.insert(ligacao);
            } catch (DAOException ex) {
                Logger.getLogger(NumeroTelefonico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
	public NumeroTelefonicoVO getNumeroTelefonico(String numero)
			throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			return (NumeroTelefonicoVO) dao.selectByNumero(numero);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			INumeroTelefonicoDAO dao = factory.getNumeroTelefonicoDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

        public List getLigacoes(NumeroTelefonicoVO vo) throws BusinessException {
                DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioNumeroTelefonicoDAO dao = factory.getUsuarioNumeroTelefonicoDAO();
			return dao.getLigacoes(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
        }

        public List getLigacoesPorUsuario(String email) throws BusinessException {
                DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioNumeroTelefonicoDAO dao = factory.getUsuarioNumeroTelefonicoDAO();
			return dao.getLigacoesPorUsuario(email);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
        }

    public void deleteLigacaoAssociada(String numero, Calendar dataHora) throws BusinessException {
                DAOFactory factory = DAOFactory.getInstance();
		try {
			IUsuarioNumeroTelefonicoDAO dao = factory.getUsuarioNumeroTelefonicoDAO();
			UsuarioNumeroTelefonicoVO ligacao = dao.getLigacao(numero,dataHora);
			dao.delete(ligacao);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
    }

}
