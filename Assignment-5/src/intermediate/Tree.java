package intermediate;

/**
 *
 * @author BrandonRossi
 */
public class Tree {

    public Node root;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Node getroot() {
        return root;
    }

    public void setroot(Node the_Whole_Tree) {
        root = the_Whole_Tree;
    }
}
