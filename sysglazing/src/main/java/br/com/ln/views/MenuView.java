/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.views;

import br.com.ln.comum.JsfHelper;
import br.com.ln.entity.LnUsuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Marcos Naves
 */

//@SessionScoped
//@ManagedBean(name = "menuView")
public class MenuView implements Serializable{
    
    private MenuModel model;
    private GlaAccess glaAccess;

    public MenuView() {
    }

    public void montaMenu(){
        
        glaAccess = (GlaAccess) JsfHelper.getSessionAttribute("glazingView");
        System.out.println("Usuario : " + glaAccess.getUsuStCodigo());

        model = new DefaultMenuModel();
         
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
        firstSubmenu.setRendered(true);
        
        DefaultMenuItem item = new DefaultMenuItem("External");
        firstSubmenu.addElement(item);
        
        model.addElement(firstSubmenu);
         
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
 
        item = new DefaultMenuItem("Save");
        item.setRendered(true);
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Delete");
        item.setRendered(true);
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Redirect");
        item.setRendered(true);
        secondSubmenu.addElement(item);
 
        model.addElement(secondSubmenu);
    }
    
    public MenuModel getModel() {
        montaMenu();
        return model;
    }
    
}
