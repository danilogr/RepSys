/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.lib;

/**
 *   Esta interface é utilizada por todos o JPanels que desejam receber retorno 
 * de outro JPanel.
 * 
 * @author danilogr
 */
public interface ReturnEvent {
    public void onReturnFromOtherWindow(Object returnedObject);
}
