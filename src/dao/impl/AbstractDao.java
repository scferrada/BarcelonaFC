package dao.impl;

import dao.IDao;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 03-05-13
 * Time: 02:42 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDao<T, ID extends Serializable> implements IDao<T, ID> {

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void save(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.beginTransaction();
        try{
            hibernateSession.save(entity);
            hibernateSession.getTransaction().commit();
            System.out.println("saved!");
        }catch (Exception ex){
            hibernateSession.getTransaction().rollback();
            ex.printStackTrace();
        }
        hibernateSession.close();
    }

    public void merge(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.merge(entity);
    }

    public void delete(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.delete(entity);
    }

    public List<T> findMany(Query query) {
        List<T> t;
        t = (List<T>) query.list();
        return t;
    }

    public T findOne(Query query) {
        T t = (T) query.uniqueResult();
        return t;
    }

    public T findByID(Class<T> clazz, Integer id) {
        Session hibernateSession = this.getSession();
        T t = (T) hibernateSession.get(clazz, id);
        return t;
    }

    public List<T> findAll(Class<T> clazz) {
        Session hibernateSession = this.getSession();
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        List<T> res =  query.list();
        hibernateSession.close();
        return res;
    }
}
