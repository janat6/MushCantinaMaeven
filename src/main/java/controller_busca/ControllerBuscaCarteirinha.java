/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroCarteirinha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Carteirinha;
import service.CarteirinhaService;
import utilities.Utilities;
import view.busca.BuscaCarteirinha;
import view.cadastro.CadastroCarteirinha;

/**
 *
 * @author janai
 */
public class ControllerBuscaCarteirinha implements ActionListener{
    
    public static String colunaFiltro;
    BuscaCarteirinha buscaCarteirinha;
    public static String nomeClienteCarteirinha;
    public int idCarteirinha;
    
    public ControllerBuscaCarteirinha(BuscaCarteirinha buscaCarteirinha) {
        this.buscaCarteirinha = buscaCarteirinha;

        this.buscaCarteirinha.getjButtonCarregar().addActionListener(this);
        this.buscaCarteirinha.getjButtonFiltrar().addActionListener(this);
        this.buscaCarteirinha.getjButtonSair().addActionListener(this);
        this.buscaCarteirinha.getjCBFiltro().addActionListener(this);
        this.buscaCarteirinha.getjTFFitrar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCarteirinha.getjButtonSair()) {
            this.buscaCarteirinha.dispose();
        }
        else if(e.getSource() == this.buscaCarteirinha.getjButtonCarregar()){
            ControllerCadastroCarteirinha.codigo =  (int) this.buscaCarteirinha.getjTableDados().getValueAt(this.buscaCarteirinha.getjTableDados().getSelectedRow(), 0);
            nomeClienteCarteirinha = (String) this.buscaCarteirinha.getjTableDados().getValueAt(this.buscaCarteirinha.getjTableDados().getSelectedRow(), 1);
            idCarteirinha = (int) this.buscaCarteirinha.getjTableDados().getValueAt(this.buscaCarteirinha.getjTableDados().getSelectedRow(), 0);
            CarteirinhaService.carregar();
            this.buscaCarteirinha.dispose();
        }            

            else if (e.getSource() == this.buscaCarteirinha.getjButtonFiltrar()){
                
                if (this.buscaCarteirinha.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");
            } else {
                List<Carteirinha> listaCarteirinhas = new ArrayList<>();
                if(this.buscaCarteirinha.getjCBFiltro().getSelectedIndex() == 0){
                listaCarteirinhas.add(CarteirinhaService.carregar(Integer.parseInt(this.buscaCarteirinha.getjTFFitrar().getText())));
                }
                else{
                colunaFiltro = this.buscaCarteirinha.getjCBFiltro().getSelectedItem().toString().trim();
                listaCarteirinhas = CarteirinhaService.carregar(colunaFiltro, this.buscaCarteirinha.getjTFFitrar().getText().trim());
                    
                }
                
        DefaultTableModel tabela = (DefaultTableModel) this.buscaCarteirinha.getjTableDados().getModel();
        tabela.setRowCount(0);
        for (Carteirinha carteirinhaAtual : listaCarteirinhas){
            tabela.addRow(new Object[] {carteirinhaAtual.getId(), 
                                        carteirinhaAtual.getCliente().getNome(),
                                        carteirinhaAtual.getCliente().getMatricula(),
                                        carteirinhaAtual.getCodigoBarra(),
                                        carteirinhaAtual.getDataGeracao(),
                                        carteirinhaAtual.getDataCancelamento(),
                                        carteirinhaAtual.getCliente().getCpf(),
                                        carteirinhaAtual.getCliente().getDataNascimento()
            });
        }
    }
    }
    }

    


}