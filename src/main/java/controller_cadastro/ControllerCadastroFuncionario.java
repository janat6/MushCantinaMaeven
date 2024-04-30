/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;


import controller_busca.ControllerBuscaEndereco;
import controller_busca.ControllerBuscaFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static model.DAO.Persiste.funcionarioList;
import model.bo.Endereco;
import model.bo.Funcionario;
import service.EnderecoService;
import service.FuncionarioService;
import utilities.Utilities;
import view.busca.BuscaEndereco;
import view.busca.BuscaFuncionario;
import view.cadastro.CadastroEndereco;
import view.cadastro.CadastroFuncionario;


/**
 *
 * @author aluno
 */
public class ControllerCadastroFuncionario implements ActionListener {

    CadastroFuncionario cadastroFuncionario;
    public static int codigo;

    public ControllerCadastroFuncionario(CadastroFuncionario cadastroFuncionario) {
        this.cadastroFuncionario = cadastroFuncionario;

        this.cadastroFuncionario.getjBNovo().addActionListener(this);
        this.cadastroFuncionario.getjBBuscar().addActionListener(this);
        this.cadastroFuncionario.getjBGravar().addActionListener(this);
        this.cadastroFuncionario.getjBCancelar().addActionListener(this);
        this.cadastroFuncionario.getjBSair().addActionListener(this);
        this.cadastroFuncionario.getjBEndereco().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroFuncionario.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroFuncionario.getjBNovo()) {
            Utilities.ativa(false, this.cadastroFuncionario.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroFuncionario.getjPanDados());
            this.cadastroFuncionario.getjTFLogradouro().setEnabled(false);
            this.cadastroFuncionario.getjTFbairro().setEnabled(false);
            this.cadastroFuncionario.getjTFcidade().setEnabled(false);
            this.cadastroFuncionario.getjFTFCep().setEnabled(false);
            this.cadastroFuncionario.getjTFId().setEnabled(false);
        } 
        else if (e.getSource() == this.cadastroFuncionario.getjBBuscar()) {
            codigo = 0;
            BuscaFuncionario buscaFuncionario = new BuscaFuncionario(null, true);
            ControllerBuscaFuncionario controllerBuscaFuncionario = new ControllerBuscaFuncionario(buscaFuncionario);
            buscaFuncionario.setVisible(true);
            
            if (codigo != 0) {
                Funcionario funcionario = new Funcionario();
                funcionario = FuncionarioService.carregar(codigo);
                utilities.Utilities.ativa(false, this.cadastroFuncionario.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroFuncionario.getjPanDados());
                
                this.cadastroFuncionario.getjTFId().setText(funcionario.getId() + "");
                this.cadastroFuncionario.getjComboBoxStatus1().setSelectedItem(funcionario.getStatus().toString() + "");
                this.cadastroFuncionario.getjTFEmail().setText(funcionario.getEmail()+ "");
                this.cadastroFuncionario.getjPasswordField1().setText(funcionario.getSenha()+ "");
                this.cadastroFuncionario.getjTFUsuario().setText(funcionario.getUsuario()+ "");
                this.cadastroFuncionario.getjTFNome().setText(funcionario.getNome() + "");
                this.cadastroFuncionario.getjFTFcpf().setText(funcionario.getCpf() + "");
                this.cadastroFuncionario.getjTFrg().setText(funcionario.getRg()+ "");
                this.cadastroFuncionario.getjFTFFone1().setText(funcionario.getFone1() + "");
                this.cadastroFuncionario.getjFTFFone2().setText(funcionario.getFone2() + "");
                this.cadastroFuncionario.getjTFComplemento().setText(funcionario.getComplementoEndereco() + "");
                this.cadastroFuncionario.getjTFbairro().setText(funcionario.getEndereco().getBairro().getDescricao()+ "");
                this.cadastroFuncionario.getjTFcidade().setText(funcionario.getEndereco().getCidade().getDescricao()+ "");
                this.cadastroFuncionario.getjFTFCep().setText(funcionario.getEndereco().getCep() + "");
                this.cadastroFuncionario.getjTFLogradouro().setText(funcionario.getEndereco().getLogradouro()+ "");
                
                this.cadastroFuncionario.getjTFId().setEnabled(false);
                this.cadastroFuncionario.getjTFLogradouro().setEnabled(false);
                this.cadastroFuncionario.getjTFbairro().setEnabled(false);
                this.cadastroFuncionario.getjTFcidade().setEnabled(false);
                this.cadastroFuncionario.getjFTFCep().setEnabled(false);
            }
        } 
        else if (e.getSource() == this.cadastroFuncionario.getjBCancelar()) {
            Utilities.ativa(true, this.cadastroFuncionario.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanDados());
        } 
        else if (e.getSource() == this.cadastroFuncionario.getjBGravar()) {
            if (this.cadastroFuncionario.getjComboBoxStatus1().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um valor válido para o Status!");
            }
            else if(this.cadastroFuncionario.getjTFUsuario().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Usuário!");
            }
            else if(this.cadastroFuncionario.getjPasswordField1().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Senha!");
            }
            else if(this.cadastroFuncionario.getjTFEmail().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Email!");
            }
            else if(this.cadastroFuncionario.getjFTFcpf().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do CPF!");
            }
            else if(this.cadastroFuncionario.getjTFNome().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Nome!");
            }
            else if(this.cadastroFuncionario.getjTFrg().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do RG!");
            }
            else if(this.cadastroFuncionario.getjTFComplemento().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Complemento!");
            }
            else if(this.cadastroFuncionario.getjFTFFone1().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Telefone 1!");
            }
            else if(this.cadastroFuncionario.getjFTFFone2().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Telefone 2!");
            }
            else{
            
            Endereco endereco = new Endereco();
            Funcionario funcionario = new Funcionario();
            funcionario.setEndereco(endereco);
            
            funcionario.setStatus(this.cadastroFuncionario.getjComboBoxStatus1().getSelectedItem().toString());
            funcionario.setUsuario(this.cadastroFuncionario.getjTFUsuario().getText());
            funcionario.setSenha(this.cadastroFuncionario.getjPasswordField1().getText());
            funcionario.setEmail(this.cadastroFuncionario.getjTFEmail().getText());
            funcionario.setNome(this.cadastroFuncionario.getjTFNome().getText());
            funcionario.setCpf(this.cadastroFuncionario.getjFTFcpf().getText());
            funcionario.setRg(this.cadastroFuncionario.getjTFrg().getText());
            funcionario.setFone1(this.cadastroFuncionario.getjFTFFone1().getText());
            funcionario.setFone2(this.cadastroFuncionario.getjFTFFone2().getText());
            funcionario.setComplementoEndereco(this.cadastroFuncionario.getjTFComplemento().getText());
            
            funcionario.setEndereco(EnderecoService.carregar("cep", this.cadastroFuncionario.getjFTFCep().getText()).get(0));
            
            if(this.cadastroFuncionario.getjTFLogradouro().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Informe o Endereco do Cliente!");
            }
            else {
            if(this.cadastroFuncionario.getjTFId().getText().equalsIgnoreCase("")){
                FuncionarioService.adicionar(funcionario);
            }
            else{
                funcionario.setId(Integer.parseInt(this.cadastroFuncionario.getjTFId().getText()));
                FuncionarioService.atualizar(funcionario);
                
            }
            Utilities.ativa(true, this.cadastroFuncionario.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroFuncionario.getjPanDados());
        }
    }
        }
        
        else if (e.getSource() == this.cadastroFuncionario.getjBEndereco()) {
            BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
            buscaEndereco.setVisible(true);
            
            this.cadastroFuncionario.getjTFLogradouro().setText(controllerBuscaEndereco.logradouroEndereco);
            this.cadastroFuncionario.getjFTFCep().setText(controllerBuscaEndereco.enderecoCEP);
            this.cadastroFuncionario.getjTFbairro().setText(controllerBuscaEndereco.bairroEndereco);
            this.cadastroFuncionario.getjTFcidade().setText(controllerBuscaEndereco.cidadeEndereco);
        }
        
        else if (e.getSource() == this.cadastroFuncionario.getjBSair()) {
            
            this.cadastroFuncionario.dispose();
        }
    }
}
