package controller;

import controller.UsuarioBean;
import controller.impl.UsuarioBeanImpl;
import entity.UsuarioEntity;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 04:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsuarioTest {
    private UsuarioBean bean;
    @Before public void setUp(){
        bean= new UsuarioBeanImpl();
    }

    @Test
    public void sessionTest(){
        UsuarioEntity us1 = makeUser("user", "pass");
        bean.saveUser(us1);
        UsuarioEntity us2 = bean.getAllUsers().get(0);
        assertEquals(us1, us2);
        bean.deleteUser(us2);
        assertTrue(bean.getAllUsers().isEmpty());
    }

    @Test
    public void consistencyTest(){
        UsuarioEntity us1 = makeUser(null, null);
        bean.saveUser(us1);
        assertTrue(bean.getAllUsers().isEmpty());
    }

    @Test
    public void authenticateTest(){
        UsuarioEntity us1 = makeUser("user", "pass");
        bean.saveUser(us1);
        assertTrue(bean.authenticate(us1));
        bean.deleteUser(us1);
        assertTrue(bean.getAllUsers().isEmpty());
    }

    private UsuarioEntity makeUser(String user, String pass) {
        UsuarioEntity res = new UsuarioEntity();
        res.setNombreUsuario(user);
        res.setPassword(pass);
        return res;
    }

}
