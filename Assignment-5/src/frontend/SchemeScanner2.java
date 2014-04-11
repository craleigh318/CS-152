/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author BrandonRossi
 */
public class SchemeScanner2
{

    private Scanner fileScanner;

    /**
     * @param schemeSource the Scheme source file to scan
     */
    public SchemeScanner2(File schemeSource) throws FileNotFoundException
    {
        fileScanner = new Scanner(schemeSource);
    }

    public String nextToken()
    {
        String token = "";
        if(fileScanner.hasNext())
        {
            if(fileScanner.next(".").charAt(0) == '(')
            {
                token = Character.toString(fileScanner.next(".").charAt(0));
                return token;
            }
            else if (Character.isLetter(fileScanner.next(".").charAt(0)))
            {
                while(fileScanner.next(".").charAt(0) != ' ')
                {
                    token.concat(Character.toString(fileScanner.next(".").charAt(0)));
                }
                return token;
            }
            else if (Character.isDigit(fileScanner.next(".").charAt(0)))
            {
                while(fileScanner.next(".").charAt(0) != ' ')
                {
                    token.concat(Character.toString(fileScanner.next(".").charAt(0)));
                }
                return token;
            }
        }
        return token;
    }
}
