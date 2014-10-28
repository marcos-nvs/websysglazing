/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.Historico;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnPerfilacessoPK;
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
    private Integer modInCodigo;
    private final Historico historico;

    public PerfilView() {
        listPerfil = Postgress.getListObject(LnPerfil.class);
        listModulo = Postgress.getListModuloAtivo('S');
        historico = new Historico();
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

    public Integer getModInCodigo() {
        return modInCodigo;
    }

    public void setModInCodigo(Integer modInCodigo) {
        this.modInCodigo = modInCodigo;
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
            mensagem = "Usuario sem permissao de inclusao.";
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
            mensagem = "Usuario sem permissao de alteracao.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }

    public void btExcluirPerfil() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (lnPerfil != null) {
                List<LnUsuario> listLnUsuario = Postgress.getUsuarioPerfil(lnPerfil.getPerInCodigo());
                System.out.println("ln : " + lnPerfil.getPerStDescricao() + " - listusuario : " + listLnUsuario.size());
                List<LnPerfilacesso> listPerfilacessos = Postgress.getPerfilAcessoperInCodigo(lnPerfil.getPerInCodigo());
                if (listPerfilacessos != null) {
                    mensagem = "Perfil não pode ser excluido, existem itens de acesso cadastrado.!!!!!!!!";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
                } else {
                    if (listLnUsuario != null && !listLnUsuario.isEmpty()) {
                        mensagem = "Este Perfil está sendo utilizado, não pode ser excluido!!!!!!.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
                    } else {
                        Postgress.deleteObject(lnPerfil);
                        listPerfil = Postgress.getListObject(LnPerfil.class);
                        mensagem = "Perfil excluido com sucesso !!!!.";
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
                        historico.gravaHistorico("Exclusao do Perfil : " + lnPerfil.getPerStDescricao());
                    }
                }
            } else {
                mensagem = "Por favor, escolha um perfil para excluir.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }            
        } else{
            mensagem = "Usuario sem permissao de excluir.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }

    public void btVisualizar() {
        if (lnPerfil != null) {
            this.bVerAcesso = true;
            listPerfilAcesso = Postgress.getPerfilAcessoperInCodigo(lnPerfil.getPerInCodigo());
        } else {
            mensagem = "Por favor, escolha um perfil para visualiar os acesso.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }

    public void btSalvarPerfil() {

        if (lnPerfil.getPerStDescricao() != null && !lnPerfil.getPerStDescricao().isEmpty()) {

            if (lnPerfil != null) {
                if (bAtivo) {
                    lnPerfil.setPerChAtivo('S');
                } else {
                    lnPerfil.setPerChAtivo('N');
                }
                if (bAltSenhaUsuario) {
                    lnPerfil.setPerChAlteraSenha('S');
                } else {
                    lnPerfil.setPerChAlteraSenha('N');
                }

                if (sTipoFuncaoPerfil.equals("I")) {
                    novoPerfil();
                } else {
                    this.sTipoFuncaoPerfil = "";
                    this.bEditPerfil = false;
                    Postgress.saveOrUpdateObject(lnPerfil);
                    mensagem = "Perfil alterado com sucesso !!!!.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
                    historico.gravaHistorico("Alteracao do perfil : " + lnPerfil.getPerStDescricao());
                }
                listPerfil = Postgress.getListObject(LnPerfil.class);
            }
        } else {
            mensagem = "Descricao do perfil esta vazio.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil", mensagem));
        }
    }
    
    private void novoPerfil(){
        
        LnPerfil lnNovoPerfil = Postgress.getPerfilperStDesc(lnPerfil.getPerStDescricao());
        
        if (lnNovoPerfil != null) {
            mensagem = "Perfil ja Cadastrado.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        } else {
            Integer id = Postgress.getLnPeriflNextId();
            lnPerfil.setPerInCodigo(id);
            Postgress.saveObject(lnPerfil);
            this.sTipoFuncaoPerfil = "";
            this.bEditPerfil = false;
            mensagem = "Perfil cadastrado com sucesso !!!!.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            historico.gravaHistorico("Cadastro do perfil : " + lnPerfil.getPerStDescricao());
        }
    }

    public void btCancelarPerfil() {
        this.bEditPerfil = false;
        this.sTipoFuncaoPerfil = "";
        lnPerfil = null;
    }
    
    public void btIncluirAcesso(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')){
            lnPerfilacesso = new LnPerfilacesso();
            this.bEditAcesso = true;
            this.sTipoFuncaoAcesso = "I";
        } else {
            mensagem = "Usuario sem acesso para incluir perfil de acesso.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btAlterarAcesso(){
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')){
            if (lnPerfilacesso != null){
                System.out.println("pk : " + lnPerfilacesso.toString());
                this.bEditAcesso = true;
                this.sTipoFuncaoAcesso = "A";
                this.modInCodigo = lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo();
                this.bIncluirAcesso = lnPerfilacesso.getPacChIncluir().equals('S');
                this.bAlterarAcesso = lnPerfilacesso.getPacChAlterar().equals('S');
                this.bExcluirAcesso = lnPerfilacesso.getPacChExcluir().equals('S');
                this.bPesquisarAcesso = lnPerfilacesso.getPacChPesquisar().equals('S');
            } else {
                mensagem = "Por favor, escolha um perfil de acesso.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else {
            mensagem = "Usuario sem acesso para alterar perfil de acesso.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btExcluirAcesso(){
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')){
            if (lnPerfilacesso != null) {
                Postgress.deleteObject(lnPerfilacesso);
                listPerfilAcesso = Postgress.getPerfilAcessoperInCodigo(lnPerfil.getPerInCodigo());
                historico.gravaHistorico("Exclusao do acesso ao modulo :" + buscaDescModulo(lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo()));
            } else {
                mensagem = "Por favor, escolha um perfil de acesso.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            }
        } else {
            mensagem = "Usuario sem acesso para excluir perfil de acesso.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        }
    }
    
    public void btFecharAcesso(){
        this.bVerAcesso = false;
        this.bEditAcesso = false;
        this.sTipoFuncaoAcesso = "";
    }
    
    public void btSalvarAcesso(){
        
        LnPerfilacessoPK lnPerfilacessoPK = new LnPerfilacessoPK(lnPerfil.getPerInCodigo(), modInCodigo);
        
        lnPerfilacesso.setLnPerfilacessoPK(lnPerfilacessoPK);
        
        if (this.bIncluirAcesso){
            lnPerfilacesso.setPacChIncluir('S');
        } else {
            lnPerfilacesso.setPacChIncluir('N');
        }
        if (this.bAlterarAcesso){
            lnPerfilacesso.setPacChAlterar('S');
        } else {
            lnPerfilacesso.setPacChAlterar('N');
        }
        if (this.bExcluirAcesso){
            lnPerfilacesso.setPacChExcluir('S');
        } else {
            lnPerfilacesso.setPacChExcluir('N');
        }
        if (this.bPesquisarAcesso){
            lnPerfilacesso.setPacChPesquisar('S');
        } else {
            lnPerfilacesso.setPacChPesquisar('N');
        }
        
        if (sTipoFuncaoAcesso.equals("I")){
            novoPerfilAcesso();
        } else {
            Postgress.saveOrUpdateObject(lnPerfilacesso);
            mensagem = "Perfil de acesso, alterado com sucesso !!!!.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            this.bEditAcesso = false;
            this.sTipoFuncaoAcesso = "";
            historico.gravaHistorico("Alteracao do acesso ao modulo :" + buscaDescModulo(lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo()));
        }
        listPerfilAcesso = Postgress.getPerfilAcessoperInCodigo(lnPerfil.getPerInCodigo());
    }
    
    public void novoPerfilAcesso(){
        LnPerfilacesso perfilNovo = Postgress.getPerfilAcesso(lnPerfil.getPerInCodigo(), lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo());
        
        if (perfilNovo != null){
            mensagem = "Modulo de acesso ja Cadastrado.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
        } else {
            Postgress.saveObject(lnPerfilacesso);
            this.sTipoFuncaoAcesso ="";
            this.bEditAcesso = false;
            mensagem = "Acesso cadastrado com sucesso !!!!.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Perfil", mensagem));
            historico.gravaHistorico("Inclusao do acesso ao modulo :" + buscaDescModulo(lnPerfilacesso.getLnPerfilacessoPK().getModInCodigo()));
        }
    }
    
    public void btCancelarAcesso(){
        this.sTipoFuncaoAcesso = "";
        this.bEditAcesso = false;
        lnPerfilacesso = null;
    }

}
