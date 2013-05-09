package controller.impl;

import controller.ContratoBean;
import entity.ContratoEntity;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ContratoBeanImpl implements ContratoBean{

    @Override
    public void delete(ContratoEntity contratoEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ContratoEntity> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(ContratoEntity contratoEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
