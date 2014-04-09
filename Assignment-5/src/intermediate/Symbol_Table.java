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
public class Symbol_Table
{
    //Key for the symbol table
    private String entryNameKey;
    //Key for the attribute table
    private String attributeNameKey;
    //value of the attribute table
    private String attributeValue;

    Hashtable<String , Hashtable> symbolTable;
    Hashtable<String, String> attributeTable;

    public Symbol_Table()
    {
        symbolTable = new Hashtable<>();
    }

    public void addElement(String symbol_Key, String attribute_value)
    {
        attributeTable.put(symbol_Key, attributeValue);
        symbolTable.put(symbol_Key, attributeTable);
    }
}