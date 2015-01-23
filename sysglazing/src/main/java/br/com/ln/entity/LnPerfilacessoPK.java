/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Marcos Naves
 */
@Embeddable
public class LnPerfilacessoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "per_in_codigo")
    private Integer perInCodigo;
    @Basic(optional = false)
    @Column(name = "mod_in_codigo")
    private Integer modInCodigo;

    public LnPerfilacessoPK() {
    }

    public LnPerfilacessoPK(Integer perInCodigo, Integer modInCodigo) {
        this.perInCodigo = perInCodigo;
        this.modInCodigo = modInCodigo;
    }

    public Integer getPerInCodigo() {
        return perInCodigo;
    }

    public void setPerInCodigo(Integer perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    public Integer getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(Integer modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.perInCodigo);
        hash = 83 * hash + Objects.hashCode(this.modInCodigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LnPerfilacessoPK other = (LnPerfilacessoPK) obj;
        if (!Objects.equals(this.perInCodigo, other.perInCodigo)) {
            return false;
        }
        if (!Objects.equals(this.modInCodigo, other.modInCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LnPerfilacessoPK{" + "perInCodigo=" + perInCodigo + ", modInCodigo=" + modInCodigo + '}';
    }

    
}
