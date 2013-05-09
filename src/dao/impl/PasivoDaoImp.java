package dao.impl;

import dao.IDao;
import dao.PasivoDao;
import entity.PasivoEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PasivoDaoImp extends AbstractDao<PasivoEntity, Integer> implements PasivoDao {

    public void deleteById(int id) {
        IDao dao = null;
        String query = "select p from PasivoEntity p where p.id =: id";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        Iterator iterator = q.iterate();
        PasivoEntity pasivoEntity = (PasivoEntity) iterator.next();
        dao.delete(pasivoEntity);
    }

    public void deleteByValue(int value) {
        IDao dao = null;
        String query = "select p from PasivoEntity p where p.valor =: value";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("value",value);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PasivoEntity pasivoEntity = (PasivoEntity) iterator.next();
            dao.delete(pasivoEntity);
        }

    }

    public void deletByState(String state) {
        IDao dao = null;
        String query = "select p from PasivoEntity p where p.estadoPasivo = (select e from EstadoPasivoEntity e where e.estado=:state)";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("state",state);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PasivoEntity pasivoEntity = (PasivoEntity) iterator.next();
            dao.delete(pasivoEntity);
        }
    }

    public int getSumaAll(String estado) {
        String query = "select sum(p.valor) from PasivoEntity p where p.estadoPasivo.estado =: estado";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("estado",estado);
        int suma = Integer.parseInt((String) q.list().get(0));
        return suma;
    }
}
