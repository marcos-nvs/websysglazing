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
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "glausuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glausuario.findAll", query = "SELECT g FROM Glausuario g"),
    @NamedQuery(name = "Glausuario.findByUsuStCodigo", query = "SELECT g FROM Glausuario g WHERE g.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "Glausuario.findByUsuStSenha", query = "SELECT g FROM Glausuario g WHERE g.usuStSenha = :usuStSenha"),
    @NamedQuery(name = "Glausuario.findByUsuStNome", query = "SELECT g FROM Glausuario g WHERE g.usuStNome = :usuStNome"),
    @NamedQuery(name = "Glausuario.findByUsuChSituacao", query = "SELECT g FROM Glausuario g WHERE g.usuChSituacao = :usuChSituacao")})
public class Glausuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usu_st_codigo")
    private String usuStCodigo;
    @Column(name = "usu_st_senha")
    private String usuStSenha;
    @Column(name = "usu_st_nome")
    private String usuStNome;
    @Column(name = "usu_ch_situacao")
    private Character usuChSituacao;
    @JoinColumn(name = "per_in_codigo", referencedColumnName = "per_in_codigo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Glaperfil perInCodigo;

    public Glausuario() {
    }

    public Glausuario(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getUsuStSenha() {
        return usuStSenha;
    }

    public void setUsuStSenha(String usuStSenha) {
        this.usuStSenha = usuStSenha;
    }

    public String getUsuStNome() {
        return usuStNome;
    }

    public void setUsuStNome(String usuStNome) {
        this.usuStNome = usuStNome;
    }

    public Character getUsuChSituacao() {
        return usuChSituacao;
    }

    public void setUsuChSituacao(Character usuChSituacao) {
        this.usuChSituacao = usuChSituacao;
    }

    public Glaperfil getPerInCodigo() {
        return perInCodigo;
    }

    public void setPerInCodigo(Glaperfil perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuStCodigo != null ? usuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glausuario)) {
            return false;
        }
        Glausuario other = (Glausuario) object;
        if ((this.usuStCodigo == null && other.usuStCodigo != null) || (this.usuStCodigo != null && !this.usuStCodigo.equals(other.usuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.Glausuario[ usuStCodigo=" + usuStCodigo + " ]";
    }
    
}
