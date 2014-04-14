package intermediate;

import java.util.HashSet;

/**
 * Holds intermediate code for a back end to compile.
 * 
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class IntermediateCode {

    HashSet<SchemeList> roots;

    public IntermediateCode() {
        roots = new HashSet<>();
    }

    /**
     *
     * @return the lists of the Scheme source
     */
    public HashSet<SchemeList> getLists() {
        return roots;
    }
}
