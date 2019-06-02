package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("WELCOME!\n");
        String[][] payroll  = new String[100][10];
        int[][] calendar  = new int [12][31];
        int c1 = 0, c2 = 0;

        while(c1<100)
        {
            if(c2 == 10)
            {
                c1++;
                c2 = 0;
            }
            else
            {
                payroll[c1][c2] = "NULL";
                c2++;
            }
        }
        c1 = 0;
        c2 = 0;

        while(c1 < 12)
        {
            if(c1 % 2 == 0)
            {
                if(c2 == 30)
                {
                    calendar[c1][c2] = 1;
                    c1++;
                    c2 = 0;
                }
                else
                {
                    calendar[c1][c2] = 1;
                    c2++;
                }
            }
            else if(c1 == 1)
            {
                if(c2 == 27)
                {
                    calendar[c1][c2] = 1;
                    calendar[c1][c2+1] = 0;
                    c1++;
                    c2 = 0;
                }
                else
                {
                    calendar[c1][c2] = 1;
                    c2++;
                }
            }
            else
            {
                if(c2 == 29)
                {
                    calendar[c1][c2] = 1;
                    calendar[c1][c2+1] = 0;
                    c1++;
                    c2 = 0;
                }
                else
                {
                    calendar[c1][c2] = 1;
                    c2++;
                }
            }
        }

        System.out.println("CHOOSE YOUR DATA");
        System.out.println("DAY:");

        Scanner sc = new Scanner(System.in);
        c2 = sc.nextInt();
        c2 --;

        System.out.println("MONTH:");
        c1 = sc.nextInt();
        c1 --;

        System.out.printf("YOUR DATA IS %d/%d\n",c2+1,c1+1);

        System.out.println("THIS DATA IS:");
        System.out.println("1- MONDAY");
        System.out.println("2- TUESDAY");
        System.out.println("3- WEDNESDAY");
        System.out.println("4- THURSDAY");
        System.out.println("5- FRIDAY");
        System.out.println("6- SATURDAY");
        System.out.println("7- SUNDAY");

        int day;
        day = sc.nextInt();

        System.out.println("\n");

        action(calendar,c1,c2,day,payroll);
        sc.close();
    }

    public static void action(int calendar[][],int c1,int c2,int day, String payroll[][])
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
        System.out.println("11- FINISH THE DAY");


        int operation;
        Scanner sc = new Scanner(System.in);
        operation = sc.nextInt();
        System.out.println(" ");


        if(operation == 1 )
        {
            hire(payroll,0);
            action(calendar,c1,c2,day,payroll);
        }
        else if(operation == 2 )
        {
            String name;
            sc.nextLine();
            name = sc.nextLine();
            fire(name,payroll,0);
            action(calendar,c1,c2,day,payroll);
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
        else if(operation == 11)
        {
            if(c2 == 30 || calendar[c1][c2+1] == 0)
            {
                c2 = 0;

                if(c1 == 11)
                {
                    c1 = 0;
                }
                else
                {
                    c1++;
                }

            }
            else
            {
                c2++;
            }
            day++;
            if(day == 8)
            {
                day = 1;
            }
            action(calendar,c1,c2,day,payroll);
        }
        else
        {
            System.out.println("INVALID OPERATION");
            System.out.println("PLEASE, TRY AGAIN\n");
            action(calendar,c1,c2,day,payroll);
        }

    }

    public static void hire(String payroll[][],int c1)
    {
        if(payroll[c1][0] == "NULL")
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("WHAT'S THE NAME?");
            payroll[c1][0] = sc.nextLine();

            System.out.println("WHAT'S THE ADDRESS?");
            payroll[c1][1] = sc.nextLine();

            System.out.println("WHAT'S THE TYPE?");
            System.out.println("H- HOURLY; S- SALARIED; C- COMMISSIONED");
            payroll[c1][2] = sc.nextLine();

            System.out.println("WHAT'S THE SALARY?");
            payroll[c1][3] = sc.nextLine();

            System.out.println("SYNDICATED?");
            payroll[c1][4] = sc.nextLine();

            if(payroll[c1][4] == "NO")
            {
                payroll[c1][5] = "0";
                payroll[c1][6] = "NULL";
            }
            else
            {
                System.out.println("WHAT'S THE TAX?");
                payroll[c1][5] = sc.nextLine();
                System.out.println("WHAT'S THE IDENTIFICATION?");
                payroll[c1][6] = sc.nextLine();
            }

            payroll[c1][7] = "0"; // Hours worked or sales

            System.out.println("WHAT'S THE PAYMENT METHOD?");
            System.out.println("BA- BANK ACCOUNT; CH- CHECK IN HANDS; CC- CHECK BY COURIER");
            payroll[c1][8] = sc.nextLine();

        }
        else
        {
            c1++;
            hire(payroll,c1);
        }
    }
    public static void fire(String name,String payroll[][],int c1)
    {
        if(payroll[c1][0] == name)
        {
            int c2=0;
            while(c2 < 10)
            {
                payroll[c1][c2] = "NULL";
                c2++;
            }
            System.out.printf("EMPLOYER %s was remover\n",name);
        }
        else
        {
            c1++;
            fire(name,payroll,c1);
        }
    }
}
