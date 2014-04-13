/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import frontend.Token;

/**
 *
 * @author BrandonRossi
 * @author Christopher Raleigh
 * @deprecated Use SchemeListItem instead.
 */
public class Node {

    Token tokenLeft;
    Token tokenRight;
    Node left;
    Node right;

    public Node() {
        tokenLeft = null;
    }

    /**
     * Not yet implemented.
     *
     * @return
     */
    public Node addBranch() {
        throw new UnsupportedOperationException();
    }
}
