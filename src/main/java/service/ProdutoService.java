/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.ProdutoDAO;
import model.bo.Produto;

/**
 *
 * @author aluno
 */
public class ProdutoService {
    public static void adicionar(Produto objeto) {
            ProdutoDAO.getInstance().create(objeto);
        }
        
        public static List<Produto> carregar(){
            return ProdutoDAO.getInstance().retrieve();
        }
        
        public static Produto carregar(int parPK) {
            return ProdutoDAO.getInstance().retrieve(parPK);
        }
        
        public static Produto carregarProduto(String cod){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.RetornaDeLadinho(cod);
        }
     
        
        public static List<Produto> carregar(String nomeParametro, String parString) {
            return ProdutoDAO.getInstance().retrieve(nomeParametro, parString);
        }
        
        public static void atualizar(Produto objeto){
            ProdutoDAO.getInstance().update(objeto);
        }
        
        public static void remover(Produto objeto){
            ProdutoDAO.getInstance().delete(objeto);
        }
}
