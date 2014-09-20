/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ln.comum;

import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author Marcos Naves
 */

public class VarComuns implements Serializable{
    
    public static String strDbName;
    
    public static String local(){
        Locale locale = Locale.getDefault();
        return locale.toString();
    }

    public static String getStrDbName() {
        return strDbName;
    }

    public static void setStrDbName(String strDbName) {
        VarComuns.strDbName = strDbName;
    }
}
