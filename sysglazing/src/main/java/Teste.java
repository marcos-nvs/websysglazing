
import br.com.ln.entity.LnPerfil;
import br.com.ln.entity.LnPerfilacesso;
import br.com.ln.entity.LnUsuario;
import br.com.ln.glazing.MenuSistema;
import br.com.ln.hibernate.Postgress;
import br.com.ln.hibernate.SessionFactoryDbName;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcos Naves
 */
public class Teste {
    
    public static void main(String... args) {
        
        LnUsuario usuario = Postgress.getUsuario("Marcos", "Public");
        
        if (usuario != null){
            MenuSistema menuSistema = new MenuSistema(usuario, "Public");
            
            menuSistema.menuPerfil();
        }
        
        
        
//        Session session = SessionFactoryDbName.getCurrentSessionByName("Public");
//        Transaction tx = session.beginTransaction();
//        
//        try {
//            Query query = session.getNamedQuery("LnMenu.findAll");
//            
//            List l = query.list();
//            tx.commit();
//            
//            if (l != null && !l.isEmpty()){
//                
//                List<LnMenu> listMenu = (List<LnMenu>) l;
//                
//                for (LnMenu lnMenu : listMenu) {
//                    System.out.println("Menu : " + lnMenu.getMenStDescricao());
//
//                    Iterator iter = lnMenu.getListModulos().iterator();
//                    
//                    while (iter.hasNext()){
//                        LnModulo modulo = (LnModulo) iter.next();
//                        
//                        System.out.println("modulo : " + modulo.getModStDescricao());
//                    }
//                    
//                }
//                
//            } else{
//                System.out.println("Não encontrado");
//            }
//        }finally{
//            session.close();
//        }        
//        
        
//        MenuSistema menu = new MenuSistema(null, "Public");
//        menu.getModel();

//        Session session = SessionFactoryDbName.getCurrentSessionByName("Public");
//        Transaction tx = session.beginTransaction();
//        
//        try {
//            Query query = session.getNamedQuery("LnPerfil.findAll");
//            
//            List l = query.list();
//            tx.commit();
//            
//            if (l != null && !l.isEmpty()){
//                
//                List<LnPerfil> listPerfil = (List<LnPerfil>) l;
//                
//                for (LnPerfil lnPerfil : listPerfil) {
//                    System.out.println("perfil : " + lnPerfil.getPerStDescricao());
//                }                
//            } else{
//                System.out.println("Não encontrado");
//            }
//        }finally{
//            session.close();
//        }        

//        LnPerfil perfil = Postgress.getPerfil(1, "Public");
//        
//        System.out.println("Perfil : " + perfil.toString());
        
//        Iterator iterator = perfil.getListPerfilacesso().iterator();
//        
//        while (iterator.hasNext()){
//            
//            LnPerfilacesso lnPerfilacesso = (LnPerfilacesso) iterator.next();
//            
//            System.out.println("Perfil Acesso : " + lnPerfilacesso.toString());
//        }
        
    }
}
