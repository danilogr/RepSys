/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.lib;

/**
 *
 * @author Daniel
 */
public interface Consultavel {
    public enum Mode  {
        NORMAL, SELECIONAVEL, EDITAVEL
    }
    
    public Mode getMode();
    public void setMode(Mode newMode);
    
}
