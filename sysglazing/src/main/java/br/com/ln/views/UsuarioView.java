/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.views;

import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Marcos Naves
 */

@ViewScoped
@ManagedBean(name = "usuarioView")
public class UsuarioView implements Serializable{
    
    private List<LnUsuario> listUsuario = Postgress.getListObject(LnUsuario.class, "Public");
    private LnUsuario lnUsuario;
    private List<LnPerfil> listPerfil = Postgress.getListObject(LnPerfil.class, "Public");
    private boolean bAtivo;
    private boolean bAlteraSenha;
    private boolean bExpiraSenha;
    private boolean bApresenta = false;

    public UsuarioView() {
    }

    public List<LnUsuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<LnUsuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public LnUsuario getLnUsuario() {
        return lnUsuario;
    }

    public void setLnUsuario(LnUsuario lnUsuario) {
        this.lnUsuario = lnUsuario;
    }

    public List<LnPerfil> getListPerfil() {
        return listPerfil;
    }

    public boolean isbAtivo() {
        return bAtivo;
    }

    public void setbAtivo(boolean bAtivo) {
        this.bAtivo = bAtivo;
    }

    public boolean isbAlteraSenha() {
        return bAlteraSenha;
    }

    public void setbAlteraSenha(boolean bAlteraSenha) {
        this.bAlteraSenha = bAlteraSenha;
    }

    public boolean isbExpiraSenha() {
        return bExpiraSenha;
    }

    public void setbExpiraSenha(boolean bExpiraSenha) {
        this.bExpiraSenha = bExpiraSenha;
    }

    public boolean isbApresenta() {
        return bApresenta;
    }

    public void setbApresenta(boolean bApresenta) {
        this.bApresenta = bApresenta;
    }
    
    public void setbotaoIncluir(){
        lnUsuario = new LnUsuario();
        this.bApresenta = true;
    }
    
    public void setbotaoAlterar(){
        if (lnUsuario != null){
            this.bApresenta = true;
        } else {
            this.bApresenta = false;
        }
    }
    
    public void setbotaoGravar(){
        this.bApresenta = false;
    }
    
    public void setbotaoCancelar(){
        this.bApresenta = false;
    }

    public void onRowSelect(SelectEvent event) {

        lnUsuario = (LnUsuario) event.getObject();
        System.out.println("Usuário selecionado : " + lnUsuario.getUsuStCodigo());
        
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Usuario não selecionado", ((LnUsuario) event.getObject()).getUsuStCodigo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
