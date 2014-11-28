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

    private final Historico historico;
    private List<LnCliente> listCliente;
    private List<LnEndereco> listEnderecos;
    private List<LnTelefone> listTelefones;
    private List<LnHistorico> listHistorico;
    private LnCliente lnCliente;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;

    private Boolean bPessoaFisica = true;
    private Boolean bPessoaJuridica = false;
    private Boolean bTelaCadastro = false;
    
    private String sTipoPessoa = "1";
    private String sTipoFuncao;
    private String sTipoFuncaoEnd;
    private String sTipoFuncaoTel = "I";
    private String mensagem;

    private String cpf;
    private String rg;
    private String nomeFisica;
    private String emailFisica;

    private String cnpj;
    private String ie;
    private String nomeJuridica;
    private String emailJuridica;
    private String contato;

    private String tipoEndereco;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    
    private String ddd;
    private String telefone;
    private String tipoTelefone;
    
    private String nomeFilter;

//    static {
//        String host = "proxy-sp.dasa.net";
//        String port = "3128";
//        System.out.println("Using proxy: " + host + ":" + port);
//        System.setProperty("http.proxyHost", host);
//        System.setProperty("http.proxyPort", port);
//        System.setProperty("http.proxySet", "true");
//        System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");
//    }
        
    public ClienteView() {
        listCliente = Postgress.grabListCliente('1');
        listEnderecos = new ArrayList<>();
        listTelefones = new ArrayList<>();
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
    
    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeFilter() {
        return nomeFilter;
    }

    public void setNomeFilter(String nomeFilter) {
        this.nomeFilter = nomeFilter;
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
            if (lnCliente != null) {
                bTelaCadastro = true;
                if (lnCliente.getCliStCpf() != null && !lnCliente.getCliStCpf().equals("")) {
                    cpf = lnCliente.getCliStCpf();
                    rg = lnCliente.getCliStRg();
                    nomeFisica = lnCliente.getCliStNome();
                    emailFisica = lnCliente.getCliStEmail();
                    bPessoaFisica = true;
                    bPessoaJuridica = false;
                }

                if (lnCliente.getCliStCnpj() != null && !lnCliente.getCliStCnpj().equals("")) {
                    cnpj = lnCliente.getCliStCnpj();
                    ie = lnCliente.getCliStIe();
                    nomeJuridica = lnCliente.getCliStNome();
                    emailJuridica = lnCliente.getCliStEmail();
                    contato = lnCliente.getCliStContato();
                    bPessoaJuridica = true;
                    bPessoaFisica = false;
                }

                listEnderecos = Postgress.grabListEnderecoCliente(lnCliente.getCliInCodigo());
                listTelefones = Postgress.grabListTelefones(lnCliente.getCliInCodigo());

                sTipoFuncao = "A";
            } else {
                mensagem = "Por favor, escolha um cliente.!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
            }
        } else {
            mensagem = "Usuario nao tem permissao para alterar cliente";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btExluir() {
        if (VarComuns.lnPerfilacesso.getPacChExcluir().equals('S')){
            if (lnCliente != null){
                Postgress.deleteObject(lnCliente);
                historico.gravaHistorico("Exclusao do Cliente : " + lnCliente.getCliInCodigo() + " - " + lnCliente.getCliStNome());
                mensagem = "Cliente excluido com sucesso.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
                listCliente = Postgress.grabListCliente('1');
                bTelaCadastro = false;
            } else {
                mensagem = "Escolha um cliente para ser excluido.";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
            }
        } else {
            mensagem = "Usuario sem permissao de exclusao de Cliente.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
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
        tipoEndereco = "";
        cep = "";
        logradouro = "";
        numero = "";
        complemento = "";
        bairro = "";
        cidade = "";
        estado = "";
        sTipoFuncaoEnd = "I";
    }

    public void btAtleraEnd(){
        sTipoFuncaoEnd = "A";
        tipoEndereco = lnEndereco.getEndStTipo();
        cep = lnEndereco.getEndStCep();
        logradouro = lnEndereco.getEndStLogradouro();
        numero = lnEndereco.getEndStNumero();
        complemento = lnEndereco.getEndStComplemento();
        bairro = lnEndereco.getEndStBairro();
        cidade = lnEndereco.getEndStCidade();
        estado = lnEndereco.getEndStEstado();
    }
    
    public void btExcluiEnd(){
        if (lnEndereco != null) {
            listEnderecos.remove(lnEndereco);
            lnEndereco = new LnEndereco();
            mensagem = "Endereco excluido com sucesso!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        } else {
            mensagem = "Escolha um endereco para ser excluido.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }
    
    public void btFecharEnd(){
        lnEndereco = new LnEndereco();
    }
    
    public void btListaEndereco() {
        lnEndereco = new LnEndereco(tipoEndereco, logradouro, numero, complemento, bairro, cidade, estado, cep);
        if (lnEndereco != null && verificaEnderecoObrigatorio()) {
            
            if (sTipoFuncaoEnd.equals("A")){
                listEnderecos.remove(lnEndereco);
            }
            
            listEnderecos.add(lnEndereco);
            lnEndereco = new LnEndereco();
            tipoEndereco = "";
            cep = "";
            logradouro = "";
            numero = "";
            complemento = "";
            bairro = "";
            cidade = "";
            estado = "";
                
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btIncluiTelefone() {
        lnTelefone = new LnTelefone(tipoTelefone, ddd, telefone);
        
        if (sTipoFuncaoTel.equals("A")){
            listTelefones.remove(lnTelefone);
        }
        
        listTelefones.add(lnTelefone);
        lnTelefone = new LnTelefone();
        tipoTelefone="";
        ddd="";
        telefone="";
    }
    
    public void btAlteraTelefone() {
        sTipoFuncaoTel = "A";
        if (lnTelefone != null) {
            tipoTelefone = lnTelefone.getTelStTipo();
            ddd = lnTelefone.getTelStDdd();
            telefone = lnTelefone.getTelStTelefone();
            mensagem = "Telefone alterado com sucesso!!!";
            sTipoFuncaoTel="I";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        } else {
            mensagem = "Por favor, escolha um telefone";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }
    
    public void btExluiTelefone(){
        System.out.println("Telefone : " + lnTelefone.toString());
        if (lnTelefone != null){
            listTelefones.remove(lnTelefone);
            lnTelefone = new LnTelefone();
            mensagem = "Telefone excluido com sucesso!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        } else {
            mensagem = "Escolha um telefone para ser excluido.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void trocaTipoPessoa() {
        if (sTipoFuncao.equals("I")) {
            bPessoaFisica = sTipoPessoa.equals("1");
            bPessoaJuridica = sTipoPessoa.equals("2");
        } else {
            mensagem = "Nao e possivel realizar esta alteracao";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
        
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
        if (cep != null) {
            EnderecoCep enderecoCep = new EnderecoCep();
            Correios correio = new Correios();
            enderecoCep = correio.entregaEndereco(cep.replaceAll("-", ""));
            correio.close();
            if (enderecoCep != null) {
                System.out.println("encontrado");
                logradouro = enderecoCep.getTipoDeLogradouro() +" "+enderecoCep.getLogradouro();
                bairro = enderecoCep.getBairro();
                cidade = enderecoCep.getCidade();
                estado = enderecoCep.getEstado();
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
        if (cnpj != null && !cnpj.equals("")){
            cnpj = cnpj.replaceAll("\\.", "");
            cnpj = cnpj.replaceAll("-", "");
            cnpj = cnpj.replaceAll("/", "");
            if (!Utilitarios.calculaCNPJ(cnpj)) {
                mensagem = mensagem + " " + "CNPJ invalido";
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
            cpf = "";
            rg = "";
            cnpj = "";
            ie = "";
            nomeFisica = "";
            nomeJuridica = "";
            emailFisica = "";
            emailJuridica = "";
            contato = "";
            
            mensagem = "Cliente gravado com sucesso!!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        } else {
            mensagem = "Cliente ja existe no sistema!!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    private void defineCliente() {
        if (bPessoaFisica) {
            lnCliente = new LnCliente(cpf, null, rg, null, nomeFisica, emailFisica, null, '1');
        }

        if (bPessoaJuridica) {
            lnCliente = new LnCliente(null, cnpj, null, ie, nomeJuridica, emailJuridica, contato, '1');
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
    
    public List<LnCliente> btPesquisaNomeCliente(){
        return listCliente = Postgress.grabClientePorNome(nomeFilter, '1');
    }
}
