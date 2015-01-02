/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ln.comum;

import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnUsuario;
import br.com.ln.hibernate.Postgress;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author Marcos Naves
 */

@Singleton
public class EjbMap implements Serializable{
    
    private static Map<String, LnUsuario> mapUsuario = new HashMap<>(100);
    private static Map<Integer, LnPerfil> mapPerfil = new HashMap<>(30);
    
    
    public synchronized static LnUsuario grabUsuario(String usuStCodigo){
        LnUsuario lnUsuario = null;
        
        if (usuStCodigo != null){
            if (mapUsuario.containsKey(usuStCodigo)){
                return mapUsuario.get(usuStCodigo);
            } else {
                lnUsuario = Postgress.grabUsuario(usuStCodigo, 'S');
                
                if (lnUsuario != null){
                    mapUsuario.put(usuStCodigo, lnUsuario);
                    return lnUsuario;
                }
            }
        }
        return lnUsuario;
    }
    
    public synchronized static LnPerfil grabPerfil(Integer perInCodigo){
        LnPerfil lnPerfil = null;
        
        if(perInCodigo != null){
            if(mapPerfil.containsKey(perInCodigo)){
                return mapPerfil.get(perInCodigo);
            } else {
                lnPerfil = Postgress.grabPerfil(perInCodigo, 'S');
                
                if(lnPerfil !=null){
                    mapPerfil.put(perInCodigo, lnPerfil);
                    return lnPerfil;
                }
            }
        }
        
        return lnPerfil;
    }
}
