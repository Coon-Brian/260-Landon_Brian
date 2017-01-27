/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Brian
 */
public class Bedroom implements Serializable{
    
    // class instance variables
    private String bedroom;

    public Bedroom() {
    }
    
    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.bedroom);
        return hash;
    }

    @Override
    public String toString() {
        return "Bedroom{" + "bedroom=" + bedroom + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bedroom other = (Bedroom) obj;
        if (!Objects.equals(this.bedroom, other.bedroom)) {
            return false;
        }
        return true;
    }
    
    
}
