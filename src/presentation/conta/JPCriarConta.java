/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPCriarConta.java
 *
 * Created on May 6, 2012, 11:40:00 PM
 */
package presentation.conta;

import business.BusinessException;
import business.BusinessFactory;
import java.awt.CardLayout;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.TableColumn;
import presentation.desktop.MainWindow;
import presentation.lib.IMultiModePanel.Mode;
import presentation.usuario.JPUsuariosCadastrados;
import vo.ContaVO;
import vo.ContaValorFixoVO;
import vo.ContaValorVariavelVO;
import vo.UsuarioVO;
import vo.VOException;

/**
 *
 * @author Daniel
 */
public class JPCriarConta extends javax.swing.JPanel implements presentation.lib.ReturnEvent{

    /** Creates new form JPCriarConta */
    public JPCriarConta() {
        initComponents();
        initCardLayout();
        myInit();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textFieldNomeConta = new javax.swing.JTextField();
        textFieldValorConta = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 30));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("I18n/Bundle"); // NOI18N
        jLabel8.setText(bundle.getString("JPCriarConta.jLabel8.text")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri", 3, 18));
        jLabel9.setText(bundle.getString("JPCriarConta.jLabel9.text")); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 3, 18));
        jLabel10.setText(bundle.getString("JPCriarConta.jLabel10.text")); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 3, 18));
        jLabel11.setText(bundle.getString("JPCriarConta.jLabel11.text")); // NOI18N

        textFieldNomeConta.setFont(new java.awt.Font("Catriel", 0, 11)); // NOI18N
        textFieldNomeConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNomeContaActionPerformed(evt);
            }
        });

        textFieldValorConta.setFont(new java.awt.Font("Catriel", 0, 11)); // NOI18N

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText(bundle.getString("JPCriarConta.jLabel12.text")); // NOI18N

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Calibri", 0, 14));
        jRadioButton3.setText(bundle.getString("JPCriarConta.jRadioButton3.text")); // NOI18N
        jRadioButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton3StateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Calibri", 0, 14));
        jRadioButton4.setText(bundle.getString("JPCriarConta.jRadioButton4.text")); // NOI18N
        jRadioButton4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton4StateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 3, 18));
        jLabel13.setText(bundle.getString("JPCriarConta.jLabel13.text")); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(3);
        jScrollPane3.setViewportView(jTextArea2);

        jPanel3.setLayout(new java.awt.CardLayout());

        jLabel14.setFont(new java.awt.Font("Calibri", 3, 18));
        jLabel14.setText(bundle.getString("JPCriarConta.jLabel14.text")); // NOI18N

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Catriel", 0, 11)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton3.setText(bundle.getString("JPCriarConta.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Daniel", "daniel@gmail.com", null},
                {null, "João", "joão@gmail.com", null},
                {null, "Pedro", "pedro@gmail.com", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Selecionar", "Nome", "e-mail", "Proporção (%)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable2);

        jLabel15.setFont(new java.awt.Font("Calibri", 3, 18));
        jLabel15.setText(bundle.getString("JPCriarConta.jLabel15.text")); // NOI18N

        jCheckBox2.setFont(new java.awt.Font("Calibri", 0, 14));
        jCheckBox2.setText(bundle.getString("JPCriarConta.jCheckBox2.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jCheckBox2)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2))
        );

        jButton1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jButton1.setText(bundle.getString("JPCriarConta.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 1, 12));
        jButton2.setText(bundle.getString("JPCriarConta.jButton2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldValorConta)
                                    .addComponent(textFieldNomeConta, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton4))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel13)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jRadioButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textFieldNomeConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(textFieldValorConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void textFieldNomeContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNomeContaActionPerformed
// TODO add your handling code here:
      
}//GEN-LAST:event_textFieldNomeContaActionPerformed

private void jRadioButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton3StateChanged
// TODO add your handling code here:
    JRadioButton rb = (JRadioButton)evt.getSource();
    if(rb.getModel() == buttonGroup1.getSelection()){
        CardLayout cl = (CardLayout)(this.jPanel3.getLayout());
        cl.show(this.jPanel3, "fix");
        this.isValorFixo=true;
    }   
}//GEN-LAST:event_jRadioButton3StateChanged

private void jRadioButton4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton4StateChanged
// TODO add your handling code here:
    JRadioButton rb = (JRadioButton)evt.getSource();
    if(rb.getModel() == buttonGroup1.getSelection()){
        CardLayout cl = (CardLayout)(this.jPanel3.getLayout());
        cl.show(this.jPanel3, "var");
        this.isValorFixo=false;
    }
}//GEN-LAST:event_jRadioButton4StateChanged

private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextField5ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    try{
        if(isTudoPreenchido()){
            this.parseFormData();
            this.salvarConta();
            JOptionPane.showMessageDialog(this, "Conta cadastrada.");
            MainWindow.getInstance().closeCurrentCard();
        }
        else
            JOptionPane.showMessageDialog(this, "Checar campos");
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(this, "erro");
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
    JPUsuariosCadastrados jpanel = new JPUsuariosCadastrados();
    jpanel.setMode(Mode.SELECIONAVEL);
    MainWindow.getInstance().showCard(this, jpanel);
}//GEN-LAST:event_jButton3ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField textFieldNomeConta;
    private javax.swing.JTextField textFieldValorConta;
    // End of variables declaration//GEN-END:variables
    
    
    private JPValorFixo cardFix;
    private JPValorVariavel cardVar;
    
    private List usuariosEnvolvidos;
    private String nomeConta;
    private double valorConta;
    private String descricaoConta;
    private Boolean isValorFixo;
    private String recorrenciaContaValorFixo;
    private int repeticoesContaValorFixo;
    private Calendar dataInicialContaValorFixo;
    private Calendar vencimentoContaValorVariavel;
    private UsuarioVO usuarioResponsavel;
    
    
    private void initCardLayout(){
        this.cardFix = new JPValorFixo();
        this.cardVar = new JPValorVariavel();
        this.jPanel3.add(cardFix,"fix");
        this.jPanel3.add(cardVar,"var");
        CardLayout cl = (CardLayout)(this.jPanel3.getLayout());
        cl.show(this.jPanel3, "fix");
    }

    private void myInit(){
        int colIndex = 0;
        int width = 75;
        TableColumn col = this.jTable2.getColumnModel().getColumn(colIndex);
        col.setMinWidth(width);
        col.setMaxWidth(width);
        col.setPreferredWidth(width); 
        
        colIndex = 3;
        width=100;
        col = this.jTable2.getColumnModel().getColumn(colIndex);
        col.setMinWidth(width);
        col.setMaxWidth(width);
        col.setPreferredWidth(width);
    }
    
    public void onReturnFromOtherWindow(Object returnedObject) {
        if (returnedObject instanceof UsuarioVO){
            this.usuarioResponsavel = (UsuarioVO)returnedObject;
            String text=this.usuarioResponsavel.getNome()+" ("+this.usuarioResponsavel.getEmail()+")";
            jTextField5.setText(text);
            jTextField5.setToolTipText(text);
        }
    }

    private void parseFormData() throws ParseException,Exception, NumberFormatException{        
        
        usuariosEnvolvidos = new ArrayList();
        for (int i=0; i < this.jTable2.getRowCount();i++){
            if ((Boolean)this.jTable2.getValueAt(i, 2)){
                usuariosEnvolvidos.add(this.jTable2.getValueAt(i,2));
            }
        }
        
        nomeConta = this.textFieldNomeConta.getText();
        descricaoConta = this.jTextArea2.getText();
        try{            
            valorConta = Double.parseDouble(textFieldValorConta.getText());
            if(isValorFixo) {
                    recorrenciaContaValorFixo = this.cardFix.getRecorrencia();
                    repeticoesContaValorFixo = this.cardFix.getRepeticoes();
            }
            else {
                vencimentoContaValorVariavel = this.cardVar.getVencimento();
            }
        
        }
        catch(ParseException e){
            throw e;
        }
        catch(NumberFormatException e){
            throw e;
        }
        catch(Exception e){
            throw e;
        }        
    }

    private void salvarConta() throws BusinessException, VOException {
        //throw new UnsupportedOperationException("Not yet implemented");
        BusinessFactory factory = BusinessFactory.getInstance();
        try {
            ContaVO conta = new ContaVO(nomeConta, valorConta, usuarioResponsavel, descricaoConta);
            
            if(this.isValorFixo){
                factory.getConta().create(new ContaValorFixoVO(conta, dataInicialContaValorFixo,  repeticoesContaValorFixo, recorrenciaContaValorFixo));
            }
            else{                
                factory.getConta().create(new ContaValorVariavelVO(conta, vencimentoContaValorVariavel));         
            }
        } catch (BusinessException e) {
            throw e;
        } catch (VOException e){
            throw e;
        }
    }

    private boolean isTudoPreenchido() throws Exception {        
        try{
            if ( this.textFieldNomeConta.getText().equals("") || this.textFieldValorConta.getText().equals("") )
                return false;
            
            else if(this.isValorFixo)
                return ( ! ( this.cardFix.getDataInicial()==null || this.cardFix.getRecorrencia()==null || this.cardFix.getRepeticoes()==null ) );
            else
                return ( ! ( this.cardVar.getVencimento()==null ) );
        }
        catch(Exception e){
            throw e;
        }
    }
}
