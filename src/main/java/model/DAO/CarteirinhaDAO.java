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
import model.bo.Carteirinha;
import model.bo.Cliente;

/**
 *
 * @author aluno
 */
public class CarteirinhaDAO implements InterfaceDAO<Carteirinha>{
    
    private static CarteirinhaDAO instance;
    protected EntityManager entityManager;
    
     public static CarteirinhaDAO getInstance(){
        if(instance==null){
            instance = new CarteirinhaDAO();
        }
        return instance;
    }
    
    public CarteirinhaDAO(){
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
    public void create(Carteirinha objeto) {
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
    public List<Carteirinha> retrieve() {
        List<Carteirinha> listaCarteirinhas;
        listaCarteirinhas = entityManager.createQuery("Select ca From Carteirinha ca",Carteirinha.class).getResultList();
        return listaCarteirinhas;
    }

    @Override
    public Carteirinha retrieve(int parPK) {
        return entityManager.find(Carteirinha.class, parPK);
    }

    public List<Carteirinha> retrieve(String nomeParametro, String parString) {
        List<Carteirinha> listaCarteirinhas;
        listaCarteirinhas = entityManager.createQuery("Select ca from Carteirinha ca Where ca." + nomeParametro + " like "
                + ":parCodigobarra", Carteirinha.class).setParameter("parCodigobarra", "%" + parString + "%").getResultList();
        return listaCarteirinhas;
    }

    @Override
    public void update(Carteirinha objeto) {
        try {
             Carteirinha carteirinha = entityManager.find(Carteirinha.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Carteirinha objeto) {
    }

    @Override
    public List<Carteirinha> retrieve(String parString) {
        return null;
    }

}
