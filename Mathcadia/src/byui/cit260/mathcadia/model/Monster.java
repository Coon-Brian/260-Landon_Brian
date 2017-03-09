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
public class Monster extends Character implements Serializable{
    
    // class instance variables
    private String monster;
    private boolean die;

    public Monster() {
        gradePoints = 10;
        knowledge = 10;
        power = 0;
    }
    
    
    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
    }

    public boolean isDie() {
        return die;
    }

    public void setDie(boolean die) {
        this.die = die;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.monster);
        hash = 67 * hash + (this.die ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Monster{" + "monster=" + monster + ", die=" + die + '}';
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
        final Monster other = (Monster) obj;
        if (this.die != other.die) {
            return false;
        }
        if (!Objects.equals(this.monster, other.monster)) {
            return false;
        }
        return true;
    }
    
    
}

