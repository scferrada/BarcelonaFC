package dao;

import entity.UsuarioEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 06:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UsuarioDao extends IDao<UsuarioEntity, Integer> {

    public UsuarioEntity findById(int id);
    public UsuarioEntity findByUserName(String username);
}
