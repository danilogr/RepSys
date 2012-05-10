/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPUsuariosCadastrados.java
 *
 * Created on 07/05/2012, 00:26:59
 */
package presentation.usuario;

import business.BusinessException;
import business.BusinessFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import presentation.desktop.MainWindow;
import presentation.lib.IMultiModePanel;
import vo.UsuarioVO;

/**
 *
 * @author Endril
 */
public class JPUsuariosCadastrados extends javax.swing.JPanel implements presentation.lib.ReturnEvent,IMultiModePanel{

    /** Creates new form JPUsuariosCadastrados */
    public JPUsuariosCadastrados() {
        initComponents();
        populaTabela();
        this.setMode(Mode.NORMAL);
    }
    
    public JPUsuariosCadastrados(Mode mode) {
        initComponents();
        populaTabela();
        this.setMode(mode);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonRemover = new javax.swing.JButton();
        buttonConfirmarSelecao = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 30));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("I18n/Bundle"); // NOI18N
        jLabel1.setText(bundle.getString("JPUsuariosCadastrados.jLabel1.text")); // NOI18N

        buttonVoltar.setFont(new java.awt.Font("Calibri", 1, 12));
        buttonVoltar.setText(bundle.getString("JPUsuariosCadastrados.buttonVoltar.text")); // NOI18N
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Calibri", 1, 12));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "E-mail", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("JPUsuariosCadastrados.jTable1.columnModel.title0")); // NOI18N
        jTable1.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("JPUsuariosCadastrados.jTable1.columnModel.title1")); // NOI18N
        jTable1.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("JPUsuariosCadastrados.jTable1.columnModel.title2")); // NOI18N

        buttonRemover.setFont(new java.awt.Font("Calibri", 1, 12));
        buttonRemover.setText(bundle.getString("JPUsuariosCadastrados.buttonRemover.text")); // NOI18N
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });

        buttonConfirmarSelecao.setFont(new java.awt.Font("Calibri", 1, 12));
        buttonConfirmarSelecao.setText(bundle.getString("JPUsuariosCadastrados.buttonConfirmarSelecao.text")); // NOI18N
        buttonConfirmarSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarSelecaoActionPerformed(evt);
            }
        });

        buttonEditar.setFont(new java.awt.Font("Calibri", 1, 12));
        buttonEditar.setText(bundle.getString("JPUsuariosCadastrados.buttonEditar.text")); // NOI18N
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonRemover)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addComponent(buttonConfirmarSelecao)
                        .addGap(18, 18, 18)
                        .addComponent(buttonVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVoltar)
                    .addComponent(buttonRemover)
                    .addComponent(buttonConfirmarSelecao)
                    .addComponent(buttonEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed
// TODO add your handling code here:
    if(this.mode == Mode.NORMAL){
        try{
            this.chamarRemocao();
        }
        catch(BusinessException e){
            JOptionPane.showMessageDialog(this, "erro:"+e.toString());
        }            
    }
}//GEN-LAST:event_buttonRemoverActionPerformed

private void buttonConfirmarSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmarSelecaoActionPerformed
// TODO add your handling code here:
    if(this.mode == Mode.SELECIONAVEL)
        this.retornarUsuarioSelecionado();
}//GEN-LAST:event_buttonConfirmarSelecaoActionPerformed

private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
// TODO add your handling code here:
    MainWindow.getInstance().closeCurrentCard();
}//GEN-LAST:event_buttonVoltarActionPerformed

private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
// TODO add your handling code here:
    if(this.mode == Mode.NORMAL)
        this.chamarEdicao();
}//GEN-LAST:event_buttonEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConfirmarSelecao;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonRemover;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private Mode mode;
    private List<UsuarioVO> usuarios;
    
    public void onReturnFromOtherWindow(Object returnedObject) {
    }

    public Mode getMode() {
        return this.mode;
    }

    public void setMode(Mode newMode) {
        
        this.mode = newMode;
        
        switch (this.mode){
            case NORMAL:
                this.buttonEditar.setEnabled(true);
                this.buttonRemover.setEnabled(true);
                this.jTable1.setRowSelectionAllowed(false);
                this.jTable1.setColumnSelectionAllowed(false);
                this.jTable1.setCellSelectionEnabled(false);
                break;
            case SELECIONAVEL:
                this.buttonEditar.setEnabled(false);
                this.buttonRemover.setEnabled(false);
                this.jTable1.setRowSelectionAllowed(true);
                this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                this.jTable1.setColumnSelectionAllowed(false);
                this.jTable1.setCellSelectionEnabled(false);
                break;
        }
    }
    
    private void retornarUsuarioSelecionado(){
        MainWindow.getInstance().closeCurrentCard(usuarios.get((this.jTable1.getSelectedRow())));
    }

    private void chamarEdicao() {
        MainWindow.getInstance().showCard(this, new JPAtualizarUsuario(usuarios.get((this.jTable1.getSelectedRow()))));
    }

    private void chamarRemocao() throws BusinessException {
        UsuarioVO selecionado = usuarios.get((this.jTable1.getSelectedRow()));
        BusinessFactory factory = BusinessFactory.getInstance();
        try{
            factory.getUsuario().delete(selecionado.getEmail());
        }
        catch(BusinessException e){
            throw e;
        }
    }

    private void populaTabela(){
        usuarios = new ArrayList<UsuarioVO>();
        BusinessFactory factory = BusinessFactory.getInstance();
        
        try {
            usuarios = factory.getUsuario().getAll();
        } catch (BusinessException ex) {
            Logger.getLogger(JPUsuariosCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int counter=0;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (UsuarioVO usuario:usuarios) {
            float saida = (float) usuario.getSaldo();
        
            String fn = "";
            if(saida<0.0)
                fn = "DEVEDOR "+Float.toString(saida);
            else
                fn = "CREDOR "+Float.toString(saida);
            model.insertRow(counter, new Object[]{usuario.getNome(),usuario.getEmail(),fn});
            counter++;
        }
    }
}
