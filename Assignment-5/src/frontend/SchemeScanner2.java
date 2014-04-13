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
    HashMap<String, String> procedure_Symbol_Map;

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
        procedure_Symbol_Map = new HashMap<>();

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
            if (splitListIndex >= splitList.length)
            {
                return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
            }
            currentLine = splitList[splitListIndex];
        }
        //if the index into the array of lines is greater then the length then end of file
        if (splitListIndex >= splitList.length)
        {
            return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
        }
        //If the current line is empty then move to the next line
        while (currentLine.equals(""))
        {
            if (splitListIndex < splitList.length)
            {
                splitListIndex += 1;
                currentLine = splitList[splitListIndex];
                lineIndex = 0;
            }
        }
        //If the current character is a space then incrament the index by 1 to go to the next character
        while (currentLine.charAt(lineIndex) == ' ')
        {
            lineIndex++;
            if (lineIndex >= currentLine.length())
            {
                splitListIndex++;
                if (splitListIndex >= splitList.length)
                {
                    return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                }
                currentLine = splitList[splitListIndex];
                lineIndex = 0;

            }
        }

        //If the current character is a ( create a new token and return it
        //incrament the index into the string
        if (currentLine.charAt(lineIndex) == '(')
        {
            //currentToken = new Token("(", Token.Type.SPECIAL_SYMBOL);
            lineIndex++;
            return new Token("(", Token.Type.SPECIAL_SYMBOL);
        } //If the current chara ter is a ) then create a new token and return it
        //incrament the index into the string
        else if (currentLine.charAt(lineIndex) == ')')
        {
            //currentToken = new Token(")", Token.Type.SPECIAL_SYMBOL);
            lineIndex++;
            return new Token(")", Token.Type.SPECIAL_SYMBOL);
        } //Check for procedures
        else if (is_Procedure(Character.toString(currentLine.charAt(lineIndex))))
        {
            Token temp = new Token(Character.toString(currentLine.charAt(lineIndex)), Token.Type.PROCEDURE);
            lineIndex++;
            if (lineIndex >= currentLine.length())
            {
                splitListIndex++;
                if (splitListIndex >= splitList.length)
                {
                    return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                }
                currentLine = splitList[splitListIndex];
                lineIndex = 0;

            }
            return temp;
        } //Checks for special Symbols excluding ( and )
        else if (is_Special_Symbol(Character.toString(currentLine.charAt(lineIndex)))
                && currentLine.charAt(lineIndex) != '(' && currentLine.charAt(lineIndex) != ')')
        {
            Token temp = new Token(Character.toString(currentLine.charAt(lineIndex)), Token.Type.SPECIAL_SYMBOL);
            lineIndex++;
            if (lineIndex >= currentLine.length())
            {
                splitListIndex++;
                if (splitListIndex >= splitList.length)
                {
                    return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                }
                currentLine = splitList[splitListIndex];
                lineIndex = 0;

            }
            return temp;
        } //If the current character is a letter
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
                if (lineIndex >= currentLine.length())
                {
                    splitListIndex++;
                    if (splitListIndex >= splitList.length)
                    {
                        return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                    }
                    currentLine = splitList[splitListIndex];
                    lineIndex = 0;

                }
                //A check for it a term is hyphenated
                if (currentLine.charAt(lineIndex) == '-' && (Character.isAlphabetic(currentLine.charAt(lineIndex + 1)) || Character.isDigit(currentLine.charAt(lineIndex + 1))))
                {
                    token += Character.toString(currentLine.charAt(lineIndex));
                    lineIndex++;
                    if (lineIndex >= currentLine.length())
                    {
                        splitListIndex++;
                        if (splitListIndex >= splitList.length)
                        {
                            return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                        }
                        currentLine = splitList[splitListIndex];
                        lineIndex = 0;

                    }
                }
                if(token.equals("member") && currentLine.charAt(lineIndex) == '?')
                {
                    token += "?";
                    lineIndex++;

                    if (lineIndex >= currentLine.length())
                    {
                        splitListIndex++;
                        if (splitListIndex >= splitList.length)
                        {
                            return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                        }
                        currentLine = splitList[splitListIndex];
                        lineIndex = 0;

                    }

                }
                if(token.equals("null") && currentLine.charAt(lineIndex) == '?')
                {
                    token += "?";
                    lineIndex++;

                    if (lineIndex >= currentLine.length())
                    {
                        splitListIndex++;
                        if (splitListIndex >= splitList.length)
                        {
                            return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                        }
                        currentLine = splitList[splitListIndex];
                        lineIndex = 0;

                    }

                }
                if(token.equals("set") && currentLine.charAt(lineIndex) == '!')
                {
                    token += "!";
                    lineIndex++;

                    if (lineIndex >= currentLine.length())
                    {
                        splitListIndex++;
                        if (splitListIndex >= splitList.length)
                        {
                            return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                        }
                        currentLine = splitList[splitListIndex];
                        lineIndex = 0;
                    }
                }

                if (lineIndex >= currentLine.length() || currentLine.charAt(lineIndex) == ')')
                {
                    break;
                }
            }
            if(is_Key_Word(token))
            {
                return new Token(token, Token.Type.KEYWORD);//Need to check for TYPE eventully
            }
            if(is_Procedure(token))
            {
                return new Token(token, Token.Type.PROCEDURE);//Need to check for TYPE eventully
            }
            return new Token(token, Token.Type.IDENTIFIER);//Need to check for TYPE eventully
        } //If the current character is a digit
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
                if (lineIndex >= currentLine.length())
                {
                    splitListIndex++;
                    if (splitListIndex >= splitList.length)
                    {
                        return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
                    }
                    currentLine = splitList[splitListIndex];
                    lineIndex = 0;

                }
                if (currentLine.charAt(lineIndex) == ')')
                {
                    break;
                }
            }
            return new Token(token, Token.Type.NUMBER);////Need to check for TYPE eventully
        }
        return new Token("ERROR", Token.Type.ERROR);
    }

    private boolean is_Procedure(String key)
    {
        return procedure_Symbol_Map.containsKey(key);
    }

    private boolean is_Special_Symbol(String key)
    {
        return special_Symbol_Map.containsKey(key);
    }

    private boolean is_Key_Word(String key)
    {
        return key_Word_Map.containsKey(key);
    }


    private void setUpMaps()
    {
        key_Word_Map.put("and", keyword);
        key_Word_Map.put("begin", keyword);
        key_Word_Map.put("begin0", keyword);
        key_Word_Map.put("break-var", keyword);
        key_Word_Map.put("case", keyword);
        key_Word_Map.put("cond", keyword);
        key_Word_Map.put("cycle", keyword);
        key_Word_Map.put("define", keyword);
        key_Word_Map.put("delay", keyword);
        key_Word_Map.put("delay-list-cons", keyword);
        key_Word_Map.put("do", keyword);
        key_Word_Map.put("else", keyword);
        key_Word_Map.put("extend-syntax", keyword);
        key_Word_Map.put("for", keyword);
        key_Word_Map.put("freeze", keyword);
        key_Word_Map.put("if", keyword);
        key_Word_Map.put("lambda", keyword);
        key_Word_Map.put("let*", keyword);
        key_Word_Map.put("let", keyword);
        key_Word_Map.put("letrec", keyword);
        key_Word_Map.put("macro", keyword);
        key_Word_Map.put("object-maker", keyword);
        key_Word_Map.put("or", keyword);
        key_Word_Map.put("quote", keyword);
        key_Word_Map.put("repeat", keyword);
        key_Word_Map.put("safe-letrec", keyword);
        key_Word_Map.put("set!", keyword);
        key_Word_Map.put("stream-cons", keyword);
        key_Word_Map.put("variable-case", keyword);
        key_Word_Map.put("while", keyword);
        key_Word_Map.put("wrap", keyword);

        special_Symbol_Map.put("[", special_Symbol);
        special_Symbol_Map.put("]", special_Symbol);
        special_Symbol_Map.put("{", special_Symbol);
        special_Symbol_Map.put("}", special_Symbol);
        special_Symbol_Map.put(";", special_Symbol);
        special_Symbol_Map.put(",", special_Symbol);
        special_Symbol_Map.put(".", special_Symbol);
        special_Symbol_Map.put("\"", special_Symbol);
        special_Symbol_Map.put("\'", special_Symbol);
        special_Symbol_Map.put("#", special_Symbol);
        special_Symbol_Map.put("\\", special_Symbol);

        procedure_Symbol_Map.put("+", procedure);
        procedure_Symbol_Map.put("-", procedure);
        procedure_Symbol_Map.put("*", procedure);
        procedure_Symbol_Map.put("/", procedure);
        procedure_Symbol_Map.put("null?", procedure);
        procedure_Symbol_Map.put("member?", procedure);
        procedure_Symbol_Map.put("list?", procedure);
    }
}
