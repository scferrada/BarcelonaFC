package dao.impl;

import dao.IDao;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.io.Serializable;
import java.math.BigDecimal;
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
        return HibernateUtil.getSession();
    }

    public void save(T entity) {
        Session hibernateSession = this.getSession();
        hibernateSession.saveOrUpdate(entity);
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

    public T findByID(Class clazz, BigDecimal id) {
        Session hibernateSession = this.getSession();
        T t = (T) hibernateSession.get(clazz, id);
        return t;
    }

    public List findAll(Class clazz) {
        Session hibernateSession = this.getSession();
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        return query.list();
    }
}
