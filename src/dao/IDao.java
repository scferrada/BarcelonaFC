package dao;

import org.hibernate.Query;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 07-05-13
 * Time: 05:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IDao<T, ID extends Serializable> {

    public void save(T entity);

    public void merge(T entity);

    public void delete(T entity);

    public List<T> findMany(Query query);

    public T findOne(Query query);

    public List<T> findAll(Class<T> clazz);

    public T findByID(Class<T> clazz, Integer id);

}
