package controller.impl;

import controller.SocioBean;
import dao.SocioDao;
import dao.impl.SocioDaoImp;
import entity.SocioEntity;
import util.Consistence;

import javax.ejb.Stateless;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
            Consistence.dontIntersect(socio.getFechaNacimiento(), new Timestamp(new Date().getTime()));
            Consistence.isNotNull(socio.getDerechoAsiento());
            socioDao.save(socio);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAssociate(SocioEntity socio) {
        try{
            socioDao.delete(socio);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<SocioEntity> getAllAssociates() {
        List<SocioEntity> res = new ArrayList<SocioEntity>();
        try{
            res = socioDao.findAll(SocioEntity.class);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
