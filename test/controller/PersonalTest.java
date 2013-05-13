package controller;

import controller.PersonalBean;
import controller.impl.PersonalBeanImpl;
import entity.ContratoEntity;
import entity.NacionalidadEntity;
import entity.PersonalEntity;
import entity.TipoPersonalEntity;
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
public class PersonalTest {

    PersonalBean bean;
    @Before public void setUp(){
        bean = new PersonalBeanImpl();
    }

    @Test
    public void sessionTest(){
        PersonalEntity ps1 = makePersonal("Claudio", "Berroeta");
        bean.save(ps1);
        PersonalEntity ps2 = bean.getAll().get(0);
        assertEquals(ps1, ps2);
        bean.delete(ps1);
        assertTrue(bean.getAll().isEmpty());
    }

    @Test
    public void consistencyTest(){
        PersonalEntity ps1 = makePersonal("hola", null);
        ps1.setFechaNacimiento(null);
        bean.save(ps1);
        assertTrue(bean.getAll().isEmpty());
        ps1.setFechaNacimiento(new Timestamp(1000L));
        bean.save(ps1);
        assertTrue(bean.getAll().isEmpty());
    }

    private PersonalEntity makePersonal(String nombre, String apellido) {
        PersonalEntity res = new PersonalEntity();
        ContratoEntity cnt = new ContratoEntity();
        NacionalidadEntity ndd = new NacionalidadEntity();
        TipoPersonalEntity tpe = new TipoPersonalEntity();
        tpe.setDescripcion("barre la calle");
        tpe.setTipo("arquero");
        tpe.setId(1);
        ndd.setId(1);
        ndd.setPais("Chile");
        cnt.setFechaInicio(new Timestamp(0L));
        cnt.setFechaExpiracion(new Timestamp(10000L));
        cnt.setMensualidad(356698);
        res.setNombre(nombre);
        res.setApellido(apellido);
        res.setContratado(1);
        res.setContrato(cnt);
        res.setFechaNacimiento(new Timestamp(1000*(new Date().getTime()/1000)));
        res.setNacionalidad(ndd);
        res.setValorBase(5000);
        res.setTipoPersonal(tpe);
        return res;
    }

}
