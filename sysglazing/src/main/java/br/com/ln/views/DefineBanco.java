/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.views;

import br.com.ln.comum.JsfHelper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcos Naves
 */

@ViewScoped
@ManagedBean(name = "defineCaminho")
public class DefineBanco implements Serializable {
    
    private String strDbName;
    private GlaAccess acesso;
    private String retorno;

    public DefineBanco() {
        this.strDbName = JsfHelper.getRequestParameter("nome");
        acesso = (GlaAccess) JsfHelper.getSessionAttribute("glazingView");
        acesso.setStrDbName(this.strDbName);
    }
    
    public void inicia(){
        retorno = "yes";
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
}
