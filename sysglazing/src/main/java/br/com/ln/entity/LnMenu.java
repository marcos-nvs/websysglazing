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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnMenu.findAll", query = "SELECT l FROM LnMenu l"),
    @NamedQuery(name = "LnMenu.findByMenInCodigo", query = "SELECT l FROM LnMenu l WHERE l.menInCodigo = :menInCodigo"),
    @NamedQuery(name = "LnMenu.findByMenStDescricao", query = "SELECT l FROM LnMenu l WHERE l.menStDescricao = :menStDescricao"),
    @NamedQuery(name = "LnMenu.findByMenChAtivo", query = "SELECT l FROM LnMenu l WHERE l.menChAtivo = :menChAtivo")})
public class LnMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "men_in_codigo")
    private Integer menInCodigo;
    @Basic(optional = false)
    @Column(name = "men_st_descricao")
    private String menStDescricao;
    @Basic(optional = false)
    @Column(name = "men_ch_ativo")
    private Character menChAtivo;
    @JoinTable(name = "ln_menumodulo", joinColumns = {
        @JoinColumn(name = "men_in_codigo", referencedColumnName = "men_in_codigo")}, inverseJoinColumns = {
        @JoinColumn(name = "mod_in_codigo", referencedColumnName = "mod_in_codigo")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<LnModulo> lnModuloList;

    public LnMenu() {
    }

    public LnMenu(Integer menInCodigo) {
        this.menInCodigo = menInCodigo;
    }

    public LnMenu(Integer menInCodigo, String menStDescricao, Character menChAtivo) {
        this.menInCodigo = menInCodigo;
        this.menStDescricao = menStDescricao;
        this.menChAtivo = menChAtivo;
    }

    public Integer getMenInCodigo() {
        return menInCodigo;
    }

    public void setMenInCodigo(Integer menInCodigo) {
        this.menInCodigo = menInCodigo;
    }

    public String getMenStDescricao() {
        return menStDescricao;
    }

    public void setMenStDescricao(String menStDescricao) {
        this.menStDescricao = menStDescricao;
    }

    public Character getMenChAtivo() {
        return menChAtivo;
    }

    public void setMenChAtivo(Character menChAtivo) {
        this.menChAtivo = menChAtivo;
    }

    @XmlTransient
    public List<LnModulo> getLnModuloList() {
        return lnModuloList;
    }

    public void setLnModuloList(List<LnModulo> lnModuloList) {
        this.lnModuloList = lnModuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menInCodigo != null ? menInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnMenu)) {
            return false;
        }
        LnMenu other = (LnMenu) object;
        if ((this.menInCodigo == null && other.menInCodigo != null) || (this.menInCodigo != null && !this.menInCodigo.equals(other.menInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnMenu[ menInCodigo=" + menInCodigo + " ]";
    }
    
}
