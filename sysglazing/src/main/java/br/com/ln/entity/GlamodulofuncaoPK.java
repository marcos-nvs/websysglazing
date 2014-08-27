/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Marcos Naves
 */
@Embeddable
public class GlamodulofuncaoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "mod_in_codigo")
    private int modInCodigo;
    @Basic(optional = false)
    @Column(name = "mfu_in_codigo")
    private int mfuInCodigo;

    public GlamodulofuncaoPK() {
    }

    public GlamodulofuncaoPK(int modInCodigo, int mfuInCodigo) {
        this.modInCodigo = modInCodigo;
        this.mfuInCodigo = mfuInCodigo;
    }

    public int getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(int modInCodigo) {
        this.modInCodigo = modInCodigo;
    }

    public int getMfuInCodigo() {
        return mfuInCodigo;
    }

    public void setMfuInCodigo(int mfuInCodigo) {
        this.mfuInCodigo = mfuInCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) modInCodigo;
        hash += (int) mfuInCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlamodulofuncaoPK)) {
            return false;
        }
        GlamodulofuncaoPK other = (GlamodulofuncaoPK) object;
        if (this.modInCodigo != other.modInCodigo) {
            return false;
        }
        if (this.mfuInCodigo != other.mfuInCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.GlamodulofuncaoPK[ modInCodigo=" + modInCodigo + ", mfuInCodigo=" + mfuInCodigo + " ]";
    }
    
}
