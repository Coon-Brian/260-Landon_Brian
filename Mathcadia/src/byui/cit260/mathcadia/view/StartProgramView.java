/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.mathcadia.view;

/**
 *
 * @author Brian
 */
public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView() {
        this.promptMessage = "\nPlease enter your name: ";
        // display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
                "\n********************************************************"
              + "\n*                                                      *"
              + "\n*                      MATHCADIA                       *"
              + "\n*              pronounced math - k - dia               *"
              + "\n*                                                      *"
              + "\n* You are a student of the prestigious university      *"
              + "\n* known as Mathcadia, a school that studies in the     *"
              + "\n* mystic arts of mathematics and magic. You and your   *"
              + "\n* best friend Matica (as in the software Mathematica), *"
              + "\n* work together to unlock the power of algebraic       *"
              + "\n* spells by solving problems involving different       *"
              + "\n* aspects of math. Your knowledge in the math arts     *"
              + "\n* knowledge in the math arts can be used to fight      *"
              + "\n* monsters and unlock special abilities. You and       *"
              + "\n* Matica are both working to gain the title of Math    *"
              + "\n* Master and finally graduate from your studies.       *"
              + "\n*                                                      *"
              + "\n* You will be studying for an exam by sparring with    *"
              + "\n* monsters. You will have to advance through 20        *"
              + "\n* different training rooms by solving math problems    *"
              + "\n* and will gain experience with each battle. As you    *"
              + "\n* defeat monsters, you will solve fewer problems.      *"
              + "\n* In the final room, you will have to face the dreaded *"
              + "\n* Math Midterm Monster!                                *"
              + "\n*                                                      *"          
              + "\n*               Have fun and good luck!                *"
              + "\n*                                                      *"
              + "\n********************************************************"  
        );
    }

    public void displayStartProgramView() {
        System.out.println("\n*** displayStartProgram() function called ***");
    }
}
