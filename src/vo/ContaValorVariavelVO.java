package vo;

import java.util.Calendar;

public class ContaValorVariavelVO extends ContaVO {
	private Calendar dataVencimento;

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
