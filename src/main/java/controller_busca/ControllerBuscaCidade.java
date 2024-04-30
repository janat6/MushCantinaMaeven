/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroCidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Cidade;
import service.CidadeService;
import utilities.Utilities;
import view.busca.BuscaCidade;
import view.cadastro.CadastroCidade;

/**
 *
 * @author janai
 */
public class ControllerBuscaCidade implements ActionListener {

    public static String colunaFiltro;
    BuscaCidade buscaCidade;
    public static String enderecoCidade;

    public ControllerBuscaCidade(BuscaCidade buscaCidade) {
        this.buscaCidade = buscaCidade;

        this.buscaCidade.getjButtonCarregar().addActionListener(this);
        this.buscaCidade.getjButtonFiltrar().addActionListener(this);
        this.buscaCidade.getjButtonSair().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaCidade.getjButtonSair()) {
            this.buscaCidade.dispose();
        } 
    
        
        
        else if (e.getSource() == this.buscaCidade.getjButtonCarregar()) {

            ControllerCadastroCidade.codigo = (int) this.buscaCidade.getjTableDados().getValueAt(this.buscaCidade.getjTableDados().getSelectedRow(), 0);
            enderecoCidade = (String) this.buscaCidade.getjTableDados().getValueAt(this.buscaCidade.getjTableDados().getSelectedRow(), 1);
            
            this.buscaCidade.dispose();
        }
        else if (e.getSource() == this.buscaCidade.getjButtonFiltrar()) {
            
            if (! this.buscaCidade.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                List<Cidade> listaCidades = new ArrayList<Cidade>();

                if (this.buscaCidade.getjCBFiltro().getSelectedItem().toString().equalsIgnoreCase("id")) {
                    listaCidades.add(service.CidadeService.carregar(Integer.parseInt(this.buscaCidade.getjTFFitrar().getText())));
                } else {
                    listaCidades = service.CidadeService.carregar(this.buscaCidade.getjCBFiltro().getSelectedItem().toString().toLowerCase(), this.buscaCidade.getjTFFitrar().getText());
                }

                //Criar um objeto do tipo TableModel
                DefaultTableModel tabela = (DefaultTableModel) this.buscaCidade.getjTableDados().getModel();
                tabela.setRowCount(0);

                for (Cidade cidadeAtual : listaCidades) {
                    tabela.addRow(new Object[]{cidadeAtual.getId(),
                        cidadeAtual.getDescricao(),
                        cidadeAtual.getUf()});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Atenção!\nOpção de Filtro Vazia...");
                this.buscaCidade.getjTFFitrar().requestFocus();
            }
        }
            
            /*if (this.buscaCidade.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção\nOpção de Filtro Vazia...");
            } else {
                List<Cidade> listaCidade = new ArrayList<Cidade>();

                if (this.buscaCidade.getjCBFiltro().getSelectedIndex() == 0) {
                    listaCidade.add(CidadeService.carregar(Integer.parseInt(this.buscaCidade.getjTFFitrar().getText())));
                } 
                
                
                else {
                    colunaFiltro = this.buscaCidade.getjCBFiltro().getSelectedItem().toString().trim();
                    listaCidade = CidadeService.carregar(this.buscaCidade.getjTFFitrar().getText());
                }

                DefaultTableModel tabelaDados = (DefaultTableModel) buscaCidade.getjTableDados().getModel();
                tabelaDados.setRowCount(0);
                for (Cidade cidadeAtual : listaCidade) {
                    tabelaDados.addRow(new Object[]{
                        cidadeAtual.getId(),
                        cidadeAtual.getDescricao(),
                        cidadeAtual.getUf()});
                }
            }
        }
    }*/

    }
    }

