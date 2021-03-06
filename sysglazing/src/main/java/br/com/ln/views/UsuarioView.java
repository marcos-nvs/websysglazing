/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.EjbMap;
import br.com.ln.comum.Historico;
import br.com.ln.comum.VarComuns;
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
public class UsuarioView implements Serializable {

    private List<LnUsuario> listUsuario;
    private LnUsuario lnUsuario;
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
    private final Historico historico;

    public UsuarioView() {
        this.listUsuario = Postgress.grabListObject(LnUsuario.class);
        this.listPerfil = Postgress.grabListPerfilAtivo('S');
        historico = new Historico();
        lnUsuario = new LnUsuario();
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
        listPerfil = Postgress.grabListPerfilAtivo('S');
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

    public void btIncluir() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            lnUsuario = new LnUsuario();
            this.bTelaCadastro = true;
            this.bAtivo = false;
            this.bAlteraSenha = false;
            this.bExpiraSenha = false;
            this.sTipoFuncao = "I";
            this.bMostraSenha = true;
        } else {
            mensagem = "Usuario sem permissao de inclusao.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
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
                mensagem = "Por favor, escolha um Usuario.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            }
        } else {
            mensagem = "Usuario sem permissao de Alteracao.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btExcluir() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')) {
            if (lnUsuario != null) {
                if (Postgress.grabVerificaHistorico(lnUsuario.getUsuStCodigo())) {
                    Postgress.deleteObject(lnUsuario);
                    this.historico.gravaHistorico("Exclusao do usuario : " + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome());
                    listUsuario = Postgress.grabListObject(LnUsuario.class);
                    mensagem = "Usuario excluido com sucesso!!!!.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
                } else {
                    mensagem = "Usuario nao pode ser excluido por ter transacoes no sistema. Voce pode desativar.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
                }
            } else {
                mensagem = "Por favor, escolha um Usuario.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            }
        } else {
            mensagem = "Usuario sem permissao de Exclusao.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btGravar() {
        if (validaUsuario()) {
            this.bTelaCadastro = false;

            if (bAtivo) {
                lnUsuario.setUsuChAtivo('S');
            } else {
                lnUsuario.setUsuChAtivo('N');
            }

            if (bAlteraSenha) {
                lnUsuario.setUsuChAlterasenha('S');
            } else {
                lnUsuario.setUsuChAlterasenha('N');
            }

            if (bExpiraSenha) {
                lnUsuario.setUsuChExpirasenha('S');
            } else {
                lnUsuario.setUsuChExpirasenha('N');
            }

            if (sTipoFuncao.equals("I")) {
                novoUsuario();
            } else {
                Postgress.saveOrUpdateObject(lnUsuario);
                EjbMap.updateUsuario(lnUsuario, VarComuns.strDbName);
                VarComuns.lnUsusario = lnUsuario;
                this.historico.gravaHistorico("Alteracao do usuario : " + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome());
            }

            listUsuario = Postgress.grabListObject(LnUsuario.class);
            mensagem = "Usuario gravado com sucesso!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btCancelar() {
        this.bTelaCadastro = false;
    }

    private void novoUsuario() {

        LnUsuario lnNovoUsuario = Postgress.grabUsuario(lnUsuario.getUsuStCodigo());

        if (lnNovoUsuario != null) {
            mensagem = "Usuario ja Cadastrado.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        } else {
            lnUsuario.setUsuDtCadastro(Postgress.grabDateFromDB());
            lnUsuario.setUsuDtExpiracao(Postgress.grabDateFromDB());
            Postgress.saveObject(lnUsuario);
            this.historico.gravaHistorico("Inclusao do usuario : " + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome());
        }
    }

    public void btAltSenha() {
        if (VarComuns.lnPerfil.getPerChAlteraSenha().equals('S')) {
            if (lnUsuario != null) {
                this.bPerSenha = true;
            } else {
                mensagem = "Por favor, escolha um Usuario .";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
            }
        } else {
            mensagem = "Usuario sem permissao para alterar a senha de outro usuario.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btGravaSenha() {

        if (novaSenha.equals(repeteSenha)) {
            this.bPerSenha = false;
            lnUsuario.setUsuStSenha(novaSenha);
            EjbMap.updateUsuario(lnUsuario, VarComuns.strDbName);
            Postgress.saveOrUpdateObject(lnUsuario);
            historico.gravaHistorico("Alteracao da senha do usuario : " + lnUsuario.getUsuStCodigo() + " - " + lnUsuario.getUsuStNome());
            mensagem = "Senha alterada com sucesso.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        } else {
            mensagem = "Senhas nao conferem.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", mensagem));
        }
    }

    public void btCancelarSenha() {
        this.bPerSenha = false;
    }

    private boolean validaUsuario() {
        
        boolean validado = true;
        
        if (this.lnUsuario == null){
            validado = false;
            mensagem = "Por favor preencher as informacoes";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario", mensagem));
        } 
        
        if (this.lnUsuario.getUsuStCodigo() == null || this.lnUsuario.getUsuStCodigo().isEmpty()){
            validado = false;
            mensagem = "Usuario esta vazio, por favor preencher as informacoes ";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario", mensagem));
        }

        if (this.lnUsuario.getUsuStSenha() == null || this.lnUsuario.getUsuStSenha().isEmpty()){
            validado = false;
            mensagem = "Senha esta vazio, por favor preencher as informacoes ";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario", mensagem));
        }

        if (this.lnUsuario.getUsuStNome() == null || this.lnUsuario.getUsuStNome().isEmpty()){
            validado = false;
            mensagem = "Nome esta vazio, por favor preencher as informacoes ";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario", mensagem));
        }
        
        return validado;
    }
    
}