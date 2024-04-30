/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_busca;

import controller_cadastro.ControllerCadastroBairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Bairro;
import service.BairroService;
import utilities.Utilities;
import view.busca.BuscaBairro;

/**
 *
 * @author janai
 */
public class ControllerBuscaBairro implements ActionListener{
    
    BuscaBairro buscaBairro;
    public static String enderecoBairro;
    
    public ControllerBuscaBairro(BuscaBairro buscaBairro) {
        this.buscaBairro = buscaBairro;

        this.buscaBairro.getjButtonCarregar().addActionListener(this);
        this.buscaBairro.getjButtonFiltrar().addActionListener(this);
        this.buscaBairro.getjButtonSair().addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscaBairro.getjButtonSair()) {
            this.buscaBairro.dispose();
        }
        else if(e.getSource() == this.buscaBairro.getjButtonCarregar()){
         ControllerCadastroBairro.codigo =  (int) this.buscaBairro.getjTableDados1().getValueAt(this.buscaBairro.getjTableDados1().getSelectedRow(), 0);
         enderecoBairro = (String) buscaBairro.getjTableDados1().getValueAt(this.buscaBairro.getjTableDados1().getSelectedRow(), 1);
         this.buscaBairro.dispose();
        }
        else if (e.getSource() == this.buscaBairro.getjButtonFiltrar()){
            if (this.buscaBairro.getjTFFitrar().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"Atenção\nOpção de Filtro Vazia...");
            }else{
                
                List<Bairro> listaBairro = new ArrayList<Bairro>();
                
                if(this.buscaBairro.getjCBFiltro().getSelectedIndex() == 0){
                    listaBairro.add(BairroService.carregar(Integer.parseInt(this.buscaBairro.getjTFFitrar().getText())));
                            }else if (this.buscaBairro.getjCBFiltro().getSelectedIndex() == 1){
                              listaBairro = BairroService.carregar(this.buscaBairro.getjTFFitrar().getText().trim());
                            }
        
            DefaultTableModel tabelaDados = (DefaultTableModel) buscaBairro.getjTableDados1().getModel();
            tabelaDados.setRowCount(0);
            for (Bairro bairroAtual : listaBairro) {
                tabelaDados.addRow(new Object[]{bairroAtual.getId(),
                                                bairroAtual.getDescricao()});
        }

            
        }
    }
    
}
}
