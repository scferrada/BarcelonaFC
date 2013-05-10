package dao;

import controller.PasivoBean;
import controller.impl.PasivoBeanImpl;
import entity.EstadoPasivoEntity;
import entity.PasivoEntity;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 04:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class PasivoTest {

    @Test
    public  void sessionTest(){
        PasivoBean bean = new PasivoBeanImpl();
        PasivoEntity pv1 = makePasivo(65888, "desc1", "state 1");
        bean.savePasivo(pv1);
        PasivoEntity pv2 = bean.getAllPasives().get(0);
        assertEquals(pv1, pv2);
        bean.deletePasive(pv1);
        assertTrue(bean.getAllPasives().isEmpty());
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

}
