/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.VendaDAO;
import model.bo.Venda;

/**
 *
 * @author aluno
 */
public class VendaService {
    public static void adicionar(Venda objeto) {
            VendaDAO.getInstance().create(objeto);
        }
        
        public static List<Venda> carregar(){
            return VendaDAO.getInstance().retrieve();
        }
        
        public static Venda carregar(int parPK) {
            return VendaDAO.getInstance().retrieve(parPK);
        }
        
        public static  String carregaDeLadinho(String info){
            VendaDAO vendaDAO = new VendaDAO();
            return vendaDAO.retornoNome(info);
        }
        public static List<Venda> carregar(String nomeParametro, String parString) {
            return VendaDAO.getInstance().retrieve(nomeParametro, parString);
        }
        
        public static void atualizar(Venda objeto){
            VendaDAO.getInstance().update(objeto);
        }
        
        public static void remover(Venda objeto){
            VendaDAO.getInstance().delete(objeto);
        }
}
