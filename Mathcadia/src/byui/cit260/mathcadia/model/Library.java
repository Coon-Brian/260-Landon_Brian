/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.model;

import java.awt.Desktop;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This room gives the player the option to study up on algebra topics by 
 * opening their default browser to a math web site.
 * @author Landon
 * @since Jan. 26 2017
 */
public class Library extends Location implements Serializable{
    
    public Library(){
        roomName = "Library";
        roomItem = null;
        roomFileName = null;
    }
    

    
    
    public void openWebBrowser(){
        String url = "http://www.coolmath.com/algebra";

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return;
            }
        }
    }
    
    
}
