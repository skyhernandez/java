
//*****************************************************************************
// Name:         Skylar Hernandez
// Date:         October 17, 2007
// Program:      AptManagement.java
/* Description:  Given the number of people in the apartments, and the floor
                 and this program will calculate the maintenance cost per
                 apartment, and keeps check of how many people live on each
                 floor and in the apartments to make sure the rules aren't
                 violated.
                 Note that the rules are:
                   * no more than 8 to a floor
                   * no more than 4 to an Apt
                   * there are two Apts in the second floor
                   * there are three Apts in the first floor
                   * maintenance costs per apt equal to the amount of people in
                     the apt
*/
// Course:       CSC 120
//*****************************************************************************

import java.util.Scanner;

//=============================================================================
public class AptManagement {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    private static final int MAX_FLOORS             = 2;
    private static final int MAX_FIRST_FLOOR_APTS   = 3;
    private static final int MAX_SECOND_FLOOR_APTS  = 2;
    private static final int MAX_FLOOR_OCCUPANCY    = 8;
    private static final int MAX_APTS_OCCUPANCY     = 4;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

// Welcome message
   System.out.println("Welcome to Coconut Grove Palace");

// Variables
   char maintenanceOptions;
   int[][] aptArray;

// setting up the defaultArray
   aptArray = CreateDefaultArray();

// The variable must be either A,B,P and X and then set to Caps
do{
   maintenanceOptions = Options();

//  The switch for the entire program
   switch (maintenanceOptions){
     case 'A':
        AptView(aptArray);
        break;
     case 'B':
        BuildingView(aptArray);
        break;


     case 'P':
        PeopleView(aptArray);
        break;
     case 'X':
        return;
     default:
        break;
     }
  } while(maintenanceOptions != 'X');
}
//-----------------------------------------------------------------------------
    private static void  AptView(int[][] aptArray) {

    int floor, aptNumber, numberOfPeople;
    double maintenanceCost;

    System.out.print("Please enter floor number     : ");
    floor      = keyboard.nextInt();
    floor      = FloorCheck(floor);
    floor      += -1;
    System.out.print("Please enter apartment number : ");
    aptNumber = keyboard.nextInt();
    aptNumber = AptCheck(floor, aptNumber);
    aptNumber += -1;
    numberOfPeople  = GetFloorData(floor, aptNumber, aptArray);
    maintenanceCost = Cost(numberOfPeople, aptArray);
    System.out.printf("Floor%2d Apt%2d: %d people: $%7.2f maintenance\n",
                    (floor+=1), (aptNumber+=1), numberOfPeople,
                     maintenanceCost);
     }
//-----------------------------------------------------------------------------
     private static void BuildingView(int[][] aptArray){

     int numberOfPeople;
     double maintenanceCost;

     for (int i = 0; i < aptArray.length; i++){
       for (int j = 0; j < aptArray[i].length; j++){
           numberOfPeople  = GetFloorData(i, j, aptArray);
           maintenanceCost = Cost(numberOfPeople, aptArray);
           System.out.printf("Floor %2d Apt %2d: %d people: $%7.2f maintenance\n",
                            (i + 1), (j + 1), numberOfPeople, maintenanceCost);
           }
       }
     }
//-----------------------------------------------------------------------------
    private static int[][] PeopleView(int[][] aptArray){

    int floor, aptNumber, numberOfPeople, total;

    total = 0;

    System.out.print("Please enter floor number     : ");
    floor      = keyboard.nextInt();
    floor      = FloorCheck(floor);
    floor      += -1;
    System.out.print("Please enter apartment number : ");
    aptNumber = keyboard.nextInt();
    aptNumber = AptCheck(floor, aptNumber);
    aptNumber += -1;
    System.out.print("How many people will there be : ");
    numberOfPeople  = keyboard.nextInt();
    aptArray = MaxOccCheck(floor, aptNumber, numberOfPeople, aptArray);
    return (aptArray);
    }
//-----------------------------------------------------------------------------
    private static int[][] MaxOccCheck (int floor, int aptNumber,
                                        int numberOfPeople, int[][] aptArray){

    int total = 0;

    int pNot = aptArray[floor][aptNumber];

    if (numberOfPeople > MAX_APTS_OCCUPANCY){
        System.out.println("ERROR: Too many people for an apartment");
        } else {
           aptArray[floor][aptNumber] = numberOfPeople;
           total = TotalOnFloor(floor, aptArray);
                if (total > MAX_FLOOR_OCCUPANCY) {
                    aptArray[floor][aptNumber] = (numberOfPeople - pNot);
                    System.out.println("ERROR: Too many people for the floor");
                    } else {
                      aptArray[floor][aptNumber] = numberOfPeople;
           }
         }
    return (aptArray);
    }
//-----------------------------------------------------------------------------
     private static int FloorCheck(int floor){

     while (floor > 2 || floor < 0){
        System.out.print("Must be in range 1 to 2 : ");
        floor = keyboard.nextInt();
        }
        return (floor);
     }
//-----------------------------------------------------------------------------
     private static int AptCheck(int floor, int aptNumber){

     if (floor == 0){
     while (aptNumber > 3 || aptNumber < 0){
        System.out.print("Must be in range 1 to 3 : ");
        aptNumber = keyboard.nextInt();
        }
     } else if (floor == 1){
        while (aptNumber > 2 || aptNumber < 0){
        System.out.print("Must be in range 1 to 2 : ");
        aptNumber = keyboard.nextInt();
        }
     }
       return (aptNumber);
     }
//-----------------------------------------------------------------------------
    private static int TotalOnFloor(int floor, int[][]aptArray){

    int total;

    total=0;

    for (int j = 0; j < aptArray[floor].length; j++){
         total += aptArray[floor][j];
         }
    return (total);
    }
//-----------------------------------------------------------------------------
    private static int[][] CreateDefaultArray() {

    int [][] defaultArray = {{2,2,2},{2,2}};

    return (defaultArray);
    }
//-----------------------------------------------------------------------------
    private static char Options() {

    char options;

    do{
        System.out.print("(A)partment, (B)uilding, (P)eople, e(X)it : ");
        options = keyboard.next().charAt(0);
        options = Character.toUpperCase(options);

        switch (options){
            case 'A':
            case 'B':
            case 'P':
            case 'X':
              return (options);
         }
       } while (true);
    }
//-----------------------------------------------------------------------------
    private static int GetFloorData(int floor, int aptNumber,
                                    int [][] aptArray) {

    int peopleInApt;

// Getting the number of people in the apartment
    peopleInApt = aptArray[floor][aptNumber];
    return (peopleInApt);
    }
//-----------------------------------------------------------------------------
    private static double Cost (int people, int [][] aptArray){

      int total = 0, totalj = 0;
      double maintenance;

// Summing up the total  number of people in the apartment complex
      for (int i = 0; i < aptArray.length; i++){
          totalj=0;
      for (int j = 0; j < aptArray[i].length; j++){
          totalj += aptArray[i][j];
      }
      total +=totalj;
      }

// Calculating the maintance cost in the apartment number and floor
// specified
     maintenance = (double) (5000.0/total) * people;
     return maintenance;
     }
//-----------------------------------------------------------------------------
}
//=============================================================================
