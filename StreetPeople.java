//*********************************************************************************************************************
// Name:                   Skylar Hernandez
// Date:                   October 8, 2007
// Program:                StreetPeople.java
// Description:            Given the number of houses in a block and the number of people
//                         living in those houses, this will calculate the sum of the ages
//                         per house and for the entire block.
// Course:                 CSC 120
//*********************************************************************************************************************

import java.util.Scanner;

//===========================================================================
public class StreetPeople {
//----------------------------------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

// declaring loop vars to 0
   int sumj = 0;
   int sumi = 0;
   int houseNumbers[];

// gather data
   // setting the array to obtain the number of house in a block
        System.out.print("How many houses in the street?  :");
        int houses = keyboard.nextInt();
        houseNumbers = new int [houses];

   // method to get to number each house
        for (int i = 0; i < houses; i++){
            System.out.print("What is the next house number?  :");
            houseNumbers[i] = keyboard.nextInt();
        }

   // setting the array to obtain how many people live in the house
   // and how old is each person in the house
        int [][] houseAges = new int [houseNumbers.length][];

   // for loop to find the number of people per house
        for (int i = 0; i < houseNumbers.length; i++){
            System.out.print("How many people live in number " + houseNumbers[i]
                             + " : ");
            houseAges[i] = new int [keyboard.nextInt()];
   
    // another for loop w/in a for loop to find houseAges
            for (int j = 0; j < houseAges[i].length; j++ ){
                 System.out.print("What is the age of person " + (j+1) + " :");
                 houseAges [i][j] = keyboard.nextInt();
            }
       }

// perform calculations & display output
     // for loop to calculate the sums
        for (int i = 0; i < houseNumbers.length; i++){
            sumj = 0;
            for (int j = 0; j < houseAges[i].length; j++ ){
     
    // calculate each house's total age
                 sumj += houseAges[i][j];
             }

     // calculate the block's total age
             sumi += sumj;
             System.out.println("House " + houseNumbers[i]
                                + " has a total age of" + " " + sumj);

             }
         System.out.println("The street has a total age of " + sumi);
         }
//----------------------------------------------------------------------------------------------------------------------------------------
}
//===========================================================================
