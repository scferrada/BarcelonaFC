package dao;

import entity.SocioEntity;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SocioDao extends IDao<SocioEntity, Integer> {

    public SocioEntity findById(int id);

}
