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

    @Override
    public UsuarioEntity findByUserName(String username) {
        String sql = "select u from UsuarioEntity u where u.nombreUsuario = :username";
        Query query = HibernateUtil.createQuery(sql).setParameter("username", username);
        UsuarioEntity found = this.findOne(query);
        HibernateUtil.closeSession();
        return found;
    }
}
