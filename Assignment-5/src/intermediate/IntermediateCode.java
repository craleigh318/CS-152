package intermediate;

import java.util.ArrayList;

/**
 * Holds intermediate code for a back end to compile.
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class IntermediateCode {

    ArrayList<SchemeList> roots;

    public IntermediateCode() {
        roots = new ArrayList<>();
    }

    /**
     *
     * @return the lists of the Scheme source
     */
    public ArrayList<SchemeList> getLists() {
        return roots;
    }
}
