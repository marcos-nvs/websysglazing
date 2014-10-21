/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnCliente;
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
@ManagedBean(name="clienteView")
public class ClienteView implements Serializable{
    
    private List<LnCliente> listCliente;
    private LnCliente lnCliente;
    private boolean bTelaCadastro; 
    private String mensagem;

    public ClienteView() {
        listCliente = Postgress.getListObject(LnCliente.class);
    }

    public List<LnCliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<LnCliente> listCliente) {
        this.listCliente = listCliente;
    }

    public LnCliente getLnCliente() {
        return lnCliente;
    }

    public void setLnCliente(LnCliente lnCliente) {
        this.lnCliente = lnCliente;
    }

    public boolean isbTelaCadastro() {
        return bTelaCadastro;
    }

    public void setbTelaCadastro(boolean bTelaCadastro) {
        this.bTelaCadastro = bTelaCadastro;
    }
    
    public void btIncluir(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')){
            bTelaCadastro = true;
        } else {
            mensagem = "Usuario nao tem permissao para incluir cliente";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }
    public void btAlterar(){}
    public void btExluir(){}
    public void btVisualiar(){}
    public void btHistorico(){}
    
}
