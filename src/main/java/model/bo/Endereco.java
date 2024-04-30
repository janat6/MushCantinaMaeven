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
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String cep;
    @Column
    private String logradouro;
    @Column
    private String status;

    @JoinColumn
    @ManyToOne
    private Bairro bairro;
    
    @JoinColumn
    @ManyToOne
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(int id, String status, String cep, String logradouro) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.status = status;
    }

    public Endereco(int id, String status, String cep, String logradouro, Cidade cidade, Bairro bairro) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.status = status;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return this.getCep() + ' '
                + this.getLogradouro() + ' '
                + this.bairro.getDescricao() + ' '
                + this.cidade.getDescricao() + ' '
                + this.getStatus() + ' ';

    }


}
