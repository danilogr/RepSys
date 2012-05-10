package vo;

import java.text.SimpleDateFormat;

/**
 * @author Henrique Barcelos
 */
public class UsuarioVO extends ObjectVO {

	private String email;

	private String senha;

	private String nome;

	private double saldo;
	
	public UsuarioVO() {
		super();
	}
	
	public UsuarioVO(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public UsuarioVO(String email, String senha, String nome, double saldo) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.saldo = saldo;
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

	public double getSaldo() {
		return this.saldo;
	}
	
	@Override
	public boolean isEquals(ObjectVO vo) {
		UsuarioVO emp = (UsuarioVO) vo;
		return this.getEmail() == emp.getEmail()
			&& this.getNome() == emp.getNome()
			&& this.getSenha() == emp.getSenha();
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		buffer.append("email = ");
		buffer.append(this.getEmail());
		buffer.append(", nome = ");
		buffer.append(this.getNome());
		buffer.append(", senha = ");
		buffer.append(this.getSenha());
		buffer.append(", saldo = ");
		buffer.append(this.getSaldo());
		buffer.append("]");
		return buffer.toString();
	}
}
