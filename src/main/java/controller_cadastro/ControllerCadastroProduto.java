/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;


import controller_busca.ControllerBuscaProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Produto;
import service.ProdutoService;
import utilities.Utilities;
import view.busca.BuscaProduto;
import view.cadastro.CadastroProduto;


/**
 *
 * @author aluno
 */
public class ControllerCadastroProduto implements ActionListener {

    CadastroProduto cadastroProduto;
    public static int codigo;
    

    public ControllerCadastroProduto(CadastroProduto cadastroProduto) {
        this.cadastroProduto = cadastroProduto;

        this.cadastroProduto.getjBNovo().addActionListener(this);
        this.cadastroProduto.getjBBuscar().addActionListener(this);
        this.cadastroProduto.getjBGravar().addActionListener(this);
        this.cadastroProduto.getjBCancelar().addActionListener(this);
        this.cadastroProduto.getjBSair().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroProduto.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroProduto.getjPanDados());
    }

    @Override
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroProduto.getjBNovo()) {
            Utilities.ativa(false, this.cadastroProduto.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroProduto.getjPanDados());
            this.cadastroProduto.getjTFid().setEnabled(false);
        } 
        else if (e.getSource() == this.cadastroProduto.getjBBuscar()) {
            codigo = 0;
            
            BuscaProduto buscaProduto = new BuscaProduto(null, true);
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(buscaProduto);
            
            buscaProduto.setVisible(true);
            
             if (codigo != 0) {

                Produto produto = new Produto();
                produto = service.ProdutoService.carregar(codigo);
                
                utilities.Utilities.ativa(false, this.cadastroProduto.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroProduto.getjPanDados());
                
                this.cadastroProduto.getjTFid().setText(produto.getId() + "");
                this.cadastroProduto.getjComboBoxStatus().setSelectedItem(produto.getStatus() + "");
                this.cadastroProduto.getjTFcodigoBarras().setText(produto.getCodigobarra() + "");
                this.cadastroProduto.getjTFdescricao().setText(produto.getDescricao() + "");
                this.cadastroProduto.getjTFvalor().setText(produto.getValor() + "");
                this.cadastroProduto.getjTFid().setEnabled(false);
             }
             
            
        } 
        else if (e.getSource() == this.cadastroProduto.getjBCancelar()) {
            Utilities.ativa(true, this.cadastroProduto.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroProduto.getjPanDados());
        } 
        else if (e.getSource() == this.cadastroProduto.getjBGravar()) {
            if (this.cadastroProduto.getjComboBoxStatus().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um valor válido para o Status!");
            }
            else if(this.cadastroProduto.getjTFdescricao().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Descrição!");
            }
            else if(this.cadastroProduto.getjTFvalor().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Valor!");
            }
            else if (this.cadastroProduto.getjTFcodigoBarras().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Código de Barras!");
            }
            else {
                Produto produto = new Produto();
                produto.setStatus(this.cadastroProduto.getjComboBoxStatus().getSelectedItem().toString());
                produto.setDescricao(this.cadastroProduto.getjTFdescricao().getText().trim());
                produto.setCodigobarra(this.cadastroProduto.getjTFcodigoBarras().getText().trim());
                try {
                    String textoValor = this.cadastroProduto.getjTFvalor().getText().trim();
                    float valor = Float.parseFloat(textoValor);
                    produto.setValor(valor);
                } catch (NumberFormatException ex) {
                    System.err.println("Erro ao converter texto para float: " + ex.getMessage());
                }
            
            if(this.cadastroProduto.getjTFid().getText().trim().equalsIgnoreCase("")){
                ProdutoService.adicionar(produto);
            }
           
           else{
                produto.setId(Integer.parseInt(this.cadastroProduto.getjTFid().getText()));
                service.ProdutoService.atualizar(produto);
            }
            
            Utilities.ativa(true, this.cadastroProduto.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroProduto.getjPanDados());
        }  
            }
            
        else if (e.getSource() == this.cadastroProduto.getjBSair()) {
            
            this.cadastroProduto.dispose();
        }
    }
}