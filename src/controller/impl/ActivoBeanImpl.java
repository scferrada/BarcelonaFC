package controller.impl;

import controller.ActivoBean;
import dao.ActivoDao;
import dao.impl.ActivoDaoImp;
import entity.ActivoEntity;
import util.Consistence;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Victor
 * Date: 09-05-13
 * Time: 05:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ActivoBeanImpl implements ActivoBean{
    private final ActivoDao activoDao;

    public ActivoBeanImpl(){
        activoDao = new ActivoDaoImp();
    }


    @Override
    public void save(ActivoEntity activo) {
        try{
            Consistence.possitive(activo.getValor());
            activoDao.save(activo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<ActivoEntity> getAll() {
        List<ActivoEntity> lista = new ArrayList<ActivoEntity>();
        try{
            lista = activoDao.findAll(ActivoEntity.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public void delete(ActivoEntity activoEntity) {
        try{
            activoDao.delete(activoEntity);
        }catch (Exception e){
            System.out.println(e.getMessage());        }
    }
}
