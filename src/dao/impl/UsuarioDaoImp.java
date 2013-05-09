package dao.impl;

import dao.IDao;
import dao.UsuarioDao;
import entity.UsuarioEntity;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 06:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsuarioDaoImp extends AbstractDao<UsuarioEntity, Integer> implements UsuarioDao{

    public void deleteById(int id){
        String query = "delete from UsuarioEntity u where u.id =: id";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("id",id);
        q.executeUpdate();
    }

    public void deleteByName(String name){
        String query = "delete from UsuarioEntity u where u.nombreUsuario =: name";
        Query q = HibernateUtil.getSession().createQuery(query).setParameter("name",name);
        q.executeUpdate();
    }

}
