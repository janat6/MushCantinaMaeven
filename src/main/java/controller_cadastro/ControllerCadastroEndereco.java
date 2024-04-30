/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;

import controller_busca.ControllerBuscaBairro;
import controller_busca.ControllerBuscaCidade;
import static controller_busca.ControllerBuscaCidade.enderecoCidade;
import controller_busca.ControllerBuscaEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static model.DAO.Persiste.enderecoList;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import utilities.Utilities;
import view.busca.BuscaBairro;
import view.busca.BuscaCidade;
import view.busca.BuscaEndereco;
import view.cadastro.CadastroEndereco;

/**
 *
 * @author aluno
 */
public class ControllerCadastroEndereco implements ActionListener {

    CadastroEndereco cadastroEndereco;
    public static int codigo;

    public ControllerCadastroEndereco(CadastroEndereco cadastroEndereco) {
        this.cadastroEndereco = cadastroEndereco;

        this.cadastroEndereco.getjBNovo().addActionListener(this);
        this.cadastroEndereco.getjBBuscar().addActionListener(this);
        this.cadastroEndereco.getjBGravar().addActionListener(this);
        this.cadastroEndereco.getjBCancelar().addActionListener(this);
        this.cadastroEndereco.getjBSair().addActionListener(this);
        /*this.cadastroEndereco.getjBBairro().addActionListener(this);
        this.cadastroEndereco.getjBCidade().addActionListener(this);*/

        List<Cidade> listaCidades = new ArrayList<Cidade>();
        List<Bairro> listaBairros = new ArrayList<Bairro>();
        
        listaCidades = service.CidadeService.carregar();
        listaBairros = service.BairroService.carregar();
        
        this.cadastroEndereco.getjComboBoxBairro().removeAll();
        this.cadastroEndereco.getjComboBoxCidade().removeAll();

        for (Bairro bairroAtual : listaBairros) {
            this.cadastroEndereco.getjComboBoxBairro().addItem(bairroAtual.getDescricao());
        }

        for (Cidade cidadeAtual : listaCidades) {
            this.cadastroEndereco.getjComboBoxCidade().addItem(cidadeAtual.getDescricao());
        }
        
        utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroEndereco.getjBNovo()) {
            Utilities.ativa(false, this.cadastroEndereco.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroEndereco.getjPanDados());
            this.cadastroEndereco.getjTFId().setEnabled(false);
        } 
        
        else if (e.getSource() == this.cadastroEndereco.getjBBuscar()) {
            codigo = 0;

            BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
            buscaEndereco.setVisible(true);

            if (codigo != 0) {
                Endereco endereco = new Endereco();
                endereco = service.EnderecoService.carregar(codigo);
                
                utilities.Utilities.ativa(false, this.cadastroEndereco.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroEndereco.getjPanDados());

                this.cadastroEndereco.getjTFId().setText(endereco.getId() + "");
                this.cadastroEndereco.getjTFLogradouro().setText(endereco.getLogradouro() + "");
                this.cadastroEndereco.getjFTFCep().setText(endereco.getCep() + "");
                this.cadastroEndereco.getjComboBoxStatus().setSelectedItem(endereco.getStatus() + "");
                
                this.cadastroEndereco.getjComboBoxBairro().setSelectedItem(endereco.getBairro().getDescricao());
                this.cadastroEndereco.getjComboBoxCidade().setSelectedItem(endereco.getCidade().getDescricao());
                
                this.cadastroEndereco.getjTFId().setEnabled(false);
                
            } 
        }
          else if (e.getSource() == this.cadastroEndereco.getjBCancelar()) {
                Utilities.ativa(true, this.cadastroEndereco.getjPanBotoes());
                Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanDados());
            } 
            
            
            else if (e.getSource() == this.cadastroEndereco.getjBGravar()) {
                
                Endereco endereco = new Endereco();
            endereco.setLogradouro(this.cadastroEndereco.getjTFLogradouro().getText());
            endereco.setCep(this.cadastroEndereco.getjFTFCep().getText());
            //endereco.setStatus("A");
            endereco.setStatus(this.cadastroEndereco.getjComboBoxStatus().getSelectedItem().toString());


            endereco.setBairro(service.BairroService.carregar("" + this.cadastroEndereco.getjComboBoxBairro().getSelectedItem()).get(0));
            endereco.setCidade(service.CidadeService.carregar("descricao", this.cadastroEndereco.getjComboBoxCidade().getSelectedItem() + "").get(0));
            //neste ponto eu setei o objeto cidade e bairro trazendo os dados
            //atrav�s dos m�todos de carga que recebem uma String como par�metro.
            //por�m, eles trazem uma lista e eu necessito um objeto singular
            //por isso o get(0) no final que ir� pegar apenas o primeiro elemento da lista.

            if (codigo == 0) {
                //novo objeto a persistir
                service.EnderecoService.adicionar(endereco);
                utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanBotoes());
                Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanDados());

                this.cadastroEndereco.getjTFId().setEnabled(false);

            } else {
                //� um objeto existente sendo atualizado
                endereco.setId(codigo);

                service.EnderecoService.atualizar(endereco);
                utilities.Utilities.ativa(true, this.cadastroEndereco.getjPanBotoes());
                Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanDados());

                this.cadastroEndereco.getjTFId().setEnabled(false);

            }
               /* 
               if (this.cadastroEndereco.getjComboBoxStatus().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um valor válido para o Status!");
            } else if (this.cadastroEndereco.getjTFbairro().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Bairro!");
            } else if (this.cadastroEndereco.getjTFcidade().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Cidade!");
            } else if (this.cadastroEndereco.getjTFLogradouro().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Logradouro!");
            } else if (this.cadastroEndereco.getjFTFCep().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do CEP!");
            } else {
                Endereco endereco = new Endereco();
                Cidade cidade = new Cidade();
                Bairro bairro = new Bairro();
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                
                endereco.setLogradouro(this.cadastroEndereco.getjTFLogradouro().getText());
                endereco.setCep(this.cadastroEndereco.getjFTFCep().getText());
                endereco.setStatus(this.cadastroEndereco.getjComboBoxStatus().getSelectedItem().toString());
                endereco.getBairro().setDescricao(this.cadastroEndereco.getjTFbairro().getText());
                endereco.getCidade().setDescricao(this.cadastroEndereco.getjTFcidade().getText());

                if (this.cadastroEndereco.getjTFId().getText().trim().equalsIgnoreCase("")) {

                    service.EnderecoService.adicionar(endereco);

                } else {
                    endereco.setId(Integer.parseInt(this.cadastroEndereco.getjTFId().getText()));
                    service.EnderecoService.atualizar(endereco);
                }
            }

                Utilities.ativa(true, this.cadastroEndereco.getjPanBotoes());
                Utilities.limpaComponentes(false, this.cadastroEndereco.getjPanDados());*/
            }
            
            
            
            
            else if (e.getSource() == this.cadastroEndereco.getjBSair()) {

                this.cadastroEndereco.dispose();
            } 
            
            
           /* else if (e.getSource() == this.cadastroEndereco.getjBCidade()) {
                BuscaCidade buscaCidade = new BuscaCidade(null, true);
                ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(buscaCidade);
                buscaCidade.setVisible(true);
                

                this.cadastroEndereco.getjTFcidade().setText(controllerBuscaCidade.enderecoCidade);                
            }
            
            
            
            else if (e.getSource() == this.cadastroEndereco.getjBBairro()) {
                BuscaBairro buscaBairro = new BuscaBairro(null, true);
                ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(buscaBairro);
                buscaBairro.setVisible(true);
                

                this.cadastroEndereco.getjTFbairro().setText(controllerBuscaBairro.enderecoBairro);
            }*/
        }
    }

