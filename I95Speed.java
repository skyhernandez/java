//*********************************************************************************************************************
// Name:                   Skylar Hernandez
// Date:                   September 19, 2007
// Program:                I95Speed.java
// Description:            Given distance and time wished to travel, this program will
//                         calculate the speed you must travel to meet that distance, and
//                         whether or not you will have to go over th 65mph speed limit.
// Course:                 CSC 120
//*********************************************************************************************************************

import java.util.Scanner;
//===========================================================================
public class I95Speed {
//----------------------------------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//  Constants
    private static final float POTTY_DISTANCE  = 100;   // miles
    private static final float POTTY_TIME      = 5;     // mins
    private static final float HR_TO_MINS      = 60;    // mins in an hour
    private static final int   I95_SPEED_LIMIT = 65;    // mph
//----------------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

// Variables
       double  milesPerHour;
       float   timeAvailable, distance;

//User Messages
       displayUseInstructions();

// Gather data
       System.out.print("Enter distance to travel : ");
       distance      = keyboard.nextFloat();
       System.out.print("Enter Time available     : ");
       timeAvailable = keyboard.nextFloat();

// Perform calculation
   // Calculate Speed
       milesPerHour  = MPH(distance, timeAvailable);

// Display results
    displayOut(milesPerHour);
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static void displayUseInstructions() {
        System.out.println("Welcome to the I95 Speed Machine" + '\n');
        System.out.println("You will have to supply: ");
        System.out.println("+ The distance you want to travel, in miles");
        System.out.println("+ The time you have available, in hours" + '\n');
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static double MPH(float distance, float timeAvailable) {

        float   timeForTravel;
        int     pottyBreak;

   // Calculate Time for stops (in mins)
        pottyBreak    = (int) ((Math.ceil(distance/POTTY_DISTANCE))*POTTY_TIME);

   // Calculate Time for travel (in hours)
        timeForTravel = ((float) (((timeAvailable*HR_TO_MINS) -  pottyBreak)
                        /HR_TO_MINS));

   // Calculate Speed (in mph)
        return ((double) distance/timeForTravel);
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static void displayOut(double milesPerHour){

       boolean I95SpeedLimits;

       System.out.println('\n' + "You will have to travel at " + milesPerHour
                          + "mph");
       I95SpeedLimits = (milesPerHour > I95_SPEED_LIMIT);
       System.out.println("Over the speed limit     : " + I95SpeedLimits);
}
//----------------------------------------------------------------------------------------------------------------------------------------
}
//===========================================================================
