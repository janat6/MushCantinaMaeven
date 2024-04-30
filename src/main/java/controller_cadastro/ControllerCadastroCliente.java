/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;


import controller_busca.ControllerBuscaBairro;
import controller_busca.ControllerBuscaCidade;
import controller_busca.ControllerBuscaCliente;
import controller_busca.ControllerBuscaEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import static model.DAO.Persiste.clienteList;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Endereco;
import service.ClienteService;
import service.EnderecoService;
import utilities.Utilities;
import view.busca.BuscaBairro;
import view.busca.BuscaCidade;
import view.busca.BuscaCliente;
import view.busca.BuscaEndereco;
import view.cadastro.CadastroCliente;
import view.cadastro.CadastroEndereco;


/**
 *
 * @author aluno
 */
public class ControllerCadastroCliente implements ActionListener {

    CadastroCliente cadastroCliente;
    public static int codigo;

    public ControllerCadastroCliente(CadastroCliente cadastroCliente) {
        this.cadastroCliente = cadastroCliente;

        this.cadastroCliente.getjBNovo().addActionListener(this);
        this.cadastroCliente.getjBBuscar().addActionListener(this);
        this.cadastroCliente.getjBGravar().addActionListener(this);
        this.cadastroCliente.getjBCancelar().addActionListener(this);
        this.cadastroCliente.getjBSair().addActionListener(this);
        this.cadastroCliente.getjBEndereco().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroCliente.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroCliente.getjPanDados());
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCliente.getjBNovo()) {
            Utilities.ativa(false, this.cadastroCliente.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroCliente.getjPanDados());
            this.cadastroCliente.getjTFLogradouro().setEnabled(false);
            this.cadastroCliente.getjTFbairro().setEnabled(false);
            this.cadastroCliente.getjTFcidade().setEnabled(false);
            this.cadastroCliente.getjFTFCep().setEnabled(false);
            this.cadastroCliente.getjTFId().setEnabled(false);
        } 
        else if (e.getSource() == this.cadastroCliente.getjBBuscar()) {
            codigo = 0;
            BuscaCliente buscaCliente = new BuscaCliente(null, true);
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
            buscaCliente.setVisible(true);
            
            if (codigo != 0) {
                Cliente cliente = new Cliente();
                cliente = ClienteService.carregar(codigo);
                utilities.Utilities.ativa(false, this.cadastroCliente.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroCliente.getjPanDados());
                
                this.cadastroCliente.getjTFId().setText(cliente.getId() + "");
                this.cadastroCliente.getjComboBoxStatus().setSelectedItem(cliente.getStatus().toString() + "");
                this.cadastroCliente.getjTFMatricula().setText(cliente.getMatricula() + "");
                this.cadastroCliente.getjFTFDataNasc().setText(cliente.getDataNascimento()+ "");
                this.cadastroCliente.getjTFEmail().setText(cliente.getEmail()+ "");
                this.cadastroCliente.getjTFNome().setText(cliente.getNome() + "");
                this.cadastroCliente.getjFTFcpf().setText(cliente.getCpf() + "");
                this.cadastroCliente.getjFTFrg().setText(cliente.getRg()+ "");
                this.cadastroCliente.getjFTFFone1().setText(cliente.getFone1() + "");
                this.cadastroCliente.getjFTFFone2().setText(cliente.getFone2() + "");
                this.cadastroCliente.getjTFComplemento().setText(cliente.getComplementoEndereco() + "");
                this.cadastroCliente.getjTFbairro().setText(cliente.getEndereco().getBairro().getDescricao()+ "");
                this.cadastroCliente.getjTFcidade().setText(cliente.getEndereco().getCidade().getDescricao()+ "");
                this.cadastroCliente.getjFTFCep().setText(cliente.getEndereco().getCep() + "");
                this.cadastroCliente.getjTFLogradouro().setText(cliente.getEndereco().getLogradouro()+ "");
          
                this.cadastroCliente.getjTFId().setEnabled(false);
                this.cadastroCliente.getjTFLogradouro().setEnabled(false);
                this.cadastroCliente.getjTFbairro().setEnabled(false);
                this.cadastroCliente.getjTFcidade().setEnabled(false);
                this.cadastroCliente.getjFTFCep().setEnabled(false);
            }
        } 
        else if (e.getSource() == this.cadastroCliente.getjBCancelar()) {
            Utilities.ativa(true, this.cadastroCliente.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroCliente.getjPanDados());
        } 
        else if (e.getSource() == this.cadastroCliente.getjBGravar()) {
           
            if (this.cadastroCliente.getjComboBoxStatus().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um valor válido para o Status!");
            }
            else if(this.cadastroCliente.getjTFMatricula().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Matrícula!");
            }
            else if(this.cadastroCliente.getjFTFDataNasc().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Data de Nascimento!");
            }
            else if(this.cadastroCliente.getjTFEmail().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Email!");
            }
            else if(this.cadastroCliente.getjFTFcpf().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do CPF!");
            }
            else if(this.cadastroCliente.getjTFNome().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Nome!");
            }
            else if(this.cadastroCliente.getjFTFrg().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do RG!");
            }
            else if(this.cadastroCliente.getjTFComplemento().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Complemento!");
            }
            else if(this.cadastroCliente.getjFTFFone1().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Telefone 1!");
            }
            else if(this.cadastroCliente.getjFTFFone2().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Telefone 2!");
            }
            else{
            
            Endereco endereco = new Endereco();
            Cliente cliente = new Cliente();
            cliente.setEndereco(endereco);
            
            cliente.setStatus(this.cadastroCliente.getjComboBoxStatus().getSelectedItem().toString());
            cliente.setMatricula(this.cadastroCliente.getjTFMatricula().getText());
            cliente.setDataNascimento(this.cadastroCliente.getjFTFDataNasc().getText());
            cliente.setEmail(this.cadastroCliente.getjTFEmail().getText());
            cliente.setNome(this.cadastroCliente.getjTFNome().getText());
            cliente.setCpf(this.cadastroCliente.getjFTFcpf().getText());
            cliente.setRg(this.cadastroCliente.getjFTFrg().getText());
            cliente.setFone1(this.cadastroCliente.getjFTFFone1().getText());
            cliente.setFone2(this.cadastroCliente.getjFTFFone2().getText());
            cliente.setComplementoEndereco(this.cadastroCliente.getjTFComplemento().getText());
            
            cliente.setEndereco(EnderecoService.carregar("cep", this.cadastroCliente.getjFTFCep().getText()).get(0));
            
            if(this.cadastroCliente.getjTFLogradouro().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Informe o Endereco do Cliente!");
            }
            
            else {
                if(this.cadastroCliente.getjTFId().getText().trim().equalsIgnoreCase("")){
                    ClienteService.adicionar(cliente);
                }
                else {
                    cliente.setId(Integer.parseInt(this.cadastroCliente.getjTFId().getText()));
                    ClienteService.atualizar(cliente);
                    
                }
                
                Utilities.ativa(true, this.cadastroCliente.getjPanBotoes());
                Utilities.limpaComponentes(false, this.cadastroCliente.getjPanDados());
            }
            
            
            }
        }
        else if (e.getSource() == this.cadastroCliente.getjBEndereco()) {
            BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
            buscaEndereco.setVisible(true);
            
            this.cadastroCliente.getjTFLogradouro().setText(controllerBuscaEndereco.logradouroEndereco);
            this.cadastroCliente.getjFTFCep().setText(controllerBuscaEndereco.enderecoCEP);
            this.cadastroCliente.getjTFbairro().setText(controllerBuscaEndereco.bairroEndereco);
            this.cadastroCliente.getjTFcidade().setText(controllerBuscaEndereco.cidadeEndereco);
        }
        else if (e.getSource() == this.cadastroCliente.getjBSair()) {
            
            this.cadastroCliente.dispose();
        }
    }
}

