package vo;

import java.util.Date;

public class ContaValorFixoVO extends ContaVO {
	private ContaVO conta;
	private Date dataInicial;
	private int tempoRecorrencia;
	private String periodoRecorrencia;
	
	public ContaVO getConta() {
		return conta;
	}
	
	public void setConta(ContaVO conta) {
		this.conta = conta;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public int getTempoRecorrencia() {
		return tempoRecorrencia;
	}
	
	public void setTempoRecorrencia(int tempoRecorrencia) throws VOException {
		if(tempoRecorrencia <= 0) {
			throw new VOException("O tempo de recorrência deve ser maior que 0");
		}
		this.tempoRecorrencia = tempoRecorrencia;
	}
	
	public String getPeriodoRecorrencia() {
		return periodoRecorrencia;
	}
	
	public void setPeriodoRecorrencia(String periodoRecorrencia) {
		this.periodoRecorrencia = periodoRecorrencia;
	}
}
