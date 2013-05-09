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

    public void save(SocioEntity socioEntity);

    public void delete(SocioEntity socioEntity);
    public void deleteById(int id);
    public void deleteByNation(String nation);
    public void deleteByName(String name);
    public void deleteByLastName(String lastName);
    public void deleteByBirth(Timestamp birth);
    public void deleteByHired(BigInteger seat);
    public void deleteByContact(String dato);

}
