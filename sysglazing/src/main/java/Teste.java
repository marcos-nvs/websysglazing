
import br.com.ln.entity.Glausuario;
import br.com.ln.hibernate.SessionFactoryDbName;
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
        
        Session session = SessionFactoryDbName.getCurrentSessionByName("Public");
        Transaction tx = session.beginTransaction();
        
        Glausuario glaUsuarios = null;
        Query query = session.getNamedQuery("Glausuario.findAll");
        
        List l = query.list();
        
        if (l != null){
            glaUsuarios = (Glausuario) l.get(0);
            
            System.out.println("usuario : " + glaUsuarios.toString());
        } else {
            System.out.println("lista vazia.....");
        }
    }
}
