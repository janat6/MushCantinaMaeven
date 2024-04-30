/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

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

/**
 *
 * @author aluno
 */
public class EnderecoDAO implements InterfaceDAO<Endereco>{
    
    private static EnderecoDAO instance;
    protected EntityManager entityManager;
    
     public static EnderecoDAO getInstance(){
        if(instance==null){
            instance = new EnderecoDAO();
        }
        return instance;
    }
    
    public EnderecoDAO(){
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
    public void create(Endereco objeto) {
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
    public List<Endereco> retrieve() {
        List<Endereco> listaEnderecos;
        listaEnderecos = entityManager.createQuery("Select e From Endereco e",Endereco.class).getResultList();
        return listaEnderecos;
    }

    public Endereco retrieve(int parPK) {
        return entityManager.find(Endereco.class, parPK);
    }

   
    public List<Endereco> retrieve(String nomeParametro, String parString) {
        List<Endereco> listaEnderecos;
        listaEnderecos = entityManager.createQuery("Select e from Endereco e Where e." + nomeParametro + "  like "
                + ":parLogradouro", Endereco.class).setParameter("parLogradouro", "%" + parString + "%").getResultList();
        return listaEnderecos;
    }

    @Override
    public void update(Endereco objeto) {
        try {
             Endereco endereco = entityManager.find(Endereco.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Endereco objeto) {
    }

    @Override
    public List<Endereco> retrieve(String parString) {
        return null;    
    }

}

