package business.impl;

import vo.EmprestimoVO;
import business.BusinessException;
import business.spec.IEmprestimo;
import dao.DAOFactory;
import dao.spec.IEmprestimoDAO;

import dao.spec.IEmprestimoUsuarioRelDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import vo.EmprestimoUsuarioRelVO;
import vo.UsuarioVO;

/**
 * @author Nelson
 * @author Henrique (Alterações)
 */
public class Emprestimo implements IEmprestimo {

	public void create(EmprestimoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
        
        public void createCredor(EmprestimoUsuarioRelVO vo) throws BusinessException
        {
                DAOFactory factory = DAOFactory.getInstance();
                try {
			IEmprestimoUsuarioRelDAO dao = factory.getEmprestimoUsuarioCredorDAO();
			dao.insert(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
        }

        
        public void createDevedores(List<EmprestimoUsuarioRelVO> vo) throws BusinessException
        {
                DAOFactory factory = DAOFactory.getInstance();
                try {
			IEmprestimoUsuarioRelDAO dao = factory.getEmprestimoUsuarioDevedorDAO();
                        for(EmprestimoUsuarioRelVO a:vo)
                        {
                            dao.insert(a);
                        }
			
		} catch (Exception e) {
			throw new BusinessException(e);
		}
        }

        
        
	public void delete(EmprestimoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
	//		EmprestimoVO emprestimo = getEmprestimo(date);
			dao.delete(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public void update(EmprestimoVO vo) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			dao.update(vo);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public EmprestimoVO getEmprestimo(Calendar date) throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			return (EmprestimoVO) dao.selectByData(date);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	public List getAll() throws BusinessException {
		DAOFactory factory = DAOFactory.getInstance();
		try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			return dao.selectAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

        public List getAllWithUsers() throws BusinessException {
                DAOFactory factory = DAOFactory.getInstance();
                try {
			IEmprestimoDAO dao = factory.getEmprestimoDAO();
			List eList = dao.selectAll();
                        LinkedList returnableList = new LinkedList();
                        for (Object o:eList){
                            if(o instanceof EmprestimoVO){
                                EmprestimoVO emp = (EmprestimoVO) o;
                                List<UsuarioVO> usuariosCredores;
                                List<UsuarioVO> usuariosDevedores;
                                usuariosCredores = factory.getEmprestimoUsuarioCredorDAO().getUsuarios(emp);
                                usuariosDevedores = factory.getEmprestimoUsuarioDevedorDAO().getUsuarios(emp);
                                for (UsuarioVO uc : usuariosCredores){
                                    for (UsuarioVO ud: usuariosDevedores){
                                        ArrayList temp = new ArrayList();
                                        temp.add(emp);
                                        temp.add(uc);
                                        temp.add(ud);
                                        returnableList.add(temp);
                                    }
                                }
                            }
                        }
                        return returnableList;
		} catch (Exception e) {
			throw new BusinessException(e);
		}
        }
}
