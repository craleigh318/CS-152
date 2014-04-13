package frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class SchemeScanner2 {

    private final String keyword = "KEYWORD";
    private final String identifier = "IDENTIFIER";
    private final String special_Symbol = "SPECIAL_SYMBOL";
    private final String procedure = "PROCEDURE";
    Scanner fileScanner;
    HashMap<String, String> key_Word_Map;
    HashMap<String, String> special_Symbol_Map;
    HashMap<String, String> procedure_Symbol_Map;

    public SchemeScanner2(File file) throws FileNotFoundException {
        fileScanner = new Scanner(file);
        key_Word_Map = setUpKeywordMap();
        special_Symbol_Map = setUpSpecialSymbolMap();
        procedure_Symbol_Map = setUpProcedureSymbolMap();
    }

    public Token nextToken() {
        try {
            String currentToken = fileScanner.next();

            if (currentToken.equals("(")) {
                return new Token("(", Token.Type.SPECIAL_SYMBOL);
            } else if (currentToken.equals(")")) {
                return new Token(")", Token.Type.SPECIAL_SYMBOL);
            } else if (is_Key_Word(currentToken)) {
                return new Token(currentToken, Token.Type.KEYWORD);
            } else if (is_Procedure(currentToken)) {
                return new Token(currentToken, Token.Type.PROCEDURE);
            } else if (is_Special_Symbol(currentToken)) {
                return new Token(currentToken, Token.Type.SPECIAL_SYMBOL);
            } else if (currentToken.equals("'(")) {
                String tokenName = currentToken;
                while (!currentToken.equals(")")) {
                    currentToken = fileScanner.next();
                    tokenName += currentToken + " ";
                }
                int index = tokenName.lastIndexOf(" ) ");
                if (index != -1) {
                    tokenName = tokenName.substring(0, index) + ")";
                } else {
                    tokenName = tokenName.substring(0, tokenName.length() - 2) + ")";
                }
                return new Token(tokenName, Token.Type.IDENTIFIER);
            } else if (Character.isDigit(currentToken.charAt(0))) {
                return new Token(currentToken, Token.Type.NUMBER);
            }
            return new Token(currentToken, Token.Type.IDENTIFIER);
        } catch (NoSuchElementException e) {
            return new Token("END OF INPUT", Token.Type.END_OF_INPUT);
        }
    }

    private boolean is_Procedure(String key) {
        return procedure_Symbol_Map.containsKey(key);
    }

    private boolean is_Special_Symbol(String key) {
        return special_Symbol_Map.containsKey(key);
    }

    private boolean is_Key_Word(String key) {
        return key_Word_Map.containsKey(key);
    }

    private HashMap<String, String> setUpKeywordMap() {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("and", keyword);
        newMap.put("begin", keyword);
        newMap.put("begin0", keyword);
        newMap.put("break-var", keyword);
        newMap.put("case", keyword);
        newMap.put("cond", keyword);
        newMap.put("cycle", keyword);
        newMap.put("define", keyword);
        newMap.put("delay", keyword);
        newMap.put("delay-list-cons", keyword);
        newMap.put("do", keyword);
        newMap.put("else", keyword);
        newMap.put("extend-syntax", keyword);
        newMap.put("for", keyword);
        newMap.put("freeze", keyword);
        newMap.put("if", keyword);
        newMap.put("lambda", keyword);
        newMap.put("let*", keyword);
        newMap.put("let", keyword);
        newMap.put("letrec", keyword);
        newMap.put("macro", keyword);
        newMap.put("object-maker", keyword);
        newMap.put("or", keyword);
        newMap.put("quote", keyword);
        newMap.put("repeat", keyword);
        newMap.put("safe-letrec", keyword);
        newMap.put("set!", keyword);
        newMap.put("stream-cons", keyword);
        newMap.put("variable-case", keyword);
        newMap.put("while", keyword);
        newMap.put("wrap", keyword);
        return newMap;
    }

    private HashMap<String, String> setUpSpecialSymbolMap() {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("[", special_Symbol);
        newMap.put("]", special_Symbol);
        newMap.put("{", special_Symbol);
        newMap.put("}", special_Symbol);
        newMap.put(";", special_Symbol);
        newMap.put(",", special_Symbol);
        newMap.put(".", special_Symbol);
        newMap.put("\"", special_Symbol);
        newMap.put("\'", special_Symbol);
        newMap.put("#", special_Symbol);
        newMap.put("\\", special_Symbol);
        return newMap;
    }

    private HashMap<String, String> setUpProcedureSymbolMap() {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("+", procedure);
        newMap.put("-", procedure);
        newMap.put("*", procedure);
        newMap.put("/", procedure);
        newMap.put("null?", procedure);
        newMap.put("member?", procedure);
        newMap.put("list?", procedure);
        return newMap;
    }
}
