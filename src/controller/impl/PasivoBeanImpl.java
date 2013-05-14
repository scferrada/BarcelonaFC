package controller.impl;

import controller.PasivoBean;
import dao.PasivoDao;
import dao.impl.PasivoDaoImp;
import entity.PasivoEntity;
import util.Consistence;

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
public class PasivoBeanImpl implements PasivoBean{

    private final PasivoDao pasivoDao;

    public PasivoBeanImpl(){
        pasivoDao = new PasivoDaoImp();
    }

    @Override
    public boolean savePasivo(PasivoEntity pasivo) {
        try{
            Consistence.possitive(pasivo.getValor());
            pasivoDao.save(pasivo);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<PasivoEntity> getAllPasives() {
        List<PasivoEntity> res = new ArrayList<PasivoEntity>();
        try{
            res = pasivoDao.findAll(PasivoEntity.class);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean deletePasive(PasivoEntity pasivoEntity) {
        try{
            pasivoDao.delete(pasivoEntity);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
