/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author aluno
 */
@Entity
public class ItemVenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @Column
    private String qtdProduto;
    @Column
    private String valorUnitario;
    @Column
    private String status;

    @JoinColumn
    @ManyToOne
    private Venda venda;
    
    @JoinColumn
    @ManyToOne
    private Produto produto;
    
    public ItemVenda() {
    }

    public ItemVenda(String qtdProduto, String valorUnitario, String status) {
        this.qtdProduto = qtdProduto;
        this.valorUnitario = valorUnitario;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(String qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return this.getId() + " " +
                this.getQtdProduto() + " " +
                this.getValorUnitario() + " "+
                this.getStatus() + " " +
                this.venda.getId() + " " +
                this.venda.getDataVenda() + " " +
                this.venda.getHoraVenda()+ " " +
                this.venda.getValorDesconto() + " " +
                this.venda.getFlagTipoDesconto()+ " "+
                this.venda.getObservacao() + " " +
                this.venda.getStatus() + " " + 
                this.produto.getId() + " "+
                this.produto.getDescricao() + " "+
                this.produto.getCodigobarra()+ " "+
                this.produto.getStatus() + " ";
    
    
}
}