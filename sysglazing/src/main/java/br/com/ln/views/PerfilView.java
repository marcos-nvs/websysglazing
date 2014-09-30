/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */

@SessionScoped
@ManagedBean(name = "perfilView")
public class PerfilView implements Serializable{
    
    private List<LnPerfil> listPerfil;
    private List<LnPerfilacesso> listPerfilAcesso;
    private LnPerfil lnPerfil;
    private LnPerfilacesso lnPerfilacesso;
    private boolean bVerAcesso;
    private String mensagem;

    public PerfilView() {
        listPerfil = Postgress.getListObject(LnPerfil.class);
    }

    public List<LnPerfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<LnPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public LnPerfil getLnPerfil() {
        return lnPerfil;
    }

    public void setLnPerfil(LnPerfil lnPerfil) {
        this.lnPerfil = lnPerfil;
    }

    public List<LnPerfilacesso> getListPerfilAcesso() {
        return listPerfilAcesso;
    }

    public void setListPerfilAcesso(List<LnPerfilacesso> listPerfilAcesso) {
        this.listPerfilAcesso = listPerfilAcesso;
    }

    public LnPerfilacesso getLnPerfilacesso() {
        return lnPerfilacesso;
    }

    public void setLnPerfilacesso(LnPerfilacesso lnPerfilacesso) {
        this.lnPerfilacesso = lnPerfilacesso;
    }

    public boolean isbVerAcesso() {
        return bVerAcesso;
    }

    public void setbVerAcesso(boolean bVerAcesso) {
        this.bVerAcesso = bVerAcesso;
    }
    
    
    
    public void btVisualizar(){
        
        if (lnPerfil != null) {
            this.bVerAcesso = true;
            listPerfilAcesso = Postgress.getPerfilAcessoperInCodigo(lnPerfil.getPerInCodigo());
        } else {
        mensagem = "Por favor, escolha o perfil que deseja visualizar";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil", mensagem));
        }
    }
    
    public void btFechar(){
        this.bVerAcesso = false;
    }
    
}
