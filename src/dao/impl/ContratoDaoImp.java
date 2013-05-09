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
    public void delete(ContratoEntity contratoEntity){
        ContratoDao contratoDao = new ContratoDaoImp();
        contratoDao.delete(contratoEntity);
    }

    @Override
    public void deleteCascade(ContratoEntity contrato) {
        PersonalDao personalDao = new PersonalDaoImp();
        ContratoDao contratoDao = new ContratoDaoImp();
        PersonalEntity contratado = personalDao.getPersonalByContrato(contrato);
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
