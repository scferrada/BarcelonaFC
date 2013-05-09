package controller;

import entity.ContratoEntity;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface ContratoBean {

    public void delete(ContratoEntity contratoEntity);
    public List<ContratoEntity> getAll();
    public void update(ContratoEntity contratoEntity);

}
