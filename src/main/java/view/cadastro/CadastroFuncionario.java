/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.cadastro;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author janai
 */
public class CadastroFuncionario extends javax.swing.JDialog {

    /**
     * Creates new form CadastroFuncionarioD
     */
    public CadastroFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
    }

    public JButton getjBBuscar() {
        return jBBuscar;
    }

    public void setjBBuscar(JButton jBBuscar) {
        this.jBBuscar = jBBuscar;
    }

    public JButton getjBCancelar() {
        return jBCancelar;
    }

    public void setjBCancelar(JButton jBCancelar) {
        this.jBCancelar = jBCancelar;
    }

    public JButton getjBEndereco() {
        return jBEndereco;
    }

    public void setjBEndereco(JButton jBEndereco) {
        this.jBEndereco = jBEndereco;
    }

    public JButton getjBGravar() {
        return jBGravar;
    }

    public void setjBGravar(JButton jBGravar) {
        this.jBGravar = jBGravar;
    }

    public JButton getjBNovo() {
        return jBNovo;
    }

    public void setjBNovo(JButton jBNovo) {
        this.jBNovo = jBNovo;
    }

    public JButton getjBSair() {
        return jBSair;
    }

    public void setjBSair(JButton jBSair) {
        this.jBSair = jBSair;
    }

    public JFormattedTextField getjFTFCep() {
        return jFTFCep;
    }

    public void setjFTFCep(JFormattedTextField jFTFCep) {
        this.jFTFCep = jFTFCep;
    }

    public JFormattedTextField getjFTFFone1() {
        return jFTFFone1;
    }

    public JTextField getjTFUsuario() {
        return jTFUsuario;
    }

    public void setjTFUsuario(JTextField jTFUsuario) {
        this.jTFUsuario = jTFUsuario;
    }

    public void setjFTFFone1(JFormattedTextField jFTFFone1) {
        this.jFTFFone1 = jFTFFone1;
    }

    public JFormattedTextField getjFTFFone2() {
        return jFTFFone2;
    }

    public void setjFTFFone2(JFormattedTextField jFTFFone2) {
        this.jFTFFone2 = jFTFFone2;
    }

    public JFormattedTextField getjFTFcpf() {
        return jFTFcpf;
    }

    public void setjFTFcpf(JFormattedTextField jFTFcpf) {
        this.jFTFcpf = jFTFcpf;
    }

    public JPanel getjPanBotoes() {
        return jPanBotoes;
    }

    public void setjPanBotoes(JPanel jPanBotoes) {
        this.jPanBotoes = jPanBotoes;
    }

    public JPanel getjPanDados() {
        return jPanDados;
    }

    public void setjPanDados(JPanel jPanDados) {
        this.jPanDados = jPanDados;
    }

    public JPanel getjPanTitulo() {
        return jPanTitulo;
    }

    public void setjPanTitulo(JPanel jPanTitulo) {
        this.jPanTitulo = jPanTitulo;
    }

    public JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    public void setjPasswordField1(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public JTextField getjTFComplemento() {
        return jTFComplemento;
    }

    public void setjTFComplemento(JTextField jTFComplemento) {
        this.jTFComplemento = jTFComplemento;
    }

    public JTextField getjTFEmail() {
        return jTFEmail;
    }

    public void setjTFEmail(JTextField jTFEmail) {
        this.jTFEmail = jTFEmail;
    }

    public JTextField getjTFId() {
        return jTFId;
    }

    public void setjTFId(JTextField jTFId) {
        this.jTFId = jTFId;
    }

    public JTextField getjTFLogradouro() {
        return jTFLogradouro;
    }

    public void setjTFLogradouro(JTextField jTFLogradouro) {
        this.jTFLogradouro = jTFLogradouro;
    }

    public JTextField getjTFMatricula() {
        return jTFUsuario;
    }

    public void setjTFMatricula(JTextField jTFMatricula) {
        this.jTFUsuario = jTFMatricula;
    }

    public JTextField getjTFNome() {
        return jTFNome;
    }

    public void setjTFNome(JTextField jTFNome) {
        this.jTFNome = jTFNome;
    }

    public JComboBox<String> getjComboBoxStatus1() {
        return jComboBoxStatus1;
    }

    public void setjComboBoxStatus1(JComboBox<String> jComboBoxStatus1) {
        this.jComboBoxStatus1 = jComboBoxStatus1;
    }

    public JTextField getjTFbairro() {
        return jTFbairro;
    }

    public void setjTFbairro(JTextField jTFbairro) {
        this.jTFbairro = jTFbairro;
    }

    public JTextField getjTFcidade() {
        return jTFcidade;
    }

    public void setjTFcidade(JTextField jTFcidade) {
        this.jTFcidade = jTFcidade;
    }

    public JTextField getjTFrg() {
        return jTFrg;
    }

    public void setjTFrg(JTextField jTFrg) {
        this.jTFrg = jTFrg;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanTitulo = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jPanDados = new javax.swing.JPanel();
        jLId = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jTFUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFComplemento = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jFTFFone1 = new javax.swing.JFormattedTextField();
        jFTFFone2 = new javax.swing.JFormattedTextField();
        jBEndereco = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jFTFcpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFrg = new javax.swing.JTextField();
        jTFId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jFTFCep = new javax.swing.JFormattedTextField();
        jTFLogradouro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFcidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTFbairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxStatus1 = new javax.swing.JComboBox<>();
        jPanBotoes = new javax.swing.JPanel();
        jBNovo = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBGravar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanTitulo.setBackground(new java.awt.Color(235, 158, 147));
        jPanTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanTitulo.setForeground(new java.awt.Color(153, 255, 0));

        jLTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("Cadastro Funcionário");

        javax.swing.GroupLayout jPanTituloLayout = new javax.swing.GroupLayout(jPanTitulo);
        jPanTitulo.setLayout(jPanTituloLayout);
        jPanTituloLayout.setHorizontalGroup(
            jPanTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanTituloLayout.setVerticalGroup(
            jPanTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        getContentPane().add(jPanTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 40));

        jPanDados.setBackground(new java.awt.Color(255, 194, 185));
        jPanDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanDados.setEnabled(false);
        jPanDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLId.setText("ID");
        jPanDados.add(jLId, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 22, -1, -1));
        jPanDados.add(jTFNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 107, 264, -1));
        jPanDados.add(jTFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 42, 110, 30));

        jLabel1.setText("Nome");
        jPanDados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 85, 41, -1));

        jLabel4.setText("Usuário");
        jPanDados.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 68, -1));

        jLabel5.setText("Senha");
        jPanDados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel6.setText("Status");
        jPanDados.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 22, 41, -1));
        jPanDados.add(jTFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 250, -1));

        jLabel7.setText("Email");
        jPanDados.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 41, -1));

        jLabel8.setText("Telefone 1");
        jPanDados.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel9.setText("Telefone 2");
        jPanDados.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jLabel10.setText("Complemento");
        jPanDados.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 86, -1));
        jPanDados.add(jTFComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 150, -1));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanDados.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 110, 30));

        try {
            jFTFFone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFFone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFFone1ActionPerformed(evt);
            }
        });
        jPanDados.add(jFTFFone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 110, -1));

        try {
            jFTFFone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFFone2.setText("");
        jPanDados.add(jFTFFone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 110, -1));

        jBEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Bottom.png"))); // NOI18N
        jBEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnderecoActionPerformed(evt);
            }
        });
        jPanDados.add(jBEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 70, -1));

        jLabel11.setText("Endereço");
        jPanDados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        try {
            jFTFcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanDados.add(jFTFcpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 118, -1));

        jLabel2.setText("CPF");
        jPanDados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel3.setText("RG");
        jPanDados.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));
        jPanDados.add(jTFrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 119, -1));
        jPanDados.add(jTFId, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 44, 90, -1));

        jLabel18.setText("CEP");
        jPanDados.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        try {
            jFTFCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanDados.add(jFTFCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 100, -1));
        jPanDados.add(jTFLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 370, -1));

        jLabel12.setText("Logradouro");
        jPanDados.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 86, -1));

        jTFcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFcidadeActionPerformed(evt);
            }
        });
        jPanDados.add(jTFcidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 140, -1));

        jLabel14.setText("Cidade");
        jPanDados.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 86, -1));
        jPanDados.add(jTFbairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 150, -1));

        jLabel15.setText("Bairro");
        jPanDados.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 86, -1));

        jLabel13.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("__________________________________________________");
        jPanDados.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 640, 30));

        jComboBoxStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        jComboBoxStatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatus1ActionPerformed(evt);
            }
        });
        jPanDados.add(jComboBoxStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 44, 110, -1));

        getContentPane().add(jPanDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 630, 360));

        jPanBotoes.setBackground(new java.awt.Color(235, 158, 147));
        jPanBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBNovo.setBackground(new java.awt.Color(255, 194, 185));
        jBNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Create.png"))); // NOI18N
        jBNovo.setText("Novo");
        jBNovo.setActionCommand("0");
        jBNovo.setPreferredSize(new java.awt.Dimension(110, 35));

        jBCancelar.setBackground(new java.awt.Color(255, 194, 185));
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Cancel.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.setActionCommand("1");
        jBCancelar.setEnabled(false);
        jBCancelar.setPreferredSize(new java.awt.Dimension(110, 35));

        jBGravar.setBackground(new java.awt.Color(255, 194, 185));
        jBGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/OK.png"))); // NOI18N
        jBGravar.setText("Gravar");
        jBGravar.setActionCommand("1");
        jBGravar.setEnabled(false);
        jBGravar.setPreferredSize(new java.awt.Dimension(110, 35));

        jBBuscar.setBackground(new java.awt.Color(255, 194, 185));
        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Find.png"))); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.setActionCommand("0");
        jBBuscar.setPreferredSize(new java.awt.Dimension(110, 35));

        jBSair.setBackground(new java.awt.Color(255, 194, 185));
        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Exit.png"))); // NOI18N
        jBSair.setText("Sair");
        jBSair.setActionCommand("0");
        jBSair.setPreferredSize(new java.awt.Dimension(110, 35));

        javax.swing.GroupLayout jPanBotoesLayout = new javax.swing.GroupLayout(jPanBotoes);
        jPanBotoes.setLayout(jPanBotoesLayout);
        jPanBotoesLayout.setHorizontalGroup(
            jPanBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanBotoesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jBGravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanBotoesLayout.setVerticalGroup(
            jPanBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanBotoesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGravar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 630, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jFTFFone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFFone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFFone1ActionPerformed

    private void jBEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEnderecoActionPerformed

    private void jTFcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFcidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFcidadeActionPerformed

    private void jComboBoxStatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStatus1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroFuncionario dialog = new CadastroFuncionario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEndereco;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSair;
    private javax.swing.JComboBox<String> jComboBoxStatus1;
    private javax.swing.JFormattedTextField jFTFCep;
    private javax.swing.JFormattedTextField jFTFFone1;
    private javax.swing.JFormattedTextField jFTFFone2;
    private javax.swing.JFormattedTextField jFTFcpf;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanBotoes;
    private javax.swing.JPanel jPanDados;
    private javax.swing.JPanel jPanTitulo;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFLogradouro;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JTextField jTFbairro;
    private javax.swing.JTextField jTFcidade;
    private javax.swing.JTextField jTFrg;
    // End of variables declaration//GEN-END:variables
}
