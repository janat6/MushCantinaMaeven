/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDV.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.ItemVenda;
import model.bo.Produto;
import model.bo.Venda;
import view.pdv.PDV;
import controller_busca.ControllerBuscaCarteirinha;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.bo.Carteirinha;
import model.bo.Cliente;
import model.bo.Funcionario;
import service.ItemVendaService;
import service.ProdutoService;
import service.VendaService;
import view.busca.BuscaCarteirinha;

/**
 *
 * @author eduar
 */
public class ControllerPontoDeVenda implements ActionListener {

    PDV pontoDeVendaView;
    public static int codigo = 0;
    float resultado = 0;

    public ControllerPontoDeVenda(PDV pontoDeVendaView) {
        this.pontoDeVendaView = pontoDeVendaView;
        //this.pontoDeVendaView.getJMenuBar().setVisible(false);

        this.pontoDeVendaView.getPassaInfo().addActionListener(this);
        this.pontoDeVendaView.getCancelaItem().addActionListener(this);
        this.pontoDeVendaView.getFechaCaixa().addActionListener(this);
        this.pontoDeVendaView.getLerCodigoBarra().addActionListener(this);
        this.pontoDeVendaView.getClienteButton3().addActionListener(this);
        this.pontoDeVendaView.getFinalizaVenda().addActionListener(this);

        utilities.Utilities.ativa(true, this.pontoDeVendaView.getjPanelMeio());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tabela = (DefaultTableModel) this.pontoDeVendaView.getTabelaListaProduto().getModel();
        if (e.getSource() == this.pontoDeVendaView.getFinalizaVenda()) {

            Date dataAtual = new Date();
            SimpleDateFormat dataFormato = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat horaFormato = new SimpleDateFormat("HH:mm:ss");
            String dataFormatada = dataFormato.format(dataAtual);
            String horaFormatada = horaFormato.format(dataAtual);

            this.pontoDeVendaView.getDataDeEmissao().setText(dataFormatada);
            this.pontoDeVendaView.getHoraDeEmissao().setText(horaFormatada);

            if (this.pontoDeVendaView.getTabelaListaProduto().getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Não é possivel finalizar a venda!");

            } else {

                Venda venda = new Venda();
                ItemVenda itemVenda = new ItemVenda();
                Funcionario funcionario = new Funcionario();
                Produto produto = new Produto();
                Carteirinha carteirinha = new Carteirinha();

                
                
                venda.setFuncionario(funcionario);
                venda.setCarteirinha(carteirinha);
                
                itemVenda.setProduto(produto);
                itemVenda.setVenda(venda);
                
                venda.setObservacao(this.pontoDeVendaView.getObservacao3().getText().toString().trim());

                if (this.pontoDeVendaView.getStatus().getSelectedIndex() == 0) {
                    venda.setStatus(this.pontoDeVendaView.getStatus().getSelectedItem().toString().replace("[V] Venda", "V").trim());
                } else {
                    venda.setStatus(this.pontoDeVendaView.getStatus().getSelectedItem().toString().replace("[C] Cancelado", "C").trim());
                }

                venda.getFuncionario().setId(Integer.parseInt(this.pontoDeVendaView.getIdFuncionario().getText().trim()));
                venda.getCarteirinha().setId(Integer.parseInt(this.pontoDeVendaView.getIdCliente3().getText().trim()));
                venda.setDataVenda(this.pontoDeVendaView.getDataDeEmissao().getText().trim());
                venda.setHoraVenda(this.pontoDeVendaView.getHoraDeEmissao().getText().trim());
                venda.setValorDesconto(String.format("%.2f", Float.valueOf(this.pontoDeVendaView.getTotal().getText().trim())));
               
                VendaService.adicionar(venda);
                
                this.pontoDeVendaView.getIDVenda().setText(Integer.toString(venda.getId()));
                
                
                for (int i = 0; i < tabela.getRowCount(); i++) {
                    
                    itemVenda.setQtdProduto(String.valueOf(Float.valueOf(tabela.getValueAt(i, 3).toString())));
                    itemVenda.setValorUnitario(String.valueOf(Float.parseFloat(tabela.getValueAt(i, 2).toString())));
                    
                    
                    itemVenda.setProduto(ProdutoService.carregar(Integer.parseInt(tabela.getValueAt(i, 0).toString())));
                     
                    itemVenda.setStatus((String) tabela.getValueAt(i, 4));
                    
                    
                    itemVenda.setVenda(venda);
                   // itemVenda.setId(Integer.parseInt(this.pontoDeVendaView.getIDVenda().getText().trim().toString()));
                    
                   // itemVenda.getVenda().getCarteirinha().setId(Integer.parseInt((this.pontoDeVendaView.getIdCliente().getText())));
                   
                    
                    ItemVendaService.adicionar(itemVenda);
                    
                }
                
              
                
                
                JOptionPane.showMessageDialog(pontoDeVendaView, itemVenda);
                
                
            }
            
             utilities.Utilities.ativa(true, this.pontoDeVendaView.getjPanelFim());
             utilities.Utilities.limpaComponentes(false, this.pontoDeVendaView.getjPanelMeio());
     
        } else if (e.getSource() == this.pontoDeVendaView.getLerCodigoBarra()) {

            if (this.pontoDeVendaView.getCodigoBarra().getText().equalsIgnoreCase("")) {

                JOptionPane.showMessageDialog(null, "Insira um codigo de barra, para adicionar um produto !");

            } else {

                if (this.pontoDeVendaView.getCodigoBarra().getText().length() < 13) {
                    JOptionPane.showMessageDialog(null, "Codigo de Barras invalido!");
                } else if (this.pontoDeVendaView.getCodigoBarra().getText().length() == 13) {
                    this.pontoDeVendaView.getQuantidade().setText("1");

                    Produto produto = new Produto();
                    produto = ProdutoService.carregarProduto(this.pontoDeVendaView.getCodigoBarra().getText().trim());
                    JOptionPane.showMessageDialog(this.pontoDeVendaView,produto.getValor());

                    this.pontoDeVendaView.getProdutoNome1().setText(produto.getDescricao());
                    this.pontoDeVendaView.getValorUnitario().setText(Float.toString(produto.getValor()));

                } else {
                    int tamanho = this.pontoDeVendaView.getCodigoBarra().getText().length(); //PEGA O TAMANHO DO CODIGO DE BARRA

                    //  String[] teste = this.pontoDeVendaView.getCodigoBarra().getText().split("x", 3);
                    String quantidade = this.pontoDeVendaView.getCodigoBarra().getText().substring(0, tamanho - 13);

                    this.pontoDeVendaView.getQuantidade().setText(quantidade.replace("x", ""));

                    Produto produto = new Produto();
                    produto = ProdutoService.carregarProduto(this.pontoDeVendaView.getCodigoBarra().getText().substring(tamanho - 13).trim());
                    
                    this.pontoDeVendaView.getProdutoNome1().setText(produto.getDescricao());
                    this.pontoDeVendaView.getValorUnitario().setText(Float.toString(produto.getValor()));

                }

            }

        } else if (e.getSource() == this.pontoDeVendaView.getPassaInfo()) {

            if (this.pontoDeVendaView.getProdutoNome1().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Nenhum item selecionado!");

            } else {
                int tamanho = this.pontoDeVendaView.getCodigoBarra().getText().length();
                Produto produto = new Produto();
                produto = ProdutoService.carregarProduto(this.pontoDeVendaView.getCodigoBarra().getText().substring(tamanho - 13).trim());

                tabela.addRow(new Object[]{
                    produto.getId(),
                    produto.getDescricao(),
                    produto.getValor(),
                    this.pontoDeVendaView.getQuantidade().getText(),
                    "A"

                });

                utilities.Utilities.limpaComponentes(true, this.pontoDeVendaView.getjPanelMeio());

                this.pontoDeVendaView.getCodigoBarra().setEnabled(true);
                this.pontoDeVendaView.getProdutoNome1().setEnabled(false);
                this.pontoDeVendaView.getNomeCliente3().setEnabled(false);
                this.pontoDeVendaView.getIdCliente3().setEnabled(false);
                this.pontoDeVendaView.getHoraDeEmissao().setEnabled(false);
                this.pontoDeVendaView.getDataDeEmissao().setEnabled(false);
                this.pontoDeVendaView.getQuantidade().setEnabled(false);
                this.pontoDeVendaView.getValorUnitario().setEnabled(false);
                this.pontoDeVendaView.getTotal().setEnabled(false);
                this.pontoDeVendaView.getIdFuncionario().setEnabled(false);
                this.pontoDeVendaView.getIDVenda().setEnabled(false);

                if (this.pontoDeVendaView.getTabelaListaProduto().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(pontoDeVendaView, "Tabela nula");
                }else{

                    float resultado = 0;

                    for (int i = 0; i < tabela.getRowCount(); i++) {
                        // Obter o status da coluna 4 e o valor da coluna 2
                        Object statusObj = tabela.getValueAt(i, 4);
                        Object valorObj = tabela.getValueAt(i, 2);
                        Object qtdObj = tabela.getValueAt(i, 3);
                        // Verificar se os objetos são do tipo esperado antes de fazer o cast
                        if (statusObj instanceof String) {
                            String status = (String) statusObj;
                            
                            //ItemVenda itemVenda = new ItemVenda();
                            //itemVenda.setQtdProduto((Float.valueOf((String)tabela.getValueAt(i, 3))));
                            //itemVenda.setValorUnitario( Float.valueOf((String)tabela.getValueAt(i, 2)));
                            //itemVenda.setStatus((String) tabela.getValueAt(i, 4));
                            
                            //ItemVendaService.adicionar(itemVenda);

                            // Tenta converter o valor diretamente para float
                            try {
                                int quantidade = Integer.parseInt(qtdObj.toString());
                                float valor = Float.parseFloat(valorObj.toString());

                                valor = valor * quantidade;
                                // Verificar o status e calcular o valor
                                if ("A".equalsIgnoreCase(status)) {

                                    resultado += valor;
                                } else if ("C".equalsIgnoreCase(status)) {
                                    resultado -= valor;
                                }
                            } catch (NumberFormatException ea) {
                                JOptionPane.showMessageDialog(null, "Erro ao converter valor para float.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Tipo de status não é String.");
                        }
                         this.pontoDeVendaView.getTotal().setText(String.valueOf(resultado));
                    }

                }
            }
            

        } else if (e.getSource()
                == this.pontoDeVendaView.getCancelaItem()) {

            if (tabela.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Não é possivel cancelar itens, a tabela esta vazia!!!");
            } else {
                tabela.setValueAt('C', this.pontoDeVendaView.getTabelaListaProduto().getSelectedRow(), 4);

                for (int i = 0; i < tabela.getRowCount(); i++) {
                    // Obter o status da coluna 4 e o valor da coluna 2
                    Object qtdObj = tabela.getValueAt(i, 3);
                    Object statusObj = tabela.getValueAt(i, 4);
                    Object valorObj = tabela.getValueAt(i, 2);
                    // Verificar se os objetos são do tipo esperado antes de fazer o cast
                    if (statusObj instanceof String) {
                        String status = (String) statusObj;
                        // Tenta converter o valor diretamente para float
                        try {
                            int quantidade = Integer.parseInt(qtdObj.toString());
                            float valor = Float.parseFloat(valorObj.toString());
                            // Verificar o status e calcular o valor

                            valor = quantidade * valor;

                            if ("A".equalsIgnoreCase(status)) {
                                resultado += valor;
                            } else if ("C".equalsIgnoreCase(status)) {
                                resultado -= valor;
                            }
                        } catch (NumberFormatException ea) {
                            JOptionPane.showMessageDialog(null, "Erro ao converter valor para float.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Tipo de status não é String.");
                    }
                }

                this.pontoDeVendaView.getTotal().setText(String.valueOf(resultado));

                JOptionPane.showMessageDialog(null, "Produto Cancelado!");
            }

        } else if (e.getSource()
                == this.pontoDeVendaView.getFechaCaixa()) {

           int result = JOptionPane.showConfirmDialog(null, "Vai fechar o caixa?");
            
            if(result == JOptionPane.YES_OPTION){
                this.pontoDeVendaView.dispose();
            }
            
            
            

        } else if (e.getSource()
                == this.pontoDeVendaView.getClienteButton3()) {
           
            BuscaCarteirinha buscaCarteirinha = new BuscaCarteirinha(null, true);
            ControllerBuscaCarteirinha controllerBuscaCarteirinha = new ControllerBuscaCarteirinha(buscaCarteirinha);
            buscaCarteirinha.setVisible(true);
            
            this.pontoDeVendaView.getNomeCliente3().setText(controllerBuscaCarteirinha.nomeClienteCarteirinha);
            this.pontoDeVendaView.getIdCliente3().setText(Integer.toString(controllerBuscaCarteirinha.idCarteirinha));

        }

    }

}
