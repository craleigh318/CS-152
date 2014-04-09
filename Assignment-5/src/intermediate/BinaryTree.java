/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

/**
 *
 * @author BrandonRossi
 */
public class BinaryTree
{

    public BinaryTree()
    {

    }

    private static class Node
    {
        String item;
        Node leftNode;
        Node rightNode;

        public Node(String str)
        {
            item = str;
            leftNode = null;
            rightNode = null;
        }
    }
}
