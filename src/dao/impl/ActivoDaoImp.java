package dao.impl;

import dao.ActivoDao;
import dao.IDao;
import entity.ActivoEntity;
import entity.UsuarioEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivoDaoImp extends AbstractDao<ActivoEntity, Integer> implements ActivoDao {

    @Override
    public ActivoEntity findById(int id) {
        String query = "select a from ActivoEntity a where a.id = :id";
        Query q  = HibernateUtil.createQuery(query).setParameter("id", id);
        ActivoEntity usr = findOne(q);
        HibernateUtil.closeSession();
        return usr;
    }

    public int getSumAll() {
        String query = "select sum(a.valor) from ActivoEntity a";
        Query q = HibernateUtil.createQuery(query);
        int suma = Integer.parseInt( q.uniqueResult() + "");
        HibernateUtil.closeSession();
        return suma;
    }
}
