package util;

import exception.InconsistentArgumentException;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastián
 * Date: 10-05-13
 * Time: 04:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consistence {

    public void dontIntersect(Timestamp from, Timestamp to) throws InconsistentArgumentException {
        if(to.before(from))
            throw new InconsistentArgumentException("Dates are in wrong order");
    }

    public void possitive(int test) throws InconsistentArgumentException {
        if(test <= 0)
            throw new InconsistentArgumentException("Number must be non-zero possitive integer");
    }

    public void isNull(Object o) throws InconsistentArgumentException{
        if(o!=null)
            throw new InconsistentArgumentException("Field must be null-content");
    }

    public void isNotNull(Object o) throws InconsistentArgumentException{
        if(o==null)
            throw new InconsistentArgumentException("Non-null field has null value");
    }



}
