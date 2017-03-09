/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import java.util.ArrayList;

/**
 *
 * @author Landon
 */
public class Map {
    
    private ArrayList<Location> locations;
    
    
    Map(){
        
        //All of the file names here
        Location bedroom = new Location("bedroom.txt", 1);
        Location library = new Location("library.txt", 2);
        Location br1 = new Location("br1.txt", 1);
        Location br2 = new Location("br2.txt", 2);
        Location br3 = new Location("br3.txt", 3);
        Location br4 = new Location("br4.txt", 4);
        Location br5 = new Location("br5.txt", 5);
        Location br6 = new Location("br6.txt", 6);
        Location br7 = new Location("br7.txt", 7);
        Location br8 = new Location("br8.txt", 8);
        Location br9 = new Location("br9.txt", 9);
        Location br10 = new Location("br10.txt", 10);
        Location br11 = new Location("br11.txt", 11);
        Location br12 = new Location("br12.txt", 12);
      
        this.locations.add(bedroom);
        this.locations.add(library);
        this.locations.add(br1);
        this.locations.add(br2);
        this.locations.add(br3);
        this.locations.add(br4);
        this.locations.add(br5);
        this.locations.add(br6);
        this.locations.add(br7);
        this.locations.add(br8);
        this.locations.add(br9);
        this.locations.add(br10);
        this.locations.add(br11);
        this.locations.add(br12);
        
        
        
    }
    
}
