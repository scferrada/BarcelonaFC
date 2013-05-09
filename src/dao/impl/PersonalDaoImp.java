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

    public void save(PersonalEntity personal){
        ContratoDao contratoDao = new ContratoDaoImp();
        contratoDao.save(personal.getContrato());
        save(personal);
    }

    @Override
    public void delete(PersonalEntity personalEntity){
        IDao dao = null;
        dao.delete(personalEntity.getContratado());
        dao.delete(personalEntity);
    }

    @Override
    public PersonalEntity getPersonalByContrato(ContratoEntity contrato) {
        String query = "select p from PersonalEntity p where p.contrato = :contrato";
        Query q = HibernateUtil.getSessionFactory().openSession().createQuery(query).setParameter("contrato", contrato);
        return this.findOne(q);
    }
}
