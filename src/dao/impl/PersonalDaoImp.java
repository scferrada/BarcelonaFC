package dao.impl;

import dao.ContratoDao;
import dao.IDao;
import dao.PersonalDao;
import entity.*;
import org.hibernate.Query;
import util.HibernateUtil;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonalDaoImp extends AbstractDao<PersonalEntity, Integer> implements PersonalDao {
    @Override
    public PersonalEntity findById(int id) {
        String query = "select a from PersonalEntity a where a.id = :id";
        Query q  = HibernateUtil.createQuery(query).setParameter("id", id);
        PersonalEntity usr = findOne(q);
        HibernateUtil.closeSession();
        return usr;
    }
}
