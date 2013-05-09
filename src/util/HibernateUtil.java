package util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 05:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Query createQuery(String hql){
        return sessionFactory.openSession().createQuery(hql);
    }

    public static void closeSession() {
        sessionFactory.getCurrentSession().close();
    }
}
