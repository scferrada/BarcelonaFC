package dao.impl;

import dao.IDao;
import dao.PersonalDao;
import entity.NacionalidadEntity;
import entity.PersonalEntity;
import entity.TipoPersonalEntity;
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

    public void save(PersonalEntity personalEntity){
        IDao dao = null;
        dao.save(personalEntity);
        dao.save(personalEntity.getContrato());
    }

    public void delete(PersonalEntity personalEntity){
        IDao dao = null;
        dao.delete(personalEntity.getContratado());
        dao.delete(personalEntity);
    }

    public void deleteById(int id) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.id =: id";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        PersonalEntity personalEntity = (PersonalEntity) q.iterate().next();
        dao.delete(personalEntity);
        dao.delete(personalEntity.getContrato());
    }

    public void deleteByName(String name) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.nombre =: name";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("name",name);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PersonalEntity personalEntity = (PersonalEntity) iterator.next();
            dao.delete(personalEntity);
            dao.delete(personalEntity.getContrato());
        }
    }

    public void deleteByLastName(String lastName) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.apellido =: lastName";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("lastName",lastName);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PersonalEntity personalEntity = (PersonalEntity) iterator.next();
            dao.delete(personalEntity);
            dao.delete(personalEntity.getContrato());
        }
    }

    public void deleteByBirth(Timestamp birth) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.fechaNacimiento =: birth";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("birth",birth);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PersonalEntity personalEntity = (PersonalEntity) iterator.next();
            dao.delete(personalEntity);
            dao.delete(personalEntity.getContrato());
        }
    }

    public void deleteByHired(BigInteger hired) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.contratado =: hired";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("hired",hired);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PersonalEntity personalEntity = (PersonalEntity) iterator.next();
            dao.delete(personalEntity);
            dao.delete(personalEntity.getContrato());
        }
    }

    public void deleteByValue(int value) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.valorBase =: value";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("value",value);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PersonalEntity personalEntity = (PersonalEntity) iterator.next();
            dao.delete(personalEntity);
            dao.delete(personalEntity.getContrato());
        }
    }

    public void deleteByType(String type) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.tipoPersonal = (select t from TipoPersonalEntity t where t.tipo=:type)";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("type",type);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PersonalEntity personalEntity = (PersonalEntity) iterator.next();
            dao.delete(personalEntity);
            dao.delete(personalEntity.getContrato());
        }
    }

    public void deleteByNation(String nation) {
        IDao dao = null;
        String query = "select p from PersonalEntity p where p.nacionalidad = (select n from NacionalidadEntity n where n.pais =:nation)";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("nation",nation);
        Iterator iterator = q.iterate();
        while(iterator.hasNext()){
            PersonalEntity personalEntity = (PersonalEntity) iterator.next();
            dao.delete(personalEntity);
            dao.delete(personalEntity.getContrato());
        }
    }
}
