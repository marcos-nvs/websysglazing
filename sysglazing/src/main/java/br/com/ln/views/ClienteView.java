/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.Correios;
import br.com.ln.comum.EnderecoCep;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnCliente;
import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnTelefone;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.ArrayList;
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
    private List<LnEndereco> listEnderecos;
    private List<LnTelefone> listTelefones;
    private LnCliente lnCliente;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;
    private String sTipoPessoa = "1";
    private boolean bPessoaFisica = true;
    private boolean bPessoaJuridica;
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

    public String getsTipoPessoa() {
        return sTipoPessoa;
    }

    public void setsTipoPessoa(String sTipoPessoa) {
        this.sTipoPessoa = sTipoPessoa;
    }

    public boolean isbPessoaFisica() {
        return bPessoaFisica;
    }

    public void setbPessoaFisica(boolean bPessoaFisica) {
        this.bPessoaFisica = bPessoaFisica;
    }

    public boolean isbPessoaJuridica() {
        return bPessoaJuridica;
    }

    public void setbPessosJuridica(boolean bPessoaJuridica) {
        this.bPessoaJuridica = bPessoaJuridica;
    }

    public LnEndereco getLnEndereco() {
        return lnEndereco;
    }

    public void setLnEndereco(LnEndereco lnEndereco) {
        this.lnEndereco = lnEndereco;
    }

    public LnTelefone getLnTelefone() {
        return lnTelefone;
    }

    public void setLnTelefone(LnTelefone lnTelefone) {
        this.lnTelefone = lnTelefone;
    }

    public List<LnEndereco> getListEnderecos() {
        return listEnderecos;
    }

    public void setListEnderecos(List<LnEndereco> listEnderecos) {
        this.listEnderecos = listEnderecos;
    }

    public List<LnTelefone> getListTelefones() {
        return listTelefones;
    }

    public void setListTelefones(List<LnTelefone> listTelefones) {
        this.listTelefones = listTelefones;
    }
    
    public void btIncluir(){
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')){
            lnCliente = new LnCliente();
            listEnderecos = new ArrayList<>();
            listTelefones = new ArrayList<>();
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
    public void btGrava(){}
    public void btCancelar(){}
    
    public void btIncluiEnd(){
        lnEndereco = new LnEndereco();
    }
    
    public void btListaEndereco(){
        listEnderecos.add(lnEndereco);
        lnEndereco = new LnEndereco();
    }
    
    public void btTelefone(){}

    public void trocaTipoPessoa(){
        bPessoaFisica = sTipoPessoa.equals("1");
        bPessoaJuridica = sTipoPessoa.equals("2");
    }
    
    public String descTipoEndereco(String sTipoEndereco){
        if (sTipoEndereco.equals("1")){
            return "Residêncial";
        } else if (sTipoEndereco.equals("2")){
            return "Comercial";
        } else if (sTipoEndereco.equals("3")){
            return "Entrega";
        } else{
            return "";
        }
    }
    
    public void btPesquisaCEP(){
        if (lnEndereco.getEndStCep() != null){
            EnderecoCep endereco = new EnderecoCep();
            Correios correio = new Correios();
            System.out.println("cep : " + lnEndereco.getEndStCep().replaceAll("-", ""));
            endereco = correio.entregaEnderco(lnEndereco.getEndStCep().replaceAll("-", ""));
            
            if (endereco != null){
                lnEndereco.setEndStLogradouro(endereco.getTipoDeLogradouro() +" " +endereco.getLogradouro());
                lnEndereco.setEndStBairro(endereco.getBairro());
                lnEndereco.setEndStCidade(endereco.getCidade());
                lnEndereco.setEndStEstado(endereco.getEstado());
                
                System.out.println("Endereco retornado : " + lnEndereco.toString());
            } else {
                mensagem = "Cep não localizado!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
            }
        } else{
            mensagem = "Cep em branco, por favor entre com o CEP!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }
}
