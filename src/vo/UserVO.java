package vo;

public class UserVO extends ObjectVO {

	private String email;

	private String senha;

	private String nome;

	public UserVO() {
	}

	public UserVO(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public UserVO(String email, String senha, String nome) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}

	public UserVO(int id, String email, String senha, String nome) {
		super(id);
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

	public void setName(String nome) {
		this.nome = nome;
	}

    @Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("id = ");
		buffer.append(this.getId());
		buffer.append(", nome = ");
		buffer.append(this.getNome());
		buffer.append(", email = ");
		buffer.append(this.getEmail());
		buffer.append("]");
		return buffer.toString();
	}
}
