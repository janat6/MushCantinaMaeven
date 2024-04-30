/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.ClienteDAO;
import model.bo.Cliente;

/**
 *
 * @author janai
 */
public class ClienteService {
    public static void adicionar(Cliente objeto) {
            ClienteDAO.getInstance().create(objeto);
        }
        
        public static List<Cliente> carregar(){
            return ClienteDAO.getInstance().retrieve();
        }
        
        public static Cliente carregar(int parPK) {
            return ClienteDAO.getInstance().retrieve(parPK);
        }
        
        public static List<Cliente> carregar(String nomeParametro, String parString) {
            return ClienteDAO.getInstance().retrieve(nomeParametro, parString);
        }
        
        public static void atualizar(Cliente objeto){
            ClienteDAO.getInstance().update(objeto);
        }
        
        public static void remover(Cliente objeto){
            ClienteDAO.getInstance().delete(objeto);
        }
}
