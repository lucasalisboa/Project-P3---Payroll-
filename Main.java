package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        Locale.setDefault(Locale.US);
        System.out.println("CHOOSE YOUR OPERATION:");
        System.out.println("1- ADD NEW EMPLOYER");
        System.out.println("2- REMOVE A EMPLOYER");
        System.out.println("3- PUT THE POINT CARD");
        System.out.println("4- PUT THE SALE'S RESULT");
        System.out.println("5- PUT THE SERVICE TAX");
        System.out.println("6- CHANGE THE EMPLOYER INFORMATIONS");
        System.out.println("7- RUN THE PAYROLL");
        System.out.println("8- UNDO/REDO");
        System.out.println("9- SHOW THE PAYMENT SCHEDULE");
        System.out.println("10- CREATE A NEW PAYMENT SCHEDULE");

        int operation;
        Scanner sc = new Scanner(System.in);
        operation = sc.nextInt();
        System.out.println(" ");

        if(operation == 1 )
        {

        }
        else if(operation == 2 )
        {

        }
        else if(operation == 3 )
        {

        }
        else if(operation == 4 )
        {

        }
        else if(operation == 5 )
        {

        }
        else if(operation == 6 )
        {

        }
        else if(operation == 7 )
        {

        }
        else if(operation == 8 )
        {

        }
        else if(operation == 9 )
        {

        }
        else if(operation == 10 )
        {

        }
        else
        {
            System.out.println("INVALID OPERATION");
            System.out.println("PLEASE, TRY AGAIN\n");
            main(args);
        }

    }
}
