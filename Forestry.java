//*****************************************************************************
// Name:         Skylar Hernandez
// Date:         November 17, 2007
// Program:      Forestry.java
/* Description:  This program will deal with forests, where it will do:
                     * Display the current forest
                       (with tree heights to 2 decimal places).
                     * Discard the current forest and create a new forest.
                     * Simulate a year's growth in the current forest.
                     * Reap the current forest.
                     * Save the information about the current forest to file
                       (named after the forest).
                     * Discard the current forest and load the information
                       about a forest from a file.

*/
// Course:       CSC 120
//*****************************************************************************

import java.util.*;
import java.io.*;

//=============================================================================
public class Forestry {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    private static int     TREE_MAX = 10;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

// Variable
   char forestOptions;
   String name = null;
   forestObject forest = null;

// The opions must be D, N, L, S, R, Y, X ...

do{
   forestOptions = Options();

//  The switch for the entire program
   switch (forestOptions){
      case 'D':
          displayForest(forest);
          break;
      case 'N':
          forest = newForest();
          break;
      case 'Y':
          forest = oneYear(forest);
          break;
      case 'R':
          forest = reapForest(forest);
          break;
      case 'S':
          save(forest);
          break;
      case 'L':
           forest = loadFile();
          break;
      case 'X':
          System.out.println("Goodbye");
          return;
      default:
          break;
     }
  } while(forestOptions != 'X');
}
//-----------------------------------------------------------------------------
    private static char Options() {

    char options;
    File forest;

    do{
        System.out.print("(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave, (L)oad, e(X)it : ");
        options = keyboard.next().charAt(0);
        options = Character.toUpperCase(options);

        switch (options){
            case 'D':
            case 'N':
            case 'Y':
            case 'R':
            case 'S':
            case 'L':
            case 'X':
              return (options);
         }
       } while (true);
    }
//-----------------------------------------------------------------------------
    private static void displayForest(forestObject forest){

//       forestObject forestType;

       if (forest != null){
              forest.display();
       } else {
          System.out.println("No forest");
       }

    }
//-----------------------------------------------------------------------------
    private static forestObject newForest() {

       // variables
       String name = null;
       forestObject forest = null;

       // create a forest
       System.out.print("What is the forest name : ");
       name = keyboard.next();
       forest = new forestObject(name);

    return forest;
    }
//-----------------------------------------------------------------------------
    private static void save(forestObject forest){

     try{
         ObjectOutputStream object_out;
         object_out  = new ObjectOutputStream(new FileOutputStream(forest.getName()));
         object_out.writeObject(forest);
         object_out.close();
      } catch (Exception e) {
         System.out.println(e.getMessage() + " caused and excepion.");
      }
   }

//-----------------------------------------------------------------------------
    private static forestObject oneYear(forestObject forest){

       if (forest != null){
          forest.year();
       } else {
          System.out.println("No forest");
       }

       return forest;

    }
//-----------------------------------------------------------------------------
    private static forestObject reapForest(forestObject forest) {

       float reapHeight;

       System.out.print("What height to reap at  : ");
       reapHeight = keyboard.nextFloat();

       if (forest != null){
          forest.reap(reapHeight);
       } else {
          System.out.println("no forest");
       }

    return forest;

    }
//-----------------------------------------------------------------------------
    private static forestObject loadFile() {

        ObjectInputStream object_input;
        forestObject forest;

        try {
            System.out.print("What is the forest name : ");
            object_input = new ObjectInputStream(new FileInputStream(keyboard.next()));
            forest = (forestObject)object_input.readObject();
            object_input.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            forest = null;
        }

        return(forest);
    }
//-----------------------------------------------------------------------------
}
//=============================================================================
