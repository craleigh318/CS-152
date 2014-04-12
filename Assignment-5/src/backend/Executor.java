/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import frontend.SchemeScanner2;
import java.io.File;
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
            File inputFile = new File("input 2.txt");
            SchemeScanner2 scanner = new SchemeScanner2(inputFile);
            scanner.nextToken();
        } catch (Exception e)
        {
            System.out.println("error " + e);
        }

    }
}
