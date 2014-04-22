/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend;

import java.util.HashMap;

/**
 *
 * @author BrandonRossi
 */
public class SymbolMapList
{

    private static final String keyword = "KEYWORD";
    private static final String identifier = "IDENTIFIER";
    private static final String special_Symbol = "SPECIAL_SYMBOL";
    private static final String procedure = "PROCEDURE";
    private static final String scope_Keyword = "SCOPE_KEYWORD";
    private static final String list_Operator = "LIST_OPERATOR";

    private static HashMap<String, String> key_Word_Map;
    private static HashMap<String, String> special_Symbol_Map;
    private static HashMap<String, String> procedure_Symbol_Map;

    static{
        key_Word_Map = setUpKeywordMap();
        special_Symbol_Map = setUpSpecialSymbolMap();
        procedure_Symbol_Map = setUpProcedureSymbolMap();
    }

     /**
     * Checks if a string is a procedure.
     *
     * @param key the string to check
     * @return true if key is a procedure
     */
    public static boolean is_Procedure(String key) {
        return procedure_Symbol_Map.containsKey(key);
    }

    /**
     * Checks if a string is a special symbol.
     *
     * @param key the string to check
     * @return true if key is a special symbol
     */
    public static boolean is_Special_Symbol(String key) {
        return special_Symbol_Map.containsKey(key);
    }

    /**
     * Checks if a string is a keyword.
     *
     * @param key the string to check
     * @return true if key is a keyword
     */
    public static boolean is_Key_Word(String key) {
        return key_Word_Map.containsKey(key);
    }

    /**
     *
     * @return a map of all of the keywords in Scheme
     */
    public static HashMap<String, String> setUpKeywordMap() {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.putAll(setUpScopeKeyWordMap());
        newMap.put("begin", keyword);
        newMap.put("begin0", keyword);
        newMap.put("break-var", keyword);
        newMap.put("case", keyword);
        newMap.put("cond", keyword);
        newMap.put("cycle", keyword);
        newMap.put("delay", keyword);
        newMap.put("delay-list-cons", keyword);
        newMap.put("do", keyword);
        newMap.put("else", keyword);
        newMap.put("extend-syntax", keyword);
        newMap.put("for", keyword);
        newMap.put("freeze", keyword);
        newMap.put("if", keyword);
        newMap.put("macro", keyword);
        newMap.put("object-maker", keyword);
        newMap.put("quote", keyword);
        newMap.put("repeat", keyword);
        newMap.put("safe-letrec", keyword);
        newMap.put("set!", keyword);
        newMap.put("stream-cons", keyword);
        newMap.put("variable-case", keyword);
        newMap.put("while", keyword);
        newMap.put("wrap", keyword);
        newMap.put("or", keyword);
        newMap.put("and", keyword);
        return newMap;
    }

    public static HashMap<String, String> setUpScopeKeyWordMap()
    {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("define", scope_Keyword);
        newMap.put("let*", scope_Keyword);
        newMap.put("let", scope_Keyword);
        newMap.put("letrec", scope_Keyword);
        newMap.put("lambda", scope_Keyword);
        return newMap;
    }

    /**
     *
     * @return a map of all of the special symbols in Scheme
     */
    public static HashMap<String, String> setUpSpecialSymbolMap() {
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

    /**
     *
     * @return a map of all of the predefined procedures in Scheme
     */
    public static HashMap<String, String> setUpProcedureSymbolMap() {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.putAll(setUpListOperationsMap());
        newMap.put("+", procedure);
        newMap.put("-", procedure);
        newMap.put("*", procedure);
        newMap.put("/", procedure);
        newMap.put("=", procedure);
        newMap.put("eq?", procedure);
        newMap.put("equal?", procedure);
        newMap.put("null?", procedure);
        newMap.put("member?", procedure);
        newMap.put("list?", procedure);
        newMap.put("not", procedure);
        newMap.put("symbol?", procedure);
        newMap.put("map", procedure);
        return newMap;
    }

    private static HashMap<String, String> setUpListOperationsMap() {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("list", list_Operator);
        newMap.put("car", list_Operator);
        newMap.put("cdr", list_Operator);
        newMap.put("cons", list_Operator);
        return newMap;
    }

}
