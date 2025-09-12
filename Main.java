/*
 * Main.java
 * Author: Enrique A. Montero Candelario
 * Date: July 20, 2025
 * Purpose: Main program for displaying and updating 12-hour and 24-hour clocks.
 */

import java.util.Scanner;

public class Main {

    /**
    Displays the menu options for the user.
    */
    public static void displayMenu() {
        System.out.println();
        System.out.println("******************************");
        System.out.println("* 1 - Add One Hour           *");
        System.out.println("* 2 - Add One Minute         *");
        System.out.println("* 3 - Add One Second         *");
        System.out.println("* 4 - Exit Program           *");
        System.out.println("******************************");
    }

    /**
    Displays both the 12-hour and 24-hour clocks.
    @param clock Clock object to be displayed
    */
    public static void displayClocks(Clock clock) {
        System.out.println("\n**************************     **************************");
        clock.display12HourClock();
        clock.display24HourClock();
        System.out.println("**************************     **************************\n");
    }

    /**
    Entry point for the program.
    Prompts the user for an initial time, then loops through menu choices.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get initial time from user
        System.out.print("Enter initial hour (0-23): ");
        int h = scanner.nextInt();
        System.out.print("Enter initial minute (0-59): ");
        int m = scanner.nextInt();
        System.out.print("Enter initial second (0-59): ");
        int s = scanner.nextInt();

        Clock myClock = new Clock(h, m, s);

        int choice;
        do {
            displayClocks(myClock);
            displayMenu();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> myClock.addHour();
                case 2 -> myClock.addMinute();
                case 3 -> myClock.addSecond();
                case 4 -> System.out.println("\nProgram Finished.");
                default -> System.out.println("Invalid input. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
