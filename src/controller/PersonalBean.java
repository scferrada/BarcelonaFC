
package controller;

import entity.PersonalEntity;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface PersonalBean {

    public boolean save(PersonalEntity personalEntity);
    public List<PersonalEntity> getAll();
    public void delete(PersonalEntity personalEntity);
}
