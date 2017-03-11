/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import java.io.Serializable;

/**
 *
 * @author Brian
 */
public enum Item implements Serializable{
    
    ExtraCredit("EXTRA CREDIT POTION", 100),
    Knowledge("KNOWLEDGE POTION", 2),
    Power("POWER POTION", 5),
    Experience("EXPERIENCE POTION", 100);
    
    
    
    // Class instance variables
    private final String itemName;
    private final int bonusValue;

    Item(String name, int bonusValue) {

        this.itemName = name;
        this.bonusValue = bonusValue;
        

    }

    public String getItemName() {
        return itemName;
    }


    public int getBonusValue() {
        return bonusValue;
    }



    @Override
    public String toString() {
        return "Item{" + "itemName=" + itemName + ", bonusValue=" + bonusValue + '}';
    }
    
    
    
    
    
     
}
