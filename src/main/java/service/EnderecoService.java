/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.DAO.EnderecoDAO;
import model.bo.Endereco;

/**
 *
 * @author aluno
 */
public class EnderecoService {
    public static void adicionar(Endereco objeto) {
        EnderecoDAO.getInstance().create(objeto);
    }

    public static List<Endereco> carregar() {
        return EnderecoDAO.getInstance().retrieve();
    }

    public static Endereco carregar(int parPK) {
        return EnderecoDAO.getInstance().retrieve(parPK);
    }

    public static List<Endereco> carregar(String nomeParametro, String parString) {
        return EnderecoDAO.getInstance().retrieve(nomeParametro, parString);
    }

    public static void atualizar(Endereco objeto) {
        EnderecoDAO.getInstance().update(objeto);
    }

    public static void remover(Endereco objeto) {
        EnderecoDAO.getInstance().delete(objeto);
    }
}
