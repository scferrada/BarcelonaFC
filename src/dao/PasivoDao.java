package dao;

import entity.PasivoEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PasivoDao extends IDao<PasivoEntity, Integer> {

    public PasivoEntity findById(int id);
    public int getSumaEstado(String estado);

}
