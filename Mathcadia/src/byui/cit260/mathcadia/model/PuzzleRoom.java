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
public class PuzzleRoom implements Serializable{
    
    // class instance variables
    private boolean passedPuzzle;
    private String puzzle;

    public PuzzleRoom() {
    }
    

    public boolean isPassedPuzzle() {
        return passedPuzzle;
    }

    public void setPassedPuzzle(boolean passedPuzzle) {
        this.passedPuzzle = passedPuzzle;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.passedPuzzle ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.puzzle);
        return hash;
    }

    @Override
    public String toString() {
        return "PuzzleRoom{" + "passedPuzzle=" + passedPuzzle + ", puzzle=" + puzzle + '}';
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
        final PuzzleRoom other = (PuzzleRoom) obj;
        if (this.passedPuzzle != other.passedPuzzle) {
            return false;
        }
        if (!Objects.equals(this.puzzle, other.puzzle)) {
            return false;
        }
        return true;
    }
    
    
}
