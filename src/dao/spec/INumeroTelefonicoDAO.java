/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.spec;

import dao.DAOException;
import vo.NumeroTelefonicoVO;

/**
 *
 * @author Nelson
 */
public interface INumeroTelefonicoDAO extends IGenericDAO{
    
    NumeroTelefonicoVO selectByNumero(int numero) throws DAOException;
    
    
}
