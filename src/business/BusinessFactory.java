package business;

import business.impl.Conta;
import business.impl.Emprestimo;
import business.impl.ItemFaturaTelefonica;
import business.impl.NumeroTelefonico;
import business.impl.Usuario;
import business.spec.IConta;
import business.spec.IEmprestimo;
import business.spec.IItemFaturaTelefonica;
import business.spec.INumeroTelefonico;
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

	public IConta getConta() {
		return new Conta();
	}

	public IUsuario getUsuario() {
		return new Usuario();
	}
        
        public INumeroTelefonico getNumeroTelefonico() {
		return new NumeroTelefonico();
	}

        public IItemFaturaTelefonica getItemFaturaTelefonica() {
                return new ItemFaturaTelefonica();
        }
        
        public IEmprestimo getEmprestimo()
        {
                return new Emprestimo();
        }
        
}
