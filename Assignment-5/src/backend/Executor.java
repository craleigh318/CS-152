/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import frontend.SchemeParser;
import intermediate.IntermediateCode;
import intermediate.SymbolTable;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
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


            IntermediateCode interCode = new IntermediateCode();
            SymbolTable symbolTable = new SymbolTable();
            SchemeParser parser = new SchemeParser(interCode, file, symbolTable);


            for (int i = 0; i < 10; i++)
            {
                parser.parse();
            }

            //Testing the scanner output
//            SchemeScanner2 scanner = new SchemeScanner2(file);
//            Token t = scanner.nextToken();
//            System.out.println(t.getName() + "          " + t.getType());
//            while (!t.getType().equals("END_OF_INPUT") && !t.getType().equals("ERROR")) {
//                t = scanner.nextToken();
//                System.out.println(t.getName() + "          " + t.getType());
//            }

        } catch (Exception e) {
            System.out.println("error " + e);
            e.printStackTrace();
        }

    }
}
