package dao;

import entity.SocioEntity;

import java.math.BigInteger;

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
    public void deleteByName(String name);
    public void deleteByLastName(String lastName);
    public void deleteByHired(BigInteger seat);
    public void deleteByNation(String nation);
}
