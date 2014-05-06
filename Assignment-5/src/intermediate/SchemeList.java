package intermediate;

/**
 * Holds items that can be gotten using car() and cdr().
 *
 * @author Christopher Raleigh
 * @author Brandon Rossi
 */
public class SchemeList implements SchemeListItem
{

    private SchemeListItem car;
    private SchemeList cdr;
    private SymbolTable table;

    /**
     *
     * @param table current symbol table
     */
    public SchemeList (SymbolTable table)
    {
        car = null;
        cdr = null;
        this.table = table;
    }

    /**
     *
     * @param content the item with which to initialize the list
     * @param table   current symbol table
     */
    public SchemeList (SchemeListItem content, SymbolTable table)
    {
        car = content;
        cdr = null;
        this.table = table;
    }

    /**
     * Adds an item to the end of this list.
     *
     * @param content the item to be added
     */
    public void add (SchemeListItem content)
    {
        add(content, table);
    }

    /**
     * Adds an item to the end of this list.
     *
     * @param content  the item to be added
     * @param newTable
     */
    public void add (SchemeListItem content, SymbolTable newTable)
    {
        if (car == null)
        {
            car = content;
        }
        else if (cdr == null)
        {
            cdr = new SchemeList(content, newTable);
        }
        else
        {
            cdr.add(content, newTable);
        }
    }

    /**
     *
     * @return this list symbol table
     */
    public SymbolTable getTable ()
    {
        return table;
    }

    @Override
    public SchemeListItem car ()
    {
        return car;
    }

    @Override
    public SchemeList cdr ()
    {
        return cdr;
    }

    @Override
    public String toString ()
    {
        String returnString = "(";
        if (car != null)
        {
            returnString = returnString.concat(car.toString());
            if (cdr != null)
            {
                returnString = returnString.concat("." + cdr.toString());
            }
        }
        returnString = returnString.concat(")");
        return returnString;
    }
}
