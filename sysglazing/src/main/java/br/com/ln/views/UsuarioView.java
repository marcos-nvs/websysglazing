/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.views;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.JsfHelper;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    
    private List<LnUsuario> listUsuario;
    private LnUsuario lnUsuario;
    private List<LnPerfil> listPerfil;
    private boolean bAtivo;
    private boolean bAlteraSenha;
    private boolean bExpiraSenha;
    private boolean bSenha;
    private boolean bDialog;

    public UsuarioView() {
        listUsuario = Postgress.getListObject(LnUsuario.class, VarComuns.strDbName);
        listPerfil = Postgress.getListObject(LnPerfil.class, VarComuns.strDbName);
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

    public boolean isbSenha() {
        return bSenha;
    }

    public boolean isbDialog() {
        return bDialog;
    }

    public void setbDialog(boolean bDialog) {
        this.bDialog = bDialog;
    }
    
    public void setbSenha(boolean bSenha) {
        this.bSenha = bSenha;
    }
    
    public void setbotaoIncluir(){
        lnUsuario = new LnUsuario();
        bDialog = true;
        bSenha = true;
    }
    
    public void setbotalAlterar(){
        bSenha = false;
        if (lnUsuario != null){
            bDialog = true;
            bAtivo = lnUsuario.getUsuChAtivo() == 'S';
            bAlteraSenha = lnUsuario.getUsuChAlterasenha() == 'S';
            bExpiraSenha = lnUsuario.getUsuChExpirasenha() == 'S';
        } else {
            bDialog = false;
        }
    }

    public void setbotaoGravar(){
        
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
        
        if (bExpiraSenha){
            lnUsuario.setUsuChExpirasenha('S');
            lnUsuario.setUsuInDia(30);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(Postgress.getDateFromDB(VarComuns.strDbName));
            calendar.add(30, 0);
            lnUsuario.setUsuDtExpiracao(calendar.getTime());
        } else {
            lnUsuario.setUsuChExpirasenha('N');
        }
        lnUsuario.setUsuDtCadastro(Postgress.getDateFromDB(VarComuns.strDbName));

        Postgress.saveOrUpdateObject(lnUsuario, VarComuns.strDbName);
        listUsuario = Postgress.getListObject(LnUsuario.class, VarComuns.strDbName);
        lnUsuario = null;
    }
    
    public void setbotaoDelete(){
        Postgress.deleteObject(lnUsuario, VarComuns.strDbName);
        listUsuario = Postgress.getListObject(LnUsuario.class, VarComuns.strDbName);
        lnUsuario =  null;
    }
    
}
