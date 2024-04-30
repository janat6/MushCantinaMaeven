/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DAO.FuncionarioDAO;
import model.bo.Funcionario;

/**
 *
 * @author janai
 */
public class FuncionarioService {
    public static void adicionar(Funcionario objeto) {
            FuncionarioDAO.getInstance().create(objeto);
        }
        
        public static List<Funcionario> carregar(){
            return FuncionarioDAO.getInstance().retrieve();
        }
        
        public static Funcionario carregar(int parPK) {
            return FuncionarioDAO.getInstance().retrieve(parPK);
        }
        
        public static List<Funcionario> carregar(String nomeParametro, String parString) {
            return FuncionarioDAO.getInstance().retrieve(nomeParametro, parString);
        }
        
        public static void atualizar(Funcionario objeto){
            FuncionarioDAO.getInstance().update(objeto);
        }
        
        public static void remover(Funcionario objeto){
            FuncionarioDAO.getInstance().delete(objeto);
        }
}
