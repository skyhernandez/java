//*************************************************************************************************
// Name:                   Skylar Hernandez
// Date:                   August 31, 2007
// Program:                Time.java
// Description:            Given milliseconds, this program will calculate how many days,
//                         hrs, mins, and seconds equal that many milliseconds.
// Course:                 CSC 120
//*************************************************************************************************

import java.util.Scanner;
//==============================================================
public class Time {
//-----------------------------------------------------------------------------------------------------------------
    	private static Scanner keyboard = new Scanner(System.in);
//  Constants
    	private static final double MILLISECS_TO_SECS = 0.001;
    	private static final double SECS_TO_HR        = 0.0002777777777777778;
    	private static final double HR_TO_DAY         = 0.0416666666666666667;
    	private static final double ONEDAY            = 24;
    	private static final double ONEHR             = 60;
    	private static final double ONESEC            = 60;
//-----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

// Variables to hold millisecs
        	double millisec, decimalday, wholeday, decimalhr, wholehr, decimalmin,
        	wholemin, second;
// Gather data
        	System.out.print("Enter number of milliseconds : ");
        	millisec = keyboard.nextDouble();

// Perform calculation
   // millisecs to decimal days
        	decimalday     = millisec * MILLISECS_TO_SECS * SECS_TO_HR * HR_TO_DAY;
   // whole days
        	wholeday        = Math.floor(decimalday);
   // decimal hrs
        	decimalhr        = (decimalday - wholeday) * ONEDAY;
   // whole hrs
        	wholehr           = Math.floor(decimalhr);
   // decimal minutes
       	 decimalmin   = (decimalhr - wholehr) * ONEHR;
   // whole minutes
        	wholemin       = Math.floor(decimalmin);
   // seconds
        	second            = (decimalmin - wholemin) * ONESEC;

// Display results
        System.out.println(" Day number  : " + wholeday);
        System.out.println(" Hour        : " + wholehr);
        System.out.println(" Minutes     : " + wholemin);
        System.out.println(" Seconds     : " + second);
    }
//-----------------------------------------------------------------------------------------------------------------
}
//==============================================================
