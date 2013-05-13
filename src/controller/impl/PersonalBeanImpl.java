package controller.impl;

import controller.PersonalBean;
import dao.PersonalDao;
import dao.impl.PersonalDaoImp;
import entity.PersonalEntity;
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
public class PersonalBeanImpl implements PersonalBean{

    private PersonalDao personalDao;

    public PersonalBeanImpl(){
        personalDao = new PersonalDaoImp();
    }

    @Override
    public boolean save(PersonalEntity personal) {
        try{
            Consistence.dontIntersect(personal.getFechaNacimiento(), new Timestamp(new Date().getTime()));
            Consistence.possitive(personal.getValorBase());
            personalDao.save(personal);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<PersonalEntity> getAll() {
        List<PersonalEntity> res = new ArrayList<PersonalEntity>();
        try{
            res = personalDao.findAll(PersonalEntity.class);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean delete(PersonalEntity personalEntity) {
        try{
            personalDao.delete(personalEntity);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
