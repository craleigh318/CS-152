/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.util.HashMap;
import java.util.NoSuchElementException;
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

    private String file;
    Scanner fileScanner;
    HashMap<String, String> key_Word_Map;
    HashMap<String, String> special_Symbol_Map;
    HashMap<String, String> procedure_Symbol_Map;

    public SchemeScanner2(String file)
    {
        //This is the file
        this.file = file;
        fileScanner = new Scanner(this.file);
        key_Word_Map = new HashMap<>();
        special_Symbol_Map = new HashMap<>();
        procedure_Symbol_Map = new HashMap<>();

        setUpMaps();
    }

    public Token nextToken()
    {
        try
        {
            String currentToken = fileScanner.next();
            return new Token(currentToken, Token.Type.IDENTIFIER);
        } catch (NoSuchElementException e)
        {
            return new Token("ERROR", Token.Type.ERROR);
        }
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
