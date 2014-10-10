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
public class PerfilView implements Serializable {

    private List<LnPerfil> listPerfil;
    private List<LnPerfilacesso> listPerfilAcesso;
    private List<LnModulo> listModulo;
    private LnPerfil lnPerfil;
    private LnPerfilacesso lnPerfilacesso;
    private boolean bVerAcesso;
    private boolean bEditPerfil = false;
    private boolean bEditAcesso = false;
    private boolean bAtivo;
    private boolean bAltSenhaUsuario;
    private boolean bIncluirAcesso;
    private boolean bAlterarAcesso;
    private boolean bExcluirAcesso;
    private boolean bPesquisarAcesso;
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

    public boolean isbIncluirAcesso() {
        return bIncluirAcesso;
    }

    public void setbIncluirAcesso(boolean bIncluirAcesso) {
        this.bIncluirAcesso = bIncluirAcesso;
    }

    public boolean isbAlterarAcesso() {
        return bAlterarAcesso;
    }

    public void setbAlterarAcesso(boolean bAlterarAcesso) {
        this.bAlterarAcesso = bAlterarAcesso;
    }

    public boolean isbExcluirAcesso() {
        return bExcluirAcesso;
    }

    public void setbExcluirAcesso(boolean bExcluirAcesso) {
        this.bExcluirAcesso = bExcluirAcesso;
    }

    public boolean isbPesquisarAcesso() {
        return bPesquisarAcesso;
    }

    public void setbPesquisarAcesso(boolean bPesquisarAcesso) {
        this.bPesquisarAcesso = bPesquisarAcesso;
    }

    public String buscaDescModulo(Integer modInCodigo) {
        return VarComuns.mapModulo.get(modInCodigo);
    }

    public void btIncluirPerfil() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            this.bEditPerfil = true;
            this.sTipoFuncaoPerfil = "I";
            lnPerfil = new LnPerfil();
        } else {
            mensagem = "Perfil sem permissão de inclusão.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }

    public void btAlterarPerfil() {
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            if (lnPerfil != null) {
                this.bEditPerfil = true;
                this.sTipoFuncaoPerfil = "A";
                this.bAtivo = lnPerfil.getPerChAtivo().equals('S');
                this.bAltSenhaUsuario = lnPerfil.getPerChAlteraSenha().equals('S');
            } else {
                mensagem = "Por favor, escolha um perfil para alterar.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else {
            mensagem = "Perfil sem permissão de alteracao.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }

    public void btExcluirPerfil() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (lnPerfil != null) {
                Postgress.deleteObject(lnPerfil);
                listPerfil = Postgress.getListObject(LnPerfil.class);
                mensagem = "Perfil excluído com sucesso !!!!.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            } else {
                mensagem = "Por favor, escolha um perfil para excluir.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }            
        } else{
            mensagem = "Perfil sem permissão de excluir.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }

    public void btVisualizar() {
    }

    public void btSalvarPerfil() {
        if (lnPerfil != null){
            if (bAtivo){
                lnPerfil.setPerChAtivo('S');
            } else {
                lnPerfil.setPerChAtivo('N');
            }
            if (bAltSenhaUsuario){
                lnPerfil.setPerChAlteraSenha('S');
            } else{
                lnPerfil.setPerChAlteraSenha('N');
            }
            
            if (sTipoFuncaoPerfil.equals("I")){
                novoPerfil();
            } else {
                this.sTipoFuncaoPerfil = "";
                this.bEditPerfil = false;
                Postgress.saveOrUpdateObject(lnPerfil);
                listPerfil = Postgress.getListObject(LnPerfil.class);
                mensagem = "Perfil alterado com sucesso !!!!.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        }
    }
    
    private void novoPerfil(){
        
        LnPerfil lnNovoPerfil = Postgress.getPerfilperStDesc(lnPerfil.getPerStDescricao());
        
        if (lnNovoPerfil != null) {
            mensagem = "Perfil já Cadastrado.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        } else {
            Integer id = Postgress.getLnPeriflNextId();
            lnPerfil.setPerInCodigo(id);
            Postgress.saveObject(lnPerfil);
            this.sTipoFuncaoPerfil = "";
            this.bEditPerfil = false;
            listPerfil = Postgress.getListObject(LnPerfil.class);
            mensagem = "Perfil cadastrado com sucesso !!!!.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }

    public void btCancelarPerfil() {
        this.bEditPerfil = false;
        this.sTipoFuncaoPerfil = "";
        lnPerfil = null;
    }

}
