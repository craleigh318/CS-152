package backend;

import intermediate.SymbolTable;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
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
        if (!symbolTables.containsKey(scopeLevel)) {
            symbolTables.put(scopeLevel, new HashSet<SymbolTable>());
        }
        return symbolTables.get(scopeLevel).add(symbolTable);
    }

    /**
     * Gets the scope of the specified symbol table.
     *
     * @param symbolTable the symbol table to find
     * @return symbolTable's scope
     */
    public int getScopeLevel(SymbolTable symbolTable) {
        for (Map.Entry<Integer, Set<SymbolTable>> entry : symbolTables.entrySet()) {
            if (entry.getValue().contains(symbolTable)) {
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
    public Set<SymbolTable> getAllSymbolTablesInScope(int scopeLevel) {
        return symbolTables.get(scopeLevel);
    }
}
