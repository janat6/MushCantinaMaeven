/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.ArrayList;
import static model.DAO.Persiste.instance;
import model.bo.Bairro;
import model.bo.Caixa;
import model.bo.Carteirinha;
import model.bo.Cidade;
import model.bo.Cliente;
import model.bo.Compra;
import model.bo.Contas;
import model.bo.Endereco;
import model.bo.Fornecedor;
import model.bo.Funcionario;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.MovimentacaoEstoque;
import model.bo.MovimentoCaixa;
import model.bo.Produto;
import model.bo.Venda;

/**
 *
 * @author janai
 */
public class Persiste {
    
    public static Persiste instance;
    public static ArrayList<Bairro> bairroList;
    public static ArrayList<Caixa> caixaList;
    public static ArrayList<Carteirinha> carteirinhaList;
    public static ArrayList<Cidade> cidadeList;
    public static ArrayList<Cliente> clienteList;
    public static ArrayList<Compra> compraList;
    public static ArrayList<Contas> contasList;
    public static ArrayList<Endereco> enderecoList;
    public static ArrayList<Fornecedor> fornecedorList;
    public static ArrayList<Funcionario> funcionarioList;
    public static ArrayList<ItemCompra> itemCompraList;
    public static ArrayList<ItemVenda> itemVendaList;
    public static ArrayList<MovimentacaoEstoque> movimentacaoEstoqueList;
    public static ArrayList<MovimentoCaixa> movimentoCaixaList;
    public static ArrayList<Produto> produtoList;
    public static ArrayList<Venda> vendaList;
    
    public static synchronized Persiste getInstance(){
        if(instance == null){
            instance = new Persiste();
            
        }
        return instance;
    }
    
    public Persiste() {
        bairroList = new ArrayList();
        caixaList = new ArrayList();
        carteirinhaList = new ArrayList();
        cidadeList = new ArrayList();
        clienteList = new ArrayList();
        compraList = new ArrayList();
        contasList = new ArrayList();
        enderecoList = new ArrayList();
        fornecedorList = new ArrayList();
        funcionarioList = new ArrayList();
        itemCompraList = new ArrayList();
        itemVendaList = new ArrayList();
        movimentacaoEstoqueList = new ArrayList();
        movimentoCaixaList = new ArrayList();
        produtoList = new ArrayList();
        vendaList = new ArrayList();
        
        Bairro bairro1 = new Bairro(1, "Centro");
        Bairro bairro2 = new Bairro(2, "Dehon");
        Cidade cidade1 = new Cidade(1, "Biguaçu", "SC");
        Endereco endereco = new Endereco(1, "Ativo", "88704080", "Pe. Dionísio da Cunha Laudt", cidade1, bairro2);
        Fornecedor fornecedor = new Fornecedor("47893654000167", "5432346543", "empresa lala", 1, "jana", "48988493378", "48988493378", "janaina.teles2003@gmail.com", "a", "apto 201", endereco);
        Funcionario funcionario = new Funcionario("12938931964", "7114809", "mush", "1234", 1, "wilsu", "48988493378", "48988493378","janaina.teles2003@gmail.com", "a", "apto 201", endereco);
        Cliente cliente = new Cliente("12938931964", "7114809", "201911901063", "06/10/2003", 1, "Janaina", "48988493378", "48988493378", "janaina.teles2003@gmail.com", "a", "apto 201", endereco);
        Carteirinha carteirinha = new Carteirinha(1, "37483928749234", "01/01/2019", "01/01/2021", cliente);
        Produto produto = new Produto(1, "bolo", "6545676543", "ativo", (float) 1.5);
        
        bairroList.add(bairro1);
        bairroList.add(bairro2);
        cidadeList.add(cidade1);
        enderecoList.add(endereco);
        carteirinhaList.add(carteirinha);
        clienteList.add(cliente);
        fornecedorList.add(fornecedor);
        funcionarioList.add(funcionario);
        produtoList.add(produto);       
    }          
}
