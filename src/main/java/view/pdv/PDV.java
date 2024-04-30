/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.pdv;

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class PDV extends javax.swing.JDialog {
    
    /**
     * Creates new form TemplateCadastro
     */
    public PDV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        utilities.Utilities.ativa(true, jPanelFim);
    }

    public JTextField getCodigoBarra() {
        return CodigoBarra;
    }

    public void setCodigoBarra(JTextField CodigoBarra) {
        this.CodigoBarra = CodigoBarra;
    }

    public JFormattedTextField getDataDeEmissao() {
        return DataDeEmissao;
    }

    public void setDataDeEmissao(JFormattedTextField DataDeEmissao) {
        this.DataDeEmissao = DataDeEmissao;
    }

    public JFormattedTextField getHoraDeEmissao() {
        return HoraDeEmissao;
    }

    public void setHoraDeEmissao(JFormattedTextField HoraDeEmissao) {
        this.HoraDeEmissao = HoraDeEmissao;
    }

  


    public JTable getTabelaListaProduto() {
        return TabelaListaProduto;
    }

    public void setTabelaListaProduto(JTable TabelaListaProduto) {
        this.TabelaListaProduto = TabelaListaProduto;
    }

    public JTextField getTotal() {
        return Total;
    }

    public void setTotal(JTextField Total) {
        this.Total = Total;
    }

    public JLabel getjLabelCodigoBarra() {
        return jLabelCodigoBarra;
    }

    public void setjLabelCodigoBarra(JLabel jLabelCodigoBarra) {
        this.jLabelCodigoBarra = jLabelCodigoBarra;
    }

    public JLabel getjLabelDataDeEmissao() {
        return jLabelDataDeEmissao;
    }

    public void setjLabelDataDeEmissao(JLabel jLabelDataDeEmissao) {
        this.jLabelDataDeEmissao = jLabelDataDeEmissao;
    }

    public JLabel getjLabelHoraDeEmissao() {
        return jLabelHoraDeEmissao;
    }

    public void setjLabelHoraDeEmissao(JLabel jLabelHoraDeEmissao) {
        this.jLabelHoraDeEmissao = jLabelHoraDeEmissao;
    }

   

    public JLabel getjLabelProduto() {
        return jLabelProduto;
    }

    public void setjLabelProduto(JLabel jLabelProduto) {
        this.jLabelProduto = jLabelProduto;
    }

    public JLabel getjLabelValorUnitario() {
        return jLabelValorUnitario;
    }

    public void setjLabelValorUnitario(JLabel jLabelValorUnitario) {
        this.jLabelValorUnitario = jLabelValorUnitario;
    }

    public JLabel getjLtitulo() {
        return jLtitulo;
    }

    public void setjLtitulo(JLabel jLtitulo) {
        this.jLtitulo = jLtitulo;
    }

    public JMenu getjMenu1() {
        return Comandos;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.Comandos = jMenu1;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPanel getjPanelFim() {
        return jPanelFim;
    }

    public void setjPanelFim(JPanel jPanelFim) {
        this.jPanelFim = jPanelFim;
    }

    public JPanel getjPanelMeio() {
        return jPanelMeio;
    }

    public void setjPanelMeio(JPanel jPanelMeio) {
        this.jPanelMeio = jPanelMeio;
    }

    public JPanel getjPanelTitulo() {
        return jPanelTitulo;
    }

    public void setjPanelTitulo(JPanel jPanelTitulo) {
        this.jPanelTitulo = jPanelTitulo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextField getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(JTextField valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public JMenu getComandos() {
        return Comandos;
    }

    public void setComandos(JMenu Comandos) {
        this.Comandos = Comandos;
    }

    public JMenuItem getFinalizaVenda() {
        return finalizaVenda;
    }

    public void setFinalizaVenda(JMenuItem finalizaVenda) {
        this.finalizaVenda = finalizaVenda;
    }

    public JComboBox<String> getStatus() {
        return Status;
    }

    public void setStatus(JComboBox<String> Status) {
        this.Status = Status;
    }


    

    public JMenuItem getCancelaItem() {
        return cancelaItem;
    }

    public void setCancelaItem(JMenuItem cancelaItem) {
        this.cancelaItem = cancelaItem;
    }

    public JMenuItem getFechaCaixa() {
        return fechaCaixa;
    }

    public void setFechaCaixa(JMenuItem fechaCaixa) {
        this.fechaCaixa = fechaCaixa;
    }

    public JMenuItem getLerCodigoBarra() {
        return lerCodigoBarra;
    }

    public void setLerCodigoBarra(JMenuItem lerCodigoBarra) {
        this.lerCodigoBarra = lerCodigoBarra;
    }

    public JMenuItem getPassaInfo() {
        return passaInfo;
    }

    public void setPassaInfo(JMenuItem passaInfo) {
        this.passaInfo = passaInfo;
    }

    public JTextField getProdutoNome1() {
        return ProdutoNome1;
    }

    public void setProdutoNome1(JTextField ProdutoNome1) {
        this.ProdutoNome1 = ProdutoNome1;
    }

    public JTextField getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(JTextField Quantidade) {
        this.Quantidade = Quantidade;
    }

    public JTextField getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(JTextField idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public JTextField getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(JTextField IDVenda) {
        this.IDVenda = IDVenda;
    }

    public JPanel getPanelInfo() {
        return PanelInfo;
    }

    public void setPanelInfo(JPanel PanelInfo) {
        this.PanelInfo = PanelInfo;
    }

    public JButton getClienteButton3() {
        return ClienteButton3;
    }

    public void setClienteButton3(JButton ClienteButton3) {
        this.ClienteButton3 = ClienteButton3;
    }

    public JLabel getJLabelDVenda() {
        return JLabelDVenda;
    }

    public void setJLabelDVenda(JLabel JLabelDVenda) {
        this.JLabelDVenda = JLabelDVenda;
    }

    public JLabel getJLabelDVenda1() {
        return JLabelDVenda1;
    }

    public void setJLabelDVenda1(JLabel JLabelDVenda1) {
        this.JLabelDVenda1 = JLabelDVenda1;
    }

    public JLabel getJLabelStatus() {
        return JLabelStatus;
    }

    public void setJLabelStatus(JLabel JLabelStatus) {
        this.JLabelStatus = JLabelStatus;
    }

    public JTextField getNomeCliente3() {
        return NomeCliente3;
    }

    public void setNomeCliente3(JTextField NomeCliente3) {
        this.NomeCliente3 = NomeCliente3;
    }

    public JTextField getObservacao3() {
        return Observacao3;
    }

    public void setObservacao3(JTextField Observacao3) {
        this.Observacao3 = Observacao3;
    }

    public JPanel getPanelCli3() {
        return PanelCli3;
    }

    public void setPanelCli3(JPanel PanelCli3) {
        this.PanelCli3 = PanelCli3;
    }

    public JTextField getIdCliente3() {
        return idCliente3;
    }

    public void setIdCliente3(JTextField idCliente3) {
        this.idCliente3 = idCliente3;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabelIdCliente6() {
        return jLabelIdCliente6;
    }

    public void setjLabelIdCliente6(JLabel jLabelIdCliente6) {
        this.jLabelIdCliente6 = jLabelIdCliente6;
    }

    public JLabel getjLabelIdCliente7() {
        return jLabelIdCliente7;
    }

    public void setjLabelIdCliente7(JLabel jLabelIdCliente7) {
        this.jLabelIdCliente7 = jLabelIdCliente7;
    }

    public JLabel getjLabelIdFuncionario() {
        return jLabelIdFuncionario;
    }

    public void setjLabelIdFuncionario(JLabel jLabelIdFuncionario) {
        this.jLabelIdFuncionario = jLabelIdFuncionario;
    }

    public JLabel getjLabelNomeCliente3() {
        return jLabelNomeCliente3;
    }

    public void setjLabelNomeCliente3(JLabel jLabelNomeCliente3) {
        this.jLabelNomeCliente3 = jLabelNomeCliente3;
    }

    public JLabel getjLabelObs3() {
        return jLabelObs3;
    }

    public void setjLabelObs3(JLabel jLabelObs3) {
        this.jLabelObs3 = jLabelObs3;
    }

    public JLabel getjLabelProduto1() {
        return jLabelProduto1;
    }

    public void setjLabelProduto1(JLabel jLabelProduto1) {
        this.jLabelProduto1 = jLabelProduto1;
    }

    
    
    
    

  
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLtitulo = new javax.swing.JLabel();
        jPanelMeio = new javax.swing.JPanel();
        jLabelCodigoBarra = new javax.swing.JLabel();
        CodigoBarra = new javax.swing.JTextField();
        jLabelProduto = new javax.swing.JLabel();
        Quantidade = new javax.swing.JTextField();
        valorUnitario = new javax.swing.JTextField();
        jLabelValorUnitario = new javax.swing.JLabel();
        ProdutoNome1 = new javax.swing.JTextField();
        jLabelProduto1 = new javax.swing.JLabel();
        Status = new javax.swing.JComboBox<>();
        JLabelStatus = new javax.swing.JLabel();
        jLabelDataDeEmissao = new javax.swing.JLabel();
        DataDeEmissao = new javax.swing.JFormattedTextField();
        jLabelHoraDeEmissao = new javax.swing.JLabel();
        HoraDeEmissao = new javax.swing.JFormattedTextField();
        PanelInfo = new javax.swing.JPanel();
        idFuncionario = new javax.swing.JTextField();
        JLabelDVenda = new javax.swing.JLabel();
        IDVenda = new javax.swing.JTextField();
        JLabelDVenda1 = new javax.swing.JLabel();
        jLabelIdFuncionario = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaListaProduto = new javax.swing.JTable();
        PanelCli3 = new javax.swing.JPanel();
        ClienteButton3 = new javax.swing.JButton();
        Observacao3 = new javax.swing.JTextField();
        idCliente3 = new javax.swing.JTextField();
        jLabelIdCliente6 = new javax.swing.JLabel();
        jLabelNomeCliente3 = new javax.swing.JLabel();
        jLabelObs3 = new javax.swing.JLabel();
        NomeCliente3 = new javax.swing.JTextField();
        jLabelIdCliente7 = new javax.swing.JLabel();
        jPanelFim = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Comandos = new javax.swing.JMenu();
        lerCodigoBarra = new javax.swing.JMenuItem();
        passaInfo = new javax.swing.JMenuItem();
        cancelaItem = new javax.swing.JMenuItem();
        finalizaVenda = new javax.swing.JMenuItem();
        fechaCaixa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        jPanelTitulo.setBackground(new java.awt.Color(235, 158, 147));
        jPanelTitulo.setForeground(new java.awt.Color(0, 102, 153));
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(394, 56));

        jLtitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLtitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLtitulo.setText("Ponto de Venda");
        jPanelTitulo.add(jLtitulo);

        jPanelMeio.setBackground(new java.awt.Color(255, 194, 185));
        jPanelMeio.setPreferredSize(new java.awt.Dimension(800, 530));
        jPanelMeio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCodigoBarra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelCodigoBarra.setText("Código de Barra");
        jPanelMeio.add(jLabelCodigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        CodigoBarra.setActionCommand("<none>");
        CodigoBarra.setAutoscrolls(false);
        CodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoBarraActionPerformed(evt);
            }
        });
        jPanelMeio.add(CodigoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 450, 40));

        jLabelProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelProduto.setText("Quantidade");
        jPanelMeio.add(jLabelProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        Quantidade.setActionCommand("1");
        Quantidade.setEnabled(false);
        Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantidadeActionPerformed(evt);
            }
        });
        jPanelMeio.add(Quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 80, 30));

        valorUnitario.setActionCommand("1");
        valorUnitario.setEnabled(false);
        valorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorUnitarioActionPerformed(evt);
            }
        });
        jPanelMeio.add(valorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 100, 30));

        jLabelValorUnitario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelValorUnitario.setText("Valor Unitario");
        jPanelMeio.add(jLabelValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        ProdutoNome1.setActionCommand("1");
        ProdutoNome1.setEnabled(false);
        jPanelMeio.add(ProdutoNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 210, 30));

        jLabelProduto1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelProduto1.setText("Produto");
        jPanelMeio.add(jLabelProduto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[V] Venda" }));
        Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusActionPerformed(evt);
            }
        });
        jPanelMeio.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 30));

        JLabelStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabelStatus.setText("Status");
        jPanelMeio.add(JLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabelDataDeEmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelDataDeEmissao.setText("Data de Emissão");
        jPanelMeio.add(jLabelDataDeEmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        try {
            DataDeEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        DataDeEmissao.setActionCommand("1");
        DataDeEmissao.setEnabled(false);
        DataDeEmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataDeEmissaoActionPerformed(evt);
            }
        });
        jPanelMeio.add(DataDeEmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 110, 30));

        jLabelHoraDeEmissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelHoraDeEmissao.setText("Hora de Emissão");
        jPanelMeio.add(jLabelHoraDeEmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 20));

        try {
            HoraDeEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        HoraDeEmissao.setActionCommand("1");
        HoraDeEmissao.setEnabled(false);
        HoraDeEmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoraDeEmissaoActionPerformed(evt);
            }
        });
        jPanelMeio.add(HoraDeEmissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 120, 30));

        PanelInfo.setBackground(new java.awt.Color(255, 194, 185));

        idFuncionario.setActionCommand("1");
        idFuncionario.setEnabled(false);
        idFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFuncionarioActionPerformed(evt);
            }
        });

        JLabelDVenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabelDVenda.setText("Total");

        IDVenda.setActionCommand("1");
        IDVenda.setEnabled(false);
        IDVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDVendaActionPerformed(evt);
            }
        });

        JLabelDVenda1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabelDVenda1.setText("ID Venda");

        jLabelIdFuncionario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelIdFuncionario.setText("ID Funcionario");

        Total.setActionCommand("1");
        Total.setEnabled(false);

        TabelaListaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Produto", "Valor", "Quantidade", "Status"
            }
        ));
        jScrollPane1.setViewportView(TabelaListaProduto);

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdFuncionario)
                            .addComponent(idFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLabelDVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLabelDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInfoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdFuncionario)
                    .addComponent(JLabelDVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabelDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(IDVenda)))
                    .addGroup(PanelInfoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Total))))
        );

        jPanelMeio.add(PanelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 0, 570, -1));

        PanelCli3.setBackground(new java.awt.Color(255, 194, 185));

        ClienteButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/Bottom.png"))); // NOI18N
        ClienteButton3.setActionCommand("0");
        ClienteButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ClienteButton3.setPreferredSize(new java.awt.Dimension(5, 19));
        ClienteButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ClienteButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteButtonActionPerformed(evt);
            }
        });

        Observacao3.setActionCommand("0");
        Observacao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObservacaoActionPerformed(evt);
            }
        });

        idCliente3.setActionCommand("1");
        idCliente3.setEnabled(false);

        jLabelIdCliente6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelIdCliente6.setText("ID Cliente");

        jLabelNomeCliente3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelNomeCliente3.setText("Nome Cliente");

        jLabelObs3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelObs3.setText("Observação");

        NomeCliente3.setActionCommand("1");
        NomeCliente3.setEnabled(false);

        jLabelIdCliente7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelIdCliente7.setText("Buscar");

        javax.swing.GroupLayout PanelCli3Layout = new javax.swing.GroupLayout(PanelCli3);
        PanelCli3.setLayout(PanelCli3Layout);
        PanelCli3Layout.setHorizontalGroup(
            PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCli3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCli3Layout.createSequentialGroup()
                        .addGroup(PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCli3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabelIdCliente7))
                            .addComponent(ClienteButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdCliente6)
                            .addComponent(idCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeCliente3)
                            .addComponent(NomeCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Observacao3)
                    .addGroup(PanelCli3Layout.createSequentialGroup()
                        .addComponent(jLabelObs3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelCli3Layout.setVerticalGroup(
            PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCli3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdCliente6)
                    .addComponent(jLabelIdCliente7)
                    .addComponent(jLabelNomeCliente3))
                .addGap(8, 8, 8)
                .addGroup(PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NomeCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ClienteButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabelObs3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Observacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        jPanelMeio.add(PanelCli3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 170));

        jPanelFim.setBackground(new java.awt.Color(235, 158, 147));
        jPanelFim.setForeground(new java.awt.Color(0, 102, 153));
        jPanelFim.setPreferredSize(new java.awt.Dimension(631, 55));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Adicionar Item (F1)   ");
        jLabel2.setToolTipText("");
        jPanelFim.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ler Código de Barra (F2)   ");
        jLabel1.setToolTipText("");
        jPanelFim.add(jLabel1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cancelar Item (F3)   ");
        jLabel3.setToolTipText("");
        jPanelFim.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Finalizar Venda (F4)   ");
        jLabel4.setToolTipText("");
        jPanelFim.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fechar Caixa (F5)");
        jLabel5.setToolTipText("");
        jPanelFim.add(jLabel5);

        jMenuBar1.setFocusable(false);

        Comandos.setBackground(new java.awt.Color(0, 102, 153));

        lerCodigoBarra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        lerCodigoBarra.setText("lerCodigoBarra");
        lerCodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lerCodigoBarraActionPerformed(evt);
            }
        });
        Comandos.add(lerCodigoBarra);

        passaInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        passaInfo.setText("passaInfo");
        Comandos.add(passaInfo);

        cancelaItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        cancelaItem.setText("cancelaItem");
        cancelaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaItemActionPerformed(evt);
            }
        });
        Comandos.add(cancelaItem);

        finalizaVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        finalizaVenda.setText("finalizaVenda");
        finalizaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaVendaActionPerformed(evt);
            }
        });
        Comandos.add(finalizaVenda);

        fechaCaixa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        fechaCaixa.setText("fechaCaixa");
        Comandos.add(fechaCaixa);

        jMenuBar1.add(Comandos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelMeio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMeio, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFim, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoBarraActionPerformed

    private void valorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorUnitarioActionPerformed

    private void lerCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lerCodigoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lerCodigoBarraActionPerformed

    private void QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantidadeActionPerformed

    private void cancelaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelaItemActionPerformed

    private void finalizaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizaVendaActionPerformed

    private void StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusActionPerformed

    private void DataDeEmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataDeEmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataDeEmissaoActionPerformed

    private void HoraDeEmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraDeEmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoraDeEmissaoActionPerformed

    private void IDVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDVendaActionPerformed

    private void idFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFuncionarioActionPerformed

    private void ObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObservacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObservacaoActionPerformed

    private void ClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteButtonActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_ClienteButtonActionPerformed

   


    
    
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
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PDV dialog = new PDV(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton ClienteButton3;
    private javax.swing.JTextField CodigoBarra;
    private javax.swing.JMenu Comandos;
    private javax.swing.JFormattedTextField DataDeEmissao;
    private javax.swing.JFormattedTextField HoraDeEmissao;
    private javax.swing.JTextField IDVenda;
    private javax.swing.JLabel JLabelDVenda;
    private javax.swing.JLabel JLabelDVenda1;
    private javax.swing.JLabel JLabelStatus;
    private javax.swing.JTextField NomeCliente3;
    private javax.swing.JTextField Observacao3;
    private javax.swing.JPanel PanelCli3;
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JTextField ProdutoNome1;
    private javax.swing.JTextField Quantidade;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JTable TabelaListaProduto;
    private javax.swing.JTextField Total;
    private javax.swing.JMenuItem cancelaItem;
    private javax.swing.JMenuItem fechaCaixa;
    private javax.swing.JMenuItem finalizaVenda;
    private javax.swing.JTextField idCliente3;
    private javax.swing.JTextField idFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCodigoBarra;
    private javax.swing.JLabel jLabelDataDeEmissao;
    private javax.swing.JLabel jLabelHoraDeEmissao;
    private javax.swing.JLabel jLabelIdCliente6;
    private javax.swing.JLabel jLabelIdCliente7;
    private javax.swing.JLabel jLabelIdFuncionario;
    private javax.swing.JLabel jLabelNomeCliente3;
    private javax.swing.JLabel jLabelObs3;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelProduto1;
    private javax.swing.JLabel jLabelValorUnitario;
    private javax.swing.JLabel jLtitulo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelFim;
    private javax.swing.JPanel jPanelMeio;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem lerCodigoBarra;
    private javax.swing.JMenuItem passaInfo;
    private javax.swing.JTextField valorUnitario;
    // End of variables declaration//GEN-END:variables
}
