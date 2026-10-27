package com.pluralsight;

import java.io.*;
import java.util.*;

public class Main {

    static String[] stories = {"goldilocks.txt",
            "hansel_and_gretel.txt", "mary_had_a_little_lamb.txt"};
    static Scanner scanner = new Scanner(System.in);
    static int lineNumber = 1;

    public static void main(String[] args) {
        System.out.println("""
                list of childern stories
                1 - goldilocks
                2 - hansel and gretel
                3 - mary had a little lamb""");
        System.out.print("enter a list number to read ->: ");
        String enterResult = scanner.nextLine().toLowerCase();

        boolean isCorrect = false;
        while (!isCorrect) {
            switch (enterResult) {
                case ("1"), ("2"), ("3") -> isCorrect = true;
                default -> {
                    System.out.print("""
                            Error input not found please enter a valid input
                            enter a list number to read ->:""" + " ");
                    enterResult=scanner.nextLine().toLowerCase();
                }
            }
        }
        int result = Integer.parseInt(enterResult);
        scanner.close();
        try {
            FileReader fileReader = new FileReader(stories[result - 1]);
            BufferedReader bufReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufReader.readLine()) != null) {
                System.out.println(lineNumber+line);
                lineNumber++;
            }
            bufReader.close();
        }
        catch(IOException e) {
            System.out.print("java.io.FileNotFoundException: file.txt (No such file or directory)\n");
            //e.printStackTrace();
        }
    }
}