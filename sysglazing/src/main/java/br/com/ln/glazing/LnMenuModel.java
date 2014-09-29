/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.glazing;

import br.com.ln.comum.BeanVar;
import br.com.ln.comum.JsfHelper;
import br.com.ln.entity.LnMenu;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Marcos Naves
 */

@ManagedBean
public class LnMenuModel implements Serializable {
    
    private MenuModel model;
    private LnUsuario lnUsuario;
    private LnPerfil lnPerfil;
    private String strDbName;
    private Map<String, LnPerfilacesso> mapPerfilUsuario = new HashMap<String, LnPerfilacesso>();
    private BeanVar beanVar;

    public LnMenuModel() {
        beanVar = (BeanVar) JsfHelper.getSessionAttribute("beanVar");
    }

    public LnMenuModel(LnUsuario lnUsuario, String strDbName) {
        this.lnUsuario = lnUsuario;
        this.strDbName = strDbName;
        montaMenu();
    }
    
    private void montaMenu(){
        menuPerfil();
        
        List<LnMenu> listMenu = Postgress.getMenu('S');

        model = new DefaultMenuModel();
        DefaultSubMenu subMenu;
        DefaultMenuItem item;

        for (LnMenu lnMenu : listMenu) {
            subMenu = new DefaultSubMenu(lnMenu.getMenStDescricao());
            subMenu.setRendered(false);
            
            Iterator inIt = lnMenu.getListModulos().iterator();

            while (inIt.hasNext()) {
                LnModulo lnModulo = (LnModulo) inIt.next();

                if (mapPerfilUsuario.containsKey(Integer.toString(lnModulo.getModInCodigo()))) {
                    item = new DefaultMenuItem(lnModulo.getModStDescricao());
                    item.setId(Integer.toString(lnModulo.getModInCodigo()));
                    item.setTitle(lnModulo.getModStDescricao());
                    item.setCommand("#{lnMenuModel.menuActionClick}");
                    item.setUpdate(":idLayoutCenter");
                    item.setProcess(":idLayoutCenter");
                    item.setAjax(false);
                    item.setIcon("ui-icon-folder-open");
                    subMenu.addElement(item);
                    subMenu.setRendered(true);
                    subMenu.setId(Integer.toString(lnModulo.getModInCodigo()));
                }
            }
            model.addElement(subMenu);
        }
    }


    private void menuPerfil() {

        
        if (lnUsuario != null) {
            lnPerfil = Postgress.getPerfil(lnUsuario.getPerInCodigo(),'S');

            List<LnPerfilacesso> lnPerfilacesso = (List<LnPerfilacesso>) Postgress.getListObject(LnPerfilacesso.class);

            for (LnPerfilacesso perfilAcesso : lnPerfilacesso) {

                String Key = Integer.toString(perfilAcesso.getLnPerfilacessoPK().getModInCodigo());
                if (!mapPerfilUsuario.containsKey(Key)) {
                    mapPerfilUsuario.put(Key, perfilAcesso);
                }
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void menuActionClick(MenuActionEvent menuActionEvent){
        
        if (menuActionEvent != null) {
            String itemMenuClick = menuActionEvent.getMenuItem().getTitle();
            switch (itemMenuClick) {
                case "Usuário":
                    beanVar.setNovaTela("WEB-INF/templates/usuario.xhtml");
                    break;
                case "Perfil":
                    beanVar.setNovaTela("WEB-INF/templates/perfil.xhtml");
                    break;
                case "Cliente":
                    beanVar.setNovaTela("WEB-INF/templates/cliente.xhtml");
                    break;
            }
        }
    }
}