/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "glaperfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glaperfil.findAll", query = "SELECT g FROM Glaperfil g"),
    @NamedQuery(name = "Glaperfil.findByPerInCodigo", query = "SELECT g FROM Glaperfil g WHERE g.perInCodigo = :perInCodigo"),
    @NamedQuery(name = "Glaperfil.findByPerStDescricao", query = "SELECT g FROM Glaperfil g WHERE g.perStDescricao = :perStDescricao"),
    @NamedQuery(name = "Glaperfil.findByPerChSituacao", query = "SELECT g FROM Glaperfil g WHERE g.perChSituacao = :perChSituacao")})
public class Glaperfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "per_in_codigo")
    private Integer perInCodigo;
    @Column(name = "per_st_descricao")
    private String perStDescricao;
    @Column(name = "per_ch_situacao")
    private Character perChSituacao;
    @OneToMany(mappedBy = "perInCodigo", fetch = FetchType.EAGER)
    private List<Glausuario> glausuarioList;

    public Glaperfil() {
    }

    public Glaperfil(Integer perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    public Integer getPerInCodigo() {
        return perInCodigo;
    }

    public void setPerInCodigo(Integer perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    public String getPerStDescricao() {
        return perStDescricao;
    }

    public void setPerStDescricao(String perStDescricao) {
        this.perStDescricao = perStDescricao;
    }

    public Character getPerChSituacao() {
        return perChSituacao;
    }

    public void setPerChSituacao(Character perChSituacao) {
        this.perChSituacao = perChSituacao;
    }

    @XmlTransient
    public List<Glausuario> getGlausuarioList() {
        return glausuarioList;
    }

    public void setGlausuarioList(List<Glausuario> glausuarioList) {
        this.glausuarioList = glausuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perInCodigo != null ? perInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glaperfil)) {
            return false;
        }
        Glaperfil other = (Glaperfil) object;
        if ((this.perInCodigo == null && other.perInCodigo != null) || (this.perInCodigo != null && !this.perInCodigo.equals(other.perInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.Glaperfil[ perInCodigo=" + perInCodigo + " ]";
    }
    
}
