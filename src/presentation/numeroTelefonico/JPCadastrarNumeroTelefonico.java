/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPCadastrarNumeroTelefonico.java
 *
 * Created on May 7, 2012, 6:21:40 PM
 */
package presentation.numeroTelefonico;

import business.BusinessException;
import business.BusinessFactory;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import presentation.desktop.MainWindow;
import presentation.usuario.JPCadastrarUsuario;
import vo.NumeroTelefonicoVO;
import vo.UsuarioNumeroTelefonicoVO;
import vo.UsuarioVO;

/**
 *
 * @author Nelson
 */
public class JPCadastrarNumeroTelefonico extends javax.swing.JPanel implements presentation.lib.ReturnEvent {
       
    /** Creates new form JPCadastrarNumeroTelefonico */
    public JPCadastrarNumeroTelefonico() {
        initComponents();
        // Carrega usuários
        try {
            List<UsuarioVO> usuarios = BusinessFactory.getInstance().getUsuario().getAll();
            DefaultTableModel model = (DefaultTableModel) jTableResponsaveis.getModel();
            int i = 0;
            for (UsuarioVO usuario:usuarios) {
                model.insertRow(i, new Object[]{false,usuario.getNome(),usuario.getEmail()});
            }
        } catch (BusinessException ex) {
            Logger.getLogger(JPCadastrarNumeroTelefonico.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelRecorrencia = new javax.swing.JLabel();
        jRadioButtonUnica = new javax.swing.JRadioButton();
        jRadioButtonSempre = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResponsaveis = new javax.swing.JTable();
        jLabelData = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jTextFieldHora = new javax.swing.JTextField();
        jLabelCadastrarNumeroTelefonico = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelResponsaveis = new javax.swing.JLabel();
        jToggleButtonConfirmar = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(560, 450));

        jLabelNumero.setFont(new java.awt.Font("Calibri", 1, 18));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("I18n/Bundle"); // NOI18N
        jLabelNumero.setText(bundle.getString("JPCadastrarNumeroTelefonico.jLabelNumero.text")); // NOI18N

        jTextFieldNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusLost(evt);
            }
        });

        jLabelRecorrencia.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelRecorrencia.setText(bundle.getString("JPCadastrarNumeroTelefonico.jLabelRecorrencia.text")); // NOI18N

        buttonGroup1.add(jRadioButtonUnica);
        jRadioButtonUnica.setSelected(true);
        jRadioButtonUnica.setText(bundle.getString("JPCadastrarNumeroTelefonico.jRadioButtonUnica.text")); // NOI18N
        jRadioButtonUnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUnicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonSempre);
        jRadioButtonSempre.setText(bundle.getString("JPCadastrarNumeroTelefonico.jRadioButtonSempre.text")); // NOI18N
        jRadioButtonSempre.setEnabled(false);
        jRadioButtonSempre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSempreActionPerformed(evt);
            }
        });

        jTableResponsaveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Responsável", "Nome", "E-maill"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableResponsaveis.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableResponsaveis);
        jTableResponsaveis.getColumnModel().getColumn(0).setResizable(false);
        jTableResponsaveis.getColumnModel().getColumn(0).setPreferredWidth(15);
        jTableResponsaveis.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("JPCadastrarNumeroTelefonico.jTableResponsaveis.columnModel.title0_1")); // NOI18N
        jTableResponsaveis.getColumnModel().getColumn(1).setResizable(false);
        jTableResponsaveis.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("JPCadastrarNumeroTelefonico.jTableResponsaveis.columnModel.title1_1")); // NOI18N
        jTableResponsaveis.getColumnModel().getColumn(2).setResizable(false);
        jTableResponsaveis.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("JPCadastrarNumeroTelefonico.jTableResponsaveis.columnModel.title2_1")); // NOI18N

        jLabelData.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelData.setText(bundle.getString("JPCadastrarNumeroTelefonico.jLabelData.text")); // NOI18N

        jLabelHora.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelHora.setText(bundle.getString("JPCadastrarNumeroTelefonico.jLabelHora.text")); // NOI18N

        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });
        jTextFieldData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDataFocusLost(evt);
            }
        });

        jTextFieldHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoraActionPerformed(evt);
            }
        });
        jTextFieldHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldHoraFocusLost(evt);
            }
        });

        jLabelCadastrarNumeroTelefonico.setFont(new java.awt.Font("Cambria", 1, 30));
        jLabelCadastrarNumeroTelefonico.setText(bundle.getString("JPCadastrarNumeroTelefonico.jLabelCadastrarNumeroTelefonico.text")); // NOI18N

        jLabelResponsaveis.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelResponsaveis.setText(bundle.getString("JPCadastrarNumeroTelefonico.jLabelResponsaveis.text")); // NOI18N

        jToggleButtonConfirmar.setText(bundle.getString("JPCadastrarNumeroTelefonico.jToggleButtonConfirmar.text")); // NOI18N
        jToggleButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonConfirmarActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText(bundle.getString("JPCadastrarUsuario.jLabel8.text")); // NOI18N
        jLabel8.setVisible(false);

        jButton2.setFont(new java.awt.Font("Calibri", 1, 12));
        jButton2.setText(bundle.getString("JPCadastrarNumeroTelefonico.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText(bundle.getString("JPCadastrarNumeroTelefonico.jLabel9.text")); // NOI18N
        jLabel9.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelCadastrarNumeroTelefonico, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabelNumero)
                                    .addGap(78, 78, 78)
                                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelData)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelRecorrencia)
                                        .addComponent(jLabelHora)
                                        .addComponent(jLabelResponsaveis))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jRadioButtonUnica)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButtonSempre))
                                            .addComponent(jTextFieldData, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)))))
                            .addComponent(jToggleButtonConfirmar))
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelCadastrarNumeroTelefonico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonUnica)
                    .addComponent(jRadioButtonSempre)
                    .addComponent(jLabelRecorrencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelResponsaveis)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHora)
                    .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonConfirmar)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jTextFieldHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoraActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldHoraActionPerformed

private void jRadioButtonSempreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSempreActionPerformed
    jTextFieldData.setText("");
    jTextFieldHora.setText("");
    jTextFieldData.setEditable(false);
    jTextFieldHora.setEditable(false);
}//GEN-LAST:event_jRadioButtonSempreActionPerformed

private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldDataActionPerformed

private void jRadioButtonUnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUnicaActionPerformed
    jTextFieldData.setEditable(true);
    jTextFieldHora.setEditable(true);  
}//GEN-LAST:event_jRadioButtonUnicaActionPerformed

private void jToggleButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonConfirmarActionPerformed
    
    String sNumero = jTextFieldNumero.getText();
    String data = this.jTextFieldData.getText();
    String hora = this.jTextFieldHora.getText();
    NumeroTelefonicoVO voNumero;
    BusinessFactory factory = BusinessFactory.getInstance();
    boolean ok = true;
    boolean recorrente;
    
    if (jRadioButtonUnica.isSelected())
        recorrente = false;
    else
        recorrente = true;
    
    if (!recorrente && hora.isEmpty()) {
        jTextFieldHora.setBackground(Color.red);
        jTextFieldHora.grabFocus();
        ok = false;
    }
    
    if (!recorrente && data.isEmpty()) {
        jTextFieldData.setBackground(Color.red);
        jTextFieldData.grabFocus();
        ok = false;
    }
    
    if (sNumero.isEmpty()) {
        jTextFieldNumero.setBackground(Color.red);
        jTextFieldNumero.grabFocus();
        ok = false;
    }
    
    jLabel8.setVisible(!ok);
    
    if (ok) {
        try {
            // Procura o número (se não existir, numero==null)
            voNumero = factory.getNumeroTelefonico().getNumeroTelefonico(sNumero);
            if (voNumero == null) {
                // Cria novo número
                voNumero = new NumeroTelefonicoVO(sNumero);
                factory.getNumeroTelefonico().create(voNumero);
            }
            // --- Inserção na tabela Usuario_NumeroTelefonico ---
            // Data e Hora
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Calendar data_hora = Calendar.getInstance();
            if (!recorrente) {
                try {
                    data_hora.setTime(sdf.parse(data+" "+hora));
                    jLabel9.setVisible(false);
                    jTextFieldData.setBackground(Color.white);
                    jTextFieldHora.setBackground(Color.white);
                } catch (ParseException ex) {
                    jLabel9.setVisible(true);
                    jTextFieldData.setBackground(Color.red);
                    jTextFieldHora.setBackground(Color.red);
                    jTextFieldData.grabFocus();
                    return;
                }
            }
            // Insert
            UsuarioNumeroTelefonicoVO ligacao = new UsuarioNumeroTelefonicoVO(
                null,       // Usuário (será setado no loop abaixo)
                voNumero,   // Número Telefônico
                data_hora,  // Data/Hora
                recorrente ? 1 : 0
            );
            for (int i=0; i < jTableResponsaveis.getRowCount();i++) {
                if ((Boolean)jTableResponsaveis.getValueAt(i,0)){
                    ligacao.setUsuario(factory.getUsuario().getUsuarioByEmail((String)jTableResponsaveis.getValueAt(i,2)));
                    factory.getNumeroTelefonico().addLigacao(ligacao);
                }
            }
            MainWindow.getInstance().closeCurrentCard(voNumero);
        } catch (BusinessException ex) {
            Logger.getLogger(JPCadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}//GEN-LAST:event_jToggleButtonConfirmarActionPerformed

private void jTextFieldNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusLost
    jTextFieldNumero.setBackground(Color.white);    
}//GEN-LAST:event_jTextFieldNumeroFocusLost

private void jTextFieldDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataFocusLost
    jTextFieldData.setBackground(Color.white);    
}//GEN-LAST:event_jTextFieldDataFocusLost

private void jTextFieldHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldHoraFocusLost
    jTextFieldHora.setBackground(Color.white);    
}//GEN-LAST:event_jTextFieldHoraFocusLost

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    MainWindow.getInstance().closeCurrentCard();
}//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCadastrarNumeroTelefonico;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRecorrencia;
    private javax.swing.JLabel jLabelResponsaveis;
    private javax.swing.JRadioButton jRadioButtonSempre;
    private javax.swing.JRadioButton jRadioButtonUnica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableResponsaveis;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JToggleButton jToggleButtonConfirmar;
    // End of variables declaration//GEN-END:variables

    public void onReturnFromOtherWindow(Object returnedObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
