package controller.impl;

import controller.ContratoBean;
import dao.ContratoDao;
import dao.impl.ContratoDaoImp;
import entity.ContratoEntity;
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
public class ContratoBeanImpl implements ContratoBean{

    private ContratoDao contratoDao;

    public ContratoBeanImpl(){
        contratoDao = new ContratoDaoImp();
    }

    @Override
    public boolean deleteContract(ContratoEntity contrato) {
        try{
            contratoDao.delete(contrato);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<ContratoEntity> getAllContracts() {
        List<ContratoEntity> res = new ArrayList<ContratoEntity>();
        try{
            res = contratoDao.findAll(ContratoEntity.class);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean updateContract(ContratoEntity contrato) {
        try{
            //Consistence.isNotNull(contrato.getId());
            //Consistence.isNotNull();
            Consistence.dontIntersect(contrato.getFechaInicio(), contrato.getFechaExpiracion());
            Consistence.possitive(contrato.getMensualidad());
            contratoDao.save(contrato);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
