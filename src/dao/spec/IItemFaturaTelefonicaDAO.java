/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.spec;

import dao.DAOException;
import java.util.Calendar;
import java.util.List;
import vo.ItemFaturaTelefonicaVO;

/**
 *
 * @author Nelson
 */
public interface IItemFaturaTelefonicaDAO extends IGenericDAO{
    
    ItemFaturaTelefonicaVO selectByNumeroDataHora(String numero, Calendar dataHora) throws DAOException;

    public List selectByMesAno(int mes, int ano) throws DAOException;
    
    
    
}
