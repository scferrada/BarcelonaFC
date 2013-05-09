package controller.impl;

import controller.PasivoBean;
import entity.PasivoEntity;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class PasivoBeanImpl implements PasivoBean{
    @Override
    public void save(PasivoEntity pasivoEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PasivoEntity> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(PasivoEntity pasivoEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
