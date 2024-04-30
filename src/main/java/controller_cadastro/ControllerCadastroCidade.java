/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;

import controller_busca.ControllerBuscaCidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static model.DAO.Persiste.cidadeList;
import model.bo.Cidade;
import service.CidadeService;
import utilities.Utilities;
import view.busca.BuscaCidade;
import view.cadastro.CadastroCidade;

/**
 *
 * @author aluno
 */
public class ControllerCadastroCidade implements ActionListener {

    CadastroCidade cadastroCidade;
    public static int codigo;

    public ControllerCadastroCidade(CadastroCidade cadastroEndereco) {
        this.cadastroCidade = cadastroEndereco;

        this.cadastroCidade.getjBNovo().addActionListener(this);
        this.cadastroCidade.getjBBuscar().addActionListener(this);
        this.cadastroCidade.getjBGravar().addActionListener(this);
        this.cadastroCidade.getjBCancelar().addActionListener(this);
        this.cadastroCidade.getjBSair().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroCidade.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroCidade.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCidade.getjBNovo()) {
            Utilities.ativa(false, this.cadastroCidade.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroCidade.getjPanDados());
            this.cadastroCidade.getjTFId().setEnabled(false);
        } 
        else if (e.getSource() == this.cadastroCidade.getjBBuscar()) {
            codigo = 0;
            
            BuscaCidade buscaCidade = new BuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(buscaCidade);
            
            buscaCidade.setVisible(true);
            
             if (codigo != 0) {

                Cidade cidade = new Cidade();
                cidade = service.CidadeService.carregar(codigo);
                
                utilities.Utilities.ativa(false, this.cadastroCidade.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroCidade.getjPanDados());
                
                this.cadastroCidade.getjTFId().setText(cidade.getId() + "");
                this.cadastroCidade.getjTFDescricao().setText(cidade.getDescricao() + "");
                this.cadastroCidade.getjTFuf().setText(cidade.getUf() + "");
                this.cadastroCidade.getjTFId().setEnabled(false);
             }
             
            
        } 
        else if (e.getSource() == this.cadastroCidade.getjBCancelar()) {
            Utilities.ativa(true, this.cadastroCidade.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroCidade.getjPanDados());
        } 
        else if (e.getSource() == this.cadastroCidade.getjBGravar()) {
            if(this.cadastroCidade.getjTFDescricao().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Descrição!");
            }
            else if(this.cadastroCidade.getjTFuf().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da UF!");
            }
            else {
              Cidade cidade = new Cidade();
            cidade.setDescricao(this.cadastroCidade.getjTFDescricao().getText().trim());
            cidade.setUf(this.cadastroCidade.getjTFuf().getText().trim());
            
            if(this.cadastroCidade.getjTFId().getText().trim().equalsIgnoreCase("")){
                CidadeService.adicionar(cidade);
            }
           
           else{
                cidade.setId(Integer.parseInt(this.cadastroCidade.getjTFId().getText()));
                service.CidadeService.atualizar(cidade);
            }
            
            Utilities.ativa(true, this.cadastroCidade.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroCidade.getjPanDados());
        }  
            }
            
        else if (e.getSource() == this.cadastroCidade.getjBSair()) {
            
            this.cadastroCidade.dispose();
        }
    }
}
