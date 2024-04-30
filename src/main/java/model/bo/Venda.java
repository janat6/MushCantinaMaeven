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
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;
    @Column
    private String dataVenda;
    @Column
    private String horaVenda;
    @Column
    private String valordesconto;
    @Column
    private String flagtipodesconto;
    @Column
    private String observacao;
    @Column
    private String status;

    @JoinColumn
    @ManyToOne
    private Funcionario funcionario;
    
    @JoinColumn (name = "carteirinha_id", nullable = true)
    @ManyToOne
    private Carteirinha carteirinha;
    
    public Venda() {
    }

    public Venda(String dataVenda, String horaVenda, String valordesconto, String flagtipodesconto, String observacao, String status) {
//        this.id = id;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
        this.valordesconto = valordesconto;
        this.flagtipodesconto = flagtipodesconto;
        this.observacao = observacao;
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }

    /**
     *
     * @return
     */
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

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }


    public String getValorDesconto() {
        return valordesconto;
    }

    public void setValorDesconto(String valorDesconto) {
        this.valordesconto = valorDesconto;
    }

    public String getFlagTipoDesconto() {
        return flagtipodesconto;
    }

    public void setFlagTipoDesconto(String flagTipoDesconto) {
        this.flagtipodesconto = flagTipoDesconto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return  this.getId() + " " +
                this.getDataVenda() + " " +
                this.getHoraVenda() + " " +
                this.getValorDesconto() + " " +
                this.getFlagTipoDesconto()+ " "+
                this.getObservacao() + " " +
                this.getStatus() + " "+ 
                this.funcionario.getCpf()+" "+
                this.funcionario.getRg()+" "+
                this.funcionario.getUsuario()+" "+
                this.funcionario.getSenha()+" ";        
    }
                
    }
    
    
    
