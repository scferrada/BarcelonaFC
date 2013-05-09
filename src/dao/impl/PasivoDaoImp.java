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

    public int getSumaAll(String estado) {
        String query = "select sum(p.valor) from PasivoEntity p where p.estadoPasivo.estado =: estado";
        Query q = HibernateUtil.createQuery(query).setParameter("estado",estado);
        int suma = Integer.parseInt((String) q.uniqueResult());
        HibernateUtil.closeSession();
        return suma;
    }

}
