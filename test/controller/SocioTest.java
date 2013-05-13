package controller;

import controller.SocioBean;
import controller.impl.SocioBeanImpl;
import entity.ContratoEntity;
import entity.NacionalidadEntity;
import entity.SocioEntity;
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
public class SocioTest {
    SocioBean bean;
    @Before public void setUp(){
        bean  = new SocioBeanImpl();
    }

    @Test
    public void sessionTest(){
        SocioEntity sc1 = makeSocio("Victor", "Diaz");
        bean.saveAssociate(sc1);
        SocioEntity sc2 = bean.getAllAssociates().get(0);
        assertEquals(sc1, sc2);
        bean.deleteAssociate(sc2);
        assertTrue(bean.getAllAssociates().isEmpty());
    }

    @Test
    public void consistencyTest(){
        SocioEntity sc1 = makeSocio("asd", "fgh");
        sc1.setFechaNacimiento(null);
        bean.saveAssociate(sc1);
        assertTrue(bean.getAllAssociates().isEmpty());
    }

    private SocioEntity makeSocio(String nombre, String apellido) {
       SocioEntity res = new SocioEntity();
        ContratoEntity cnt = new ContratoEntity();
        NacionalidadEntity ndd = new NacionalidadEntity();
        ndd.setId(2);
        ndd.setPais("Brasil");
        cnt.setFechaInicio(new Timestamp(0L));
        cnt.setFechaExpiracion(new Timestamp(1000L));
        cnt.setMensualidad(5522200);
        res.setNombre(nombre);
        res.setApellido(apellido);
        res.setDerechoAsiento(1);
        res.setFechaNacimiento(new Timestamp(1000*(new Date().getTime()/1000)));
        res.setContrato(cnt);
        res.setNacionalidad(ndd);
        return res;
    }

}
