package controller;

import entity.PasivoEntity;

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
public interface PasivoBean {

    public boolean savePasivo(PasivoEntity pasivo);
    public List<PasivoEntity> getAllPasives();
    public boolean deletePasive(PasivoEntity pasivoEntity);


}
