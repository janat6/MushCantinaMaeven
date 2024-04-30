/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;


import controller_busca.ControllerBuscaEndereco;
import controller_busca.ControllerBuscaFornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static model.DAO.Persiste.fornecedorList;
import model.bo.Endereco;
import model.bo.Fornecedor;
import service.EnderecoService;
import service.FornecedorService;
import utilities.Utilities;
import view.busca.BuscaEndereco;
import view.busca.BuscaFornecedor;
import view.cadastro.CadastroEndereco;
import view.cadastro.CadastroFornecedor;


/**
 *
 * @author aluno
 */
public class ControllerCadastroFornecedor implements ActionListener {

    CadastroFornecedor cadastroFornecedor;
    public static int codigo;

    public ControllerCadastroFornecedor(CadastroFornecedor cadastroFornecedor) {
        this.cadastroFornecedor = cadastroFornecedor;

        this.cadastroFornecedor.getjBNovo().addActionListener(this);
        this.cadastroFornecedor.getjBBuscar().addActionListener(this);
        this.cadastroFornecedor.getjBGravar().addActionListener(this);
        this.cadastroFornecedor.getjBCancelar().addActionListener(this);
        this.cadastroFornecedor.getjBSair().addActionListener(this);
        this.cadastroFornecedor.getjBEndereco().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroFornecedor.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroFornecedor.getjBNovo()) {
            Utilities.ativa(false, this.cadastroFornecedor.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroFornecedor.getjPanDados());
            this.cadastroFornecedor.getjTFLogradouro().setEnabled(false);
            this.cadastroFornecedor.getjTFbairro().setEnabled(false);
            this.cadastroFornecedor.getjTFcidade().setEnabled(false);
            this.cadastroFornecedor.getjFTFCep().setEnabled(false);
            this.cadastroFornecedor.getjTFId().setEnabled(false);
        } 
        else if (e.getSource() == this.cadastroFornecedor.getjBBuscar()) {
            codigo = 0;
            BuscaFornecedor buscaFornecedor = new BuscaFornecedor(null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(buscaFornecedor);
            buscaFornecedor.setVisible(true);
            
            if (codigo != 0) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = FornecedorService.carregar(codigo);
                utilities.Utilities.ativa(false, this.cadastroFornecedor.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroFornecedor.getjPanDados());
                
                this.cadastroFornecedor.getjTFId().setText(fornecedor.getId() + "");
                this.cadastroFornecedor.getjComboBoxStatus1().setSelectedItem(fornecedor.getStatus().toString() + "");
                this.cadastroFornecedor.getjTFEmail().setText(fornecedor.getEmail()+ "");
                this.cadastroFornecedor.getjTFInscricaoE().setText(fornecedor.getInscricaoEstadual()+ "");
                this.cadastroFornecedor.getjTFRazaoSocial().setText(fornecedor.getRazaoSocial()+ "");
                this.cadastroFornecedor.getjTFNome().setText(fornecedor.getNome() + "");
                this.cadastroFornecedor.getjFTFcnpj().setText(fornecedor.getCnpj()+ "");
                this.cadastroFornecedor.getjFTFFone1().setText(fornecedor.getFone1() + "");
                this.cadastroFornecedor.getjFTFFone2().setText(fornecedor.getFone2() + "");
                this.cadastroFornecedor.getjTFComplemento().setText(fornecedor.getComplementoEndereco() + "");
                this.cadastroFornecedor.getjTFbairro().setText(fornecedor.getEndereco().getBairro().getDescricao()+ "");
                this.cadastroFornecedor.getjTFcidade().setText(fornecedor.getEndereco().getCidade().getDescricao()+ "");
                this.cadastroFornecedor.getjFTFCep().setText(fornecedor.getEndereco().getCep() + "");
                this.cadastroFornecedor.getjTFLogradouro().setText(fornecedor.getEndereco().getLogradouro()+ "");

                
                this.cadastroFornecedor.getjTFId().setEnabled(false);
                this.cadastroFornecedor.getjTFLogradouro().setEnabled(false);
                this.cadastroFornecedor.getjTFbairro().setEnabled(false);
                this.cadastroFornecedor.getjTFcidade().setEnabled(false);
                this.cadastroFornecedor.getjFTFCep().setEnabled(false);
            }
        } 
        else if (e.getSource() == this.cadastroFornecedor.getjBCancelar()) {
            Utilities.ativa(true, this.cadastroFornecedor.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanDados());
        } 
        else if (e.getSource() == this.cadastroFornecedor.getjBGravar()) {
            if (this.cadastroFornecedor.getjComboBoxStatus1().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um valor válido para o Status!");
            }
            else if(this.cadastroFornecedor.getjTFInscricaoE().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Inscrição Estadual!");
            }
            else if(this.cadastroFornecedor.getjTFRazaoSocial().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo da Razão Social!");
            }
            else if(this.cadastroFornecedor.getjTFEmail().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Email!");
            }
            else if(this.cadastroFornecedor.getjFTFcnpj().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do CNPJ!");
            }
            else if(this.cadastroFornecedor.getjTFNome().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Nome!");
            }
            else if(this.cadastroFornecedor.getjTFComplemento().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Complemento!");
            }
            else if(this.cadastroFornecedor.getjFTFFone1().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Telefone 1!");
            }
            else if(this.cadastroFornecedor.getjFTFFone2().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Telefone 2!");
            }
            else{
            
            Endereco endereco = new Endereco();
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setEndereco(endereco);

            
            fornecedor.setStatus(this.cadastroFornecedor.getjComboBoxStatus1().getSelectedItem().toString());
            fornecedor.setNome(this.cadastroFornecedor.getjTFNome().getText());
            fornecedor.setInscricaoEstadual(this.cadastroFornecedor.getjTFInscricaoE().getText());
            fornecedor.setRazaoSocial(this.cadastroFornecedor.getjTFRazaoSocial().getText());
            fornecedor.setCnpj(this.cadastroFornecedor.getjFTFcnpj().getText());
            fornecedor.setEmail(this.cadastroFornecedor.getjTFEmail().getText());
            fornecedor.setFone1(this.cadastroFornecedor.getjFTFFone1().getText());
            fornecedor.setFone2(this.cadastroFornecedor.getjFTFFone2().getText());
            fornecedor.setComplementoEndereco(this.cadastroFornecedor.getjTFComplemento().getText());
            
            fornecedor.setEndereco(EnderecoService.carregar("cep", this.cadastroFornecedor.getjFTFCep().getText()).get(0));
            
            if(this.cadastroFornecedor.getjTFLogradouro().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Informe o Endereco do Cliente!");
            }
            else {
            if(this.cadastroFornecedor.getjTFId().getText().equalsIgnoreCase("")){
                FornecedorService.adicionar(fornecedor);
            }
            else{
                fornecedor.setId(Integer.parseInt(this.cadastroFornecedor.getjTFId().getText()));
                FornecedorService.atualizar(fornecedor);
                
        }
            Utilities.ativa(true, this.cadastroFornecedor.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroFornecedor.getjPanDados());
        }
        }
        }
        
                else if (e.getSource() == this.cadastroFornecedor.getjBEndereco()) {
            BuscaEndereco buscaEndereco = new BuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(buscaEndereco);
            buscaEndereco.setVisible(true);
            this.cadastroFornecedor.getjTFLogradouro().setText(controllerBuscaEndereco.logradouroEndereco);
            this.cadastroFornecedor.getjFTFCep().setText(controllerBuscaEndereco.enderecoCEP);
            this.cadastroFornecedor.getjTFbairro().setText(controllerBuscaEndereco.bairroEndereco);
            this.cadastroFornecedor.getjTFcidade().setText(controllerBuscaEndereco.cidadeEndereco);
        }
        
        else if (e.getSource() == this.cadastroFornecedor.getjBSair()) {
            
            this.cadastroFornecedor.dispose();
        }
    }
}
