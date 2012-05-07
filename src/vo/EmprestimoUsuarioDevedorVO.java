/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;


/**
 *
 * @author danilogr
 */
public class EmprestimoUsuarioDevedorVO extends ObjectVO {

    private EmprestimoVO emprestimo;
    private UsuarioVO usuario;
    
    public EmprestimoUsuarioDevedorVO(EmprestimoVO emprestimo,UsuarioVO usuario)
    {
        super();
        this.emprestimo = emprestimo;
        this.usuario = usuario;
        
    }
    
    public EmprestimoVO getEmprestimo() {
        return emprestimo;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setEmprestimo(EmprestimoVO emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }
    

    
    
    
}
