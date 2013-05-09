package dao.impl;

import dao.ActivoDao;
import dao.IDao;
import entity.ActivoEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivoDaoImp extends AbstractDao<ActivoEntity, Integer> implements ActivoDao {

    public void deleteById(int id) {
        IDao dao = null;
        String query = "select a from ActivoEntity a where a.id =: id";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        Iterator iterator = q.iterate();
        ActivoEntity activoEntity = (ActivoEntity) iterator.next();
        dao.delete(activoEntity);

    }

    public void deleteByValue(int value) {
        IDao dao = null;
        String query = "select a from ActivoEntity a where a.valor =: value";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("value",value);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            ActivoEntity activoEntity = (ActivoEntity) iterator.next();
            dao.delete(activoEntity);
        }
    }

    public void deletByType(String type) {
        IDao dao = null;
        String query = "select a from ActivoEntity a where a.tipoActivo = (select t from TipoActivoEntity t where t.tipo=:type)";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("type",type);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            ActivoEntity activoEntity = (ActivoEntity) iterator.next();
            dao.delete(activoEntity);
        }
    }
}
