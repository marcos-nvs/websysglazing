/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.glazing;

import br.com.ln.entity.LnMenu;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Marcos Naves
 */

public class MenuSistema implements Serializable{
    
    private MenuModel model;
    private LnUsuario lnUsuario;
    private String strDbName;

    public MenuSistema() {
    }

    public MenuSistema(LnUsuario lnUsuario, String strDbName) {
        this.lnUsuario = lnUsuario;
        this.strDbName = strDbName;
    }

    public MenuModel getModel() {
        montaMenu();
        return model;
    }

    public LnUsuario getLnUsuario() {
        return lnUsuario;
    }

    public void setLnUsuario(LnUsuario lnUsuario) {
        this.lnUsuario = lnUsuario;
    }

    public String getStrDbName() {
        return strDbName;
    }

    public void setStrDbName(String strDbName) {
        this.strDbName = strDbName;
    }

    private void montaMenu(){
        
        List<LnMenu> listMenu = Postgress.getMenu(strDbName);
        
        model = new DefaultMenuModel();
        DefaultSubMenu subMenu;
        DefaultMenuItem item;
        
        for (LnMenu lnMenu : listMenu) {
            subMenu = new DefaultSubMenu(lnMenu.getMenStDescricao());
            
            Iterator inIt = lnMenu.getListModulos().iterator();
            
            while (inIt.hasNext()){
                LnModulo lnModulo = (LnModulo) inIt.next();
                item = new DefaultMenuItem(lnModulo.getModStDescricao());
                subMenu.addElement(item);
            }
            
            model.addElement(subMenu);
        }
    }
}
