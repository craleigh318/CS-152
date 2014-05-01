package backend;

import intermediate.SymbolTable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Use this to add symbol tables for runtime.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class RuntimeDisplay {

    private RuntimeStack runtimeStack;
    private Map<Integer, Set<SymbolTable>> symbolTables;

    public RuntimeDisplay() {
        runtimeStack = new RuntimeStack();
        symbolTables = new TreeMap<>();
    }

    /**
     * Adds a symbol table to the runtime.
     *
     * @param scopeLevel the depth of the symbol table
     * @param symbolTable the symbol table to be added
     * @return true if table is successfully added
     */
    public boolean addSymbolTable(int scopeLevel, SymbolTable symbolTable) {
        Set<SymbolTable> targetSet = symbolTables.get(scopeLevel);
        if (targetSet == null) {
            symbolTables.put(scopeLevel, new HashSet<SymbolTable>());
        }
        return targetSet.add(symbolTable);
    }
}
