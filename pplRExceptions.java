//*********************************************************************************************************************
// Name:                  Michael Kevin Hernandez
// Date:                  November 12, 2007
// Program:               pplRExceptions.java
// Description:           Given the data on the command line this program will add only
//                        integers to a vector and return an exception for anything other
//                        than an integer.
// Course:                CSC 120
//*********************************************************************************************************************

import java.util.Scanner;
import java.util.*;
//===========================================================================
public class pplRExceptions {
//----------------------------------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

// Variable
   Vector integerVector = new Vector();
   int integer = 0;
   int index   = 0;

// Loop through the command line Strings in the main method:
   for (int i = 0; i < args.length; i++){
       try {
            integerVector.add(new Integer(args[i]));
            System.out.println("Converter method says interger OK - "
                               + args[i]);
           }  catch (NumberFormatException e) {
                System.out.println("Catch block says the argument " + args[i]
                                    + " is ignored because " + args[i]);
           }
   }

// display output
    for (index = 0; index < integerVector.size(); index ++){
            System.out.println ("Item " + index + " is "
                                + integerVector.get(index));
    }
}

//----------------------------------------------------------------------------------------------------------------------------------------
}
//===========================================================================

