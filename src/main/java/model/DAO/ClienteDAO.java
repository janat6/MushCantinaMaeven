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
import model.bo.Endereco;
import model.bo.Cidade;
import model.bo.Cliente;

/**
 *
 * @author aluno
 */
public class ClienteDAO implements InterfaceDAO<Cliente>{
    
    private static ClienteDAO instance;
    protected EntityManager entityManager;
    
     public static ClienteDAO getInstance(){
        if(instance==null){
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public ClienteDAO(){
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
public void create(Cliente objeto) {
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
 public List<Cliente> retrieve() {
    List<Cliente> listaClientes;
        listaClientes = entityManager.createQuery("Select cl From Cliente cl",Cliente.class).getResultList();
        return listaClientes;
    }

    public Cliente retrieve(int parPK) {
        return entityManager.find(Cliente.class, parPK);
    }

    public List<Cliente> retrieve(String parString) {
        return null;
    }
    
    public List<Cliente> retrieve(String nomeParametro, String parString) {
        List<Cliente> listaClientes;
        listaClientes = entityManager.createQuery("Select cl from Cliente cl Where cl." + nomeParametro + "  like "
                + ":parNome", Cliente.class).setParameter("parNome", "%" + parString + "%").getResultList();
        return listaClientes;
    }

    @Override
    public void update(Cliente objeto) {
        try {
             Cliente cliente = entityManager.find(Cliente.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cliente objeto) {
    }

}

