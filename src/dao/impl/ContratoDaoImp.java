package dao.impl;

import dao.ContratoDao;
import dao.IDao;
import entity.ContratoEntity;
import entity.PersonalEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContratoDaoImp extends AbstractDao<ContratoEntity, Integer> implements ContratoDao {

    public void delete(ContratoEntity contratoEntity){
        IDao dao = null;

        String query = "select p from PersonalEntity p where p.contrato=:contratoEntity";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("contratoEntity",contratoEntity);
        PersonalEntity personalEntity = (PersonalEntity) q.iterate().next();
        dao.delete(personalEntity);

        query = "select s from SocioEntity s where s.contrato=:contratoEntity";
        q = HibernateUtil.getSession().createQuery(query).setParameter("contratoEntity",contratoEntity);
        personalEntity = (PersonalEntity) q.iterate().next();
        dao.delete(personalEntity);
    }

    public void deleteById(int id){
        String query = "delete from PersonalEntity p where p.contrato.id =: id";      //eliminamos al personal con esa fecha
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        q.executeUpdate();

        query = "delete from SocioEntity s where s.contrato.id =: id";
        q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        q.executeUpdate();

        query = "delete from ContratoEntity c where c.id =: id";
        q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        q.executeUpdate();
    }

    public void deleteByFechaInicio(Timestamp fechaInicio) {
        String query = "delete from PersonalEntity p where p.contrato.fechaInicio =: fechaInicio";      //eliminamos al personal con esa fecha
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("fechaInicio",fechaInicio);
        q.executeUpdate();

        query = "delete from SocioEntity s where s.contrato.fechaInicio =: fechaInicio";
        q = HibernateUtil.getSession().createQuery(query).setParameter("fechaInicio",fechaInicio);
        q.executeUpdate();

        query = "delete from ContratoEntity c where c.fechaInicio =: fechaInicio";
        q = HibernateUtil.getSession().createQuery(query).setParameter("fechaInicio",fechaInicio);
        q.executeUpdate();
    }

    public void delteByFechaTermino(Timestamp fechaExpiracion) {
        String query = "delete from PersonalEntity p where p.contrato.fechaExpiracion =: fechaExpiracion";      //eliminamos al personal con esa fecha
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("fechaExpiracion",fechaExpiracion);
        q.executeUpdate();

        query = "delete from SocioEntity s where s.contrato.fechaExpiracion =: fechaExpiracion";
        q = HibernateUtil.getSession().createQuery(query).setParameter("fechaExpiracion",fechaExpiracion);
        q.executeUpdate();

        query = "delete from ContratoEntity c where c.fechaExpiracion =: fechaExpiracion";
        q = HibernateUtil.getSession().createQuery(query).setParameter("fechaExpiracion",fechaExpiracion);
        q.executeUpdate();
    }

    public void deleteByMensualidad(int mensualidad) {
        String query = "delete from PersonalEntity p where p.contrato.mensualidad =: mensualidad";      //eliminamos al personal con esa fecha
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("mensualidad",mensualidad);
        q.executeUpdate();

        query = "delete from SocioEntity s where s.contrato.mensualidad=: mensualidad";
        q = HibernateUtil.getSession().createQuery(query).setParameter("mensualidad",mensualidad);
        q.executeUpdate();

        query = "delete from ContratoEntity c where c.mensualidad =: mensualidad";
        q = HibernateUtil.getSession().createQuery(query).setParameter("mensualidad",mensualidad);
        q.executeUpdate();
    }
}
