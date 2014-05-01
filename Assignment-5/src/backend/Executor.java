package backend;

import frontend.SchemeParser;
import intermediate.IntermediateCode;
import intermediate.SchemeList;
import intermediate.SymbolTable;
import intermediate.SymbolTableStack;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * Executes a Scheme program from its source code.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class Executor {

    public static void main(String[] args) {
        if (args.length >= 1) {
            try {
                String file = "";
                File inputFile = new File(args[0]);
                PrintStream output;
                if (args.length >= 2) {
                    output = new PrintStream(args[1]);
                } else {
                    output = System.out;
                }
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
                SymbolTableStack symbolTableStack = new SymbolTableStack();
                SchemeParser parser = new SchemeParser(interCode, file, symbolTableStack);



                parser.parse();
                for (SchemeList s : interCode.getLists()) {
                    output.println(s.toString());
                }
                Stack symbolTable = interCode.getSymbolTableStack().getSymbolTableStack();
                output.println("\nThe contents of the Symbol Table \n" + symbolTable.toString());


            } catch (Exception e) {
                System.out.println("error " + e);
            }
        } else {
            System.out.println("Please specify the file input.");
        }

    }
}
