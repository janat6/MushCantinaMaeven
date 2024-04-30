/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Venda;
import service.VendaService;
import view.Busca.BuscaVenda;

/**
 *
 * @author eduar
 */
public class ControllerBuscaVenda implements ActionListener {

    BuscaVenda buscaVenda;
    public static String colunaFiltro;
    public static boolean vendaToProduto = false;

    public ControllerBuscaVenda(BuscaVenda buscaVenda) {
        this.buscaVenda = buscaVenda;

        this.buscaVenda.getjButtonFiltrar().addActionListener(this);
        this.buscaVenda.getjButtonCarregar().addActionListener(this);
        this.buscaVenda.getjButtonSair().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaVenda.getjButtonCarregar()) {
        } else if (e.getSource() == this.buscaVenda.getjButtonSair()) {

            this.buscaVenda.dispose();
        } else if (e.getSource() == this.buscaVenda.getjButtonFiltrar()) {
            if (this.buscaVenda.getjTFFitrar().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção! \nOpcão de Filtro Vazia...");
            } else {
                List<Venda> listaVenda = new ArrayList<>();
                if (this.buscaVenda.getjCBFiltro().getSelectedIndex() == 0) {
                    listaVenda.add(VendaService.carregar(Integer.parseInt(this.buscaVenda.getjTFFitrar().getText())));
                } else {

                    colunaFiltro = this.buscaVenda.getjCBFiltro().getSelectedItem().toString().trim();
                    listaVenda = VendaService.carregar(colunaFiltro, this.buscaVenda.getjTFFitrar().getText().trim());
                }
            
            

            DefaultTableModel tableLista = (DefaultTableModel) this.buscaVenda.getjTableDados1().getModel();
            for (Venda vendaAtual : listaVenda) {
                tableLista.addRow(new Object[]{
                    vendaAtual.getId(),
                    vendaAtual.getCarteirinha().getCliente().getNome(),
                    vendaAtual.getValorDesconto(),
                    vendaAtual.getDataVenda(),
                    vendaAtual.getHoraVenda(),
                    vendaAtual.getObservacao(),
                    vendaAtual.getFuncionario().getId(),
                    vendaAtual.getStatus()

                });
            }
            }
        }

    }

}
