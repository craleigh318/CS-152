/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author BrandonRossi
 */
public class SchemeScanner2
{
    private final String keyword = "KEYWORD";
    private final String identifier = "IDENTIFIER";
    private final String special_Symbol = "SPECIAL_SYMBOL";
    private final String procedure = "PROCEDURE";

    HashMap<String, String> key_Word_Map;
    HashMap<String, String> special_Symbol_Map;

    private Scanner fileScanner;

    public SchemeScanner2(File schemeSource) throws FileNotFoundException
    {
        fileScanner = new Scanner(schemeSource);
        key_Word_Map = new HashMap<>();
        special_Symbol_Map = new HashMap<>();
        setUpMaps();
    }

    public String nextToken()
    {
        String token = "";
        while(fileScanner.hasNext())
        {
            Character currentToken = fileScanner.findInLine(".").charAt(0);
            if(currentToken.equals('('))
            {
                token = Character.toString(currentToken);
                System.out.println("This is the beginning of a list " + token);
                token = "";
                continue;
            }
            else if(currentToken.equals(')'))
            {
                token = Character.toString(currentToken);
                System.out.println("This is the end of a list " + token);
                token = "";
                continue;
            }
            else if(Character.isAlphabetic(currentToken))
            {
                if (currentToken.isAlphabetic(currentToken))
                {
                    token += currentToken;
//                    currentToken = fileScanner.findInLine(".").charAt(0);
                }
                System.out.println("The Current Toke is " + token);
                token = "";
                continue;
            }





        }

        return token;
    }




    private void setUpMaps()
    {
        key_Word_Map.put("and", keyword);
        key_Word_Map.put("begin", keyword);

        special_Symbol_Map.put("+", special_Symbol);

    }


}
