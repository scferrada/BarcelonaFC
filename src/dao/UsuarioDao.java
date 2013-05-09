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

    public void deleteById(int id);
    public void deleteByName(String name);

}
