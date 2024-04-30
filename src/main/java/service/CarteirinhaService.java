/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.CarteirinhaDAO;
import model.bo.Carteirinha;

/**
 *
 * @author janai
 */
public class CarteirinhaService {
    public static void adicionar(Carteirinha objeto) {
            CarteirinhaDAO.getInstance().create(objeto);
        }
        
        public static List<Carteirinha> carregar(){
            return CarteirinhaDAO.getInstance().retrieve();
        }
        
        public static Carteirinha carregar(int parPK) {
            return CarteirinhaDAO.getInstance().retrieve(parPK);
        }
        
        public static List<Carteirinha> carregar(String nomeParametro, String parString) {
            return CarteirinhaDAO.getInstance().retrieve(nomeParametro, parString);
        }
        
        public static void atualizar(Carteirinha objeto){
            CarteirinhaDAO.getInstance().update(objeto);
        }
        
        public static void remover(Carteirinha objeto){
            CarteirinhaDAO.getInstance().delete(objeto);
        }
}
