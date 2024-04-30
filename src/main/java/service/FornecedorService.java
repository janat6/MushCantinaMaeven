/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.FornecedorDAO;
import model.bo.Fornecedor;

/**
 *
 * @author janai
 */
public class FornecedorService {
    public static void adicionar(Fornecedor objeto) {
            FornecedorDAO.getInstance().create(objeto);
        }
        
        public static List<Fornecedor> carregar(){
            return FornecedorDAO.getInstance().retrieve();
        }
        
        public static Fornecedor carregar(int parPK) {
            return FornecedorDAO.getInstance().retrieve(parPK);
        }
        
        public static List<Fornecedor> carregar(String nomeParametro, String parString) {
            return FornecedorDAO.getInstance().retrieve(nomeParametro, parString);
        }
        
        public static void atualizar(Fornecedor objeto){
            FornecedorDAO.getInstance().update(objeto);
        }
        
        public static void remover(Fornecedor objeto){
            FornecedorDAO.getInstance().delete(objeto);
        }
}
