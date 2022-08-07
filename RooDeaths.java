//*************************************************************************************************
// Name:                   Skylar Hernandez
// Date:                   September 1, 2007
// Program:                RooDeaths.java
// Description:            Given the populations of 'roos, lenghts of the roads, and the
//                         length of one side of the square area in km, this program will
//                         calculate how many 'roos will die in car collisions.
// Course:                 CSC 120
//*************************************************************************************************

import java.util.Scanner;
//==============================================================
public class RooDeaths {
//-----------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//  Constants
    private static final double WIDTHOFROADINKM  = 0.01;
    private static final double DEATHRATIO                  = 1.47;
//-----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

// Variables
        double rooNumber, sideOfASquare, rooDensity, roadLength,
        surfaceAreaOfRoad, rooDeaths;

// Gather data
        System.out.print("Enter side of square in km : ");
        sideOfASquare = keyboard.nextDouble();
        System.out.print("Enter roads length in km   : ");
        roadLength       = keyboard.nextDouble();
        System.out.print("Enter number of 'roos      : ");
        rooNumber      = keyboard.nextDouble();

// Perform calculation
   // Calculate 'roo density
        rooDensity                = (rooNumber)/(sideOfASquare * sideOfASquare);
   // Calculate the surface area of road
        surfaceAreaOfRoad = WIDTHOFROAD * roadLength ;
   // Calculate total 'roo deaths
        rooDeaths                  = rooDensity * surfaceAreaOfRoad * DEATHRATIO;

// Display results
        System.out.println("Day number                 : " + rooDeaths);
    }
//-----------------------------------------------------------------------------------------------------------------
}
//==============================================================
