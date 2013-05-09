package dao.impl;

import dao.ActivoDao;
import dao.IDao;
import entity.ActivoEntity;
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

    public int getSumAll() {
        String query = "select sum(a.valor) from ActivoEntity a";
        Query q = HibernateUtil.createQuery(query);
        int suma = Integer.parseInt((String) q.uniqueResult());
        HibernateUtil.closeSession();
        return suma;
    }
}
