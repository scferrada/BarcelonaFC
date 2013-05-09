package dao.impl;

import dao.SocioDao;
import entity.SocioEntity;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocioDaoImp extends AbstractDao<SocioEntity, Integer> implements SocioDao {
    @Override
    public void deleteById(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteByName(String name) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteByLastName(String lastName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteByHired(BigInteger seat) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteByNation(String nation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
