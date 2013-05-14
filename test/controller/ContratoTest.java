package controller;

import controller.ContratoBean;
import controller.impl.ContratoBeanImpl;
import entity.ActivoEntity;
import entity.ContratoEntity;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 04:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContratoTest {

    private ContratoBean bean;

    @Before public void setUp(){
        bean = new ContratoBeanImpl();
    }

    @Test
    public void sessionTest(){
        ContratoEntity cn1 = makeContract(3000000);
        bean.updateContract(cn1);
        ContratoEntity cn2 = bean.getAllContracts().get(0);
        assertEquals(cn1, cn2);
        bean.deleteContract(cn1);
        assertTrue(bean.getAllContracts().isEmpty());
    }

    @Test
    public void consistencyTest(){
        ContratoEntity cn1 = makeContract(-699);
        bean.updateContract(cn1);
        cn1.setMensualidad(2566);
        cn1.setFechaInicio(new Timestamp(new Date().getTime()));
        bean.updateContract(cn1);
        assertTrue(bean.getAllContracts().isEmpty());
    }

    @Test
    public void sqlTest(){
        ContratoEntity cn1 = makeContract(300);
        cn1.setFechaExpiracion(null);
        bean.updateContract(cn1);
        assertTrue(bean.getAllContracts().isEmpty());
    }

    private ContratoEntity makeContract(int mensualidad) {
        ContratoEntity res = new ContratoEntity();
        res.setFechaExpiracion(new Timestamp(1000L));
        res.setFechaInicio(new Timestamp(0L));
        res.setMensualidad(mensualidad);
        return res;
    }

}
