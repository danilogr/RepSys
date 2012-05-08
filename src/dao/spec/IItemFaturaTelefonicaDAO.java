/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.spec;

import dao.DAOException;
import java.util.Calendar;
import vo.ItemFaturaTelefonicaVO;

/**
 *
 * @author Nelson
 */
public interface IItemFaturaTelefonicaDAO extends IGenericDAO{
    
    ItemFaturaTelefonicaVO selectByMesAnoDataHora(int mes, int ano, Calendar dataHora) throws DAOException;
    
    
}
