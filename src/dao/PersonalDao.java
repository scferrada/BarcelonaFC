package dao;

import entity.ContratoEntity;
import entity.NacionalidadEntity;
import entity.PersonalEntity;
import entity.TipoPersonalEntity;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersonalDao extends IDao<PersonalEntity, Integer> {

    public PersonalEntity findById(int id);

}
