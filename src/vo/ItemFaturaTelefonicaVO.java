package vo;

import java.util.Date;

/**
 * @author Nelson
 */
public class ItemFaturaTelefonicaVO extends ObjectVO {
    
    private Date dataHora;

    private FaturaTelefonicaVO fatura;
    
    private NumeroTelefonicoVO numero;
    
    private int valor;
    
    private String duracao;

    public ItemFaturaTelefonicaVO(){
    }
    
    public ItemFaturaTelefonicaVO(Date dataHora, FaturaTelefonicaVO fatura, NumeroTelefonicoVO numero,
            int valor, String duracao) {
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.numero = numero;
        this.valor = valor;
        this.fatura = fatura;
    }
    
    
    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
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
