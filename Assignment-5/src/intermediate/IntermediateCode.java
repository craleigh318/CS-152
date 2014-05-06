package intermediate;

import java.util.ArrayList;

/**
 * Holds intermediate code for a back end to compile.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class IntermediateCode
{

    private ArrayList<SchemeList> roots;
    private SymbolTableStack symbolTableStack;

    public IntermediateCode ()
    {
        roots = new ArrayList<>();
        symbolTableStack = new SymbolTableStack();
    }

    /**
     *
     * @return the lists of the Scheme source
     */
    public ArrayList<SchemeList> getLists ()
    {
        return roots;
    }

    /**
     *
     * @return the symbol table stack
     */
    public SymbolTableStack getSymbolTableStack ()
    {
        return symbolTableStack;
    }
}
