
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.CidadeDAO;
import model.bo.Cidade;

/**
 *
 * @author aluno
 */
public class CidadeService {
    public static void adicionar(Cidade objeto) {
            CidadeDAO.getInstance().create(objeto);
        }
        
        public static List<Cidade> carregar(){
            return CidadeDAO.getInstance().retrieve();
        }
        
        public static Cidade carregar(int parPK) {
            return CidadeDAO.getInstance().retrieve(parPK);
        }
        
        public static List<Cidade> carregar(String nomeParametro, String parString) {
            return CidadeDAO.getInstance().retrieve(nomeParametro, parString);
        }
        
        public static void atualizar(Cidade objeto){
            CidadeDAO.getInstance().update(objeto);
        }
        
        public static void remover(Cidade objeto){
            CidadeDAO.getInstance().delete(objeto);
        }
}
