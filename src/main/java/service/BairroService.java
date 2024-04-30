/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.BairroDAO;
import model.bo.Bairro;

/**
 *
 * @author aluno
 */
public class BairroService {
        public static void adicionar(Bairro objeto) {
            BairroDAO.getInstance().create(objeto);
            //BairroDAO bairroDAO = new BairroDAO();
            //bairroDAO.create(objeto);
        }
        
        public static List<Bairro> carregar(){
            return BairroDAO.getInstance().retrieve();
            //BairroDAO bairroDAO = new BairroDAO();
            //return bairroDAO.retrieve();
        }
        
        public static Bairro carregar(int parPK) {
            return BairroDAO.getInstance().retrieve(parPK);
            //BairroDAO bairroDAO = new BairroDAO();
            //return bairroDAO.retrieve(parPK);
        }
        
        public static List<Bairro> carregar(String parString) {
            return BairroDAO.getInstance().retrieve(parString);
            //BairroDAO bairroDAO = new BairroDAO();
            //return bairroDAO.retrieve(parString);
        }
        
        public static void atualizar(Bairro objeto){
            BairroDAO.getInstance().update(objeto);
            //BairroDAO bairroDAO = new BairroDAO();
            //bairroDAO.update(objeto);
        }
        
        public static void remover(Bairro objeto){
            BairroDAO.getInstance().delete(objeto);
            //BairroDAO bairroDAO = new BairroDAO();
            //bairroDAO.delete(objeto);
        }
}
