package vo;

public class UserVO extends ObjectVO {

	private String login;

	private String password;

	private String nome;

	private ContaVO conta;

	
	public UserVO() {
	}

	public UserVO(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public UserVO(String login, String password, String nome) {
		super();
		this.login = login;
		this.password = password;
		this.nome = nome;
	}

	public UserVO(int id, String login, String password, String nome) {
		super(id);
		this.login = login;
		this.password = password;
		this.nome = nome;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return this.nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public ContaVO getConta() {
		return conta;
	}

	public void setConta(ContaVO conta) {
		this.conta = conta;
	}

        @Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("id = ");
		buffer.append(this.getId());
		buffer.append(", nome = ");
		buffer.append(this.getNome());
		buffer.append(", login = ");
		buffer.append(this.getLogin());
		buffer.append("]");
		return buffer.toString();
	}
}
