/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JPValorFixo.java
 *
 * Created on May 7, 2012, 12:38:07 AM
 */
package presentation.conta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class JPValorFixo extends javax.swing.JPanel {

    /** Creates new form JPValorFixo */
    public JPValorFixo() {
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

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("I18n/Bundle"); // NOI18N
        jLabel7.setText(bundle.getString("JPValorFixo.jLabel7.text")); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel8.setText(bundle.getString("JPValorFixo.jLabel8.text")); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dias", "Meses", "Anos" }));

        jTextField1.setText(bundle.getString("JPValorFixo.jTextField1.text")); // NOI18N

        jTextField2.setText(bundle.getString("JPValorFixo.jTextField2.text")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel9.setText(bundle.getString("JPValorFixo.jLabel9.text")); // NOI18N

        jTextField3.setText(bundle.getString("JPValorFixo.jTextField3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, 259, Short.MAX_VALUE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    public String getRecorrencia() throws Exception, NumberFormatException{
        String returnValue="";
        String fieldText = this.jTextField1.getText();
        try{
            int fieldInt = Integer.parseInt(fieldText);
            if(fieldInt <= 0)
                throw new Exception();
            int comboBoxIndex = this.jComboBox1.getSelectedIndex();
            returnValue+=fieldInt;
            if(comboBoxIndex == 0)
                returnValue+=" days";
            else if(comboBoxIndex == 1)
                returnValue+=" months";
            else if(comboBoxIndex == 2)
                returnValue+=" years";
            return returnValue;
        }
        catch(NumberFormatException e){
            throw e;
        }        
    }
    
    public int getRepeticoes() throws Exception,NumberFormatException{
        String fieldText = this.jTextField2.getText();
        try{
            int fieldInt = Integer.parseInt(fieldText);
            if(fieldInt <= 0)
                throw new Exception();
            return fieldInt;
            
        }
        catch(NumberFormatException e){
            throw e;
        }  
    }
    
    public Calendar getDataInicial() throws ParseException{
        String fieldText = this.jTextField3.getText();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mmm/yyyy");
            Date fieldDate = sdf.parse(fieldText);
            Calendar fieldCal = Calendar.getInstance();
            fieldCal.setTime(fieldDate);
            return fieldCal;
        }
        catch(ParseException e){
            throw e;
        }          
    }

}
