/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author Marcos Naves
 */

public class VarComuns implements Serializable{
    
    public static String strDbName;
    public static LnPerfil lnPerfil;
    public static LnPerfilacesso lnPerfilacesso;
    
    public static String local(){
        Locale locale = Locale.getDefault();
        return locale.toString();
    }
}
