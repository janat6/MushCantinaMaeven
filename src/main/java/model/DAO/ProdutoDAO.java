/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import static controller_busca.ControllerBuscaProduto.colunaFiltro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Produto;
import java.sql.ResultSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class ProdutoDAO implements InterfaceDAO<Produto>{
    
    private static ProdutoDAO instance;
    protected EntityManager entityManager;
    
     public static ProdutoDAO getInstance(){
        if(instance==null){
            instance = new ProdutoDAO();
        }
        return instance;
    }
    
    public ProdutoDAO(){
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
    public void create(Produto objeto) {
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
    public List<Produto> retrieve() {
        List<Produto> listaProdutos;
        listaProdutos = entityManager.createQuery("Select p From Produto p",Produto.class).getResultList();
        return listaProdutos;
    }

    @Override
    public Produto retrieve(int parPK) {
        return entityManager.find(Produto.class, parPK);
    }

    public List<Produto> retrieve(String nomeParametro, String parString) {
        List<Produto> listaProdutos;
        listaProdutos = entityManager.createQuery("Select p from Produto p Where p." + nomeParametro + " like "
                + ":parDescricao", Produto.class).setParameter("parDescricao", "%" + parString + "%").getResultList();
        return listaProdutos;
    }

    @Override
    public void update(Produto objeto) {
        try {
             Produto produto = entityManager.find(Produto.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Produto objeto) {
        
    }

    @Override
    public List<Produto> retrieve(String parString) {
        return null;
    }
    
    public Produto RetornaDeLadinho(String cod) {
        Produto produto = new Produto();
        produto = (Produto) entityManager.createQuery("select b from Produto b where b.codigobarra like " +cod+"",Produto.class).getSingleResult();  
     
                return produto;
     }
    
    
    
}
