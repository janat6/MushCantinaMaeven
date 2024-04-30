/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.Utilities;
import view.busca.BuscaBairro;
import view.cadastro.CadastroBairro;
import controller_busca.ControllerBuscaBairro;
import javax.swing.JOptionPane;
import static model.DAO.Persiste.bairroList;
import model.bo.Bairro;

/**
 *
 * @author aluno
 */
public class ControllerCadastroBairro implements ActionListener {

    CadastroBairro cadastroBairro;
    public static int codigo;

    public ControllerCadastroBairro(CadastroBairro cadastroBairro) {
        this.cadastroBairro = cadastroBairro;

        this.cadastroBairro.getjBNovo().addActionListener(this);
        this.cadastroBairro.getjBBuscar().addActionListener(this);
        this.cadastroBairro.getjBGravar().addActionListener(this);
        this.cadastroBairro.getjBCancelar().addActionListener(this);
        this.cadastroBairro.getjBSair().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroBairro.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroBairro.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroBairro.getjBNovo()) {
            Utilities.ativa(false, this.cadastroBairro.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroBairro.getjPanDados());
            this.cadastroBairro.getjTFId().setEnabled(false);
        } 
        else if (e.getSource() == this.cadastroBairro.getjBBuscar()) {
            codigo = 0;
            BuscaBairro buscaBairro = new BuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(buscaBairro);
            buscaBairro.setVisible(true);

            if (codigo != 0) {
                Bairro bairro = new Bairro();
                bairro = service.BairroService.carregar(codigo);
                utilities.Utilities.ativa(false, this.cadastroBairro.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroBairro.getjPanDados());
                
                this.cadastroBairro.getjTFId().setText(bairro.getId() + "");
                this.cadastroBairro.getjTFDescricao().setText(bairro.getDescricao());
                this.cadastroBairro.getjTFId().setEnabled(false);
            }
        } 
        else if (e.getSource() == this.cadastroBairro.getjBCancelar()) {
            Utilities.ativa(true, this.cadastroBairro.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroBairro.getjPanDados());
        } 
        else if (e.getSource() == this.cadastroBairro.getjBGravar()) {
            if(this.cadastroBairro.getjTFDescricao().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Descrição!");
            }
            else {
            Bairro bairro = new Bairro();
            bairro.setDescricao(this.cadastroBairro.getjTFDescricao().getText());
            
            if(this.cadastroBairro.getjTFId().getText().equalsIgnoreCase("")){
                service.BairroService.adicionar(bairro);
            }
            
            else{
                bairro.setId(Integer.parseInt(this.cadastroBairro.getjTFId().getText()));
                service.BairroService.atualizar(bairro);
            }
            
            Utilities.ativa(true, this.cadastroBairro.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroBairro.getjPanDados());
        }
        }
        else if (e.getSource() == this.cadastroBairro.getjBSair()) {
            
            this.cadastroBairro.dispose();
        }
    }
}
