package controller.impl;

import controller.SocioBean;
import dao.SocioDao;
import dao.impl.SocioDaoImp;
import entity.SocioEntity;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class SocioBeanImpl implements SocioBean{

    private SocioDao socioDao = new SocioDaoImp();

    public SocioBeanImpl(){
        socioDao = new SocioDaoImp();
    }

    @Override
    public boolean saveAssociate(SocioEntity socio) {
        try{
            socioDao.save(socio);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAssociate(SocioEntity socio) {
        try{
            socioDao.delete(socio);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SocioEntity> getAllAssociates() {
        List<SocioEntity> res = new ArrayList<SocioEntity>();
        try{
            res = socioDao.findAll(SocioEntity.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }
}
