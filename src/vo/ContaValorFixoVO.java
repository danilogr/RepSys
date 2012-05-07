package vo;

import java.util.Calendar;

public class ContaValorFixoVO extends ContaVO {
	private Calendar dataInicial;
	private int tempoRecorrencia;
	private String periodoRecorrencia;

	public ContaValorFixoVO(String nome, Double valor,
			UsuarioVO usuarioResponsavel, String descricao, Calendar cal,
			int tempoRec, String periodoRec) throws VOException {
		super(nome, valor, usuarioResponsavel, descricao);
		setDataInicial(cal);
		setTempoRecorrencia(tempoRec);
		setPeriodoRecorrencia(periodoRec);
	}

	public ContaValorFixoVO(ContaVO conta, Calendar cal, int tempoRec,
			String periodoRec) throws VOException {
		super(conta.getNome(), conta.getValor(), conta.getUsuario(), conta.getDescricao());
		setDataInicial(cal);
		setTempoRecorrencia(tempoRec);
		setPeriodoRecorrencia(periodoRec);
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
		if (tempoRecorrencia <= 0) {
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

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("id = ");
		buffer.append(this.getNome());
		buffer.append(", nome = ");
		buffer.append(this.getNome());
		buffer.append(", valor = ");
		buffer.append(this.getValor());
		buffer.append(", usuarioResponsavel = ");
		buffer.append(this.getUsuario().getNome());
		buffer.append("]");
		return buffer.toString();
	}
}
