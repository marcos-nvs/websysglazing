/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.views;

import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcos Naves
 */

@ViewScoped
@ManagedBean(name = "usuarioView")
public class UsuarioView {
    
    private List<LnUsuario> listUsuario = Postgress.getListObject(LnUsuario.class, "Public");

    public UsuarioView() {
    }

    public List<LnUsuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<LnUsuario> listUsuario) {
        this.listUsuario = listUsuario;
    }
    
    
    
}
