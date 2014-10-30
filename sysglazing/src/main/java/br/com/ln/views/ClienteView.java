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
    private String cpf;
    private String rg;
    private String cnpj;
    private String ie;
    private String nome;
    private String contato;
    private String email;
    private String tipoEndereco;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep; 
    private String tipoTelefone;
    private String ddd;
    private String numeroTelefone;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
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
    }

    public void btCancelar() {
    }

    public void btIncluiEnd() {
        lnEndereco = new LnEndereco();
    }

    public void btListaEndereco() {
        lnEndereco = new LnEndereco(null, null, tipoEndereco, endereco, numero, bairro, cidade, estado, cep);
        listEnderecos.add(lnEndereco);
    }

    public void btIncluiTelefone() {
        System.out.println("telefone");
        lnTelefone = new LnTelefone(null, null, tipoTelefone, ddd, numeroTelefone);
        System.out.println("lntelefone : " + lnTelefone.toString());
        listTelefones.add(lnTelefone);
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
        if (cep != null) {
            EnderecoCep enderecoCep = new EnderecoCep();
            Correios correio = new Correios();
            enderecoCep = correio.entregaEndereco(cep.replaceAll("-", ""));
            correio.close();
            if (endereco != null) {
                endereco = enderecoCep.getTipoDeLogradouro() + " " + enderecoCep.getLogradouro();
                bairro = enderecoCep.getBairro();
                cidade = enderecoCep.getCidade();
                estado = enderecoCep.getEstado();
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
