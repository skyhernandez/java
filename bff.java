//*********************************************************************************************************************
// Name:                  Skylar Hernandez
// Date:                  November 15, 2007
// Program:               bff.java
// Description:           Given a girl, she would only trade up for a diamond. The
//                        program keeps track of trades and rejections.
// Course:                CSC 120
//*********************************************************************************************************************

import java.util.Scanner;
//===========================================================================
public class bff {
//----------------------------------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
       Girl   girl = new Girl();
       Diamond diamond = new Diamond (0,0);
       String name;
       long   carat =0, value = 0, newCarat, newValue;
       name = girl.readinput();
  
     do{
        System.out.print("Enter carats and value    : ");
        newCarat = keyboard.nextLong();
        newValue = keyboard.nextLong();

          if ((newCarat > carat) && (newValue > value)){
              diamond = new Diamond(newCarat, newValue);
              System.out.println("Woohoo, the girl took the diamond.");
              System.out.println (name + " has a diamond, " + diamond.getCarat()
                                  + " carats, worth $"
                                  + diamond.getValue() + ".0");

                carat = newCarat;
                value = newValue;

               } else {
              System.out.println ("Aaargh, the diamond was rejected .");
              System.out.println (name + " has a diamond, " + diamond.getCarat()
                                  + " carats, worth $"
                                  + diamond.getValue() + ".0");

              }
          } while ((newCarat != 0) && (newValue != 0));

} 
//----------------------------------------------------------------------------------------------------------------------------------------
}
//===========================================================================
