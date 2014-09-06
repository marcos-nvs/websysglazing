/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.glazing;

import br.com.ln.entity.LnMenu;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Marcos Naves
 */
public class MenuSistema implements ActionListener, Serializable {

    private MenuModel model;
    private LnUsuario lnUsuario;
    private LnPerfil lnPerfil;
    private String strDbName;
    private Map<String, LnPerfilacesso> mapPerfilUsuario = new HashMap<String, LnPerfilacesso>();


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

    private void montaMenu() {

        menuPerfil();

        List<LnMenu> listMenu = Postgress.getMenu(strDbName);

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
                    subMenu.addElement(item);
                    subMenu.setId(Integer.toString(lnModulo.getModInCodigo()));

                    subMenu.setRendered(true);
                }
            }
            model.addElement(subMenu);
        }
    }

    private void menuPerfil() {

        if (lnUsuario != null) {
            LnPerfil lnPerfil = Postgress.getPerfil(lnUsuario.getPerInCodigo(), strDbName);

            List<LnPerfilacesso> lnPerfilacesso = (List<LnPerfilacesso>) Postgress.getListObject(LnPerfilacesso.class, strDbName);

            for (LnPerfilacesso perfilAcesso : lnPerfilacesso) {

                String Key = Integer.toString(perfilAcesso.getLnPerfilacessoPK().getModInCodigo());
                if (!mapPerfilUsuario.containsKey(Key)) {
                    mapPerfilUsuario.put(Key, perfilAcesso);
                }
            }
        }
    }


    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        throw new UnsupportedOperationException("Not supported yet processaction."); //To change body of generated methods, choose Tools | Templates.
    }

}
