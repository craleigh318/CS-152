/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import frontend.SchemeScanner;
import frontend.SchemeScanner2;
import frontend.Token;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author BrandonRossi
 */
public class Executor
{
    public static void main(String[] args)
    {
        try
        {
            String file = "";
            File inputFile = new File("input 3.txt");
            Scanner fileScanner = new Scanner(inputFile);

            //Reads in the whole file into a single string
            while(fileScanner.hasNextLine())
            {
                file += fileScanner.nextLine();
            }
            //Removes all comments from the file
            file = file.replaceAll(";.*", "");
            //Splits the file up into lines and places each line in an array
            String[] splitList = file.split("\n");
            //Passes the Array of lines to the SchemeScanner
            SchemeScanner2 scanner = new SchemeScanner2(splitList);

            //Testing the scanner output
            Token t = scanner.nextToken();
            System.out.println(t.getName());
            while(!t.getType().equals("END_OF_INPUT") || !t.getType().equals("ERROR"))
            {
                t = scanner.nextToken();
                System.out.println(t.getName());
            }

        } catch (Exception e)
        {
            System.out.println("error " + e);
            e.printStackTrace();
        }

    }
}
