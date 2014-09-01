/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "ln_perfilacesso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnPerfilacesso.findAll", query = "SELECT l FROM LnPerfilacesso l"),
    @NamedQuery(name = "LnPerfilacesso.findByPerInCodigo", query = "SELECT l FROM LnPerfilacesso l WHERE l.lnPerfilacessoPK.perInCodigo = :perInCodigo"),
    @NamedQuery(name = "LnPerfilacesso.findByModInCodigo", query = "SELECT l FROM LnPerfilacesso l WHERE l.lnPerfilacessoPK.modInCodigo = :modInCodigo"),
    @NamedQuery(name = "LnPerfilacesso.findByPacChIncluir", query = "SELECT l FROM LnPerfilacesso l WHERE l.pacChIncluir = :pacChIncluir"),
    @NamedQuery(name = "LnPerfilacesso.findByPacChAlterar", query = "SELECT l FROM LnPerfilacesso l WHERE l.pacChAlterar = :pacChAlterar"),
    @NamedQuery(name = "LnPerfilacesso.findByPacChExcluir", query = "SELECT l FROM LnPerfilacesso l WHERE l.pacChExcluir = :pacChExcluir"),
    @NamedQuery(name = "LnPerfilacesso.findByPacChPesquisar", query = "SELECT l FROM LnPerfilacesso l WHERE l.pacChPesquisar = :pacChPesquisar")})
public class LnPerfilacesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LnPerfilacessoPK lnPerfilacessoPK;
    @Basic(optional = false)
    @Column(name = "pac_ch_incluir")
    private Character pacChIncluir;
    @Basic(optional = false)
    @Column(name = "pac_ch_alterar")
    private Character pacChAlterar;
    @Basic(optional = false)
    @Column(name = "pac_ch_excluir")
    private Character pacChExcluir;
    @Basic(optional = false)
    @Column(name = "pac_ch_pesquisar")
    private Character pacChPesquisar;
    @JoinColumn(name = "mod_in_codigo", referencedColumnName = "mod_in_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private LnModulo lnModulo;
    @JoinColumn(name = "per_in_codigo", referencedColumnName = "per_in_codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private LnPerfil lnPerfil;

    public LnPerfilacesso() {
    }

    public LnPerfilacesso(LnPerfilacessoPK lnPerfilacessoPK) {
        this.lnPerfilacessoPK = lnPerfilacessoPK;
    }

    public LnPerfilacesso(LnPerfilacessoPK lnPerfilacessoPK, Character pacChIncluir, Character pacChAlterar, Character pacChExcluir, Character pacChPesquisar) {
        this.lnPerfilacessoPK = lnPerfilacessoPK;
        this.pacChIncluir = pacChIncluir;
        this.pacChAlterar = pacChAlterar;
        this.pacChExcluir = pacChExcluir;
        this.pacChPesquisar = pacChPesquisar;
    }

    public LnPerfilacesso(int perInCodigo, int modInCodigo) {
        this.lnPerfilacessoPK = new LnPerfilacessoPK(perInCodigo, modInCodigo);
    }

    public LnPerfilacessoPK getLnPerfilacessoPK() {
        return lnPerfilacessoPK;
    }

    public void setLnPerfilacessoPK(LnPerfilacessoPK lnPerfilacessoPK) {
        this.lnPerfilacessoPK = lnPerfilacessoPK;
    }

    public Character getPacChIncluir() {
        return pacChIncluir;
    }

    public void setPacChIncluir(Character pacChIncluir) {
        this.pacChIncluir = pacChIncluir;
    }

    public Character getPacChAlterar() {
        return pacChAlterar;
    }

    public void setPacChAlterar(Character pacChAlterar) {
        this.pacChAlterar = pacChAlterar;
    }

    public Character getPacChExcluir() {
        return pacChExcluir;
    }

    public void setPacChExcluir(Character pacChExcluir) {
        this.pacChExcluir = pacChExcluir;
    }

    public Character getPacChPesquisar() {
        return pacChPesquisar;
    }

    public void setPacChPesquisar(Character pacChPesquisar) {
        this.pacChPesquisar = pacChPesquisar;
    }

    public LnModulo getLnModulo() {
        return lnModulo;
    }

    public void setLnModulo(LnModulo lnModulo) {
        this.lnModulo = lnModulo;
    }

    public LnPerfil getLnPerfil() {
        return lnPerfil;
    }

    public void setLnPerfil(LnPerfil lnPerfil) {
        this.lnPerfil = lnPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lnPerfilacessoPK != null ? lnPerfilacessoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnPerfilacesso)) {
            return false;
        }
        LnPerfilacesso other = (LnPerfilacesso) object;
        if ((this.lnPerfilacessoPK == null && other.lnPerfilacessoPK != null) || (this.lnPerfilacessoPK != null && !this.lnPerfilacessoPK.equals(other.lnPerfilacessoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.LnPerfilacesso[ lnPerfilacessoPK=" + lnPerfilacessoPK + " ]";
    }
    
}
