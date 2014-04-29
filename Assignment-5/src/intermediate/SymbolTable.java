package intermediate;

import java.util.HashMap;
import java.util.Map;

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
    Map<String, Object> symbolMap;

    public SymbolTable() {
        //symbolTable = new Hashtable<>();
        symbolMap = new HashMap<>();
    }

    public SymbolTable(Map map)
    {
        symbolMap = map;
    }

    public void addAllEmelents(Map map)
    {
        symbolMap.putAll(map);
    }

    /**
     * Adds a token to this symbol table.
     *
     * @param symbol_Key the token to be added
     * @param attribute_value symbol_Key's value
     * @return symbolmap object
     */
    public Object addElement(String symbol_Key, Object attribute_value) {
        return symbolMap.put(symbol_Key, attribute_value);

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