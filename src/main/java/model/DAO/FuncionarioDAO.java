/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import static controller_busca.ControllerBuscaFuncionario.colunaFiltro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import model.bo.Funcionario;

/**
 *
 * @author aluno
 */
public class FuncionarioDAO implements InterfaceDAO<Funcionario>{
    
    private static FuncionarioDAO instance;
    protected EntityManager entityManager;
    
     public static FuncionarioDAO getInstance(){
        if(instance==null){
            instance = new FuncionarioDAO();
        }
        return instance;
    }
    
    public FuncionarioDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_Cantina");
        
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    @Override
    public void create(Funcionario objeto) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Funcionario> retrieve() {
        List<Funcionario> listaFuncionarios;
            listaFuncionarios = entityManager.createQuery("Select f From Funcionario f",Funcionario.class).getResultList();
            return listaFuncionarios;
    }

    public Funcionario retrieve(int parPK) {
        return entityManager.find(Funcionario.class, parPK);
    }

    public List<Funcionario> retrieve(String nomeParametro, String parString) {
        List<Funcionario> listaFuncionarios;
        listaFuncionarios = entityManager.createQuery("Select fu from Funcionario fu Where fu." + nomeParametro + " like "
        + ":parUsuario", Funcionario.class).setParameter("parUsuario", "%" + parString + "%").getResultList();
        return listaFuncionarios;
    }

    @Override
    public void update(Funcionario objeto) {
        try {
             Funcionario funcionario = entityManager.find(Funcionario.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Funcionario objeto) {
    }

    @Override
    public List<Funcionario> retrieve(String parString) {
        return null;
    }

}
