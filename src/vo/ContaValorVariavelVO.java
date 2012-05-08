package vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ContaValorVariavelVO extends ContaVO {
	private Calendar dataVencimento;

	public ContaValorVariavelVO(String nome, double valor,
			UsuarioVO usuarioResponsavel, String descricao,
			Calendar dataVencimento) throws VOException {
		super(nome, valor, usuarioResponsavel, descricao);
		setDataVencimento(dataVencimento);
	}

	public ContaValorVariavelVO(ContaVO conta, Calendar dataVencimento) {
		super(conta.getNome(), conta.getValor(), conta.getUsuario(), conta
				.getDescricao());
		setDataVencimento(dataVencimento);
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
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
		buffer.append(", dataVencimento = ");
		buffer.append(new SimpleDateFormat("dd/MM/yyyy")
				.format(getDataVencimento().getTime()));
		buffer.append("]");
		return buffer.toString();
	}
}
