package dao;

import dao.impl.*;
import entity.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 12-05-13
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DaoTest {

    @Test
    public void activoIdTest(){
        ActivoDao dao = new ActivoDaoImp();
        ActivoEntity ac1 = makeActivo("t1", "d1", 655);
        dao.save(ac1);
        ActivoEntity ac2 = dao.findById(ac1.getId());
        assertEquals(ac1, ac2);
        dao.delete(ac1);
    }

    @Test
    public void contratoIdTest(){
        ContratoDao dao = new ContratoDaoImp();
        ContratoEntity ac1 = makeContrato(655);
        dao.save(ac1);
        ContratoEntity ac2 = dao.findById(ac1.getId());
        assertEquals(ac1, ac2);
        dao.delete(ac1);
    }

    @Test
    public void pasivoIdTest(){
        PasivoDao dao = new PasivoDaoImp();
        PasivoEntity ac1 = makePasivo(655, "holo", "chau");
        dao.save(ac1);
        PasivoEntity ac2 = dao.findById(ac1.getId());
        assertEquals(ac1, ac2);
        dao.delete(ac1);
    }

    @Test
    public void personalIdTest(){
        PersonalDao dao = new PersonalDaoImp();
        PersonalEntity ac1 = makePersonal("holo", "chau");
        dao.save(ac1);
        PersonalEntity ac2 = dao.findById(ac1.getId());
        assertEquals(ac1, ac2);
        dao.delete(ac1);
    }

    @Test
    public void socioIdTest(){
        SocioDao dao = new SocioDaoImp();
        SocioEntity ac1 = makeSocio("holo", "chau");
        dao.save(ac1);
        SocioEntity ac2 = dao.findById(ac1.getId());
        assertEquals(ac1, ac2);
        dao.delete(ac1);
    }

    @Test
    public void usuarioIdTest(){
        UsuarioDao dao = new UsuarioDaoImp();
        UsuarioEntity ac1 = new UsuarioEntity();
        ac1.setNombreUsuario("user"); ac1.setPassword("pass");
        dao.save(ac1);
        UsuarioEntity ac2 = dao.findById(ac1.getId());
        assertEquals(ac1, ac2);
        dao.delete(ac1);
    }

    private PasivoEntity makePasivo(int value, String description, String state) {
        PasivoEntity res = new PasivoEntity();
        EstadoPasivoEntity epe = new EstadoPasivoEntity();
        epe.setId(20);
        epe.setDescripcion(description);
        epe.setEstado(state);
        res.setValor(value);
        res.setEstadoPasivo(epe);
        return res;
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

    private ContratoEntity makeContrato(int mensualidad) {
        ContratoEntity res = new ContratoEntity();
        res.setFechaExpiracion(new Timestamp(1000L));
        res.setFechaInicio(new Timestamp(0L));
        res.setMensualidad(mensualidad);
        return res;
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
