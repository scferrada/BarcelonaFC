package controller.impl;

import controller.PersonalBean;
import entity.PersonalEntity;

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
public class PersonalBeanImpl implements PersonalBean{
    @Override
    public void save(PersonalEntity personalEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PersonalEntity> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(PersonalEntity personalEntity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
