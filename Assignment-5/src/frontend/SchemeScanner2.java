/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.util.HashMap;

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

    //The array of strings each index contains a line of code from the file
    private String[] splitList;
    //The index into the array of lines
    private int splitListIndex;
    //This is the index of the string. traversing over the line is done with this index
    private int lineIndex;

    HashMap<String, String> key_Word_Map;
    HashMap<String, String> special_Symbol_Map;

    public SchemeScanner2(String[] split)
    {
        //This is the array
        splitList = split;
        //This is the array index
        splitListIndex = 0;
        //This is the string index
        lineIndex = 0;

        key_Word_Map = new HashMap<>();
        special_Symbol_Map = new HashMap<>();
        setUpMaps();
    }

    public Token nextToken()
    {
        //A new Token
        Token currentToken;
        //As a token is read from the string it is placed into this string
        String token = "";
        //The current line that is being read from
        String currentLine = splitList[splitListIndex];

        //if the index into the string is greater then the length of the string go to a new line
        if (lineIndex >= currentLine.length())
        {
            lineIndex = 0;
            splitListIndex += 1;
        }
        //if the index into the array of lines is greater then the length then end of file
        if (splitListIndex >= splitList.length)
        {
            return new Token("NULL", Token.Type.END_OF_INPUT);
        }
        //If the current character is a space then incrament the index by 1 to go to the next character
        if (currentLine.charAt(lineIndex) == ' ')
        {
            lineIndex++;
        }
        //If the current line is empty then move to the next line
        if (currentLine.equals(""))
        {
            if (splitListIndex < splitList.length)
            {
                splitListIndex += 1;
                currentLine = splitList[splitListIndex];
                lineIndex = 0;
            }
        }
        //If the current character is a ( create a new token and return it
        //incrament the index into the string
        if (currentLine.charAt(lineIndex) == '(')
        {
            currentToken = new Token("(", Token.Type.SPECIAL_SYMBOL);
            lineIndex += 1;
            return currentToken;
        }
        //If the current chara ter is a ) then create a new token and return it
        //incrament the index into the string
        else if (currentLine.charAt(lineIndex) == ')')
        {
            currentToken = new Token(")", Token.Type.SPECIAL_SYMBOL);
            lineIndex += 1;
            return currentToken;
        }
        //If the current character is a letter
        else if (Character.isAlphabetic(currentLine.charAt(lineIndex)))
        {
            //While the current character is a letter or a number
            //build the token name and save it into the token string
            //increment the line index
            //if the current character is equal to a ) the stop working
            //create and return a new Token
            while (Character.isAlphabetic(currentLine.charAt(lineIndex)) || Character.isDigit(currentLine.charAt(lineIndex)))
            {
                token += Character.toString(currentLine.charAt(lineIndex));
                lineIndex++;
                if (currentLine.charAt(lineIndex) == ')')
                {
                    break;
                }
            }

            return new Token(token, Token.Type.NUMBER);//Need to check for TYPE eventully
        }
        //If the current character is a digit
        else if (Character.isDigit(currentLine.charAt(lineIndex)))
        {
            //While the current character is a digit
            //build the token name and save it into the token string
            //increment the line index
            //if the current character is equal to a ) the stop working
            //create and return a new Token
            while (Character.isDigit(currentLine.charAt(lineIndex)))
            {
                token += Character.toString(currentLine.charAt(lineIndex));
                lineIndex++;
                if (currentLine.charAt(lineIndex) == ')')
                {
                    break;
                }
            }

            return new Token(token, Token.Type.NUMBER);////Need to check for TYPE eventully
        }
        return new Token("ERROR", Token.Type.ERROR);
    }

    private void setUpMaps()
    {
        key_Word_Map.put("and", keyword);
        key_Word_Map.put("begin", keyword);

        special_Symbol_Map.put("+", special_Symbol);

    }
}
