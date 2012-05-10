package vo;

/**
 * @author Henrique Barcelos
 */
public class UsuarioVO extends ObjectVO {

	private String email;

	private String senha;

	private String nome;

	public UsuarioVO() {
	}

	public UsuarioVO(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public UsuarioVO(String email, String senha, String nome) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
        
        static public boolean verificaEmail(String email) {
            // TODO
            return true;
        }

    @Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("email = ");
		buffer.append(this.getEmail());
		buffer.append(", nome = ");
		buffer.append(this.getNome());
		buffer.append("]");
		return buffer.toString();
	}
}
