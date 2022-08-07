//*********************************************************************************************************************
// Name:                    Skylar Hernandez
// Date:                    September 16, 2007
// Program:                 NitroxAndOxygen.java
// Description:             Given the depth of dive, and the percentage of O2 in your
//                          in your diving tank, this program will calculate the
//                          abientPressure, PartialPressure Max Prartial Pressute,
//                          Contingency Pressure of O2 as numeric and T/F statements.
// Course:                  CSC 120
//********************************************************************************************************************

import java.util.Scanner;
//===========================================================================
public class NitroxAndOxygen {
//----------------------------------------------------------------------------------------------------------------------------------------
       private static Scanner keyboard = new Scanner(System.in);
//  Constants
      private static final int         FEET_PER_ATM                                                          = 33;
      private static final double MAX_PARTIAL_PRESSURE_OF_O2                       = 1.4;
      private static final double CONTINGENCY_PARTIAL_PRESSURE_OF_O2  = 1.6;
//----------------------------------------------------------------------------------------------------------------------------------------
      public static void main(String[] args) {

// Variables
          int          deepness, numberToCharacter;
          float       percentOfO2, ambientPressure, O2PartialPressure;
          boolean maxPPofO2, contingencyPPofO2;
          char       character;

// Gather data
          System.out.print("Enter depth and percentage of O2 : ");
          deepness       = keyboard.nextInt();
          percentOfO2 = keyboard.nextInt();

// Perform calculation
    // Calculate the ambeintPressure
          ambientPressure       = (deepness/FEET_PER_ATM) + 1;
    // Calculate O2 Partial Pressure
    // Calculate OxygenPressureGroup
          numberToCharacter = ((int) (O2PartialPressure *10) + 65);
          character                     = (char) numberToCharacter;

// Boolean calculations
          maxPPofO2              = (O2PartialPressure > MAX_PARTIAL_PRESSURE_OF_O2);
          contingencyPPofO2 = (O2PartialPressure > CONTINGENCY_PARTIAL_PRESSURE_OF_O2);
// Display results
        System.out.println('\n' + "Ambeint pressure                 : " + ambientPressure);
        System.out.println("O2 Pressure                                        : " + O2PartialPressure);
        System.out.println("O2 group                                             : " + character + '\n');
        System.out.println("Exceeds Maximal O2 pressure         : " + maxPPofO2);
        System.out.println("Exceeds Contingency O2 pressure  : "  + contingencyPPofO2);
    }
//----------------------------------------------------------------------------------------------------------------------------------------
}
//===========================================================================
