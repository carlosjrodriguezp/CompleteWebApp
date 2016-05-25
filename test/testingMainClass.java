
import com.webapp.dominio.Registro;
import com.webapp.persistencia.dao.RegistroDAO;
import com.webapp.persistencia.dao.impl.RegistroDAOImplHibernate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testingMainClass {
        
    public static void main(String[] args) {
        //sinDAO();
        //insertDAO();
        getDAO();
    }    
    
    public static void getDAO(){
        RegistroDAO registroDAO = new RegistroDAOImplHibernate();
        try {
            Registro registro = registroDAO.get(12);
            System.out.println("ID "+registro.getId()+" NAME "+registro.getName());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    
    public static void insertDAO(){
       
        RegistroDAO registroDAO = new RegistroDAOImplHibernate();
                  
        try {
            Registro registro = new Registro(22,"sadas");
            registroDAO.insert(registro);
            System.out.println("re");
        } catch (Exception ex) {
            System.out.println(ex);
        }    
    }
    
    public static void sinDAO(){
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session=sessionFactory.openSession();
//        Registro registro = new Registro(12,"new name");
//        session.beginTransaction();
//        session.save(registro);
//        session.getTransaction().commit();

        Registro registro2=(Registro)session.get(Registro.class,12);
        System.out.println(registro2.getId());
        System.out.println(registro2.getName());
        session.close();
    }
}
