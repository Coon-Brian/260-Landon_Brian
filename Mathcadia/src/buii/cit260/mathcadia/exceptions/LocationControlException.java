
package buii.cit260.mathcadia.exceptions;

/**
 *
 * @author Brian
 */
public class LocationControlException extends Exception{

    public LocationControlException() {
    }

    public LocationControlException(String string) {
        super(string);
    }

    public LocationControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public LocationControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public LocationControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
