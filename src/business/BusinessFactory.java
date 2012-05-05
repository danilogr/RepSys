package business;

import business.impl.Conta;
import business.impl.Usuario;
import business.spec.IConta;
import business.spec.IUsuario;

public class BusinessFactory {

	private static BusinessFactory instance = null;

	private BusinessFactory() {
	}

	public static BusinessFactory getInstance() {
		if (instance == null) {
			instance = new BusinessFactory();
		}
		return instance;
	}

	public IConta getAccount() {
		return new Conta();
	}

	public IUsuario getUser() {
		return new Usuario();
	}
}
