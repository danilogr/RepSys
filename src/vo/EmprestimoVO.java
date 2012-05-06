package vo;

import java.util.Calendar;


public class EmprestimoVO extends ObjectVO {
	private Calendar dataHora;
	private double valor;
	private String descricao;
	
	public EmprestimoVO(Calendar datahora, double valor, String descricao) {
                super();
		this.setDataHora(datahora);
		this.setValor(valor);
		this.setDescricao(descricao);
	}
	
	public EmprestimoVO(Calendar datahora, double valor) {
                super();
		this.setDataHora(datahora);
		this.setValor(valor);
	}
	
	public Calendar getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
