package intermediate;

/**
 *
 * @author Christopher Raleigh
 * @author Brandon Rossi
 */
public interface SchemeListItem {

    /**
     *
     * @return the first item of this list
     */
    public SchemeListItem car();

    /**
     *
     * @return this list from the second item to its end
     */
    public SchemeList cdr();
}
