package dao;

import dao.impl.UsuarioDaoImp;
import entity.UsuarioEntity;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 06:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class FirstTest {

    @Test
    public void sessionTest(){
        System.out.println("testing...");
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        UsuarioEntity usr = new UsuarioEntity();
        usr.setNombreUsuario("Claudin"+new Date().getTime());
        usr.setPassword("holoo");
        usuarioDao.save(usr);
        System.out.println(usr.getId()+" ,"+usr.getNombreUsuario()+" ,"+usr.getPassword());
        List<UsuarioEntity> dbuser = usuarioDao.findAll(UsuarioEntity.class);
        for(UsuarioEntity user : dbuser){
            System.out.println(user.getId()+" ,"+user.getNombreUsuario()+" ,"+user.getPassword());
        }
        System.out.println("done");
    }
}
