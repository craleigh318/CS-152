/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import frontend.SchemeParser;
import intermediate.IntermediateCode;
import intermediate.SchemeList;
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
            File inputFile = new File(args[0]);
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



            parser.parse();
            for(SchemeList s: interCode.getLists() )
            {
                System.out.println(s.toString());
            }
            System.out.println("\nThe contents of the Symbol Table \n" + symbolTable.toString());


        } catch (Exception e) {
            System.out.println("error " + e);
            e.printStackTrace();
        }

    }
}
