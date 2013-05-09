package dao;

import entity.ActivoEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ActivoDao extends IDao<ActivoEntity, Integer>{

    public int getSumAll();

}
