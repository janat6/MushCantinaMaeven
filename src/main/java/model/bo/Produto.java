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

/**
 *
 * @author aluno
 */
@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;
    @Column
    private String descricao;
    @Column
    private String codigobarra;
    @Column
    private String status;
    @Column
    private float valor;

    public Produto() {
    }

    public Produto(int id, String descricao, String codigobarra, String status, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.codigobarra = codigobarra;
        this.status = status;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigoBarra) {
        this.codigobarra = codigobarra;
    }

    @Override
    public String toString() {
        return this.getId() + " "+
                this.getDescricao() + " "+
                this.getCodigobarra()+ " "+
                this.getStatus() + " " +
                this.getValor() + " ";
                
    }
    
    
}
