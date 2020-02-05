NitroxAndOxygen.java//*********************************************************************************************************************
// Name:                   Michael Kevin Hernandez
// Date:                   October 1, 2007
// Program:                1040Tax.java
// Description:            Given income, this will calculate your class, deduction,
//                         taxable income, tax group and tax owed.
// Course:                 CSC 120
//*********************************************************************************************************************

import java.util.Scanner;
//===========================================================================
public class Tax1040 {
//----------------------------------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

// Variables
       double  nextAmount, income, deductions, taxable, tax;
       char    group;

// Input incomes and deductions
     nextAmount = 0;
     deductions = 0;
     income     = 0;

     do{
          System.out.print("Enter next amount :");
          nextAmount = keyboard.nextDouble();
           if (nextAmount < 0){
               deductions += -1* Math.abs(nextAmount);
           }else{
               income     += nextAmount;
           }

      } while (nextAmount != 0);


// Compute Taxable Income
      taxable = TaxableIncome(deductions, income);

// Choose Tax Group
      group   = CharGroup(taxable);

// Compute Tax
      tax     = TaxOwed(group, taxable);

// Display Output
      displayOut(income, deductions, taxable, group, tax);

    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static double TaxableIncome(double deductions, double income) {

        double taxableIncome;

   // Difference or 0.0
        if (income + deductions > 0){
            taxableIncome = income + deductions;
        }else{
            taxableIncome = 0.0;
        }
        return taxableIncome;
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static char CharGroup(double taxable){

    char taxGroup = ' ';

         if (taxable >= 500000){
             taxGroup = 'S';
         }else if (taxable < 500000 || taxable >= 200000){
             taxGroup = 'Q';
         }else if (taxable < 200000 || taxable >= 100000){
             taxGroup = 'M';
         }else if (taxable < 100000 || taxable >=  50000){
             taxGroup = 'A';
         }else if (taxable <  50000 || taxable >=  20000){
             taxGroup = 'R';
         }else if (taxable >= 20000 ){
             taxGroup = 'P';
         }
    return taxGroup;
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static double TaxOwed(char group, double taxable){

       double tax = 0;

       if (group == 'Q' || group == 'S'){
          tax = taxable * .25;
       } else if (group == 'M'){
          tax = taxable * .10;
       } else if (group == 'A' || group == 'R'){
          tax = taxable * .03;
       } else if (group == 'P'){
          tax = 0;
       }
    return tax;
    }
//----------------------------------------------------------------------------------------------------------------------------------------
    private static void displayOut(double income, double deductions,
                                   double taxable, char group, double tax){

    System.out.println("Income         = $" + income    );
    System.out.println("Deductions     = $" + (-1*deductions));
    System.out.println("Taxable income = $" + taxable   );
    System.out.println("Tax group      = " + group     );
    System.out.println("Tax owed       = $" + tax       );

    }
//----------------------------------------------------------------------------------------------------------------------------------------
}
//===========================================================================
