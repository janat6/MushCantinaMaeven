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

/**
 *
 * @author aluno
 */
@Entity
public class Carteirinha implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String codigobarra;
    @Column
    private String datageracao;
    @Column
    private String datacancelamento;

    @JoinColumn
    @ManyToOne
    private Cliente cliente;
    
    public Carteirinha() {
    }

    public Carteirinha(int id, String codigobarra, String datageracao, String datacancelamento) {
        this.id = id;
        this.codigobarra = codigobarra;
        this.datageracao = datageracao;
        this.datacancelamento = datacancelamento;
    }

    public Carteirinha(int id, String codigobarra, String datageracao, String datacancelamento, Cliente cliente) {
        this.id = id;
        this.codigobarra = codigobarra;
        this.datageracao = datageracao;
        this.datacancelamento = datacancelamento;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public String getDataCancelamento() {
        return datacancelamento;
    }

    public void setDataCancelamento(String dataCancelamento) {
        this.datacancelamento = dataCancelamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigobarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigobarra = codigoBarra;
    }

    public String getDataGeracao() {
        return datageracao;
    }

    public void setDataGeracao(String dataGeracao) {
        this.datageracao = dataGeracao;
    }

    @Override
    public String toString() {
        return this.getId()+" "+
                this.getCodigoBarra()+" "+
                this.getDataGeracao()+" "+
                this.getDataCancelamento()+ " " +
                this.cliente.getCpf() + " " +
                this.cliente.getRg() + " " +          
                this.cliente.getMatricula() + " "+
                this.cliente.getDataNascimento() + " ";

    }
        
    
}
