package vo;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Henrique Barcelos
 */
public class ContaVO extends ObjectVO {

	protected String nome;

	protected Double valor;

	protected UsuarioVO usuarioResponsavel;

	protected String descricao;

	protected List<UsuarioVO> devedores;

	public ContaVO() {
		super();
		devedores = (List<UsuarioVO>) new ArrayList<UsuarioVO>();
	}

	public ContaVO(String nome, Double valor, UsuarioVO usuarioResponsavel,
			String descricao) {
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

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public UsuarioVO getUsuario() {
		return this.usuarioResponsavel;
	}

	public void setUsuario(UsuarioVO usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<UsuarioVO> getDevedores() {
		return devedores;
	}

	public void setDevedores(List<UsuarioVO> devedores) {
		this.devedores = devedores;
	}
	
	public void addDevedor(UsuarioVO user) {
		this.devedores.add(user);
	}
	
	public void removeDevedor(UsuarioVO user) {
		this.devedores.remove(user);
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
		buffer.append(this.getValor());
		buffer.append(", desc = ");
		buffer.append(this.getDescricao());
		buffer.append(", usuarioResponsavel = ");
		buffer.append(this.getUsuario().toString());
		buffer.append("]");
		return buffer.toString();
	}
}
