package com.airtribe.learntrack.utility;

import java.util.Scanner;

public class Helper {

    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt){

        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }

    }


    //read String Method
    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
