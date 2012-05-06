/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;

/**
 *
 * @author Endril
 */

public class UsuarioNumeroTelefonicoVO extends ObjectVO {
    
    private UsuarioVO usuario;
    private NumeroTelefonicoVO numero;
    private Date dataHora;

    public UsuarioNumeroTelefonicoVO(UsuarioVO usuario, NumeroTelefonicoVO numero, Date dataHora) {
        this.usuario = usuario;
        this.numero = numero;
        this.dataHora = dataHora;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
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
