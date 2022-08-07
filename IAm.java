//*********************************************************************************************************************
// Name:            Skylar Hernandez
// Date:            October 15, 2007
// Program:         IAm.java
// Description:     List my qualities after I type it after the string "I am".
// Course:          CSC 120
//*********************************************************************************************************************

import java.util.Scanner;

//===========================================================================
public class IAm {
//----------------------------------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

// Variable
        String sentences="", qualities="";

// Gather data
        System.out.println("Please enter sentences, . to end.");
        while (!sentences.equals(".")) {
              sentences = keyboard.nextLine();
              if (sentences.startsWith("I am ")){
                 qualities += sentences.substring (5) + ", ";
              }
         }

// Output data
        System.out.println("The qualities are " + qualities);
    }
//----------------------------------------------------------------------------------------------------------------------------------------
}
//===========================================================================
