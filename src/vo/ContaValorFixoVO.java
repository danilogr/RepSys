package vo;

import java.util.Calendar;

public class ContaValorFixoVO extends ContaVO {
	private ContaVO conta;
	private Calendar dataInicial;
	private int tempoRecorrencia;
	private String periodoRecorrencia;
	
	public ContaVO getConta() {
		return conta;
	}
	
	public void setConta(ContaVO conta) {
		this.conta = conta;
	}
	
	public Calendar getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Calendar dataInicial) {
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
