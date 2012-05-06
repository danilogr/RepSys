package vo;

/**
 * @author Henrique Barcelos
 */
public class ContaVO extends ObjectVO {

	private String nome;
	
	private Double valor;

	private UserVO usuarioResponsavel;
	
	private String descricao;

	public ContaVO() {
		super();
	}

	public ContaVO(String nome, Double valor, UserVO usuarioResponsavel, String descricao) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.usuarioResponsavel = usuarioResponsavel;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return this.valor;
	}

	public void setSaldo(Double valor) {
		this.valor = valor;
	}

	public UserVO getUsuario() {
		return this.usuarioResponsavel;
	}

	public void setUsuario(UserVO usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

        @Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("id = ");
		buffer.append(this.getNome());
		buffer.append(", nome = ");
		buffer.append(this.getNome());
		buffer.append(", valor = ");
		buffer.append(this.getSaldo());
		buffer.append(", usuarioResponsavel = ");
		buffer.append(this.getUsuario().getNome());
		buffer.append("]");
		return buffer.toString();
	}
}
