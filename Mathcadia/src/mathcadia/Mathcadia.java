/*

 */
package mathcadia;


import byui.cit260.mathcadia.model.Game;
import byui.cit260.mathcadia.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Brian
 */
public class Mathcadia {

    /**
     * @param args the command line arguments
     */
    private static Game mathcadia;


    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
        
    public static void main(String[] args) {
        try{
            //Open charcter stream file for end users input and output
            Mathcadia.inFile = new BufferedReader (new InputStreamReader(System.in));
            Mathcadia.outFile = new PrintWriter(System.out, true);
            
            //Open log file
            String filePath = "log.txt";
            Mathcadia.logFile = new PrintWriter(filePath);
            
        // create StartProgramViewOrig and display the start progam view
        StartProgramView startProgramView = new StartProgramView();   
        startProgramView.display();
     
        }catch (Throwable te){
            System.out.println(te.getMessage());
            te.printStackTrace();
            
        }
        
        finally{
            try {
                if (Mathcadia.inFile != null)
                    Mathcadia.inFile.close();
                
                if (Mathcadia.outFile != null)
                    Mathcadia.outFile.close();
                
                if (Mathcadia.logFile != null)
                    Mathcadia.logFile.close();
                
            } catch (IOException ex) {
                System.out.println("Error closing the files");
                return;
            }
        }
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Mathcadia.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Mathcadia.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Mathcadia.logFile = logFile;
    }
    
    
    public static Game getMathcadia() {
        return mathcadia;
    }

    
}
