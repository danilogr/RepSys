/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on May 6, 2012, 3:30:40 PM
 */
package presentation.desktop;

import business.BusinessException;
import business.BusinessFactory;
import business.spec.IUsuario;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.JPLogin;
import presentation.lib.ReturnEvent;
import vo.UsuarioVO;


/**
 *
 * @author danilogr
 */
public class MainWindow extends javax.swing.JFrame {

    private UsuarioVO usuarioLogado;
    /*
     * Parte do sistema que trabalha o movimento das janelas internas
     */
    private List<ReturnEvent> eventosDeRetorno; //pilha de eventos de retorno
    private List<String> eventosDeRetornoNome;  //pilha com os identificadores dos eventos
    
    /*
     * Parte que cuida da autenticação
     */
    private boolean USUARIO_AUTENTICADO = false;
    // #TODO: DECLARAR VARIAVEL PARA GUARDAR OBJETO DO USUARIO AUTENTICADO.
    
    private CardLayout content;
    
    
    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        
        //Cria a lista de eventos de retorno
        eventosDeRetorno = new ArrayList<ReturnEvent>();
        eventosDeRetornoNome = new ArrayList<String>();
        
        //salva os CardLayouts
        content = (CardLayout) jPanelContent.getLayout();
        
        //Instanciar a tela de Login
        //JPLogin login = new JPLogin();
        //jPanelLoginArea.add(login, LOGIN);
        //loginArea.show(jPanelLoginArea, LOGIN);
        
        //INSTANCIAR AQUI A JANELA PRINCIPAL
        JPLogin jlogin = new JPLogin();   
        showCard(jlogin, jlogin);
        
       
        
            
    }
    
    /**  **/
    
    public void showCard(ReturnEvent callback, javax.swing.JPanel card)
    {
       
        String cardName = Integer.toString(eventosDeRetorno.size());
        eventosDeRetornoNome.add(cardName);
        eventosDeRetorno.add(callback);
        
        jPanelContent.add(card,cardName);
        content.show(jPanelContent,cardName);
    }
 
    /*
      Funcao que fecha um objeto
     */
    public void closeCurrentCard(Object returnedValue)
    {
        if(!eventosDeRetorno.isEmpty())
        {
            int index = eventosDeRetornoNome.size()-1;
            ReturnEvent re = eventosDeRetorno.remove(index);
            eventosDeRetornoNome.remove(index);
            
            //apenas executa a funcao de retorno quando o valor retornado for diferente de null
            //e quando nao for a primeira janela criada (mesmo que ela indique um valor de retorno)
            if(eventosDeRetorno.size() >= 1 && returnedValue != null)
            {
                //chama a funcao de retorno
                re.onReturnFromOtherWindow(returnedValue);
            }
            
            jPanelContent.remove((javax.swing.JPanel)re);
            if(index > 0)
                content.show(jPanelContent, eventosDeRetornoNome.get(index-1));
        }   

    }
    
    
    public void closeCurrentCard()
    {
        closeCurrentCard(null);
    }
    
    /**
     * Autentica a MainWindow com o UsuarioVO passado por argumento
     * @param usuario 
     */
    public void authenticateUser(UsuarioVO usuario)
    {
        IUsuario user = BusinessFactory.getInstance().getUser();
        try {
            if(user.authenticate(usuario))
            {
                this.usuarioLogado= user.getUsuario(usuario.getEmail());
            } else
                this.usuarioLogado = null;
            
        } catch (BusinessException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        //autentica o usuario
        jLabelUsuarioEmail.setText(this.usuarioLogado.getEmail());
        jLabelUsuarioNome.setText(this.usuarioLogado.getNome());
        jPanelLogin.setVisible(true);
        
        //fecha a tela de login
        closeCurrentCard();
        
    }
    
    /**
     * 
     * @return UsuarioVO representando o usuario
     * autenticado.
     */
    public UsuarioVO getUsuarioLogado()
    {
        return this.usuarioLogado;
    }
    
    /**
     * Realiza o logout do sistema
     */
    public void logout()
    {
        this.usuarioLogado = null;
        jPanelLogin.setVisible(false);
        
        //Todo, chamar rotinas para liberar todas as telas
        JPLogin jlogin = new JPLogin();   
        showCard(jlogin, jlogin);
    }
    
    /*
       Funcao que permite pegar o objeto corrente desta classes
     */
    static private MainWindow mainwindow = null;
    
    public static MainWindow getInstance()
    {
        if(mainwindow == null)
        {
            mainwindow = new MainWindow();
        }
        return mainwindow;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelTop2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelLogin = new javax.swing.JPanel();
        jLabelUsuarioNome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelUsuarioEmail = new javax.swing.JLabel();
        jPanelContainerBottom = new javax.swing.JPanel();
        jScrollPanelContent = new javax.swing.JScrollPane();
        jPanelMiddle = new javax.swing.JPanel();
        jPanelContent = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("I18n/Bundle"); // NOI18N
        setTitle(bundle.getString("MainWindow.title")); // NOI18N
        setBackground(java.awt.SystemColor.activeCaptionBorder);
        setName("Form"); // NOI18N

        jPanel1.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jPanel1.setName("jPanel1"); // NOI18N

        jPanelTop2.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jPanelTop2.setName("jPanelTop"); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/resources/repsys_logo_min.png"))); // NOI18N
        jLabel3.setText("");
        jLabel3.setName("jLabel1"); // NOI18N

        jPanelLogin.setBackground(java.awt.SystemColor.controlHighlight);
        jPanelLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelLogin.setName("jPanelLogin"); // NOI18N

        jLabelUsuarioNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelUsuarioNome.setText(bundle.getString("MainWindow.jLabelUsuarioNome.text")); // NOI18N
        jLabelUsuarioNome.setName("jLabelUsuarioNome"); // NOI18N

        jButton1.setText(bundle.getString("MainWindow.jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabelUsuarioEmail.setText(bundle.getString("MainWindow.jLabelUsuarioEmail.text")); // NOI18N
        jLabelUsuarioEmail.setName("jLabelUsuarioEmail"); // NOI18N

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsuarioEmail)
                    .addComponent(jLabelUsuarioNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jLabelUsuarioNome)
                        .addGap(4, 4, 4)
                        .addComponent(jLabelUsuarioEmail)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelTop2Layout = new javax.swing.GroupLayout(jPanelTop2);
        jPanelTop2.setLayout(jPanelTop2Layout);
        jPanelTop2Layout.setHorizontalGroup(
            jPanelTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTop2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTop2Layout.setVerticalGroup(
            jPanelTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTop2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelLogin.setVisible(false);

        jPanelContainerBottom.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jPanelContainerBottom.setName("jPanelContainerBottom"); // NOI18N

        jScrollPanelContent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPanelContent.setName("jScrollPanelContent"); // NOI18N

        jPanelMiddle.setName("jPanelMiddle"); // NOI18N
        jPanelMiddle.setLayout(new java.awt.GridBagLayout());

        jPanelContent.setName("jPanelContent"); // NOI18N
        jPanelContent.setLayout(new java.awt.CardLayout());
        jPanelMiddle.add(jPanelContent, new java.awt.GridBagConstraints());

        jScrollPanelContent.setViewportView(jPanelMiddle);

        jPanelMenu.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jPanelMenu.setName("jPanelMenu"); // NOI18N

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelContainerBottomLayout = new javax.swing.GroupLayout(jPanelContainerBottom);
        jPanelContainerBottom.setLayout(jPanelContainerBottomLayout);
        jPanelContainerBottomLayout.setHorizontalGroup(
            jPanelContainerBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerBottomLayout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );
        jPanelContainerBottomLayout.setVerticalGroup(
            jPanelContainerBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTop2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContainerBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelTop2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContainerBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Botao que faz logout
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO: Verificar alguma tarefa em executacao
        this.logout();
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                getInstance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelUsuarioEmail;
    private javax.swing.JLabel jLabelUsuarioNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContainerBottom;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelMiddle;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JPanel jPanelTop1;
    private javax.swing.JPanel jPanelTop2;
    private javax.swing.JScrollPane jScrollPanelContent;
    // End of variables declaration//GEN-END:variables

    

}
