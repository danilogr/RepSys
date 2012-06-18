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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.Fatura.JPConsultarFatura;
import presentation.Fatura.JPImportarFatura;
import presentation.JPLogin;
import presentation.conta.JPConsultarConta;
import presentation.conta.JPCriarConta;
import presentation.emprestimo.JPCadastrarEmprestimo;
import presentation.emprestimo.JPConsultarEmprestimo;
import presentation.lib.ReturnEvent;
import presentation.numeroTelefonico.JPCadastrarNumeroTelefonico;
import presentation.numeroTelefonico.JPConsultarLigacao;
import presentation.usuario.JPCadastrarUsuario;
import presentation.usuario.JPUsuariosCadastrados;
import vo.UsuarioVO;


/**
 *
 * @author danilogr
 */
public class MainWindow extends javax.swing.JFrame implements presentation.lib.ReturnEvent{

    private UsuarioVO usuarioLogado;
    /*
     * Parte do sistema que trabalha o movimento das janelas internas
     */
    private List<ReturnEvent> eventosDeRetorno; //pilha de eventos de retorno
    private List<String> eventosDeRetornoNome;  //pilha com os identificadores dos eventos
    private javax.swing.JPanel currentCard;                 //fecha a atual
    private CardLayout content;
    //private int totalWindowsCount;

    
    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        
        //Cria a lista de eventos de retorno
        eventosDeRetorno = new ArrayList<ReturnEvent>();
        eventosDeRetornoNome = new ArrayList<String>();
        
        //salva os CardLayouts
        content = (CardLayout) jPanelContent.getLayout();
        
        //desativa os botoes
        setButtonsEnabled(false);
                
        //INSTANCIAR AQUI A JANELA PRINCIPAL
 
        showFirstCard(new JPLogin(this));
        
       
        
            
    }
    
    
    /* Abre uma card 'inicial'
     */
    
    private void showFirstCard(javax.swing.JPanel card)
    {
        //se tiver alguma 'card aberta'
        
        if(currentCard != null)
        {
            //remove a card atual
            content.removeLayoutComponent(currentCard);
            jPanelContent.remove(currentCard);
            currentCard = null;
            
            if(eventosDeRetorno.size() > 1)
            {
                //remove todas as outras cards
                do
                {
                    ReturnEvent re = eventosDeRetorno.remove(eventosDeRetorno.size()-1);  
                    jPanelContent.remove((javax.swing.JPanel)re);              
                } while(eventosDeRetorno.size() > 1);
            }
            
            //remove o primeiro card
            eventosDeRetorno.clear();
            eventosDeRetornoNome.clear();
        }
         
            //cria a card necessaria
            showCard(this,card); 
    }
    
    /**  **/
    
    public void showCard(ReturnEvent callback, javax.swing.JPanel card)
    {
       
        String cardName = Integer.toString(eventosDeRetorno.size());
        eventosDeRetornoNome.add(cardName);
        eventosDeRetorno.add(callback);
        currentCard = card;
        
        jPanelContent.add(card,cardName);
        content.show(jPanelContent,cardName);
        refreshWindow();
    }
 
    /*
      Funcao que fecha um objeto
     */
    public void closeCurrentCard(Object returnedValue)
    {
        if(currentCard != null)
        {
            int index = eventosDeRetornoNome.size()-1;
            ReturnEvent re = eventosDeRetorno.remove(index);
            eventosDeRetornoNome.remove(index);

            //apenas executa a funcao de retorno quando o valor retornado for diferente de null
            if(returnedValue != null)
            {
                //chama a funcao de retorno
                re.onReturnFromOtherWindow(returnedValue);
            }
            
         
            jPanelContent.remove(currentCard);
            
            if(index > 0)
            {
                content.show(jPanelContent, eventosDeRetornoNome.get(index-1));
                currentCard = (javax.swing.JPanel) re;
            }
            else
                currentCard = null;
            
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
        IUsuario user = BusinessFactory.getInstance().getUsuario();
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
        
        //ativa os botoes
        setButtonsEnabled(true);
        
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
        showFirstCard( new JPLogin(this));
        
        //desativa os botoes
        setButtonsEnabled(false);
    }
    
    /**
     *  Ativa/Desativa botoes da interface
     */
    
    private void setButtonsEnabled(boolean state)
    {       
        jButton2.setEnabled(state);
        jButton3.setEnabled(state);
        jButton5.setEnabled(state);
        jButton6.setEnabled(state);
        jButton7.setEnabled(state);
        jButton8.setEnabled(state);
        jButton10.setEnabled(state);
        jButton11.setEnabled(state);
        jButton12.setEnabled(state);
        jButton13.setEnabled(state);
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
        jle = new javax.swing.JLabel();
        jPanelContainerBottom = new javax.swing.JPanel();
        jScrollPanelContent = new javax.swing.JScrollPane();
        jPanelMiddle = new javax.swing.JPanel();
        jPanelContent = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

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

        jLabelUsuarioNome.setFont(new java.awt.Font("Tahoma", 1, 11));
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

        jle.setName("jle"); // NOI18N

        javax.swing.GroupLayout jPanelTop2Layout = new javax.swing.GroupLayout(jPanelTop2);
        jPanelTop2.setLayout(jPanelTop2Layout);
        jPanelTop2Layout.setHorizontalGroup(
            jPanelTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTop2Layout.createSequentialGroup()
                .addGroup(jPanelTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTop2Layout.createSequentialGroup()
                        .addContainerGap(695, Short.MAX_VALUE)
                        .addComponent(jle)
                        .addGap(45, 45, 45))
                    .addGroup(jPanelTop2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTop2Layout.setVerticalGroup(
            jPanelTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTop2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jPanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jle))
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

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 12));
        jLabel1.setText(bundle.getString("MainWindow.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jButton2.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton2.setText(bundle.getString("MainWindow.jButton2.text")); // NOI18N
        jButton2.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton3.setText(bundle.getString("MainWindow.jButton3.text")); // NOI18N
        jButton3.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 12));
        jLabel2.setText(bundle.getString("MainWindow.jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jSeparator2.setName("jSeparator2"); // NOI18N

        jButton5.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton5.setText(bundle.getString("MainWindow.jButton5.text")); // NOI18N
        jButton5.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton5.setName("jButton5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton6.setText(bundle.getString("MainWindow.jButton6.text")); // NOI18N
        jButton6.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jSeparator3.setName("jSeparator3"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 12));
        jLabel4.setText(bundle.getString("MainWindow.jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jButton7.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton7.setText(bundle.getString("MainWindow.jButton7.text")); // NOI18N
        jButton7.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton8.setText(bundle.getString("MainWindow.jButton8.text")); // NOI18N
        jButton8.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton8.setName("jButton8"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jSeparator4.setName("jSeparator4"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 12));
        jLabel5.setText(bundle.getString("MainWindow.jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jButton10.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton10.setText(bundle.getString("MainWindow.jButton10.text")); // NOI18N
        jButton10.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton10.setName("jButton10"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton11.setText(bundle.getString("MainWindow.jButton11.text")); // NOI18N
        jButton11.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton11.setName("jButton11"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jSeparator5.setName("jSeparator5"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 3, 12));
        jLabel6.setText(bundle.getString("MainWindow.jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jButton12.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton12.setText(bundle.getString("MainWindow.jButton12.text")); // NOI18N
        jButton12.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton12.setName("jButton12"); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton13.setText(bundle.getString("MainWindow.jButton13.text")); // NOI18N
        jButton13.setMinimumSize(new java.awt.Dimension(0, 0));
        jButton13.setName("jButton13"); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addContainerGap(81, Short.MAX_VALUE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
            .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelContainerBottomLayout = new javax.swing.GroupLayout(jPanelContainerBottom);
        jPanelContainerBottom.setLayout(jPanelContainerBottomLayout);
        jPanelContainerBottomLayout.setHorizontalGroup(
            jPanelContainerBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerBottomLayout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
        );
        jPanelContainerBottomLayout.setVerticalGroup(
            jPanelContainerBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
   
    showFirstCard(   new JPUsuariosCadastrados());
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
     
    showFirstCard(  new JPCadastrarEmprestimo());
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
    
    showFirstCard(  new JPConsultarEmprestimo());
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
// TODO add your handling code here:
    
    showFirstCard(  new JPImportarFatura());
}//GEN-LAST:event_jButton10ActionPerformed

private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
// TODO add your handling code here:
     
    showFirstCard(  new JPConsultarFatura());
}//GEN-LAST:event_jButton11ActionPerformed

private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
// TODO add your handling code here:
     
    showFirstCard(  new JPCriarConta());
}//GEN-LAST:event_jButton12ActionPerformed

private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
// TODO add your handling code here:
    
    showFirstCard(  new JPConsultarConta());
}//GEN-LAST:event_jButton13ActionPerformed

private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
showFirstCard(  new JPCadastrarUsuario());
}//GEN-LAST:event_jButton2MouseClicked

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
showFirstCard(  new JPCadastrarNumeroTelefonico());
}//GEN-LAST:event_jButton7ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
showFirstCard(  new JPConsultarLigacao());
}//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    //<editor-fold defaultstate="collapsed" desc=" Swing editor ">
    private void refreshWindow()
    {
        jle.setVisible(false);
        jle.setVisible(true);
    }//</editor-fold>
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
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelUsuarioEmail;
    private javax.swing.JLabel jLabelUsuarioNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContainerBottom;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelMiddle;
    private javax.swing.JPanel jPanelTop2;
    private javax.swing.JScrollPane jScrollPanelContent;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel jle;
    // End of variables declaration//GEN-END:variables

    public void onReturnFromOtherWindow(Object returnedObject) {
       //do nothing
    }

    public void updateComponents() {
            ResourceBundle bundle = ResourceBundle.getBundle("I18n/Bundle");
        
        
            jLabel1.setText(bundle.getString("MainWindow.jLabel1.text"));
            jLabel2.setText(bundle.getString("MainWindow.jLabel2.text"));
            jLabel4.setText(bundle.getString("MainWindow.jLabel4.text"));
            jLabel5.setText(bundle.getString("MainWindow.jLabel5.text"));
            jLabel6.setText(bundle.getString("MainWindow.jLabel6.text"));
            jLabelUsuarioNome.setText(bundle.getString("MainWindow.jLabelUsuarioNome.text"));
            jLabelUsuarioEmail.setText(bundle.getString("MainWindow.jLabelUsuarioEmail.text"));            
            jButton1.setText(bundle.getString("MainWindow.jButton1.text"));
            jButton2.setText(bundle.getString("MainWindow.jButton2.text"));
            jButton3.setText(bundle.getString("MainWindow.jButton3.text"));
            jButton5.setText(bundle.getString("MainWindow.jButton5.text"));
            jButton6.setText(bundle.getString("MainWindow.jButton6.text"));
            jButton7.setText(bundle.getString("MainWindow.jButton7.text"));
            jButton8.setText(bundle.getString("MainWindow.jButton8.text"));
            jButton10.setText(bundle.getString("MainWindow.jButton10.text"));
            jButton11.setText(bundle.getString("MainWindow.jButton11.text"));
            jButton12.setText(bundle.getString("MainWindow.jButton12.text"));
            jButton13.setText(bundle.getString("MainWindow.jButton13.text"));


/*
            jLabel4.setText(bundle.getString("JPLogin.jLabel4.text"));
            jLabel5.setText(bundle.getString("JPLogin.jLabel5.text"));
            jButton2.setText(bundle.getString("JPLogin.jButton2.text"));
            jLabel7.setText(bundle.getString("JPLogin.jLabel7.text")); // NOI18N
            jLabel8.setText(bundle.getString("JPLogin.jLabel8.text"));
            jLabel9.setText(bundle.getString("JPLogin.jLabel9.text"));*/
    }

    

}
