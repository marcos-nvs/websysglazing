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
@Table(name = "glamodulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glamodulo.findAll", query = "SELECT g FROM Glamodulo g"),
    @NamedQuery(name = "Glamodulo.findByModInCodigo", query = "SELECT g FROM Glamodulo g WHERE g.modInCodigo = :modInCodigo"),
    @NamedQuery(name = "Glamodulo.findByModStDescricao", query = "SELECT g FROM Glamodulo g WHERE g.modStDescricao = :modStDescricao"),
    @NamedQuery(name = "Glamodulo.findByModChSituacao", query = "SELECT g FROM Glamodulo g WHERE g.modChSituacao = :modChSituacao"),
    @NamedQuery(name = "Glamodulo.findByModStNome", query = "SELECT g FROM Glamodulo g WHERE g.modStNome = :modStNome")})
public class Glamodulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mod_in_codigo")
    private Integer modInCodigo;
    @Column(name = "mod_st_descricao")
    private String modStDescricao;
    @Column(name = "mod_ch_situacao")
    private Character modChSituacao;
    @Column(name = "mod_st_nome")
    private String modStNome;

    public Glamodulo() {
    }

    public Glamodulo(Integer modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    public Integer getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(Integer modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    public String getModStDescricao() {
        return modStDescricao;
    }

    public void setModStDescricao(String modStDescricao) {
        this.modStDescricao = modStDescricao;
    }

    public Character getModChSituacao() {
        return modChSituacao;
    }

    public void setModChSituacao(Character modChSituacao) {
        this.modChSituacao = modChSituacao;
    }

    public String getModStNome() {
        return modStNome;
    }

    public void setModStNome(String modStNome) {
        this.modStNome = modStNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modInCodigo != null ? modInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glamodulo)) {
            return false;
        }
        Glamodulo other = (Glamodulo) object;
        if ((this.modInCodigo == null && other.modInCodigo != null) || (this.modInCodigo != null && !this.modInCodigo.equals(other.modInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.Glamodulo[ modInCodigo=" + modInCodigo + " ]";
    }
    
}
