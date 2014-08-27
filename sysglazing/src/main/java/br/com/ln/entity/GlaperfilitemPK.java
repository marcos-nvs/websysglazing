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
public class GlaperfilitemPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "per_in_codigo")
    private int perInCodigo;
    @Basic(optional = false)
    @Column(name = "pit_in_codigo")
    private int pitInCodigo;
    @Basic(optional = false)
    @Column(name = "mfu_in_codigo")
    private int mfuInCodigo;

    public GlaperfilitemPK() {
    }

    public GlaperfilitemPK(int perInCodigo, int pitInCodigo, int mfuInCodigo) {
        this.perInCodigo = perInCodigo;
        this.pitInCodigo = pitInCodigo;
        this.mfuInCodigo = mfuInCodigo;
    }

    public int getPerInCodigo() {
        return perInCodigo;
    }

    public void setPerInCodigo(int perInCodigo) {
        this.perInCodigo = perInCodigo;
    }

    public int getPitInCodigo() {
        return pitInCodigo;
    }

    public void setPitInCodigo(int pitInCodigo) {
        this.pitInCodigo = pitInCodigo;
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
        hash += (int) perInCodigo;
        hash += (int) pitInCodigo;
        hash += (int) mfuInCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlaperfilitemPK)) {
            return false;
        }
        GlaperfilitemPK other = (GlaperfilitemPK) object;
        if (this.perInCodigo != other.perInCodigo) {
            return false;
        }
        if (this.pitInCodigo != other.pitInCodigo) {
            return false;
        }
        if (this.mfuInCodigo != other.mfuInCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.GlaperfilitemPK[ perInCodigo=" + perInCodigo + ", pitInCodigo=" + pitInCodigo + ", mfuInCodigo=" + mfuInCodigo + " ]";
    }
    
}
