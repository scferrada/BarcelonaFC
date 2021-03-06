package dao.impl;

import dao.ContratoDao;
import dao.IDao;
import dao.PersonalDao;
import entity.ContratoEntity;
import entity.PersonalEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContratoDaoImp extends AbstractDao<ContratoEntity, Integer> implements ContratoDao {

    @Override
    public ContratoEntity findById(int id) {
        String query = "select c from ContratoEntity c where c.id = :id";
        Query q  = HibernateUtil.createQuery(query).setParameter("id", id);
        ContratoEntity usr = findOne(q);
        HibernateUtil.closeSession();
        return usr;
    }
}
