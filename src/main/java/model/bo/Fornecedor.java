/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author aluno
 */
@Entity
public class Fornecedor  extends Pessoa  implements Serializable{
    
    @Column
    private String cnpj;
    @Column
    private String inscricaoEstadual;
    @Column
    private String razaoSocial;

    public Fornecedor() {
    }

    public Fornecedor(String cnpj, String inscricaoEstadual, String razaoSocial) {
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    public Fornecedor(String cnpj, String inscricaoEstadual, String razaoSocial, int id, String nome, String fone1, String fone2, String email, String status, String complementoEndereco, Endereco endereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco, endereco);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String toString() {
        return this.getCnpj() + " "+
                this.getInscricaoEstadual()+" "+
                this.getRazaoSocial() + " " ;
                
    }
    
    
}
