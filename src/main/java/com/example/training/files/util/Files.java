package com.example.training.files.util;

import java.io.*;
import java.util.Scanner;

public class Files {

    static Scanner scan = new Scanner(System.in);

    public static void createFile(String fileName) {
        File file = new File(fileName);
        try {
            PrintWriter output = new PrintWriter(file);
            output.close();
            System.out.println("File created successfully!");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void writeFile(String filename){
        File file = new File(filename);
        try {
            PrintWriter output = new PrintWriter(file);
            System.out.println("\nPlease, type the text to write in the file:");
            output.println(scan.nextLine());
            output.println("End of writing!");
            output.close();
            System.out.println("Content saved successfully!");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void readFile(String filename){
        File file = new File(filename);
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String output = input.readLine();
            System.out.println("\nReading...");
            while(output != null){
                System.out.println(output);
                output = input.readLine();
            }
            input.close();
            System.out.println("\nReading file end!");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void modifyFile(String fileName){
        File file = new File(fileName);

        try {
            PrintWriter output = new PrintWriter(new FileWriter(file, true));
            output.println("\nStart of file editing...");
            System.out.println("\nPlease, type the text to add in the file:");
            output.println(scan.nextLine());
            output.println("End of file editing...");
            output.close();
            System.out.println("File modified successfully!");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
