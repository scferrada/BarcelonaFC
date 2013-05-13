package dao.impl;

import dao.SocioDao;
import entity.SocioEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocioDaoImp extends AbstractDao<SocioEntity, Integer> implements SocioDao {
    @Override
    public SocioEntity findById(int id) {
        String query = "select a from SocioEntity a where a.id = :id";
        Query q  = HibernateUtil.createQuery(query).setParameter("id", id);
        SocioEntity usr = findOne(q);
        HibernateUtil.closeSession();
        return usr;
    }
}
