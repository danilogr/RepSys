/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.spec;

import dao.DAOException;
import vo.ItemFaturaTelefonicaVO;

/**
 *
 * @author Nelson
 */
public interface IItemFaturaTelefonicaDAO extends IGenericDAO{
    
    ItemFaturaTelefonicaVO selectByName(String itemFatura) throws DAOException;
    
    
}
