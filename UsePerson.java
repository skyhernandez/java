//*********************************************************************************************************************
// Name:                 Skylar Hernandez
// Date:                 October 29, 2007
// class:                CSC 120
// Description:          A provided main method... by Geoff, our task is to create the
//                       the corresponding objects in other files.
//*********************************************************************************************************************

import java.util.Scanner;
//===========================================================================
public class UsePerson {
//----------------------------------------------------------------------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//----------------------------------------------------------------------------------------------------------------------------------------    public static void main(String[] args) {

        Person onePerson;
        String name;
        int age;

//----Get person information
        System.out.print("Enter name of person : ");
        name = keyboard.nextLine();
        System.out.print("How old is that person    : ");
        age = keyboard.nextInt();
        keyboard.nextLine();
        onePerson = new Person(name,age);

//----Print person information
        onePerson.display();

//----Let person have a birthday
        onePerson.incrementAge();
        onePerson.display();

//----Print person information via accessors
        System.out.println("Raw access shows that " + onePerson.getName() +
" is " + onePerson.getAge() + " years old");
    }
//----------------------------------------------------------------------------------------------------------------------------------------}
//===========================================================================
