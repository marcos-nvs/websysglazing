/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnEndereco.findAll", query = "SELECT l FROM LnEndereco l"),
    @NamedQuery(name = "LnEndereco.findByEndInCodigo", query = "SELECT l FROM LnEndereco l WHERE l.endInCodigo = :endInCodigo"),
    @NamedQuery(name = "LnEndereco.findByCliInCodigo", query = "SELECT l FROM LnEndereco l WHERE l.cliInCodigo = :cliInCodigo"),
    @NamedQuery(name = "LnEndereco.findByEndStTipo", query = "SELECT l FROM LnEndereco l WHERE l.endStTipo = :endStTipo"),
    @NamedQuery(name = "LnEndereco.findByEndStLogradouro", query = "SELECT l FROM LnEndereco l WHERE l.endStLogradouro = :endStLogradouro"),
    @NamedQuery(name = "LnEndereco.findByEndStNumero", query = "SELECT l FROM LnEndereco l WHERE l.endStNumero = :endStNumero"),
    @NamedQuery(name = "LnEndereco.findByEndStBairro", query = "SELECT l FROM LnEndereco l WHERE l.endStBairro = :endStBairro"),
    @NamedQuery(name = "LnEndereco.findByEndStCidade", query = "SELECT l FROM LnEndereco l WHERE l.endStCidade = :endStCidade"),
    @NamedQuery(name = "LnEndereco.findByEndStEstado", query = "SELECT l FROM LnEndereco l WHERE l.endStEstado = :endStEstado"),
    @NamedQuery(name = "LnEndereco.findByEndStCep", query = "SELECT l FROM LnEndereco l WHERE l.endStCep = :endStCep")})
public class LnEndereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "end_in_codigo")
    private Integer endInCodigo;
    @Basic(optional = false)
    @Column(name = "cli_in_codigo")
    private Integer cliInCodigo;
    @Basic(optional = false)
    @Column(name = "end_st_tipo")
    private String endStTipo;
    @Basic(optional = false)
    @Column(name = "end_st_logradouro")
    private String endStLogradouro;
    @Basic(optional = false)
    @Column(name = "end_st_numero")
    private String endStNumero;
    @Basic(optional = false)
    @Column(name = "end_st_complemento")
    private String endStComplemento;
    @Basic(optional = false)
    @Column(name = "end_st_bairro")
    private String endStBairro;
    @Basic(optional = false)
    @Column(name = "end_st_cidade")
    private String endStCidade;
    @Basic(optional = false)
    @Column(name = "end_st_estado")
    private String endStEstado;
    @Basic(optional = false)
    @Column(name = "end_st_cep")
    private String endStCep;

    public LnEndereco() {
    }

    public LnEndereco(Integer endInCodigo) {
        this.endInCodigo = endInCodigo;
    }

    public LnEndereco(Integer endInCodigo, Integer cliInCodigo, String endStTipo, String endStLogradouro, String endStNumero, String endStComplemento, String endStBairro, String endStCidade, String endStEstado, String endStCep) {
        this.endInCodigo = endInCodigo;
        this.cliInCodigo = cliInCodigo;
        this.endStTipo = endStTipo;
        this.endStLogradouro = endStLogradouro;
        this.endStNumero = endStNumero;
        this.endStComplemento = endStComplemento;
        this.endStBairro = endStBairro;
        this.endStCidade = endStCidade;
        this.endStEstado = endStEstado;
        this.endStCep = endStCep;
    }

    public Integer getEndInCodigo() {
        return endInCodigo;
    }

    public void setEndInCodigo(Integer endInCodigo) {
        this.endInCodigo = endInCodigo;
    }

    public Integer getCliInCodigo() {
        return cliInCodigo;
    }

    public void setCliInCodigo(Integer cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public String getEndStTipo() {
        return endStTipo;
    }

    public void setEndStTipo(String endStTipo) {
        this.endStTipo = endStTipo;
    }

    public String getEndStLogradouro() {
        return endStLogradouro;
    }

    public void setEndStLogradouro(String endStLogradouro) {
        this.endStLogradouro = endStLogradouro;
    }

    public String getEndStNumero() {
        return endStNumero;
    }

    public void setEndStNumero(String endStNumero) {
        this.endStNumero = endStNumero;
    }

    public String getEndStComplemento() {
        return endStComplemento;
    }

    public void setEndStComplemento(String endStComplemento) {
        this.endStComplemento = endStComplemento;
    }
    

    public String getEndStBairro() {
        return endStBairro;
    }

    public void setEndStBairro(String endStBairro) {
        this.endStBairro = endStBairro;
    }

    public String getEndStCidade() {
        return endStCidade;
    }

    public void setEndStCidade(String endStCidade) {
        this.endStCidade = endStCidade;
    }

    public String getEndStEstado() {
        return endStEstado;
    }

    public void setEndStEstado(String endStEstado) {
        this.endStEstado = endStEstado;
    }

    public String getEndStCep() {
        return endStCep;
    }

    public void setEndStCep(String endStCep) {
        this.endStCep = endStCep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (endInCodigo != null ? endInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnEndereco)) {
            return false;
        }
        LnEndereco other = (LnEndereco) object;
        if ((this.endInCodigo == null && other.endInCodigo != null) || (this.endInCodigo != null && !this.endInCodigo.equals(other.endInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LnEndereco{" + "endInCodigo=" + endInCodigo + ", cliInCodigo=" + cliInCodigo + ", endStTipo=" + endStTipo + ", endStLogradouro=" + endStLogradouro + ", endStNumero=" + endStNumero + ", endStComplemento=" + endStComplemento + ", endStBairro=" + endStBairro + ", endStCidade=" + endStCidade + ", endStEstado=" + endStEstado + ", endStCep=" + endStCep + '}';
    }


    
}
