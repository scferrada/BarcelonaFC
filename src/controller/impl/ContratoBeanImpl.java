package controller.impl;

import controller.ContratoBean;
import dao.ContratoDao;
import dao.impl.ContratoDaoImp;
import entity.ContratoEntity;

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
public class ContratoBeanImpl implements ContratoBean{

    private ContratoDao contratoDao;

    public ContratoBeanImpl(){
        contratoDao = new ContratoDaoImp();
    }

    @Override
    public boolean deleteContract(ContratoEntity contratoEntity) {
        try{
            contratoDao.delete(contratoEntity);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ContratoEntity> getAllContracts() {
        List<ContratoEntity> res = new ArrayList<ContratoEntity>();
        try{
            res = contratoDao.findAll(ContratoEntity.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean updateContract(ContratoEntity contratoEntity) {
        try{
            contratoDao.save(contratoEntity);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
