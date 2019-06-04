package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("WELCOME!\n");
        String[][] payroll = new String[100][12];
        int[][] calendar = new int[12][31];
        int c1 = 0, c2 = 0;

        while (c1 < 100) {
            if (c2 == 10) {
                c1++;
                c2 = 0;
            } else {
                payroll[c1][c2] = "NULL";
                c2++;
            }
        }
        c1 = 0;
        c2 = 0;

        while (c1 < 12) {
            if (c1 % 2 == 0) {
                if (c2 == 30) {
                    calendar[c1][c2] = 1;
                    c1++;
                    c2 = 0;
                } else {
                    calendar[c1][c2] = 1;
                    c2++;
                }
            } else if (c1 == 1) {
                if (c2 == 27) {
                    calendar[c1][c2] = 1;
                    calendar[c1][c2 + 1] = 0;
                    c1++;
                    c2 = 0;
                } else {
                    calendar[c1][c2] = 1;
                    c2++;
                }
            } else {
                if (c2 == 29) {
                    calendar[c1][c2] = 1;
                    calendar[c1][c2 + 1] = 0;
                    c1++;
                    c2 = 0;
                } else {
                    calendar[c1][c2] = 1;
                    c2++;
                }
            }
        }

        System.out.println("CHOOSE YOUR DATA");
        System.out.println("DAY:");

        Scanner sc = new Scanner(System.in);
        c2 = sc.nextInt();
        c2--;

        System.out.println("MONTH:");
        c1 = sc.nextInt();
        c1--;

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

        action(calendar, c1, c2, day, payroll);
        sc.close();
    }

    public static void action(int calendar[][], int c1, int c2, int day, String payroll[][]) {

        Locale.setDefault(Locale.US);
        System.out.printf("YOUR DATA IS %d/%d\n", c2 + 1, c1 + 1);

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


        if (operation == 1) {
            hire(payroll, 0);
            action(calendar, c1, c2, day, payroll);
        } else if (operation == 2) {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S NAME");
            String name;
            sc.nextLine();
            name = sc.nextLine();
            fire(name, payroll, 0);
            action(calendar, c1, c2, day, payroll);
        } else if (operation == 3) {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S NAME");
            String name;
            sc.nextLine();
            name = sc.nextLine();
            point(name, payroll, 0);
            action(calendar, c1, c2, day, payroll);
        } else if (operation == 4) {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S NAME");
            String name;
            sc.nextLine();
            name = sc.nextLine();
            sale(name, payroll, 0);
            action(calendar, c1, c2, day, payroll);

        } else if (operation == 5) {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S NAME");
            String name;
            sc.nextLine();
            name = sc.nextLine();
            int aux = 0;
            while (aux < 100) {
                if (payroll[c1][0].equals(name)) {
                    payroll[c1][10] = sc.nextLine();
                }
                aux++;
            }
            action(calendar, c1, c2, day, payroll);
        } else if (operation == 6) {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S NAME");
            String name;
            sc.nextLine();
            name = sc.nextLine();
            System.out.println("WHAT INFORMATION YOU WANT TO CHANGE?");
            System.out.println("1- NAME");
            System.out.println("2- ADDRESS");
            System.out.println("3- TYPE");
            System.out.println("4- PAYMENT METHOD");
            System.out.println("5- SYNDICATED");
            System.out.println("6- IDENTIFICATION");
            System.out.println("7- SYNDICATE TAX");

            int option;
            option = sc.nextInt();

            change(name, payroll, 0, option);
            action(calendar, c1, c2, day, payroll);
        } else if (operation == 7) {
            payment(payroll, c2, 0, 0);
            action(calendar, c1, c2, day, payroll);
        } else if (operation == 8) {

        } else if (operation == 9) {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S NAME");
            String name;
            sc.nextLine();
            name = sc.nextLine();
            int aux = 0;
            while (aux < 100) {
                if (payroll[c1][0].equals(name)) {
                    System.out.println(payroll[aux][11]);
                }
                aux++;
            }

        } else if (operation == 10) {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S NAME");
            String name;
            sc.nextLine();
            name = sc.nextLine();
            System.out.println("WHAT'S THE SCHEDULE?");
            System.out.println("P- PATTERN");
            System.out.println("M1- MONTH FIRST DAY");
            System.out.println("M7- MONTH DAY SEVEN");
            System.out.println("MS- MONTH LAST DAY");
            System.out.println("WM- WEEK ON MONDAYS");
            System.out.println("WF- MONTH ON FRIDAYS");
            System.out.println("W2M- 2 WEEKS ON MONDAYS");
            s_p(name,payroll,0);
            action(calendar, c1, c2, day, payroll);

        } else if (operation == 11) {
            update(payroll, calendar, c2, c1, day, 0);

            if (c2 == 30 || calendar[c1][c2 + 1] == 0) {
                int aux = 0;
                while (aux < 100) {
                    if (payroll[c1][9].equals("NULL")) {
                        aux++;
                    } else {
                        int data;
                        data = (Integer.parseInt(payroll[c1][9]) - c2);
                        payroll[c1][9] = Integer.toString(data);
                    }
                }

                c2 = 0;
                if (c1 == 11) {
                    c1 = 0;
                } else {
                    c1++;
                }

            } else {
                c2++;
            }
            day++;
            if (day == 8) {
                day = 1;
            }

            action(calendar, c1, c2, day, payroll);
        } else {
            System.out.println("INVALID OPERATION");
            System.out.println("PLEASE, TRY AGAIN\n");
            action(calendar, c1, c2, day, payroll);
        }

    }

    public static void hire(String payroll[][], int c1) {
        if (payroll[c1][0] == "NULL") {
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

            if (payroll[c1][4].equals("NO")) {
                payroll[c1][5] = "0";
                payroll[c1][6] = "NULL";
            } else {
                System.out.println("WHAT'S THE TAX?");
                payroll[c1][5] = sc.nextLine();
                System.out.println("WHAT'S THE IDENTIFICATION?");
                payroll[c1][6] = sc.nextLine();
            }

            payroll[c1][7] = "0"; // Hours worked or sales

            System.out.println("WHAT'S THE PAYMENT METHOD?");
            System.out.println("BA- BANK ACCOUNT; CH- CHECK IN HANDS; CC- CHECK BY COURIER");
            payroll[c1][8] = sc.nextLine();

            payroll[c1][9] = "0"; // Next Payment will be write here

            System.out.println("WHAT'S THE PAYMENT BY SERVICE?");
            payroll[c1][10] = sc.nextLine();

            System.out.println("WHAT'S THE SCHEDULE?");
            System.out.println("P- PATTERN");
            System.out.println("M1- MONTH FIRST DAY");
            System.out.println("M7- MONTH DAY SEVEN");
            System.out.println("MS- MONTH LAST DAY");
            System.out.println("WM- WEEK ON MONDAYS");
            System.out.println("WF- MONTH ON FRIDAYS");
            System.out.println("W2M- 2 WEEKS ON MONDAYS");
            payroll[c1][11] = sc.nextLine();

        } else {
            c1++;
            hire(payroll, c1);
        }
    }

    public static void fire(String name, String payroll[][], int c1) {
        if (c1 == 100) {
            System.out.println("Employer doesn't exist\n");
        } else if (payroll[c1][0].equals(name)) {
            int c2 = 0;
            while (c2 < 12) {
                payroll[c1][c2] = "NULL";
                c2++;
            }
            System.out.printf("Employer %s was removed\n\n", name);
        } else {
            c1++;
            fire(name, payroll, c1);
        }
    }
    public static void s_p(String name, String payroll[][], int c1) {
        if (c1 == 100) {
            System.out.println("Employer doesn't exist\n");
        } else if (payroll[c1][0].equals(name)) {
            Scanner sc = new Scanner(System.in);
            payroll[c1][10] = sc.nextLine();
        } else {
            c1++;
            s_p(name, payroll, c1);
        }
    }

    public static void point(String name, String payroll[][], int c1) {
        if (c1 == 100) {
            System.out.println("Employer doesn't exist\n");
        } else if (payroll[c1][0].equals(name)) {
            System.out.println("HOW MANY HOURS THE EMPLOYER WORKED TODAY?");
            double hours = Double.parseDouble(payroll[c1][7]);
            Scanner sc = new Scanner(System.in);
            double h = sc.nextInt();
            if (h > 8) {
                h = (h * 1.5);
            }
            double nh = hours + h;
            payroll[c1][7] = Double.toString(nh);
            System.out.printf("The employer has %s hours worked\n", payroll[c1][7]);
        } else {
            c1++;
            point(name, payroll, c1);
        }
    }

    public static void change(String name, String payroll[][], int c1, int option) {
        if (c1 == 100) {
            System.out.println("Employer doesn't exist\n");
        } else if (payroll[c1][0].equals(name)) {
            Scanner sc = new Scanner(System.in);
            if (option == 1) {
                payroll[c1][0] = sc.nextLine();
            } else if (option == 2) {
                payroll[c1][1] = sc.nextLine();
            } else if (option == 3) {
                payroll[c1][2] = sc.nextLine();
            } else if (option == 4) {
                payroll[c1][8] = sc.nextLine();
            } else if (option == 5) {
                payroll[c1][4] = sc.nextLine();
            } else if (option == 6) {
                payroll[c1][6] = sc.nextLine();
            } else if (option == 7) {
                payroll[c1][5] = sc.nextLine();
            }
        } else {
            c1++;
            change(name, payroll, c1, option);
        }

    }

    public static void sale(String name, String payroll[][], int c1) {
        if (c1 == 100) {
            System.out.println("Employer doesn't exist\n");
        } else if (payroll[c1][0].equals(name)) {
            int s = Integer.parseInt(payroll[c1][7]);
            s++;
            payroll[c1][7] = Integer.toString(s);
        } else {
            c1++;
            sale(name, payroll, c1);
        }
    }

    public static void payment(String payroll[][], int today, int c1, int e) {
        if (c1 < 100) {
            if (payroll[c1][9].equals(Integer.toString(today))) {
                System.out.println(payroll[c1][0]);
                double p;
                if (payroll[c1][2].equals("S")) {
                    p =Double.parseDouble(payroll[c1][3]);
                } else if (payroll[c1][2].equals("H")) {
                    p = Double.parseDouble(payroll[c1][7]) * Double.parseDouble(payroll[c1][7]);
                } else {
                    p = Double.parseDouble(payroll[c1][3]) + (Double.parseDouble(payroll[c1][7]) * Double.parseDouble(payroll[c1][7]));
                }
                if(payroll[c1][4].equals("YES"))
                {
                    p = p * ((Double.parseDouble(payroll[c1][5]))/100);
                }
                System.out.println(p);
                e++;
            }
            c1++;
            payment(payroll, today, c1, e);
        } else {
            if (e == 0) {
                System.out.println("There is no employer to be paid today\n");
            }
        }
    }

    public static void update(String[][] payroll, int[][] calendar, int today, int month, int day, int c1) {
        if (c1 == 100) {
            return;
        } else if (c1 < 100) {
            if (payroll[c1][0].equals("NULL")) {
                c1++;
                update(payroll, calendar, today, month, day, c1);
            } else if (Integer.parseInt(payroll[c1][9]) <= today) {
                int aux_t = today, aux_d = day;
                if (payroll[c1][11].equals("P")) {
                    if (payroll[c1][2].equals("H")) {
                        if (payroll[c1][2].equals("H")) {
                            int pd = (5 - day);
                            if (pd >= 0) {
                                payroll[c1][9] = Integer.toString(today + pd);
                            } else {
                                payroll[c1][9] = Integer.toString(today + (7 + pd));
                            }
                        } else if (payroll[c1][2].equals("S")) {
                            while (calendar[month][aux_t] == 1 || aux_t < 30) {
                                aux_t++;
                                aux_d++;
                                if (aux_d == 8) {
                                    aux_d = 1;
                                }
                            }
                            aux_t--;
                            aux_d--;
                            if (aux_d == 6) {
                                aux_t--;
                            } else if (day == 7) {
                                aux_t = (aux_t - 2);
                            }
                            payroll[c1][9] = Integer.toString(aux_t);
                        } else {
                            if (day < 5) {
                                payroll[c1][9] = Integer.toString(aux_t + 7 + (5 - aux_d));
                            } else {
                                payroll[c1][9] = Integer.toString(aux_t + (14 + (5 - aux_d)));
                            }
                        }
                    }
                } else if (payroll[c1][11].equals("M1")) {
                    while (calendar[month][aux_t] == 1 || aux_t < 30) {
                        aux_t++;
                        aux_d++;
                        if (aux_d == 8) {
                            aux_d = 1;
                        }
                    }
                    if (aux_d == 6) {
                        aux_t = aux_t + 2;
                    } else if (aux_d == 7) {
                        aux_t++;
                    }
                    payroll[c1][9] = Integer.toString(aux_t);
                } else if (payroll[c1][11].equals("M7")) {
                    if (aux_t < 7) {
                        int n = 7 - aux_t;
                        aux_t = aux_t + n;
                        while (n > 0) {
                            aux_d++;
                            n--;
                            if (aux_d == 8) {
                                aux_d = 1;
                            }
                        }
                        if (aux_d == 6) {
                            aux_t = aux_t + 2;
                        } else if (aux_d == 7) {
                            aux_t++;
                        }
                        payroll[c1][9] = Integer.toString(aux_t);

                    } else {
                        while (calendar[month][aux_t] == 1 || aux_t < 30) {
                            aux_t++;
                            aux_d++;
                            if (aux_d == 8) {
                                aux_d = 1;
                            }
                        }
                        aux_d = aux_d + 6;
                        aux_t = aux_t + 6;

                        if (aux_d == 6) {
                            aux_t = aux_t + 2;
                        } else if (aux_d == 7) {
                            aux_t++;
                        }
                        payroll[c1][9] = Integer.toString(aux_t);
                    }

                } else if (payroll[c1][11].equals("MS")) {
                    while (calendar[month][aux_t] == 1 || aux_t < 30) {
                        aux_t++;
                        aux_d++;
                        if (aux_d == 8) {
                            aux_d = 1;
                        }
                    }
                    aux_d--;
                    aux_t--;

                    if (aux_d == 6) {
                        aux_t--;
                    } else if (aux_d == 7) {
                        aux_t = aux_t - 2;
                    }
                    payroll[c1][9] = Integer.toString(aux_t);
                }
                else if(payroll[c1][11].equals("WM"))
                {
                    int n = 8 - aux_d;
                    payroll[c1][9] = Integer.toString(aux_t+n);
                }
                else if(payroll[c1][11].equals("WF"))
                {
                    int n;
                    if(aux_d < 5)
                    {
                        n = 5 - aux_d;
                    }
                    else
                    {
                        n = 7 + (7 - aux_d);
                    }
                    payroll[c1][9] = Integer.toString(aux_t+n);
                }
                else if(payroll[c1][11].equals("W2M"))
                {
                    int n = 15 - aux_d;
                    payroll[c1][9] = Integer.toString(aux_t+n);
                }
                System.out.printf("Employer %s updated\n", payroll[c1][0]);
                c1++;
                update(payroll, calendar, today, month, day, c1);
            }
            }
        }
    }

