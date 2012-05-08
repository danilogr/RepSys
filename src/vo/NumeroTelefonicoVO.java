package vo;

/**
 * @author Nelson
 */
public class NumeroTelefonicoVO extends ObjectVO {
    
    private String numero;
    
    public NumeroTelefonicoVO(String numero){
        super();
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
