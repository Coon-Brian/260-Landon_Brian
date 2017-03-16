/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.exceptions;

/**
 *
 * @author Brian
 */
public class BattleControlException extends Exception{

    public BattleControlException() {
    }

    public BattleControlException(String string) {
        super(string);
    }

    public BattleControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public BattleControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public BattleControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
