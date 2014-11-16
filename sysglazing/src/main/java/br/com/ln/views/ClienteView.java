/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.views;

import br.com.ln.comum.Correios;
import br.com.ln.comum.EnderecoCep;
import br.com.ln.comum.Historico;
import br.com.ln.comum.Utilitarios;
import br.com.ln.comum.VarComuns;
import br.com.ln.entity.LnCliente;
import br.com.ln.entity.LnEndereco;
import br.com.ln.entity.LnHistorico;
import br.com.ln.entity.LnTelefone;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.PostActivate;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcos Naves
 */
@SessionScoped
@ManagedBean(name = "clienteView")
public class ClienteView implements Serializable {

    private List<LnCliente> listCliente;
    private List<LnEndereco> listEnderecos;
    private List<LnTelefone> listTelefones;
    private List<LnHistorico> listHistorico;
    private LnCliente lnCliente;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;
    private String sTipoPessoa = "1";
    private String sTipoFuncao;
    private boolean bPessoaFisica = true;
    private boolean bPessoaJuridica;
    private Boolean bTelaCadastro = false;
    private String mensagem;
    private String cpf;
    private String rg;
    private String cnpj;
    private String ie;
    private String nomeFisica;
    private String nomeJuridica;
    private String emailFisica;
    private String emailJuridica;
    private String contato;
    private final Historico historico;
    

    public ClienteView() {
        listCliente = Postgress.grabListObject(LnCliente.class);
        listEnderecos = Postgress.grabListObject(LnEndereco.class);
        listTelefones = Postgress.grabListObject(LnTelefone.class);
        lnCliente = new LnCliente();
        lnEndereco = new LnEndereco();
        lnTelefone = new LnTelefone();
        historico = new Historico();
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

    public Boolean getbTelaCadastro() {
        return bTelaCadastro;
    }

    public void setbTelaCadastro(Boolean bTelaCadastro) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getNomeFisica() {
        return nomeFisica;
    }

    public void setNomeFisica(String nomeFisica) {
        this.nomeFisica = nomeFisica;
    }

    public String getNomeJuridica() {
        return nomeJuridica;
    }

    public void setNomeJuridica(String nomeJuridica) {
        this.nomeJuridica = nomeJuridica;
    }

    public String getEmailFisica() {
        return emailFisica;
    }

    public void setEmailFisica(String emailFisica) {
        this.emailFisica = emailFisica;
    }

    public String getEmailJuridica() {
        return emailJuridica;
    }

    public void setEmailJuridica(String emailJuridica) {
        this.emailJuridica = emailJuridica;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    public void btIncluir() {
        if (VarComuns.lnPerfilacesso.getPacChIncluir().equals('S')) {
            lnCliente = new LnCliente();
            listEnderecos = new ArrayList<>();
            listTelefones = new ArrayList<>();
            bTelaCadastro = true;
            sTipoFuncao = "I";
        } else {
            mensagem = "Usuario nao tem permissao para incluir cliente";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btAlterar() {
        if (VarComuns.lnPerfilacesso.getPacChAlterar().equals('S')) {
            bTelaCadastro = true;
            if (lnCliente.getCliStCpf() !=null && !lnCliente.getCliStCpf().equals("")){
                cpf =  lnCliente.getCliStCpf();
                rg = lnCliente.getCliStRg();
                nomeFisica = lnCliente.getCliStNome();
                emailFisica = lnCliente.getCliStEmail();
            }
            
            if (lnCliente.getCliStCnpj() != null && !lnCliente.getCliStCnpj().equals("")){
                cnpj=lnCliente.getCliStCnpj();
                ie=lnCliente.getCliStIe();
                nomeJuridica=lnCliente.getCliStNome();
                emailJuridica=lnCliente.getCliStEmail();
                contato=lnCliente.getCliStContato();
            }
            
            listEnderecos = Postgress.grabListEnderecoCliente(lnCliente.getCliInCodigo());
            listTelefones = Postgress.grabListTelefones(lnCliente.getCliInCodigo());
            
            sTipoFuncao = "A";
        } else {
            mensagem = "Usuario nao tem permissao para alterar cliente";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btExluir() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')){
            if (lnCliente != null){
               listHistorico = Postgress.grabListHistorico(4);
               
                if (listHistorico != null) {
                    mensagem = "Cliente nao pode ser excluido por ter transacoes no sistema. Voce pode desativar.";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
                }
            }
        }
    }

    public void btVisualiar() {
    }

    public void btHistorico() {
        
    }

    public void btGrava() {
        if (verificaDadoObrigatorio()) {
            if (sTipoFuncao.equals("I")) {
                novoCliente();
                      
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente", mensagem));
        }
    }

    public void btCancelar() {
        bTelaCadastro=false;
    }

    public void btIncluiEnd() {
        lnEndereco = new LnEndereco();
    }
    
    public void btAlterarEnd(){
        
    }

    public void btListaEndereco() {
        if (lnEndereco != null && verificaEnderecoObrigatorio()) {
            listEnderecos.add(lnEndereco);
            lnEndereco = new LnEndereco();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btIncluiTelefone() {
        listTelefones.add(lnTelefone);
        lnTelefone = new LnTelefone();
    }

    public void trocaTipoPessoa() {
        bPessoaFisica = sTipoPessoa.equals("1");
        bPessoaJuridica = sTipoPessoa.equals("2");
    }

    public String descTipoEndereco(String sTipoEndereco) {
        if (sTipoEndereco.equals("1")) {
            return "Residêncial";
        } else if (sTipoEndereco.equals("2")) {
            return "Comercial";
        } else if (sTipoEndereco.equals("3")) {
            return "Entrega";
        } else {
            return "";
        }
    }

    public String descTipoTelefone(String sTipoTelefone) {
        if (sTipoTelefone.equals("1")) {
            return "Residêncial";
        } else if (sTipoTelefone.equals("2")) {
            return "Comercial";
        } else if (sTipoTelefone.equals("3")) {
            return "Celular";
        } else {
            return "";
        }
    }

    public void btPesquisaCEP() {
        if (lnEndereco.getEndStCep() != null) {
            EnderecoCep enderecoCep = new EnderecoCep();
            Correios correio = new Correios();
            enderecoCep = correio.entregaEndereco(lnEndereco.getEndStCep().replaceAll("-", ""));
            correio.close();
            if (enderecoCep != null) {
                lnEndereco.setEndStLogradouro(enderecoCep.getTipoDeLogradouro() +" "+enderecoCep.getLogradouro());
                lnEndereco.setEndStBairro(enderecoCep.getBairro());
                lnEndereco.setEndStCidade(enderecoCep.getCidade());
                lnEndereco.setEndStEstado(enderecoCep.getEstado());
            }else{
                mensagem = "Cep não localizado!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
            }
        } else {
            mensagem = "Cep em branco, por favor entre com o CEP!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }
    
    public boolean verificaEnderecoObrigatorio(){
    
        boolean validado = true;
        mensagem = "Por favor, preencher os seguintes campos: ";
    
        if (lnEndereco.getEndStLogradouro() == null || lnEndereco.getEndStLogradouro().equals("")){
            mensagem = mensagem + "Endereco - "; 
            validado = false;
        }
        
        if (lnEndereco.getEndStNumero() == null || lnEndereco.getEndStNumero().equals("")){
            mensagem = mensagem + "Numero - "; 
            validado = false;
        }

        if (lnEndereco.getEndStBairro()== null || lnEndereco.getEndStBairro().equals("")){
            mensagem = mensagem + "Bairro - "; 
            validado = false;
        }
        
        if (lnEndereco.getEndStCidade()== null || lnEndereco.getEndStCidade().equals("")){
            mensagem = mensagem + "Cidade - "; 
            validado = false;
        }

        if (lnEndereco.getEndStEstado()== null || lnEndereco.getEndStEstado().equals("")){
            mensagem = mensagem + "Estado - "; 
            validado = false;
        }

        if (lnEndereco.getEndStCep()== null || lnEndereco.getEndStCep().equals("")){
            mensagem = mensagem + "CEP "; 
            validado = false;
        }
        
        return validado;
    }
    
    public boolean verificaDadoObrigatorio(){
        
        boolean validado = true;
        mensagem = "Por favor, preencher os seguintes campos: ";
        
        if (nomeFisica == null && nomeFisica.equals("")){
            mensagem = mensagem + " "+ "Nome do Cliente em branco,";
            validado = false;
        }
        
        if (listEnderecos == null || listEnderecos.isEmpty()) {
            mensagem = mensagem + " " + "Endereco do cliente em branco,";
            validado = false;
        }
        
        if (listTelefones == null || listTelefones.isEmpty()){
            mensagem = mensagem + " " + "Telefone do cliente em branco";
            validado = false;
        }
        
        if (cpf != null && !cpf.equals("")){
            cpf = cpf.replaceAll("\\.", "");
            cpf = cpf.replaceAll("-", "");
            if (!Utilitarios.calculaCPF(cpf)) {
                mensagem = mensagem + " " + "CPF invalido";
                validado = false;
            }
        }
        return validado;
    }

    private void novoCliente() {
        defineCliente();

        if (!verificaCliente()) {
            lnCliente.setCliInCodigo(Postgress.grabLnClienteNextId());
            System.out.println("Cliente : " + lnCliente.toString());
            for (LnEndereco lsEndereco : listEnderecos) {
                lsEndereco.setCliInCodigo(lnCliente.getCliInCodigo());
                lsEndereco.setEndInCodigo(Postgress.grabLnEnderecoNextId());
                lsEndereco.setEndStCep(lsEndereco.getEndStCep().replaceAll("-", ""));
                System.out.println("endereco : " + lsEndereco.toString());
                Postgress.saveObject(lsEndereco);
            }

            for (LnTelefone lsTelefone : listTelefones) {
                lsTelefone.setCliInCodigo(lnCliente.getCliInCodigo());
                lsTelefone.setTelInCodigo(Postgress.grabLnTelefoneNextId());
                System.out.println("Telefone :  " + lsTelefone.toString());
                Postgress.saveObject(lsTelefone);
            }
            Postgress.saveObject(lnCliente);
            bTelaCadastro = false;
            listCliente.add(lnCliente);
            historico.gravaHistorico("Inclusao do Cliente : " + lnCliente.getCliInCodigo() + " - "+ lnCliente.getCliStNome());

            mensagem = "Cliente gravado com sucesso!!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        } else {
            mensagem = "Cliente ja existe no sistema!!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    private void defineCliente() {

        if (bPessoaFisica) {
            System.out.println("cpf : " + cpf);
            System.out.println("cpf depois : " + cpf);
            lnCliente = new LnCliente(cpf, null, rg, null, nomeFisica, emailFisica, null);
        }

        if (bPessoaJuridica) {
            lnCliente = new LnCliente(null, cnpj, null, ie, nomeJuridica, emailJuridica, contato);
        }
    }

    private boolean verificaCliente() {
        LnCliente novoCliente = null; 
        
        if (lnCliente.getCliStCpf() != null && !lnCliente.getCliStCpf().equals("")){
            novoCliente = Postgress.grabClienteCpf(lnCliente.getCliStCpf());
        } else if(lnCliente.getCliStCnpj() != null && !lnCliente.getCliStCnpj().contentEquals("")) {
            novoCliente = Postgress.grabClienteCpf(lnCliente.getCliStCpf());
        } else if (lnCliente.getCliStNome() != null && !lnCliente.getCliStNome().equals("")){
            novoCliente = Postgress.grabClienteCpf(lnCliente.getCliStCpf());
        }
        return novoCliente != null;
    }
}
