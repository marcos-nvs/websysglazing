/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.VarComuns;
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
    private List<LnModulo> listModulo;
    private LnPerfil lnPerfil;
    private LnPerfilacesso lnPerfilacesso;
    private boolean bVerAcesso;
    private boolean bEditPerfil;
    private boolean bEditAcesso;
    private boolean bAtivo;
    private boolean bAltSenhaUsuario;
    private String mensagem;
    private String sTipoFuncaoPerfil;
    private String sTipoFuncaoAcesso;

    public PerfilView() {
        listPerfil = Postgress.getListObject(LnPerfil.class);
        listModulo = Postgress.getListModuloAtivo('S');
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

    public boolean isbEditPerfil() {
        return bEditPerfil;
    }

    public void setbEditPerfil(boolean bEditPerfil) {
        this.bEditPerfil = bEditPerfil;
    }

    public boolean isbEditAcesso() {
        return bEditAcesso;
    }

    public void setbEditAcesso(boolean bEditAcesso) {
        this.bEditAcesso = bEditAcesso;
    }

    public boolean isbAtivo() {
        return bAtivo;
    }

    public void setbAtivo(boolean bAtivo) {
        this.bAtivo = bAtivo;
    }

    public boolean isbAltSenhaUsuario() {
        return bAltSenhaUsuario;
    }

    public void setbAltSenhaUsuario(boolean bAltSenhaUsuario) {
        this.bAltSenhaUsuario = bAltSenhaUsuario;
    }

    public List<LnModulo> getListModulo() {
        return listModulo;
    }

    public void setListModulo(List<LnModulo> listModulo) {
        this.listModulo = listModulo;
    }
    
    public String buscaDescModulo(Integer modInCodigo){
        return VarComuns.mapModulo.get(modInCodigo);
    }
    
    public void btIncluirPerfil() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            this.bEditPerfil = true;
            this.bAtivo = false;
            this.bAltSenhaUsuario = false;
            lnPerfil = new LnPerfil();
            this.sTipoFuncaoPerfil = "I";
        } else {
            mensagem = "Usuário sem permissão de inclusão.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btAlterarPerfil(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            if (lnPerfil != null) {
                this.bEditPerfil = true;
                this.bAtivo = lnPerfil.getPerChAtivo().equals('S');
                this.bAltSenhaUsuario = lnPerfil.getPerChAlteraSenha().equals('S');
                this.sTipoFuncaoPerfil = "A";
            } else {
                mensagem = "Por favor, escolha um perfil.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else {
            mensagem = "Usuário sem permissão de alteração.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btExcluirPerfil(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            if (lnPerfil != null){
                Postgress.deleteObject(lnPerfil);
                listPerfil = Postgress.getListObject(LnPerfil.class);
                mensagem = "Perfil excluído com sucesso!!!.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            } else {
                mensagem = "Por favor, escolha um perfil.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else{
            mensagem = "Usuário sem permissão de exclusão.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btVisualizar(){
        
        if (lnPerfil != null) {
            this.bVerAcesso = true;
            this.bEditPerfil = true;
            listPerfilAcesso = Postgress.getPerfilAcessoperInCodigo(lnPerfil.getPerInCodigo());
        } else {
        mensagem = "Por favor, escolha o perfil que deseja visualizar";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btFechar(){
        this.bVerAcesso = false;
        this.bEditPerfil = false;
    }
    
    public void btGravaPerfil(){
        
        if (bAtivo){
            lnPerfil.setPerChAtivo('S');
        } else {
            lnPerfil.setPerChAtivo('N');
        }
        
        if (bAltSenhaUsuario){
            lnPerfil.setPerChAlteraSenha('S');
        } else {
            lnPerfil.setPerChAlteraSenha('N');
        }
        
        if (sTipoFuncaoPerfil.equals("I")){
            if (novoPerfil()){
                this.bEditPerfil = false;
                this.sTipoFuncaoPerfil = "";
                mensagem = "Perfil criado com sucesso!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else {
            this.bEditPerfil = false;
            this.sTipoFuncaoPerfil = " ";
            mensagem = "Perfil alterado com sucesso!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            Postgress.saveOrUpdateObject(lnPerfil);
        }
    }
    
    public void btCancelarPeril(){
        this.bEditPerfil = false;
        this.sTipoFuncaoPerfil = "";
    }
    
    private boolean novoPerfil(){
        
        LnPerfil LnPerfilNovo = Postgress.getPerfilperStDesc(lnPerfil.getPerStDescricao());
        
        if (LnPerfilNovo != null){
            mensagem = "Perfil já existe!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            return false;
        } else {
            lnPerfil.setPerInCodigo(Postgress.getLnPeriflNextId());
            Postgress.saveObject(lnPerfil);
            listPerfil = Postgress.getListObject(LnPerfil.class);
            return true;
        }
    }
    
    public void btIncluirAcesso(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            this.bEditAcesso = true;
            this.sTipoFuncaoAcesso = "S";
        } else {
            mensagem = "Usuário sem permissão de inclusão.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
}
