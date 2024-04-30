/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Produto;
import service.ProdutoService;
import utilities.Utilities;
import view.busca.BuscaProduto;
import view.cadastro.CadastroProduto;

/**
 *
 * @author janai
 */
public class ControllerBuscaProduto implements ActionListener{
    
    BuscaProduto buscaProduto;
    public static String colunaFiltro;
    
    public ControllerBuscaProduto(BuscaProduto buscaProduto) {
        this.buscaProduto = buscaProduto;

        this.buscaProduto.getjButtonCarregar().addActionListener(this);
        this.buscaProduto.getjButtonFiltrar().addActionListener(this);
        this.buscaProduto.getjButtonSair().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaProduto.getjButtonSair()) {
            
            this.buscaProduto.dispose();
        }
    else if(e.getSource() == this.buscaProduto.getjButtonCarregar()){
            ControllerCadastroProduto.codigo = (int) this.buscaProduto.getjTableDados().getValueAt(this.buscaProduto.getjTableDados().getSelectedRow(), 0);
            //ProdutoService.carregar();

            this.buscaProduto.dispose();
        }
    else if (e.getSource() == this.buscaProduto.getjButtonFiltrar()){
            if (! this.buscaProduto.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Produto> listaProduto = new ArrayList<Produto>();

                if (this.buscaProduto.getjCBFiltro().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaProduto.add(service.ProdutoService.carregar(Integer.parseInt(this.buscaProduto.getjTFFitrar().getText())));
                } 
                else {
                    listaProduto = ProdutoService.carregar(this.buscaProduto.getjCBFiltro().getSelectedItem().toString().toLowerCase(), this.buscaProduto.getjTFFitrar().getText());
                }
            
                DefaultTableModel tabelaDados = (DefaultTableModel) this.buscaProduto.getjTableDados().getModel();
                tabelaDados.setRowCount(0);
                for (Produto produtoAtual : listaProduto){
                    tabelaDados.addRow(new Object[] {produtoAtual.getId(), 
                                                produtoAtual.getStatus(),
                                                produtoAtual.getCodigobarra(),
                                                produtoAtual.getDescricao(),
                                                produtoAtual.getValor()
                    });
                }
        }
            else {
                JOptionPane.showMessageDialog(null, "Atenção!\nOpção de Filtro Vazia...");
                this.buscaProduto.getjTFFitrar().requestFocus();
            }
    }
}

    
}
