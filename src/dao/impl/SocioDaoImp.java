package dao.impl;

import dao.IDao;
import dao.SocioDao;
import entity.ContratoEntity;
import entity.DatoContactoEntity;
import entity.SocioEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocioDaoImp extends AbstractDao<SocioEntity, Integer> implements SocioDao {

    public void save(SocioEntity socioEntity){      //falta salvar los datos de contacto
        IDao dao = null;
        dao.save(socioEntity);
        dao.save(socioEntity.getContrato());
    }

    public void delete(SocioEntity socioEntity){
        IDao dao = null;
        dao.delete(socioEntity.getContrato());     //elimino el contrato asociado al socio

        String query = "delete from DatoContactoEntity d where d.socio =: socioEntity";   //elimino los datos asociados
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("socioEntity",socioEntity);
        q.executeUpdate();

        dao.delete(socioEntity); //elimino el socio
    }

    public void deleteById(int id) {
        IDao dao = null;

        String query = "select s from SocioEntity s where s.id =: id";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        SocioEntity socioEntity  = (SocioEntity) q.iterate().next();

        dao.delete(socioEntity.getContrato());     //elimino el contrato asociado al socio

        query = "delete from DatoContactoEntity d where d.socio =: socioEntity";   //elimino los datos asociados
        q = HibernateUtil.getSession().createQuery(query).setParameter("socioEntity",socioEntity);
        q.executeUpdate();

        dao.delete(socioEntity); //elimino el socio
    }

    public void deleteByNation(String nation) {
        IDao dao = null;
        Query p;
        SocioEntity socioEntity;

        String query = "select s from SocioEntity s where s.nacionalidad.pais =: nation";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("nation",nation);

        while(q.iterate().hasNext()){      //por cada socio
            socioEntity = (SocioEntity) q.iterate().next();

            dao.delete(socioEntity.getContrato());     //elimino el contrato asociado al socio

            query = "delete from DatoContactoEntity d where d.socio =: socioEntity";   //elimino los datos asociados
            p = HibernateUtil.getSession().createQuery(query).setParameter("socioEntity",socioEntity);
            p.executeUpdate();

            dao.delete(socioEntity); //elimino el socio
        }
    }

    public void deleteByName(String name) {
        IDao dao = null;
        Query p;
        SocioEntity socioEntity;

        String query = "select s from SocioEntity s where s.nombre =: name";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("name",name);

        while(q.iterate().hasNext()){
            socioEntity = (SocioEntity) q.iterate().next();

            dao.delete(socioEntity.getContrato());     //elimino el contrato asociado al socio

            query = "delete from DatoContactoEntity d where d.socio =: socioEntity";   //elimino los datos asociados
            p = HibernateUtil.getSession().createQuery(query).setParameter("socioEntity",socioEntity);
            p.executeUpdate();

            dao.delete(socioEntity); //elimino el socio
        }
    }

    public void deleteByLastName(String lastName) {
        IDao dao = null;
        Query p;
        SocioEntity socioEntity;

        String query = "select s from SocioEntity s where s.apellido =: lastName";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("lastName",lastName);

        while(q.iterate().hasNext()){
            socioEntity = (SocioEntity) q.iterate().next();

            dao.delete(socioEntity.getContrato());     //elimino el contrato asociado al socio

            query = "delete from DatoContactoEntity d where d.socio =: socioEntity";   //elimino los datos asociados
            p = HibernateUtil.getSession().createQuery(query).setParameter("socioEntity",socioEntity);
            p.executeUpdate();

            dao.delete(socioEntity); //elimino el socio
        }
    }

    public void deleteByBirth(Timestamp birth) {
        IDao dao = null;
        Query p;
        SocioEntity socioEntity;

        String query = "select s from SocioEntity s where s.fechaNacimiento =: birth";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("birth",birth);

        while(q.iterate().hasNext()){
            socioEntity = (SocioEntity) q.iterate().next();

            dao.delete(socioEntity.getContrato());     //elimino el contrato asociado al socio

            query = "delete from DatoContactoEntity d where d.socio =: socioEntity";   //elimino los datos asociados
            p = HibernateUtil.getSession().createQuery(query).setParameter("socioEntity",socioEntity);
            p.executeUpdate();

            dao.delete(socioEntity); //elimino el socio
        }
    }

    public void deleteByHired(BigInteger seat) {
        IDao dao = null;
        Query p;
        SocioEntity socioEntity;

        String query = "select s from SocioEntity s where s.derechoAsiento =: seat";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("seat",seat);

        while(q.iterate().hasNext()){
            socioEntity = (SocioEntity) q.iterate().next();

            dao.delete(socioEntity.getContrato());     //elimino el contrato asociado al socio

            query = "delete from DatoContactoEntity d where d.socio =: socioEntity";   //elimino los datos asociados
            p = HibernateUtil.getSession().createQuery(query).setParameter("socioEntity",socioEntity);
            p.executeUpdate();

            dao.delete(socioEntity); //elimino el socio
        }
    }

    public void deleteByContact(String dato) {
        IDao dao = null;

        String query = "select d from DatoContactoEntity d where d.datoValor =: dato";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("dato",dato);
        DatoContactoEntity datoContactoEntity = (DatoContactoEntity) q.iterate().next();

        dao.delete(datoContactoEntity.getSocio().getContrato());    // eliminamos cotrato
        dao.delete(datoContactoEntity.getSocio());  //eliminamos al socio

        query = "delete from DatoContactoEntity d where d.datoValor =: dato"; //eliminamos los datos
        q = HibernateUtil.getSession().createQuery(query).setParameter("dato",dato);
        q.executeUpdate();
    }
}
