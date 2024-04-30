/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import static controller_busca.ControllerBuscaFornecedor.colunaFiltro;
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
import model.bo.Fornecedor;

/**
 *
 * @author aluno
 */
public class FornecedorDAO implements InterfaceDAO<Fornecedor>{
    
    private static FornecedorDAO instance;
    protected EntityManager entityManager;
    
     public static FornecedorDAO getInstance(){
        if(instance==null){
            instance = new FornecedorDAO();
        }
        return instance;
    }
    
    public FornecedorDAO(){
        entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_Cantina");
        
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    public void create(Fornecedor objeto) {
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
 public List<Fornecedor> retrieve() {
    List<Fornecedor> listaFornecedores;
        listaFornecedores = entityManager.createQuery("Select fo From Fornecedor fo",Fornecedor.class).getResultList();
        return listaFornecedores;
    }

    public Fornecedor retrieve(int parPK) {
        return entityManager.find(Fornecedor.class, parPK);
    }

    public List<Fornecedor> retrieve(String nomeParametro, String parString) {
        List<Fornecedor> listaFornecedores;
        listaFornecedores = entityManager.createQuery("Select fo from Fornecedor fo Where fo." + nomeParametro + " like "
                + ":parRazaosocial", Fornecedor.class).setParameter("parRazaosocial", "%" + parString + "%").getResultList();
        return listaFornecedores;
    }
    
    @Override
    public void update(Fornecedor objeto) {
        try {
             Fornecedor fornecedor = entityManager.find(Fornecedor.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Fornecedor objeto) {
    }

    @Override
    public List<Fornecedor> retrieve(String parString) {
        return null;
    }

}
