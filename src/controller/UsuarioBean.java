package controller;

import entity.UsuarioEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UsuarioBean {

    public boolean authenticate(UsuarioEntity usuario);
    public boolean saveUser(UsuarioEntity usuario);
    public boolean deleteUser(UsuarioEntity usuario);
    public List<UsuarioEntity> getAllUsers();
}
