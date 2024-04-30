/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static model.DAO.Persiste.fornecedorList;
import model.bo.Fornecedor;
import service.FornecedorService;
import utilities.Utilities;
import view.busca.BuscaFornecedor;
import view.cadastro.CadastroFornecedor;

/**
 *
 * @author janai
 */
public class ControllerBuscaFornecedor implements ActionListener{
    
    BuscaFornecedor buscaFornecedor;
    public static String colunaFiltro;
    
    public ControllerBuscaFornecedor(BuscaFornecedor buscaFornecedor) {
        this.buscaFornecedor = buscaFornecedor;

        this.buscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.buscaFornecedor.getjButtonFiltrar().addActionListener(this);
        this.buscaFornecedor.getjButtonSair().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaFornecedor.getjButtonSair()) {
            
            this.buscaFornecedor.dispose();
        }
        else if(e.getSource() == this.buscaFornecedor.getjButtonCarregar()){
            ControllerCadastroFornecedor.codigo = (int) this.buscaFornecedor.getjTableDados().getValueAt(this.buscaFornecedor.getjTableDados().getSelectedRow(), 0);
            FornecedorService.carregar();
            this.buscaFornecedor.dispose();
        }
        
        else if (e.getSource() == this.buscaFornecedor.getjButtonFiltrar()){            
            if (this.buscaFornecedor.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");

            } else {
                List<Fornecedor> listaFornecedor = new ArrayList<>();

                if (this.buscaFornecedor.getjCBFiltro().getSelectedIndex() == 0) {
                    listaFornecedor.add(FornecedorService.carregar(Integer.parseInt(this.buscaFornecedor.getjTFFitrar().getText())));
                } else {

                    colunaFiltro = this.buscaFornecedor.getjCBFiltro().getSelectedItem().toString().trim();
                    listaFornecedor = FornecedorService.carregar(colunaFiltro, this.buscaFornecedor.getjTFFitrar().getText().trim());
                }

            DefaultTableModel tabela = (DefaultTableModel) this.buscaFornecedor.getjTableDados().getModel();
            tabela.setRowCount(0);
            for (Fornecedor fornecedorAtual : listaFornecedor){
                tabela.addRow(new Object[] {fornecedorAtual.getId(), 
                                            fornecedorAtual.getStatus(),
                                            fornecedorAtual.getNome(),
                                            fornecedorAtual.getCnpj(),
                                            fornecedorAtual.getRazaoSocial(),
                                            fornecedorAtual.getInscricaoEstadual(),
                                            fornecedorAtual.getComplementoEndereco(),
                                            fornecedorAtual.getEndereco().getLogradouro(),
                                            fornecedorAtual.getEndereco().getBairro().getDescricao(),
                                            fornecedorAtual.getEndereco().getCidade().getDescricao(),
                                            fornecedorAtual.getEndereco().getCep(),
                                            fornecedorAtual.getEmail(),
                                            fornecedorAtual.getFone1(),
                                            fornecedorAtual.getFone2()
                });
            }
    }
    }
    
    
    }
}