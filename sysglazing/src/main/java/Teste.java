
import br.com.ln.entity.LnMenu;
import br.com.ln.entity.LnModulo;
import br.com.ln.entity.LnUsuario;
import br.com.ln.glazing.MenuSistema;
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
        
        MenuSistema menu = new MenuSistema(null, "Public");
        menu.getModel();

    }
}
