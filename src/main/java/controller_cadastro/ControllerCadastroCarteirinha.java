/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_cadastro;


import controller_busca.ControllerBuscaCarteirinha;
import controller_busca.ControllerBuscaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static model.DAO.Persiste.carteirinhaList;
import model.bo.Carteirinha;
import model.bo.Cliente;
import model.bo.Pessoa;
import service.CarteirinhaService;
import service.ClienteService;
import utilities.Utilities;
import view.busca.BuscaCarteirinha;
import view.busca.BuscaCliente;
import view.cadastro.CadastroCarteirinha;


/**
 *
 * @author aluno
 */
public class ControllerCadastroCarteirinha implements ActionListener {

    CadastroCarteirinha cadastroCarteirinha;
    public static int codigo;

    public ControllerCadastroCarteirinha(CadastroCarteirinha cadastroCarteirinha) {
        this.cadastroCarteirinha = cadastroCarteirinha;

        this.cadastroCarteirinha.getjBNovo().addActionListener(this);
        this.cadastroCarteirinha.getjBBuscar().addActionListener(this);
        this.cadastroCarteirinha.getjBGravar().addActionListener(this);
        this.cadastroCarteirinha.getjBCancelar().addActionListener(this);
        this.cadastroCarteirinha.getjBSair().addActionListener(this);
        this.cadastroCarteirinha.getjBCliente().addActionListener(this);

        utilities.Utilities.ativa(true, this.cadastroCarteirinha.getjPanBotoes());
        Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cadastroCarteirinha.getjBNovo()) {
            Utilities.ativa(false, this.cadastroCarteirinha.getjPanBotoes());
            Utilities.limpaComponentes(true, this.cadastroCarteirinha.getjPanDados());
            this.cadastroCarteirinha.getjTFid().setEnabled(false);
            this.cadastroCarteirinha.getjTFMatricula().setEnabled(false);
            this.cadastroCarteirinha.getjTFnome().setEnabled(false);
            this.cadastroCarteirinha.getjFTFDataNasc().setEnabled(false);
            this.cadastroCarteirinha.getjFTFcpf().setEnabled(false);
        } 
        else if (e.getSource() == this.cadastroCarteirinha.getjBBuscar()) {
            codigo = 0;
            BuscaCarteirinha buscaCarteirinha = new BuscaCarteirinha(null, true);
            ControllerBuscaCarteirinha controllerBuscaCarteirinha = new ControllerBuscaCarteirinha(buscaCarteirinha);
            buscaCarteirinha.setVisible(true);
            
            if (codigo != 0) {
                Carteirinha carteirinha = new Carteirinha();
                carteirinha = CarteirinhaService.carregar(codigo);  
                utilities.Utilities.ativa(false, this.cadastroCarteirinha.getjPanBotoes());
                Utilities.limpaComponentes(true, this.cadastroCarteirinha.getjPanDados());
         
                this.cadastroCarteirinha.getjTFid().setText(carteirinha.getId() + "");
                this.cadastroCarteirinha.getjTFcodigoBarras().setText(carteirinha.getCodigoBarra() + "");
                this.cadastroCarteirinha.getjFTFdataGeracao().setText(carteirinha.getDataGeracao() + "");
                this.cadastroCarteirinha.getjFTFdataCancelamento().setText(carteirinha.getDataCancelamento() + "");
                this.cadastroCarteirinha.getjTFMatricula().setText(carteirinha.getCliente().getMatricula() + "");
                this.cadastroCarteirinha.getjTFnome().setText(carteirinha.getCliente().getNome()+ "");
                this.cadastroCarteirinha.getjFTFDataNasc().setText(carteirinha.getCliente().getDataNascimento()+ "");
                this.cadastroCarteirinha.getjFTFcpf().setText(carteirinha.getCliente().getCpf()+ "");
                
                this.cadastroCarteirinha.getjTFid().setEnabled(false);
                this.cadastroCarteirinha.getjTFMatricula().setEnabled(false);
                this.cadastroCarteirinha.getjTFnome().setEnabled(false);
                this.cadastroCarteirinha.getjFTFDataNasc().setEnabled(false);
                this.cadastroCarteirinha.getjFTFcpf().setEnabled(false);
            }
        } 
        else if (e.getSource() == this.cadastroCarteirinha.getjBCancelar()) {
            Utilities.ativa(true, this.cadastroCarteirinha.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanDados());
        } 
        else if (e.getSource() == this.cadastroCarteirinha.getjBGravar()) {
            
            if(this.cadastroCarteirinha.getjTFcodigoBarras().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Defina um valor válido para o campo do Código de Barras!");
            }
            else if(this.cadastroCarteirinha.getjFTFdataGeracao().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina uma data para o campo da data de geração!");
            }
            else if(this.cadastroCarteirinha.getjFTFdataCancelamento().getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Defina quando será a data de cancelamento da carteirinha!");
            }

            else{
            String id = this.cadastroCarteirinha.getjTFid().getText();
            Cliente cliente = new Cliente();
            Carteirinha carteirinha = new Carteirinha();
            carteirinha.setCliente(cliente);
            
            carteirinha.setCodigoBarra(this.cadastroCarteirinha.getjTFcodigoBarras().getText());
            carteirinha.setDataGeracao(this.cadastroCarteirinha.getjFTFdataGeracao().getText());
            carteirinha.setDataCancelamento(this.cadastroCarteirinha.getjFTFdataCancelamento().getText());
            /*carteirinha.getCliente().setNome(this.cadastroCarteirinha.getjTFnome().getText());
            carteirinha.getCliente().setMatricula(this.cadastroCarteirinha.getjTFMatricula().getText());
            carteirinha.getCliente().setDataNascimento(this.cadastroCarteirinha.getjFTFDataNasc().getText());
            carteirinha.getCliente().setCpf(this.cadastroCarteirinha.getjFTFcpf().getText());*/
            
            carteirinha.setCliente(ClienteService.carregar("matricula", this.cadastroCarteirinha.getjTFMatricula().getText()).get(0));

            
            if(this.cadastroCarteirinha.getjTFnome().getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Informe as informações do Cliente!");
            }
            else {
            if(this.cadastroCarteirinha.getjTFid().getText().equalsIgnoreCase("")){
                CarteirinhaService.adicionar(carteirinha);
                
            }else {
                carteirinha.setId(Integer.parseInt(this.cadastroCarteirinha.getjTFid().getText()));
                CarteirinhaService.atualizar(carteirinha);
            }
            Utilities.ativa(true, this.cadastroCarteirinha.getjPanBotoes());
            Utilities.limpaComponentes(false, this.cadastroCarteirinha.getjPanDados());
            }
            }
        }
        else if (e.getSource() == this.cadastroCarteirinha.getjBCliente()) {
            BuscaCliente buscaCliente = new BuscaCliente(null, true);
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(buscaCliente);
            buscaCliente.setVisible(true);

            this.cadastroCarteirinha.getjTFMatricula().setText(controllerBuscaCliente.clienteMatricula);
            this.cadastroCarteirinha.getjTFnome().setText(controllerBuscaCliente.clienteNome);
            this.cadastroCarteirinha.getjFTFcpf().setText(controllerBuscaCliente.clienteCPF);
            this.cadastroCarteirinha.getjFTFDataNasc().setText(controllerBuscaCliente.clienteDataNascimento);
        }

        else if (e.getSource() == this.cadastroCarteirinha.getjBSair()) {
            
            this.cadastroCarteirinha.dispose();
        }
    }
}
