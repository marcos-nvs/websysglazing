/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnHistorico;
import br.com.ln.entity.LnPerfil;
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
//    private LnPerfilacesso lnPerfilAcesso;
    private List<LnPerfil> listPerfil;
    private boolean bTelaCadastro;
    private boolean bAtivo;
    private boolean bAlteraSenha;
    private boolean bExpiraSenha;
    private boolean bMostraSenha;
    private boolean bPerSenha;
    private boolean bExclui;
    private String sTipoFuncao;
    private String mensagem;
    private String novaSenha;
    private String repeteSenha;

    public UsuarioView() {
        this.listUsuario = Postgress.getListObject(LnUsuario.class);
        this.listPerfil = Postgress.getListPerfilAtivo('S');
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

    public boolean isbPerSenha() {
        return bPerSenha;
    }

    public void setbPerSenha(boolean bPerSenha) {
        this.bPerSenha = bPerSenha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getRepeteSenha() {
        return repeteSenha;
    }

    public void setRepeteSenha(String repeteSenha) {
        this.repeteSenha = repeteSenha;
    }
    
    public void btIncluir(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            lnUsuario = new LnUsuario();
            this.bTelaCadastro = true;
            this.bAtivo = false;
            this.bAlteraSenha = false;
            this.bExpiraSenha = false;
            this.sTipoFuncao = "I";
            this.bMostraSenha = true;
        } else {
            mensagem = "Usuário sem permissão de inclusão.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
        }
    }

    public void btAlterar() {

        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {

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
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
            }
        } else {
            mensagem = "Usuário sem permissão de Alteração.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
        }
    }
    
    public void btExcluir() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (lnUsuario != null) {
                if (Postgress.getVerificaHistorico(lnUsuario.getUsuStCodigo())) {
                    LnHistorico lnHistorico = new LnHistorico(Postgress.getLnHistoricoNextId(), VarComuns.lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo(),
                            Postgress.getDateFromDB(), VarComuns.lnUsusario.getUsuStCodigo(), "Exclusão do usuário : " + lnUsuario.getUsuStCodigo() + " - "+ lnUsuario.getUsuStNome());
                    Postgress.deleteObject(lnUsuario);
                    listUsuario = Postgress.getListObject(LnUsuario.class);
                    Postgress.saveObject(lnHistorico);
                    mensagem = "Usuário excluído com sucesso!!!!.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
                } else {
                    mensagem = "Usuário não pode ser excluído por ter historico. Você pode desativar.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
                }
            } else {
                mensagem = "Por favor, escolha um Usuário.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
            }
        } else {
                mensagem = "Usuário sem permissão de Exclusão.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
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
        
        if (sTipoFuncao.equals("I")){
            novoUsuario();
        } else {
            Postgress.saveOrUpdateObject(lnUsuario);
            LnHistorico lnHistorico = new LnHistorico(Postgress.getLnHistoricoNextId(), VarComuns.lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo(),
                                                      Postgress.getDateFromDB(), VarComuns.lnUsusario.getUsuStCodigo(), "Alteração do usuário : " + lnUsuario.getUsuStCodigo() + " - "+ lnUsuario.getUsuStNome());
            Postgress.saveObject(lnHistorico);
        }
        
        listUsuario = Postgress.getListObject(LnUsuario.class);
        mensagem = "Usuário gravado com sucesso!!!!";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
    }
    
    public void btCancelar(){
        this.bTelaCadastro = false;
    }
    
    private void novoUsuario(){
        
        LnUsuario lnNovoUsuario = Postgress.getUsuario(lnUsuario.getUsuStCodigo());
        
        if (lnNovoUsuario != null){
            mensagem = "Usuário já Cadastrado.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
        } else {
            Postgress.saveObject(lnUsuario);
            LnHistorico lnHistorico = new LnHistorico(Postgress.getLnHistoricoNextId(), VarComuns.lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo(),
                                                      Postgress.getDateFromDB(), VarComuns.lnUsusario.getUsuStCodigo(), "Inclusão do usuário : " + lnUsuario.getUsuStCodigo() + " - "+ lnUsuario.getUsuStNome());
            Postgress.saveObject(lnHistorico);
        }
    }
    
    public void btAltSenha(){
        if (VarComuns.lnPerfil.getPerChAlteraSenha().equals('S')){
            if (lnUsuario != null){
                this.bPerSenha = true;
            } else {
                mensagem = "Por favor, escolha um Usuário .";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
            }
        } else {
            mensagem = "Usuário sem permissão para alterar a senha de outro usuário.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
        }
    }
    
    public void btGravaSenha(){
        
        if (novaSenha.equals(repeteSenha)) {
            this.bPerSenha = false;
            Postgress.saveOrUpdateObject(lnUsuario);
            LnHistorico lnHistorico = new LnHistorico(Postgress.getLnHistoricoNextId(), VarComuns.lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo(),
                                                      Postgress.getDateFromDB(), VarComuns.lnUsusario.getUsuStCodigo(), "Alteração do usuário : " + lnUsuario.getUsuStCodigo() + " - "+ lnUsuario.getUsuStNome());
            Postgress.saveObject(lnHistorico);
            mensagem = "Senha alterada com sucesso.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
        } else {
            mensagem = "Senhas não conferem.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário", mensagem));
        }
    }
    
    public void btCancelarSenha(){
        this.bPerSenha = false;
    }
}
