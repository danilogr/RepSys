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

import business.BusinessFactory;
import java.awt.Color;
import vo.NumeroTelefonicoVO;

/**
 *
 * @author Nelson
 */
public class JPCadastrarNumeroTelefonico extends javax.swing.JPanel implements presentation.lib.ReturnEvent {
       
    /** Creates new form JPCadastrarNumeroTelefonico */
    public JPCadastrarNumeroTelefonico() {
        initComponents();
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

        setPreferredSize(new java.awt.Dimension(560, 450));

        jLabelNumero.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelNumero.setText("Número:");

        jTextFieldNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumeroFocusLost(evt);
            }
        });

        jLabelRecorrencia.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelRecorrencia.setText("Recorrência:");

        buttonGroup1.add(jRadioButtonUnica);
        jRadioButtonUnica.setText("Única");
        jRadioButtonUnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUnicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonSempre);
        jRadioButtonSempre.setText("Sempre");
        jRadioButtonSempre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSempreActionPerformed(evt);
            }
        });

        jTableResponsaveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Responsável", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableResponsaveis);
        jTableResponsaveis.getColumnModel().getColumn(0).setResizable(false);
        jTableResponsaveis.getColumnModel().getColumn(1).setResizable(false);

        jLabelData.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelData.setText("Data:");

        jLabelHora.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelHora.setText("Hora:");

        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });

        jTextFieldHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoraActionPerformed(evt);
            }
        });

        jLabelCadastrarNumeroTelefonico.setFont(new java.awt.Font("Cambria", 1, 30));
        jLabelCadastrarNumeroTelefonico.setText("Cadastrar Ligação");

        jLabelResponsaveis.setFont(new java.awt.Font("Calibri", 1, 18));
        jLabelResponsaveis.setText("Responsáveis:");

        jToggleButtonConfirmar.setText("Confirmar");
        jToggleButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelCadastrarNumeroTelefonico, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabelNumero)
                            .addGap(78, 78, 78)
                            .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabelData)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRecorrencia)
                            .addComponent(jLabelHora)
                            .addComponent(jLabelResponsaveis))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonUnica)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonSempre))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToggleButtonConfirmar))
                .addContainerGap(30, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelResponsaveis))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHora)
                    .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButtonConfirmar)
                .addGap(59, 59, 59))
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
    NumeroTelefonicoVO voNumero;
    BusinessFactory factory = BusinessFactory.getInstance();
    //private List usuarios;
    boolean ok = true;
    
    if (sNumero.isEmpty()) {
        jTextFieldNumero.setBackground(Color.red);
        jTextFieldNumero.grabFocus();
        ok = false;
    }
    
    //jLabel8.setVisible(!ok);
    
    if (ok) {
        try {
            // Procura o número (se não existir, numero==null)
            voNumero = factory.getNumeroTelefonico().getNumeroTelefonico(sNumero);
            if (voNumero == null) {
                // Cria novo número
                voNumero.setNumero(sNumero);
                factory.getNumeroTelefonico().create(voNumero);
            }
            // Inserção na tabela Usuario_NumeroTelefonico
            
            // ---
        } catch (BusinessException ex) {
            Logger.getLogger(JPCadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    NumeroTelefonicoVO numero;
    if (novoNumero) {
        numero = new NumeroTelefonicoVO(jTextFieldNumero.getText());
    } else {
        numero = 
    }

    try {
        BusinessFactory.getInstance().getNumeroTelefonico().create(numero);
    } catch (BusinessException ex) {
        Logger.getLogger(JPCadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        return;
    }    
    */
    
}//GEN-LAST:event_jToggleButtonConfirmarActionPerformed

private void jTextFieldNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumeroFocusLost
    jTextFieldNumero.setBackground(Color.white);    
}//GEN-LAST:event_jTextFieldNumeroFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
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
