package vo;

import java.util.Calendar;

/**
 * @author Nelson
 */
public class ItemFaturaTelefonicaVO extends ObjectVO {
    
    private Calendar dataHora;

    private FaturaTelefonicaVO fatura;
    
    private NumeroTelefonicoVO numero;
    
    private int valor;
    
    private String duracao;

    
    public ItemFaturaTelefonicaVO(Calendar dataHora, FaturaTelefonicaVO fatura, NumeroTelefonicoVO numero,
            int valor, String duracao) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.numero = numero;
        this.valor = valor;
        this.fatura = fatura;
    }
    
    
    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public FaturaTelefonicaVO getFatura() {
        return fatura;
    }

    public void setFatura(FaturaTelefonicaVO fatura) {
        this.fatura = fatura;
    }

    public NumeroTelefonicoVO getNumero() {
        return numero;
    }

    public void setNumero(NumeroTelefonicoVO numero) {
        this.numero = numero;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
