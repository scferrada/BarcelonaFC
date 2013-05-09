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

    public void save(PersonalEntity personalEntity);

    public void delete(PersonalEntity personalEntity);
    public void deleteById(int id);
    public void deleteByName(String name);
    public void deleteByLastName(String lastName);
    public void deleteByBirth(Timestamp birth);
    public void deleteByHired(BigInteger hired);
    public void deleteByValue(int value);
    public void deleteByType(String type);
    public void deleteByNation(String nation);

    PersonalEntity getPersonalByContrato(ContratoEntity contrato);
}
