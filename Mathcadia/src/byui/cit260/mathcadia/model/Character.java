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
 * @author Landon
 */
public class Character implements Serializable{
    //character stats that affect fighting
    protected Integer gradePoints;
    protected Integer knowledge;
    protected Integer power;
    protected Integer experience;
    protected double bestScore;
    //used to determine when battle is over
    protected Boolean alive;
    
    public Character(){
        
    }
    
    
    //all of the add methods are going to be used with items
    public void addHealth(Integer points){
        this.gradePoints += points;
    }
    
    public void addExperience(Integer points){
        this.experience += points;
    }
    
    public void addKnowledge(Integer points){
        this.experience += points;
    }
    
    public void addPower(Integer points){
        this.experience += points;
    }
    
    //for very end of game
    public void setPercentage(double points){
        
    }
    
    public Integer getHealth(){
        return gradePoints;
    }
    
    public void setHealth(int health){
        gradePoints = health;
    }
    
    public Integer getExp(){
        return experience;
    }
    
    public Integer getKnowledge(){
        return knowledge;
    }
    
    public Integer getPower(){
        return power;
    }
    
    public double getBestScore(){
        return bestScore;
    }
    
    public void attack(Character foe){
        int damage = this.knowledge - foe.power;
        foe.takeDamage(damage);
    }
    
    public void takeDamage(Integer damage){
        int health = this.gradePoints - damage;
        this.setHealth(health);
    }
    
    public Boolean isAlive(){
        return gradePoints > 0;
    }
    
      @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.gradePoints);
        hash = 83 * hash + Objects.hashCode(this.knowledge);
        hash = 83 * hash + Objects.hashCode(this.power);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.bestScore) ^ (Double.doubleToLongBits(this.bestScore) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.alive);
        return hash;
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
        final Character other = (Character) obj;
        if (Double.doubleToLongBits(this.bestScore) != Double.doubleToLongBits(other.bestScore)) {
            return false;
        }
        if (!Objects.equals(this.gradePoints, other.gradePoints)) {
            return false;
        }
        if (!Objects.equals(this.knowledge, other.knowledge)) {
            return false;
        }
        if (!Objects.equals(this.power, other.power)) {
            return false;
        }
        if (!Objects.equals(this.alive, other.alive)) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
        return "Character{" + "gradePoints=" + gradePoints + ", knowledge=" + knowledge + ", power=" + power + ", experience=" + experience + ", bestScore=" + bestScore + ", alive=" + alive + '}';
    }
    
}
