/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
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
@ManagedBean(name = "usuarioView")
public class UsuarioView implements Serializable{
    
    private List<LnUsuario> listUsuario;
    private LnUsuario lnUsuario;
    private LnPerfilacesso lnPerfilAcesso;
    private List<LnPerfil> listPerfil;
    private boolean bTelaCadastro;
    private boolean bAtivo;
    private boolean bAlteraSenha;
    private boolean bExpiraSenha;
    private boolean bMostraSenha;
    private String sTipoFuncao;
    private String mensagem;

    public UsuarioView() {
        this.listUsuario = Postgress.getListObject(LnUsuario.class);
        this.listPerfil = Postgress.getListPerfilAtivo('S');
        this.lnPerfilAcesso = VarComuns.lnPerfilacesso;
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

    public void setListPerfil(List<LnPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public boolean isbTelaCadastro() {
        return bTelaCadastro;
    }

    public void setbTelaCadastro(boolean bTelaCadastro) {
        this.bTelaCadastro = bTelaCadastro;
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

    public boolean isbMostraSenha() {
        return bMostraSenha;
    }

    public void setbMostraSenha(boolean bMostraSenha) {
        this.bMostraSenha = bMostraSenha;
    }

    public LnPerfilacesso getLnPerfilAcesso() {
        return lnPerfilAcesso;
    }

    public void setLnPerfilAcesso(LnPerfilacesso lnPerfilAcesso) {
        this.lnPerfilAcesso = lnPerfilAcesso;
    }
    
    
    public void btIncluir(){
        if (lnPerfilAcesso.getPacChIncluir().equals('S')) {
            lnUsuario = new LnUsuario();
            this.bTelaCadastro = true;
            this.bAtivo = false;
            this.bAlteraSenha = false;
            this.bExpiraSenha = false;
            this.sTipoFuncao = "I";
            this.bMostraSenha = true;
        } else {
            mensagem = "Usuário sem permissão de inclusão.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário", mensagem));
        }
    }

    public void btAlterar() {

        if (lnPerfilAcesso.getPacChAlterar().equals('S')) {

            if (lnUsuario != null) {
                this.bTelaCadastro = true;
                this.sTipoFuncao = "A";
                this.bMostraSenha = false;

                if (lnUsuario.getUsuChAlterasenha().equals('S')) {
                    bAlteraSenha = true;
                } else {
                    bAlteraSenha = false;
                }

                if (lnUsuario.getUsuChAtivo().equals('S')) {
                    bAtivo = true;
                } else {
                    bAtivo = false;
                }

                if (lnUsuario.getUsuChExpirasenha().equals('S')) {
                    bExpiraSenha = true;
                } else {
                    bExpiraSenha = false;
                }

            } else {
                mensagem = "Por favor, escolha um Usuário.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário", mensagem));
            }
        } else {
            mensagem = "Usuário sem permissão de Alteração.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário", mensagem));
        }
    }
    
    public void btExcluir() {

        if (lnPerfilAcesso.getPacChExcluir().equals('S')) {

            if (lnUsuario != null) {
                Postgress.deleteObject(lnUsuario);
                listUsuario = Postgress.getListObject(LnUsuario.class);
            } else {
                mensagem = "Por favor, escolha um Usuário.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário", mensagem));
            }
        } else {
                mensagem = "Usuário sem permissão de Exclusão.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário", mensagem));
        }
    }
    
    public void btGravar(){
        this.bTelaCadastro = false;
        
        if (bAtivo){
            lnUsuario.setUsuChAtivo('S');
        } else {
            lnUsuario.setUsuChAtivo('N');
        }
        
        if (bAlteraSenha){
            lnUsuario.setUsuChAlterasenha('S');
        } else {
            lnUsuario.setUsuChAlterasenha('N');
        }
        
        if(bExpiraSenha){
            lnUsuario.setUsuChExpirasenha('S');
        } else {
            lnUsuario.setUsuChExpirasenha('N');
        }
        
        System.out.println("Usuario : " + lnUsuario.toString());
        
        if (sTipoFuncao.equals("I")){
            novoUsuario();
        } else {
            Postgress.saveOrUpdateObject(lnUsuario);
        }
        
        listUsuario = Postgress.getListObject(LnUsuario.class);
    }
    
    public void btCancelar(){
        this.bTelaCadastro = false;
    }
    
    private void novoUsuario(){
        
        LnUsuario lnNovoUsuario = Postgress.getUsuario(lnUsuario.getUsuStCodigo());
        
        if (lnNovoUsuario != null){
            mensagem = "Usuário já Cadastrado.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário", mensagem));
        } else {
            Postgress.saveObject(lnUsuario);
        }
    }
}
