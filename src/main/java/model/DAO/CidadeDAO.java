/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import static controller_busca.ControllerBuscaCidade.colunaFiltro;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.bo.Cidade;


/**
 *
 * @author aluno
 */
public class CidadeDAO implements InterfaceDAO<Cidade>{

    private static CidadeDAO instance;
    protected EntityManager entityManager;
    
     public static CidadeDAO getInstance(){
        if(instance==null){
            instance = new CidadeDAO();
        }
        return instance;
    }
    
    public CidadeDAO(){
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
    public void create(Cidade objeto) {
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
    public List<Cidade> retrieve() {
        List<Cidade> listaCidades;
        listaCidades = entityManager.createQuery("Select c From Cidade c",Cidade.class).getResultList();
        return listaCidades;
    }

    @Override
    public Cidade retrieve(int parPK) {
        return entityManager.find(Cidade.class, parPK);
    }

    public List<Cidade> retrieve(String nomeParametro, String parString) {
        List<Cidade> listaCidades;
        listaCidades = entityManager.createQuery("Select c from Cidade c Where c." + nomeParametro + " like "
                + ":parDescricao", Cidade.class).setParameter("parDescricao", "%" + parString + "%").getResultList();
        return listaCidades;
    }

    @Override
    public void update(Cidade objeto) {
        try {
             Cidade cidade = entityManager.find(Cidade.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Cidade objeto) {
        
    }

    @Override
    public List<Cidade> retrieve(String parString) {
        return null;
    }
 }

    