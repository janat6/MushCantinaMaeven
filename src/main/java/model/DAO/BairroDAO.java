/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import model.bo.Bairro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class BairroDAO implements InterfaceDAO<Bairro>{

    private static BairroDAO instance;
    protected EntityManager entityManager;
    
    public static BairroDAO getInstance(){
        if(instance==null){
            instance = new BairroDAO();
        }
        return instance;
    }
    
    public BairroDAO(){
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
    public void create(Bairro objeto){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
       }
    }
    
    
    
    public List<Bairro> retrieve() {
        List<Bairro> listaBairros;
        listaBairros = entityManager.createQuery("Select b From Bairro b",Bairro.class).getResultList();
        return listaBairros;
    }

    @Override
    public Bairro retrieve(int parPK){
        return entityManager.find(Bairro.class, parPK);
    }
    

    @Override
    public List<Bairro> retrieve(String parString) {
        List<Bairro> listaBairros;
        listaBairros = entityManager.createQuery("Select b from Bairro b Where b.descricao like "
                + ":parDescricao", Bairro.class).setParameter("parDescricao", "%" + parString + "%").getResultList();
        return listaBairros;
    }

    @Override
    public void update(Bairro objeto) {
        try {
             Bairro bairro = entityManager.find(Bairro.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Bairro objeto) {
    }


}
