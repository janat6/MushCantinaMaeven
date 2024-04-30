/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Funcionario;
import service.FuncionarioService;
import utilities.Utilities;
import view.busca.BuscaFuncionario;
import view.cadastro.CadastroFuncionario;
import model.bo.Endereco;

/**
 *
 * @author janai
 */
public class ControllerBuscaFuncionario implements ActionListener{
    
    BuscaFuncionario buscaFuncionario;
    public static String colunaFiltro;
    public static String nomeFuncionario;
    
    public ControllerBuscaFuncionario(BuscaFuncionario buscaFuncionario) {
        this.buscaFuncionario = buscaFuncionario;

        this.buscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.buscaFuncionario.getjButtonFiltrar().addActionListener(this);
        this.buscaFuncionario.getjButtonSair().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaFuncionario.getjButtonSair()) {
            
            this.buscaFuncionario.dispose();
        }
        else if(e.getSource() == this.buscaFuncionario.getjButtonCarregar()){
           
            ControllerCadastroFuncionario.codigo = (int) this.buscaFuncionario.getjTableDados().getValueAt(this.buscaFuncionario.getjTableDados().getSelectedRow(), 0);
            nomeFuncionario = (String) this.buscaFuncionario.getjTableDados().getValueAt(this.buscaFuncionario.getjTableDados().getSelectedRow(), 3);
            FuncionarioService.carregar();
            this.buscaFuncionario.dispose();
        }
        else if (e.getSource() == this.buscaFuncionario.getjButtonFiltrar()){
            if (this.buscaFuncionario.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");

            } else {
                List<Funcionario> listaFuncionario = new ArrayList<>();

                if (this.buscaFuncionario.getjCBFiltro().getSelectedIndex() == 0) {
                    listaFuncionario.add(FuncionarioService.carregar(Integer.parseInt(this.buscaFuncionario.getjTFFitrar().getText())));
                } else {

                    colunaFiltro = this.buscaFuncionario.getjCBFiltro().getSelectedItem().toString().trim();
                    listaFuncionario = FuncionarioService.carregar(colunaFiltro, this.buscaFuncionario.getjTFFitrar().getText().trim());
                }

            DefaultTableModel tabela = (DefaultTableModel) this.buscaFuncionario.getjTableDados().getModel();
            tabela.setRowCount(0);
            for (Funcionario funcionarioAtual : listaFuncionario){
                tabela.addRow(new Object[] {funcionarioAtual.getId(),
                                            funcionarioAtual.getStatus(),
                                            funcionarioAtual.getUsuario(),
                                            funcionarioAtual.getNome(),
                                            funcionarioAtual.getCpf(),
                                            funcionarioAtual.getComplementoEndereco(),
                                            funcionarioAtual.getEndereco().getLogradouro(),
                                            funcionarioAtual.getEndereco().getBairro().getDescricao(),
                                            funcionarioAtual.getEndereco().getCidade().getDescricao(),
                                            funcionarioAtual.getEndereco().getCep(),
                                            funcionarioAtual.getEmail(),
                                            funcionarioAtual.getFone1(),
                                            funcionarioAtual.getFone2(),
                                            funcionarioAtual.getRg()
                });
            }
    }
        }
}
    }


