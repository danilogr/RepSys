package vo;

import java.text.SimpleDateFormat;
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
	
	@Override
	public boolean isEquals(ObjectVO vo) {
		EmprestimoVO emp = (EmprestimoVO) vo;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dtEmp = sdf.format(emp.getDataHora().getTime());
		String dtThis = sdf.format(this.getDataHora().getTime());
		return dtEmp.equals(dtThis)
			&& emp.getDescricao().equals(this.getDescricao())
			&& emp.getValor() == this.getValor(); 
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("dataHora = ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		buffer.append(sdf.format(this.getDataHora().getTime()));
		buffer.append(", valor = ");
		buffer.append(this.getValor());
		buffer.append(", descricao = ");
		buffer.append(this.getDescricao());
		buffer.append("]");
		return buffer.toString();
	}
}
