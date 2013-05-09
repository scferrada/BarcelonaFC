package controller.impl;

import controller.PersonalBean;
import dao.PersonalDao;
import dao.impl.PersonalDaoImp;
import entity.PersonalEntity;

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
public class PersonalBeanImpl implements PersonalBean{

    private PersonalDao personalDao;

    public PersonalBeanImpl(){
        personalDao = new PersonalDaoImp();
    }

    @Override
    public boolean save(PersonalEntity personalEntity) {
        try{
            personalDao.save(personalEntity);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PersonalEntity> getAll() {
        List<PersonalEntity> res = new ArrayList<PersonalEntity>();
        try{
            res = personalDao.findAll(PersonalEntity.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public void delete(PersonalEntity personalEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
