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
public class Item implements Serializable{
    
    // Class instance variables
    private String itemName;
    private double itemType;
    private double bonusValue;

    public Item() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemType() {
        return itemType;
    }

    public void setItemType(double itemType) {
        this.itemType = itemType;
    }

    public double getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(double bonusValue) {
        this.bonusValue = bonusValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.itemName);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.itemType) ^ (Double.doubleToLongBits(this.itemType) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.bonusValue) ^ (Double.doubleToLongBits(this.bonusValue) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Item{" + "itemName=" + itemName + ", itemType=" + itemType + ", bonusValue=" + bonusValue + '}';
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
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.itemType) != Double.doubleToLongBits(other.itemType)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bonusValue) != Double.doubleToLongBits(other.bonusValue)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        return true;
    }
    
    
    
     
}
