package vo;

public class ContaUsuarioDevedorVO extends ObjectVO {
	private UsuarioVO usuario;
	private ContaVO conta;
	private float proporcao;
	
	public ContaUsuarioDevedorVO(UsuarioVO usuario, ContaVO conta, float proporcao) {
		setUsuario(usuario);
		setConta(conta);
		setProporcao(proporcao);
	}
	
	public UsuarioVO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
	
	public ContaVO getConta() {
		return conta;
	}
	
	public void setConta(ContaVO conta) {
		this.conta = conta;
	}
	
	public float getProporcao() {
		return proporcao;
	}
	
	public void setProporcao(float proporcao) {
		this.proporcao = proporcao;
	}
}
