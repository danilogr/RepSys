package business.spec;

/**
 * @author Nelson
 */
import java.util.List;
import vo.NumeroTelefonicoVO;
import business.BusinessException;
import java.util.Calendar;
import vo.UsuarioNumeroTelefonicoVO;

public interface INumeroTelefonico {

	void create(NumeroTelefonicoVO vo) throws BusinessException;

	void delete(String numero) throws BusinessException;
	
        void deleteLigacaoAssociada(String numero, Calendar dataHora) throws BusinessException;

	void update(NumeroTelefonicoVO vo) throws BusinessException;
        
        void addLigacao(UsuarioNumeroTelefonicoVO ligacao) throws BusinessException;

	NumeroTelefonicoVO getNumeroTelefonico(String numero) throws BusinessException;
        
        List getLigacoes(NumeroTelefonicoVO vo) throws BusinessException;
        
        List getLigacoesPorUsuario(String email) throws BusinessException;

        List getAll() throws BusinessException;

}
