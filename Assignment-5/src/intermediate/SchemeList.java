package intermediate;

/**
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

    public SchemeList(SchemeListItem content) {
        car = content;
        cdr = null;
    }

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
}
