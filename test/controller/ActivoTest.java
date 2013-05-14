package controller;

import controller.ActivoBean;
import controller.impl.ActivoBeanImpl;
import entity.ActivoEntity;
import entity.TipoActivoEntity;
import exception.InconsistentArgumentException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Date;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 04:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivoTest {

    private ActivoBean bean;
    @Before
    public void setUp(){
        bean = new ActivoBeanImpl();
    }

    @Test
    public void sessionTest(){
        ActivoEntity ac1 = makeActivo("capital", "desc1", 300);
        bean.save(ac1);
        ActivoEntity ac2 = bean.getAll().get(0);
        assertEquals(ac1, ac2);
        bean.delete(ac1);
        assertTrue(bean.getAll().isEmpty());
    }

    @Test
    public void consistencyTest(){
        ActivoEntity ac1 = makeActivo("tipo asd", "desc asd", -966);
        bean.save(ac1);
        assertTrue(bean.getAll().isEmpty());
    }
    @Test
    public void sqlTest(){
        ActivoEntity ac1 = makeActivo(null, null, 699);
        bean.save(ac1);
        assertTrue(bean.getAll().isEmpty());
    }


    private ActivoEntity makeActivo(String tipo, String descripcion, int valor) {
        ActivoEntity res = new ActivoEntity();
        TipoActivoEntity tae = new TipoActivoEntity();
        tae.setId(2);
        tae.setDescripcion(descripcion);
        tae.setTipo(tipo);
        res.setTipoActivo(tae);
        res.setValor(valor);
        return res;
    }

}
