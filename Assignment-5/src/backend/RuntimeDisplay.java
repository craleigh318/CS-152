package backend;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Use this to add symbol tables for runtime.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class RuntimeDisplay
{

    private final RuntimeStack runtimeStack;
    private final Map<Integer, RuntimeActivationRecord> runtimeMap;

    public RuntimeDisplay ()
    {
        runtimeStack = new RuntimeStack();
        runtimeMap = new TreeMap<>();
    }

    /**
     * Adds a symbol table to the runtime.
     *
     * @param scopeLevel the depth of the symbol table
     * @param record     the symbol table to be added
     * @return true if table is successfully added
     */
    public RuntimeActivationRecord addRecord (int scopeLevel, RuntimeActivationRecord record)
    {
        if (runtimeMap.containsKey(scopeLevel))
        {
            record.setPreviousActivationRecord(runtimeMap.get(scopeLevel));
        }
        runtimeStack.addActivationRecord(record);
        return runtimeMap.put(scopeLevel, record);
    }

    /**
     * Gets the scope of the specified symbol table.
     *
     * @param record the symbol table to find
     * @return symbolTable's scope
     */
    public int getScopeLevel (RuntimeActivationRecord record)
    {
        for (Map.Entry<Integer, RuntimeActivationRecord> entry : runtimeMap.entrySet())
        {
            if (entry.getValue().equals(record))
            {
                return entry.getKey();
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Gets a set containing all symbol tables in a particular depth of scope.
     *
     * @param scopeLevel the scope in which to return
     * @return the set of symbol tables in the specified depth
     */
    public RuntimeActivationRecord getRecord (int scopeLevel)
    {
        return runtimeMap.get(scopeLevel);
    }

    public RuntimeActivationRecord removeRecord (int scopeLevel)
    {
        RuntimeActivationRecord temp = runtimeMap.get(scopeLevel);
        if (temp.getPreviousRunTimeActivationRecord() != null)
        {
            runtimeMap.put(scopeLevel, temp.getPreviousRunTimeActivationRecord());
        }

        return temp;

    }
}
