/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Calendar;

/**
 *
 * @author Endril
 */

public class UsuarioNumeroTelefonicoVO extends ObjectVO {
    
    private UsuarioVO usuario;
    private NumeroTelefonicoVO numero;
    private Calendar dataHora;
    private int recorrencia;

 
    public UsuarioNumeroTelefonicoVO(UsuarioVO usuario, NumeroTelefonicoVO numero, Calendar dataHora, int recorrencia) {
        this.usuario = usuario;
        this.numero = numero;
        this.dataHora = dataHora;
        this.recorrencia = recorrencia;
    }    
    
    public int getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(int recorrencia) {
        this.recorrencia = recorrencia;
    }


    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public NumeroTelefonicoVO getNumero() {
        return numero;
    }

    public void setNumero(NumeroTelefonicoVO numero) {
        this.numero = numero;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }
    
    
    
}
