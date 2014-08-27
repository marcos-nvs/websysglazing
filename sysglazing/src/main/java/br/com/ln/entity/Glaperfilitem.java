/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.entity;

import java.io.Serializable;
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
@Table(name = "glaperfilitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glaperfilitem.findAll", query = "SELECT g FROM Glaperfilitem g"),
    @NamedQuery(name = "Glaperfilitem.findByPerInCodigo", query = "SELECT g FROM Glaperfilitem g WHERE g.glaperfilitemPK.perInCodigo = :perInCodigo"),
    @NamedQuery(name = "Glaperfilitem.findByPitInCodigo", query = "SELECT g FROM Glaperfilitem g WHERE g.glaperfilitemPK.pitInCodigo = :pitInCodigo"),
    @NamedQuery(name = "Glaperfilitem.findByMfuInCodigo", query = "SELECT g FROM Glaperfilitem g WHERE g.glaperfilitemPK.mfuInCodigo = :mfuInCodigo")})
public class Glaperfilitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GlaperfilitemPK glaperfilitemPK;

    public Glaperfilitem() {
    }

    public Glaperfilitem(GlaperfilitemPK glaperfilitemPK) {
        this.glaperfilitemPK = glaperfilitemPK;
    }

    public Glaperfilitem(int perInCodigo, int pitInCodigo, int mfuInCodigo) {
        this.glaperfilitemPK = new GlaperfilitemPK(perInCodigo, pitInCodigo, mfuInCodigo);
    }

    public GlaperfilitemPK getGlaperfilitemPK() {
        return glaperfilitemPK;
    }

    public void setGlaperfilitemPK(GlaperfilitemPK glaperfilitemPK) {
        this.glaperfilitemPK = glaperfilitemPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glaperfilitemPK != null ? glaperfilitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glaperfilitem)) {
            return false;
        }
        Glaperfilitem other = (Glaperfilitem) object;
        if ((this.glaperfilitemPK == null && other.glaperfilitemPK != null) || (this.glaperfilitemPK != null && !this.glaperfilitemPK.equals(other.glaperfilitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ln.entity.Glaperfilitem[ glaperfilitemPK=" + glaperfilitemPK + " ]";
    }
    
}
