/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroCliente;
import controller_cadastro.ControllerCadastroEndereco;
import controller_cadastro.ControllerCadastroFornecedor;
import controller_cadastro.ControllerCadastroFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Endereco;
import utilities.Utilities;
import view.busca.BuscaEndereco;
import view.cadastro.CadastroCliente;
import view.cadastro.CadastroEndereco;
import view.cadastro.CadastroFornecedor;
import view.cadastro.CadastroFuncionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import service.EnderecoService;


/**
 *
 * @author janai
 */
public class ControllerBuscaEndereco implements ActionListener{
    
    BuscaEndereco buscaEndereco;    
    //public static String colunaFiltro;
    public static String logradouroEndereco;
    public static String enderecoCEP;
    public static String bairroEndereco;
    public static String cidadeEndereco;


    public ControllerBuscaEndereco(BuscaEndereco buscaEndereco) {
        this.buscaEndereco = buscaEndereco;

        this.buscaEndereco.getjButtonCarregar().addActionListener(this);
        this.buscaEndereco.getjButtonFiltrar().addActionListener(this);
        this.buscaEndereco.getjButtonSair().addActionListener(this);
        this.buscaEndereco.getjCBFiltro().addActionListener(this);
        this.buscaEndereco.getjTFFitrar().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaEndereco.getjButtonSair()) {
            
            this.buscaEndereco.dispose();
        }
        
        
        if (e.getSource() == this.buscaEndereco.getjButtonFiltrar()) {
            if (! this.buscaEndereco.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Endereco> listaEnderecos = new ArrayList<Endereco>();

                if (this.buscaEndereco.getjCBFiltro().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaEnderecos.add(service.EnderecoService.carregar(Integer.parseInt(this.buscaEndereco.getjTFFitrar().getText())));
                } else if (this.buscaEndereco.getjCBFiltro().getSelectedItem().toString().equalsIgnoreCase("cidade")) {
                    listaEnderecos = service.EnderecoService.carregar("cidade.descricao", this.buscaEndereco.getjTFFitrar().getText());
                } else if (this.buscaEndereco.getjCBFiltro().getSelectedItem().toString().equalsIgnoreCase("bairro")) {
                    listaEnderecos = service.EnderecoService.carregar("bairro.descricao", this.buscaEndereco.getjTFFitrar().getText());
                } else {
                    listaEnderecos = service.EnderecoService.carregar(this.buscaEndereco.getjCBFiltro().getSelectedItem().toString().toLowerCase(), this.buscaEndereco.getjTFFitrar().getText());
                }

                //Criar um objeto do tipo TableModel
                DefaultTableModel tabela = (DefaultTableModel) this.buscaEndereco.getjTableDados().getModel();
                tabela.setRowCount(0);

                for (Endereco enderecoAtual : listaEnderecos) {
                    tabela.addRow(new Object[]{enderecoAtual.getId(),
                        enderecoAtual.getStatus(),
                        enderecoAtual.getCep(),
                        enderecoAtual.getLogradouro(),
                        enderecoAtual.getCidade().getDescricao(),
                        enderecoAtual.getBairro().getDescricao()});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Atenção!\nOpção de Filtro Vazia...");
                this.buscaEndereco.getjTFFitrar().requestFocus();
            }
        }
            /*
        
        else if (e.getSource() == this.buscaEndereco.getjButtonFiltrar()){

        if(this.buscaEndereco.getjTFFitrar().getText().trim().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Atenção!\nOpção de Filtro Vazia...");
        } else {
            List<Endereco> listaEndereco = new ArrayList<Endereco>();
            
            if (this.buscaEndereco.getjCBFiltro().getSelectedIndex() == 0) {
                    listaEndereco.add(service.EnderecoService.carregar(Integer.parseInt(this.buscaEndereco.getjTFFitrar().getText())));
                } else{
                    colunaFiltro = this.buscaEndereco.getjCBFiltro().getSelectedItem().toString().trim();
                    listaEndereco = EnderecoService.carregar(this.buscaEndereco.getjTFFitrar().getText().trim());
                    
            }
            
            DefaultTableModel tabela = (DefaultTableModel) this.buscaEndereco.getjTableDados().getModel();
            tabela.setRowCount(0);
            for (Endereco enderecoAtual : listaEndereco){
                tabela.addRow(new Object[] {enderecoAtual.getId(), 
                                            enderecoAtual.getStatus(),
                                            enderecoAtual.getCep(),
                                            enderecoAtual.getLogradouro(),
                                            enderecoAtual.getCidade().getDescricao(),
                                            enderecoAtual.getBairro().getDescricao()
                });
            }
    }
        }
    */
        else if(e.getSource() == this.buscaEndereco.getjButtonCarregar()){
            ControllerCadastroEndereco.codigo = (int) this.buscaEndereco.getjTableDados().getValueAt(this.buscaEndereco.getjTableDados().getSelectedRow(), 0);
            String logradouro = (String) this.buscaEndereco.getjTableDados().getValueAt(this.buscaEndereco.getjTableDados().getSelectedRow(), 3);
            enderecoCEP = (String) this.buscaEndereco.getjTableDados().getValueAt(this.buscaEndereco.getjTableDados().getSelectedRow(), 2);
            logradouroEndereco = logradouro;
            bairroEndereco = (String) this.buscaEndereco.getjTableDados().getValueAt(this.buscaEndereco.getjTableDados().getSelectedRow(), 5);
            cidadeEndereco = (String) this.buscaEndereco.getjTableDados().getValueAt(this.buscaEndereco.getjTableDados().getSelectedRow(), 4);
                    
            EnderecoService.carregar();
            this.buscaEndereco.dispose();
        }
    }
    
}
