package controller.impl;

import controller.BalanceBean;
import dao.ActivoDao;
import dao.PasivoDao;
import dao.impl.ActivoDaoImp;
import dao.impl.PasivoDaoImp;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 08:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class BalanceBeanImpl implements BalanceBean{
    private ActivoDao activoDao;
    private PasivoDao pasivoDao;

    public BalanceBeanImpl(){
        activoDao = new ActivoDaoImp();
        pasivoDao = new PasivoDaoImp();
    }

    @Override
    public int totalActivos() {
        return activoDao.getSumAll();
    }

    @Override
    public int totalPasivosPendientes() {
        return pasivoDao.getSumaEstado("Pendiente");
    }

    @Override
    public int totalPasivosPagados() {
        return pasivoDao.getSumaEstado("Pagado");
    }

    @Override
    public int balanceTotal() {
        return this.totalActivos()-this.totalPasivosPendientes();
    }
}
