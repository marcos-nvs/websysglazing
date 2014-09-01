
import br.com.ln.entity.LnUsuario;
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
        
        try {
            Query query = session.getNamedQuery("LnUsuario.findByUsuStCodigo");
            query.setString("usuStCodigo", "Marcos");
            
            List l = query.list();
            tx.commit();
            
            if (l != null && !l.isEmpty()){
                LnUsuario lnUsuario = (LnUsuario) l.get(0);
                
                System.out.println("Nome do usuário : " + lnUsuario.getUsuStNome());
            } else{
                System.out.println("Não encontrado");
            }
        }finally{
            session.close();
        }        
        
    }
}
