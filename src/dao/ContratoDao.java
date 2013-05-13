package dao;

import entity.ContratoEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContratoDao extends IDao<ContratoEntity, Integer> {

    public ContratoEntity findById(int id);


}
