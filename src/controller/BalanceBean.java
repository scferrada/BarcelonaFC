package controller;

import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 08:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface BalanceBean {

    public int totalActivos();
    public int totalPasivosPendientes();
    public int totalPasivosPagados();
    public int balanceTotal();

}
