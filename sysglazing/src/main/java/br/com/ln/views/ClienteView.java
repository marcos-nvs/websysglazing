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
@ManagedBean(name = "clienteView")
public class ClienteView implements Serializable {

    private List<LnCliente> listCliente;
    private List<LnEndereco> listEnderecos;
    private List<LnTelefone> listTelefones;
    private LnCliente lnCliente;
    private LnEndereco lnEndereco;
    private LnTelefone lnTelefone;
    private String sTipoPessoa = "1";
    private String sTipoFuncao;
    private boolean bPessoaFisica = true;
    private boolean bPessoaJuridica;
    private boolean bTelaCadastro;
    private String mensagem;
    private String sCpf;
    private String sRg;
    private String sCnpj;
    private String sIe;
    private String sNome;
    private String sContato;
    private String sEmail;

    public ClienteView() {
        listCliente = Postgress.getListObject(LnCliente.class);
        listEnderecos = Postgress.getListObject(LnEndereco.class);
        listTelefones = Postgress.getListObject(LnTelefone.class);
        lnCliente = new LnCliente();
        lnEndereco = new LnEndereco();
        lnTelefone = new LnTelefone();
//        System.out.println("Cliente -------> " + lnCliente.toString());
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

    public String getsCpf() {
        return sCpf;
    }

    public void setsCpf(String sCpf) {
        this.sCpf = sCpf;
    }

    public String getsRg() {
        return sRg;
    }

    public void setsRg(String sRg) {
        this.sRg = sRg;
    }

    public String getsCnpj() {
        return sCnpj;
    }

    public void setsCnpj(String sCnpj) {
        this.sCnpj = sCnpj;
    }

    public String getsIe() {
        return sIe;
    }

    public void setsIe(String sIe) {
        this.sIe = sIe;
    }

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public String getsContato() {
        return sContato;
    }

    public void setsContato(String sContato) {
        this.sContato = sContato;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
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
            sTipoFuncao = "A";
        } else {
            mensagem = "Usuario nao tem permissao para alterar cliente";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    public void btExluir() {
    }

    public void btVisualiar() {
    }

    public void btHistorico() {
    }

    public void btGrava() {

//        if (validaCliente()) {
//            if (sTipoFuncao.equals("I")) {
//                novoCliente();
//            }
//        }
        
//        System.out.println("Cliente -------> " + lnCliente.toString());
        
        mensagem = "Teste de gravacao";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
    }

    public void btCancelar() {
    }

    public void btIncluiEnd() {
        lnEndereco = new LnEndereco();
    }

    public void btListaEndereco() {
        listEnderecos.add(lnEndereco);
        lnEndereco = new LnEndereco();
    }

    public void btTelefone() {
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

    public void btPesquisaCEP() {
        if (lnEndereco.getEndStCep() != null) {
            EnderecoCep endereco = new EnderecoCep();
            Correios correio = new Correios();
            endereco = correio.entregaEndereco(lnEndereco.getEndStCep().replaceAll("-", ""));
            correio.close();
            if (endereco != null) {
                lnEndereco.setEndStLogradouro(endereco.getTipoDeLogradouro() + " " + endereco.getLogradouro());
                lnEndereco.setEndStBairro(endereco.getBairro());
                lnEndereco.setEndStCidade(endereco.getCidade());
                lnEndereco.setEndStEstado(endereco.getEstado());
            } else {
                mensagem = "Cep não localizado!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
            }
        } else {
            mensagem = "Cep em branco, por favor entre com o CEP!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    private void novoCliente() {

        if (verificaCliente()) {
//            lnCliente.setCliInCodigo(Postgress.getLnClienteNextId());

            if (listEnderecos != null && listEnderecos.size() > 0) {

                for (LnEndereco endereco : listEnderecos) {
//                    endereco.setCliInCodigo(lnCliente.getCliInCodigo());
                }
                Postgress.saveObject(listEnderecos);
            } else {
                mensagem = "Cliente nao possui endereco!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cliente", mensagem));
            }

            if (listTelefones != null && listTelefones.size() > 0) {

                for (LnTelefone telefone : listTelefones) {
//                    telefone.setCliInCodigo(lnCliente.getCliInCodigo());
                }

                Postgress.saveObject(listTelefones);
            } else {
                mensagem = "Cliente nao possui telefone!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cliente", mensagem));
            }
//            Postgress.saveObject(lnCliente);
            mensagem = "Cliente gravado com sucesso!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", mensagem));
        }
    }

    private boolean validaCliente() {

        boolean validado = true;

//        if (lnCliente == null) {
//            validado = false;
//            mensagem = "Para gravar o Cliente precisa preencher as informacoes!!!";
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente", mensagem));
//        }

//        System.out.println("this.Cliente : " + this.lnCliente.toString());
//        System.out.println("Cliente : " + lnCliente.toString());
//        if (this.lnCliente.getCliStNome() == null || this.lnCliente.getCliStNome().isEmpty()) {
//            validado = false;
//            mensagem = "Por favor preencha o nome do Cliente!!!";
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente", mensagem));
//        }
        return validado;
    }

    private boolean verificaCliente() {

        LnCliente lnNovoCliente;

//        if (lnCliente.getCliStCpf() != null && !lnCliente.getCliStCpf().isEmpty()) {
//            lnNovoCliente = Postgress.getClienteCpf(lnCliente.getCliStCpf());
//            return lnNovoCliente == null;
//        } else {
//            if (lnCliente.getCliStCnpj() != null && !lnCliente.getCliStCnpj().isEmpty()) {
//                lnNovoCliente = Postgress.getClienteCnpj(lnCliente.getCliStCnpj());
//                return lnNovoCliente == null;
//            } else {
//                if (lnCliente.getCliStNome() != null && !lnCliente.getCliStNome().isEmpty()) {
//                    lnNovoCliente = Postgress.getClienteNome(lnCliente.getCliStNome());
//                    return lnNovoCliente == null;
//                }
//            }
//        }
        return false;
    }
}
