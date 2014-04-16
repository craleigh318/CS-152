package intermediate;

import java.util.TreeMap;

/**
 * Maps a token in Scheme with its assigned value.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class SymbolTable {
    //Key for the symbol table

    private String entryNameKey;
    //Key for the attribute table
    private String attributeNameKey;
    //value of the attribute table
    private String attributeValue;
    //Add a treemap to this
    //Hashtable<String , Hashtable> symbolTable;
    //Hashtable<String, String> attributeTable;
    TreeMap<String, String> symbolMap;

    public SymbolTable() {
        //symbolTable = new Hashtable<>();
        symbolMap = new TreeMap<>();
    }

    /**
     * Adds a token to this symbol table.
     *
     * @param symbol_Key the token to be added
     * @param attribute_value symbol_Key's value
     */
    public void addElement(String symbol_Key, String attribute_value) {
        symbolMap.put(symbol_Key, "");
        //attributeTable.put(symbol_Key, attributeValue);
        //symbolTable.put(symbol_Key, attributeTable);
    }

    @Override
    public String toString() {
        String temp = "";
        for (String s : symbolMap.keySet()) {
            temp = temp.concat(s + "\n");
        }
        return temp;
    }
}