package vo;

import java.util.Date;


public class EmprestimoVO extends ObjectVO {
	private Date dataHora;
	private double valor;
	private String descricao;
	
	public EmprestimoVO(Date datahora, double valor, String descricao) {
		setDataHora(datahora);
		setValor(valor);
		setDescricao(descricao);
	}
	
	public EmprestimoVO(Date datahora, double valor) {
		setDataHora(datahora);
		setValor(valor);
	}
	
	public Date getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(Date dataHora) {
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
