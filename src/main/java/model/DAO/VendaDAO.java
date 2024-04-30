/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.bo.Venda;


/**
 *
 * @author aluno
 */
public class VendaDAO implements InterfaceDAO<Venda>{
    
    private static VendaDAO instance;
    protected EntityManager entityManager;
    
     public static VendaDAO getInstance(){
        if(instance==null){
            instance = new VendaDAO();
        }
        return instance;
    }
    
    public VendaDAO(){
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
    public void create(Venda objeto) {
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
    public List<Venda> retrieve() {
        List<Venda> listaVendas;
        listaVendas = entityManager.createQuery("Select v From Venda v",Venda.class).getResultList();
        return listaVendas;
    }

    @Override
    public Venda retrieve(int parPK) {
        return entityManager.find(Venda.class, parPK);
    }

    public List<Venda> retrieve(String nomeParametro, String parString) {
        List<Venda> listaVendas;
        listaVendas = entityManager.createQuery("Select v from Venda v Where v.datahoravenda,"
                + " v.valordesconto, v.flagtipodesconto, v.observacao, v.status,"
                + " f.usuario, f. senha, ca.codigobarra AS carteirinha "
                + " JOIN funcionario f ON v.funcionario_id = f.id"
                + " JOIN carteirinha ca ON v.carteirinha_id = f.id like "
                + ":parStatus", Venda.class).setParameter("parStatus", "%" + parString + "%").getResultList();
        return listaVendas;
    }

    @Override
    public void update(Venda objeto) {
        try {
             Venda venda = entityManager.find(Venda.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public String retornoNome(String info) {
       return null;
    }

    @Override
    public void delete(Venda objeto) {
        
    }

    @Override
    public List<Venda> retrieve(String parString) {
        return null;
    }
    
}
