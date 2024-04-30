/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.ItemVendaDAO;
import model.bo.ItemVenda;

/**
 *
 * @author tarci
 */
public class ItemVendaService {
    
        public static void adicionar(ItemVenda objeto) {
            ItemVendaDAO.getInstance().create(objeto);
        }
        
        public static List<ItemVenda> carregar(){
            return ItemVendaDAO.getInstance().retrieve();
        }
        
        public static ItemVenda carregar(int parPK) {
            return ItemVendaDAO.getInstance().retrieve(parPK);
        }
        
        public static List<ItemVenda> carregar(String parString) {
            return ItemVendaDAO.getInstance().retrieve(parString);
        }
        
        public static void atualizar(ItemVenda objeto){
            ItemVendaDAO.getInstance().update(objeto);
        }
        
        public static void remover(ItemVenda objeto){
            ItemVendaDAO.getInstance().delete(objeto);
        }
    
}
