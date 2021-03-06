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
@Table(name = "ln_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LnCliente.findAll", query = "SELECT l FROM LnCliente l"),
    @NamedQuery(name = "LnCliente.findByCliInCodigo", query = "SELECT l FROM LnCliente l WHERE l.cliInCodigo = :cliInCodigo"),
    @NamedQuery(name = "LnCliente.findByCliStCpf", query = "SELECT l FROM LnCliente l WHERE l.cliStCpf = :cliStCpf"),
    @NamedQuery(name = "LnCliente.findByCliStCnpj", query = "SELECT l FROM LnCliente l WHERE l.cliStCnpj = :cliStCnpj"),
    @NamedQuery(name = "LnCliente.findByCliStRg", query = "SELECT l FROM LnCliente l WHERE l.cliStRg = :cliStRg"),
    @NamedQuery(name = "LnCliente.findByCliStIe", query = "SELECT l FROM LnCliente l WHERE l.cliStIe = :cliStIe"),
    @NamedQuery(name = "LnCliente.findByCliStNome", query = "SELECT l FROM LnCliente l WHERE l.cliStNome = :cliStNome"),
    @NamedQuery(name = "LnCliente.findByCliStEmail", query = "SELECT l FROM LnCliente l WHERE l.cliStEmail = :cliStEmail"),
    @NamedQuery(name = "LnCliente.findByCliChTipo", query = "SELECT l FROM LnCliente l WHERE l.cliChTipo = :cliChTipo")})
public class LnCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cli_in_codigo")
    private Integer cliInCodigo;
    @Column(name = "cli_st_cpf")
    private String cliStCpf;
    @Column(name = "cli_st_cnpj")
    private String cliStCnpj;
    @Column(name = "cli_st_rg")
    private String cliStRg;
    @Column(name = "cli_st_ie")
    private String cliStIe;
    @Basic(optional = false)
    @Column(name = "cli_st_nome")
    private String cliStNome;
    @Column(name = "cli_st_email")
    private String cliStEmail;
    @Column(name = "cli_st_contato")
    private String cliStContato;
    @Column(name = "cli_ch_tipo")
    private Character cliChTipo;

    public LnCliente() {
    }

    public LnCliente(Integer cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public LnCliente(Integer cliInCodigo, String cliStCpf, String cliStCnpj, String cliStRg, String cliStIe, String cliStNome, String cliStEmail, String cliStContato) {
        this.cliInCodigo = cliInCodigo;
        this.cliStCpf = cliStCpf;
        this.cliStCnpj = cliStCnpj;
        this.cliStRg = cliStRg;
        this.cliStIe = cliStIe;
        this.cliStNome = cliStNome;
        this.cliStEmail = cliStEmail;
        this.cliStContato = cliStContato;
    }

    public LnCliente(String cliStCpf, String cliStCnpj, String cliStRg, String cliStIe, String cliStNome, String cliStEmail, String cliStContato, Character cliChTipo) {
        this.cliStCpf = cliStCpf;
        this.cliStCnpj = cliStCnpj;
        this.cliStRg = cliStRg;
        this.cliStIe = cliStIe;
        this.cliStNome = cliStNome;
        this.cliStEmail = cliStEmail;
        this.cliStContato = cliStContato;
        this.cliChTipo = cliChTipo;
    }

    public LnCliente(Integer cliInCodigo, String cliStNome) {
        this.cliInCodigo = cliInCodigo;
        this.cliStNome = cliStNome;
    }

    public Integer getCliInCodigo() {
        return cliInCodigo;
    }

    public void setCliInCodigo(Integer cliInCodigo) {
        this.cliInCodigo = cliInCodigo;
    }

    public String getCliStCpf() {
        return cliStCpf;
    }

    public void setCliStCpf(String cliStCpf) {
        this.cliStCpf = cliStCpf;
    }

    public String getCliStCnpj() {
        return cliStCnpj;
    }

    public void setCliStCnpj(String cliStCnpj) {
        this.cliStCnpj = cliStCnpj;
    }

    public String getCliStRg() {
        return cliStRg;
    }

    public void setCliStRg(String cliStRg) {
        this.cliStRg = cliStRg;
    }

    public String getCliStIe() {
        return cliStIe;
    }

    public void setCliStIe(String cliStIe) {
        this.cliStIe = cliStIe;
    }

    public String getCliStNome() {
        return cliStNome;
    }

    public void setCliStNome(String cliStNome) {
        this.cliStNome = cliStNome;
    }

    public String getCliStEmail() {
        return cliStEmail;
    }

    public void setCliStEmail(String cliStEmail) {
        this.cliStEmail = cliStEmail;
    }

    public String getCliStContato() {
        return cliStContato;
    }

    public void setCliStContato(String cliStContato) {
        this.cliStContato = cliStContato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliInCodigo != null ? cliInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LnCliente)) {
            return false;
        }
        LnCliente other = (LnCliente) object;
        if ((this.cliInCodigo == null && other.cliInCodigo != null) || (this.cliInCodigo != null && !this.cliInCodigo.equals(other.cliInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LnCliente{" + "cliInCodigo=" + cliInCodigo + ", cliStCpf=" + cliStCpf + ", cliStCnpj=" + cliStCnpj + ", cliStRg=" + cliStRg + ", cliStIe=" + cliStIe + ", cliStNome=" + cliStNome + ", cliStEmail=" + cliStEmail + ", cliStContato=" + cliStContato + ", cliChTipo=" + cliChTipo + '}';
    }

}
