/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import frontend.SchemeParser;
import frontend.SchemeScanner2;
import frontend.Token;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author BrandonRossi
 */
public class Executor {

    public static void main(String[] args) {
        try {
            String file = "";
            File inputFile = new File("input.txt");
            Scanner fileScanner = new Scanner(inputFile);
            String[] splitfile;
            String splitFile = "";
            //Reads in the whole file into a single string
            while (fileScanner.hasNextLine()) {
                String temp = fileScanner.nextLine().replaceAll(";.*", " ");
                splitFile += temp + "\n";
                file += temp;
            }

            file = file.replaceAll("\\(", "\\( ");
            file = file.replaceAll("\\)", " \\) ");

            splitfile = splitFile.split("\n");
            //Passes the Array of lines to the SchemeScanner
            SchemeScanner2 scanner = new SchemeScanner2(new File(file));

            //Testing the scanner output
            Token t = scanner.nextToken();
            System.out.println(t.getName() + "          " + t.getType());
            while (!t.getType().equals("END_OF_INPUT") && !t.getType().equals("ERROR")) {
                t = scanner.nextToken();
                System.out.println(t.getName() + "          " + t.getType());
            }

        } catch (Exception e) {
            System.out.println("error " + e);
            e.printStackTrace();
        }

    }
}
