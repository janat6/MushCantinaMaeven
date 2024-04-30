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
import model.bo.ItemVenda;


 /* @author aluno*/

public class ItemVendaDAO implements InterfaceDAO<ItemVenda>{
    
    private static ItemVendaDAO instance;
    protected EntityManager entityManager;
    
     public static ItemVendaDAO getInstance(){
        if(instance==null){
            instance = new ItemVendaDAO();
        }
        return instance;
    }
    
    public ItemVendaDAO(){
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
    public void create(ItemVenda objeto) {
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
    public List<ItemVenda> retrieve() {
        List<ItemVenda> listaItemVendas;
        listaItemVendas = entityManager.createQuery("Select i From ItemVenda i",ItemVenda.class).getResultList();
        return listaItemVendas;
    }

    @Override
    public ItemVenda retrieve(int parPK) {
        return entityManager.find(ItemVenda.class, parPK);
    }

    @Override
    public List<ItemVenda> retrieve(String parString) {
        List<ItemVenda> listaItemVendas;
        listaItemVendas = entityManager.createQuery("Select i from ItemVenda i Where i.qtdproduto,"
                + " i.valorunitario, i.status, v.valordesconto, v.flagtipodesconto, "
                + " p.descricao, p.codigobarra JOIN venda v ON i.venda_id = v.id"
                + " JOIN produto p ON i.produto_id = p.id  like "
                + ":parStatus", ItemVenda.class).setParameter("parStatus", "%" + parString + "%").getResultList();
        return listaItemVendas;
    }

    @Override
    public void update(ItemVenda objeto) {
        try {
             ItemVenda itemVenda = entityManager.find(ItemVenda.class, objeto.getId());
             entityManager.getTransaction().begin();
             entityManager.merge(objeto);
             entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(ItemVenda objeto) {
        
    }
    
}


//    @Override
//    public void create(ItemVenda objeto) {
//        Connection conexao = ConnectionFactory.getConnection();
//        String sqlExecutar = "INSERT INTO itemVenda(qntdProduto, valorUnitario, status, venda_id, produto_id) VALUES(?, ?, ?,"
//                  + " (SELECT id FROM venda WHERE id LIKE ?),"
//                  + " (SELECT id FROM produto WHERE id LIKE ?))";
//        
//        
//        PreparedStatement pstm = null;
//        
//        try {
//            pstm = conexao.prepareStatement(sqlExecutar);
//            pstm.setString(1, objeto.getQtdProduto());
//            pstm.setString(2, objeto.getValorUnitario());
//            pstm.setString(3, objeto.getStatus());
//            pstm.setInt(4, objeto.getVenda().getId());
//            pstm.setString(5, objeto.getProduto().getCodigoBarra());
//
//            pstm.execute();
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }finally{
//            ConnectionFactory.closeConnection(conexao, pstm);
//        }
//    }