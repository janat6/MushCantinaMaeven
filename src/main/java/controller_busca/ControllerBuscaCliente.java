/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Cliente;
import service.ClienteService;
import utilities.Utilities;
import view.busca.BuscaCliente;
import view.cadastro.CadastroCliente;

/**
 *
 * @author janai
 */
public class ControllerBuscaCliente implements ActionListener{
    
    BuscaCliente buscaCliente;
    public static String colunaFiltro;
    public String clienteNome;
    public String clienteCPF;
    public String clienteMatricula;
    public String clienteDataNascimento;
    
    public ControllerBuscaCliente(BuscaCliente buscaCliente) {
        this.buscaCliente = buscaCliente;

        this.buscaCliente.getjButtonCarregar().addActionListener(this);
        this.buscaCliente.getjButtonFiltrar().addActionListener(this);
        this.buscaCliente.getjButtonSair().addActionListener(this);
        this.buscaCliente.getjCBFiltro1().addActionListener(this);
        this.buscaCliente.getjTFFitrar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCliente.getjButtonSair()) {
            
            this.buscaCliente.dispose();
        }
        else if(e.getSource() == this.buscaCliente.getjButtonCarregar()){
            
            ControllerCadastroCliente.codigo = (int) this.buscaCliente.getjTableDados().getValueAt(this.buscaCliente.getjTableDados().getSelectedRow(), 0);
            clienteNome = (String) this.buscaCliente.getjTableDados().getValueAt(this.buscaCliente.getjTableDados().getSelectedRow(), 3);
            clienteCPF = (String) this.buscaCliente.getjTableDados().getValueAt(this.buscaCliente.getjTableDados().getSelectedRow(), 4);
            clienteMatricula = (String) this.buscaCliente.getjTableDados().getValueAt(this.buscaCliente.getjTableDados().getSelectedRow(), 2);
            clienteDataNascimento = (String) this.buscaCliente.getjTableDados().getValueAt(this.buscaCliente.getjTableDados().getSelectedRow(), 5);

            ClienteService.carregar();
            this.buscaCliente.dispose();
        }
        else if (e.getSource() == this.buscaCliente.getjButtonFiltrar()){
            
            if (this.buscaCliente.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");

            }
             else {
                List<Cliente> listaCliente = new ArrayList<>();

                if (this.buscaCliente.getjCBFiltro1().getSelectedIndex() == 0) {
                    listaCliente.add(ClienteService.carregar(Integer.parseInt(this.buscaCliente.getjTFFitrar().getText())));
                } else {

                    colunaFiltro = this.buscaCliente.getjCBFiltro1().getSelectedItem().toString().trim();
                    listaCliente = ClienteService.carregar(colunaFiltro, this.buscaCliente.getjTFFitrar().getText().trim());
                }
                
            DefaultTableModel tabela = (DefaultTableModel) this.buscaCliente.getjTableDados().getModel();
            tabela.setRowCount(0);
            for (Cliente clienteAtual : listaCliente){
                tabela.addRow(new Object[] {clienteAtual.getId(),
                                            clienteAtual.getStatus(),
                                            clienteAtual.getMatricula(),
                                            clienteAtual.getNome(),
                                            clienteAtual.getCpf(),
                                            clienteAtual.getRg(),
                                            clienteAtual.getDataNascimento(),
                                            clienteAtual.getComplementoEndereco(),
                                            clienteAtual.getEndereco().getLogradouro(),
                                            clienteAtual.getEndereco().getBairro().getDescricao(),
                                            clienteAtual.getEndereco().getCidade().getDescricao(),
                                            clienteAtual.getEndereco().getCep(),
                                            clienteAtual.getFone1(),
                                            clienteAtual.getFone2(),
                                            clienteAtual.getEmail()
                });
            }
    }
   }
    }
}

    
    
