package intermediate;

import java.util.HashSet;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 */
public class IntermediateCode {

    HashSet<Tree> roots;

    public IntermediateCode() {
        roots = new HashSet<>();
    }

    /**
     * 
     * @return the lists of the Scheme source as Trees
     */
    public HashSet<Tree> getTrees() {
        return roots;
    }
}
