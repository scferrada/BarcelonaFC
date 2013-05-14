package controller.impl;

import controller.UsuarioBean;
import dao.UsuarioDao;
import dao.impl.UsuarioDaoImp;
import entity.UsuarioEntity;
import util.Consistence;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UsuarioBeanImpl implements UsuarioBean{

    private final UsuarioDao usuarioDao;

    public UsuarioBeanImpl(){
        usuarioDao = new UsuarioDaoImp();
    }

    @Override
    public boolean authenticate(UsuarioEntity usuario) {
        UsuarioEntity comp;
        try{
            comp = usuarioDao.findByUserName(usuario.getNombreUsuario());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return comp != null && comp.getPassword().equals(usuario.getPassword());
    }

    @Override
    public boolean saveUser(UsuarioEntity usuario) {
        //VALIDATE
        try{
            Consistence.isNotNull(usuario.getNombreUsuario());
            Consistence.isNotNull(usuario.getPassword());
            usuarioDao.save(usuario);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(UsuarioEntity usuario) {
        try{
            usuarioDao.delete(usuario);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<UsuarioEntity> getAllUsers() {
        List<UsuarioEntity> res = new ArrayList<UsuarioEntity>();
        try{
            res = usuarioDao.findAll(UsuarioEntity.class);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
