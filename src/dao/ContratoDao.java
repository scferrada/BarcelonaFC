package dao;

import entity.ContratoEntity;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContratoDao extends IDao<ContratoEntity, Integer> {

    public void delete(ContratoEntity contratoEntity);
    public void deleteByFechaInicio(Timestamp fechaInicio);
    public void delteByFechaTermino(Timestamp fechaExpiracion);
    public void deleteByMensualidad(int mensualidad);

}
