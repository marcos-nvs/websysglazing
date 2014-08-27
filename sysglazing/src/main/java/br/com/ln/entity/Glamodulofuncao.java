/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos Naves
 */
@Entity
@Table(name = "glamodulofuncao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glamodulofuncao.findAll", query = "SELECT g FROM Glamodulofuncao g"),
    @NamedQuery(name = "Glamodulofuncao.findByModInCodigo", query = "SELECT g FROM Glamodulofuncao g WHERE g.glamodulofuncaoPK.modInCodigo = :modInCodigo"),
    @NamedQuery(name = "Glamodulofuncao.findByMfuInCodigo", query = "SELECT g FROM Glamodulofuncao g WHERE g.glamodulofuncaoPK.mfuInCodigo = :mfuInCodigo"),
    @NamedQuery(name = "Glamodulofuncao.findByMfuStDescricao", query = "SELECT g FROM Glamodulofuncao g WHERE g.mfuStDescricao = :mfuStDescricao"),
    @NamedQuery(name = "Glamodulofuncao.findByMfuStNome", query = "SELECT g FROM Glamodulofuncao g WHERE g.mfuStNome = :mfuStNome")})
public class Glamodulofuncao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GlamodulofuncaoPK glamodulofuncaoPK;
    @Column(name = "mfu_st_descricao")
    private String mfuStDescricao;
    @Column(name = "mfu_st_nome")
    private String mfuStNome;

    public Glamodulofuncao() {
    }

    public Glamodulofuncao(GlamodulofuncaoPK glamodulofuncaoPK) {
        this.glamodulofuncaoPK = glamodulofuncaoPK;
    }

    public Glamodulofuncao(int modInCodigo, int mfuInCodigo) {
        this.glamodulofuncaoPK = new GlamodulofuncaoPK(modInCodigo, mfuInCodigo);
    }

    public GlamodulofuncaoPK getGlamodulofuncaoPK() {
        return glamodulofuncaoPK;
    }

    public void setGlamodulofuncaoPK(GlamodulofuncaoPK glamodulofuncaoPK) {
        this.glamodulofuncaoPK = glamodulofuncaoPK;
    }

    public String getMfuStDescricao() {
        return mfuStDescricao;
    }

    public void setMfuStDescricao(String mfuStDescricao) {
        this.mfuStDescricao = mfuStDescricao;
    }

    public String getMfuStNome() {
        return mfuStNome;
    }

    public void setMfuStNome(String mfuStNome) {
        this.mfuStNome = mfuStNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glamodulofuncaoPK != null ? glamodulofuncaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glamodulofuncao)) {
            return false;
        }
        Glamodulofuncao other = (Glamodulofuncao) object;
        if ((this.glamodulofuncaoPK == null && other.glamodulofuncaoPK != null) || (this.glamodulofuncaoPK != null && !this.glamodulofuncaoPK.equals(other.glamodulofuncaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.Glamodulofuncao[ glamodulofuncaoPK=" + glamodulofuncaoPK + " ]";
    }
    
}
