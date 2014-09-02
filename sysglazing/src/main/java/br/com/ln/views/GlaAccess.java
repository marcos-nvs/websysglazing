/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.views;

import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

    /**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "glazingView")
public class GlaAccess implements Serializable{
    
    private String usuStCodigo;
    private String usuStSenha;
    private String mensagem;
    private String strDbName;
    private LnUsuario lnUsuario;

    public GlaAccess() {
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStrDbName() {
        return strDbName;
    }

    public void setStrDbName(String strDbName) {
        this.strDbName = strDbName;
    }

    public LnUsuario getLnUsuario() {
        return lnUsuario;
    }

    public void setLnUsuario(LnUsuario lnUsuario) {
        this.lnUsuario = lnUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.usuStCodigo);
        hash = 43 * hash + Objects.hashCode(this.usuStSenha);
        hash = 43 * hash + Objects.hashCode(this.mensagem);
        hash = 43 * hash + Objects.hashCode(this.strDbName);
        hash = 43 * hash + Objects.hashCode(this.lnUsuario);
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
        final GlaAccess other = (GlaAccess) obj;
        if (!Objects.equals(this.usuStCodigo, other.usuStCodigo)) {
            return false;
        }
        if (!Objects.equals(this.usuStSenha, other.usuStSenha)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.strDbName, other.strDbName)) {
            return false;
        }
        if (!Objects.equals(this.lnUsuario, other.lnUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GlaAccess{" + "usuStCodigo=" + usuStCodigo + ", usuStSenha=" + usuStSenha + ", mensagem=" + mensagem + ", strDbName=" + strDbName + ", lnUsuario=" + lnUsuario + '}';
    }

   
    public void realizaLogin() {

        System.out.println("Banco realizalogin : " + strDbName);
        
        if (strDbName != null) {
            if (usuStCodigo != null && usuStSenha != null) {
                lnUsuario = Postgress.getUsuario(usuStCodigo, strDbName);

                if (lnUsuario != null) {
                    if (!lnUsuario.getUsuStSenha().equals(usuStSenha)) {
                        mensagem = "Usuário ou Senha Inválido";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e Senha", mensagem));
                    }
                } 
            } else {
                mensagem = "Usuário ou senha em Branco.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e Senha", mensagem));
            }
        }
    }

}
