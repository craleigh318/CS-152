/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;
import java.util.Hashtable;

/**
 *
 * @author BrandonRossi
 */
public class SymbolTable
{
    //Key for the symbol table
    private String entryNameKey;
    //Key for the attribute table
    private String attributeNameKey;
    //value of the attribute table
    private String attributeValue;

    //Add a treemap to this

    Hashtable<String , Hashtable> symbolTable;
    Hashtable<String, String> attributeTable;

    public SymbolTable()
    {
        symbolTable = new Hashtable<>();
    }

    public void addElement(String symbol_Key, String attribute_value)
    {
        attributeTable.put(symbol_Key, attributeValue);
        symbolTable.put(symbol_Key, attributeTable);
    }
}