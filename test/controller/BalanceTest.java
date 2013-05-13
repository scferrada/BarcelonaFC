package controller;

import controller.impl.ActivoBeanImpl;
import controller.impl.BalanceBeanImpl;
import controller.impl.PasivoBeanImpl;
import entity.ActivoEntity;
import entity.EstadoPasivoEntity;
import entity.PasivoEntity;
import entity.TipoActivoEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 12-05-13
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class BalanceTest {

    ActivoEntity ac1;
    ActivoEntity ac2;
    PasivoEntity ps1;
    PasivoEntity ps2;
    ActivoBean acBean;
    PasivoBean psBean;
    BalanceBean balanceBean;

    @Before
    public void setUp(){
        ac1 = makeActivo("t1", "d1", 20000, 5);
        ac2 = makeActivo("t2", "d2", 50000, 6);
        ps1 = makePasivo(10000, "d3", "pagado", 30);
        ps2 = makePasivo(20000, "d4", "pendiente", 31);
        acBean = new ActivoBeanImpl();
        psBean = new PasivoBeanImpl();
        balanceBean = new BalanceBeanImpl();
        acBean.save(ac1);
        acBean.save(ac2);
        psBean.savePasivo(ps1);
        psBean.savePasivo(ps2);
    }

    @Test
    public void balanceTest(){
        int result = balanceBean.balanceTotal();
        assertEquals(result,50000);
    }

    @Test
    public void totalTest(){
        assertEquals(acBean.getAll().size(), 2);
        assertEquals(psBean.getAllPasives().size(), 2);
        int activos = balanceBean.totalActivos();
        assertEquals(activos, 70000);
        int pendientes = balanceBean.totalPasivosPendientes();
        assertEquals(pendientes, 20000);
        int pagados = balanceBean.totalPasivosPagados();
        assertEquals(pagados, 10000);
    }

    @After
    public void breakDown(){
        acBean.delete(ac1);
        acBean.delete(ac2);
        psBean.deletePasive(ps1);
        psBean.deletePasive(ps2);
    }

    private ActivoEntity makeActivo(String tipo, String descripcion, int valor, Integer id) {
        ActivoEntity res = new ActivoEntity();
        TipoActivoEntity tae = new TipoActivoEntity();
        tae.setId(id);
        tae.setDescripcion(descripcion);
        tae.setTipo(tipo);
        res.setTipoActivo(tae);
        res.setValor(valor);
        return res;
    }

    private PasivoEntity makePasivo(int value, String description, String state, Integer id) {
        PasivoEntity res = new PasivoEntity();
        EstadoPasivoEntity epe = new EstadoPasivoEntity();
        epe.setId(id);
        epe.setDescripcion(description);
        epe.setEstado(state);
        res.setValor(value);
        res.setEstadoPasivo(epe);
        return res;
    }

}
