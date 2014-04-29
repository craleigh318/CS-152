package intermediate;

/**
 * Holds items that can be gotten using car() and cdr().
 *
 * @author Christopher Raleigh
 * @author Brandon Rossi
 */
public class SchemeList implements SchemeListItem {

    private SchemeListItem car;
    private SchemeList cdr;
    
    public SchemeList() {
        car = null;
        cdr = null;
    }

    /**
     *
     * @param content the item with which to initialize the list
     */
    public SchemeList(SchemeListItem content) {
        car = content;
        cdr = null;
    }

    /**
     * Adds an item to the end of this list.
     *
     * @param content the item to be added
     */
    public void add(SchemeListItem content) {
        if (car == null) {
            car = content;
        } else if (cdr == null) {
            cdr = new SchemeList(content);
        } else {
            cdr.add(content);
        }
    }

    @Override
    public SchemeListItem car() {
        return car;
    }

    @Override
    public SchemeList cdr() {
        return cdr;
    }

    @Override
    public String toString() {
        String returnString = "(";
        if (car != null) {
            returnString = returnString.concat(car.toString());
            if (cdr != null) {
                returnString = returnString.concat("." + cdr.toString());
            }
        }
        returnString = returnString.concat(")");
        return returnString;
    }
}
