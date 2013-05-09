package dao;

import controller.ContratoBean;
import controller.impl.ContratoBeanImpl;
import entity.ContratoEntity;
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

    @Test
    public void sessionTest(){
        ContratoBean bean =  new ContratoBeanImpl();
        ContratoEntity cn1 = makeContract(3000000);
        bean.updateContract(cn1);
        ContratoEntity cn2 = bean.getAllContracts().get(0);
        assertEquals(cn1, cn2);
        bean.deleteContract(cn1);
        assertTrue(bean.getAllContracts().isEmpty());
    }

    private ContratoEntity makeContract(int mensualidad) {
        ContratoEntity res = new ContratoEntity();
        res.setFechaExpiracion(new Timestamp(new Date().getTime()));
        res.setFechaInicio(new Timestamp(0L));
        res.setMensualidad(mensualidad);
        return res;
    }

}
