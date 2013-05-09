package controller;

import entity.SocioEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface SocioBean{

    public boolean saveAssociate(SocioEntity socio);
    public boolean deleteAssociate(SocioEntity socio);
    public List<SocioEntity> getAllAssociates();

}
