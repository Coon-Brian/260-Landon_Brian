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
    
    ExtraCredit("Extra Credit Potion", 1, 10),
    Knowledge("Knowledge Potion", 2, 2),
    Wisdom("Wisdom Potion", 3, 5),
    Experience("Experience potion", 4, 100);
    
    
    
    // Class instance variables
    private final String itemName;
    private final int itemType;
    private final int bonusValue;

    Item(String name, int type, int bonusValue) {

        itemName = name;
        itemType = type;
        this.bonusValue = bonusValue;
        

    }

    public String getItemName() {
        return itemName;
    }

    public int getItemType() {
        return itemType;
    }

    public int getBonusValue() {
        return bonusValue;
    }



    @Override
    public String toString() {
        return "Item{" + "itemName=" + itemName + ", itemType=" + itemType + ", bonusValue=" + bonusValue + '}';
    }
    
    
    
    
    
     
}
